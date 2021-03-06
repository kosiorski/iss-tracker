package pl.kosiorski.isstracker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.kosiorski.isstracker.model.AstronautData;
import pl.kosiorski.isstracker.model.IssData;
import pl.kosiorski.isstracker.model.Path;
import pl.kosiorski.isstracker.service.AstronautDataService;
import pl.kosiorski.isstracker.service.IssDataService;
import pl.kosiorski.isstracker.service.PathService;

import java.io.IOException;
import java.util.Arrays;

@RestController
public class IssController {

  private final IssDataService issDataService;
  private final AstronautDataService astronautDataService;
  private final PathService pathService;

  @Autowired
  public IssController(
      IssDataService issDataService,
      AstronautDataService astronautDataService,
      PathService pathService) {
    this.issDataService = issDataService;
    this.astronautDataService = astronautDataService;
    this.pathService = pathService;
  }

  @GetMapping("/astronauts")
  public AstronautData getAstronauts() {

    final String url = "http://api.open-notify.org/astros.json";

    RestTemplate restTemplate = new RestTemplate();
    String json = restTemplate.getForObject(url, String.class);

    AstronautData astronautData = new Gson().fromJson(json, AstronautData.class);
    astronautDataService.save(astronautData);

    return astronautData;
  }

  @GetMapping("/position")
  public IssData getPosition() {

    final String url = "http://api.open-notify.org/iss-now.json";

    RestTemplate restTemplate = new RestTemplate();
    String json = restTemplate.getForObject(url, String.class);

    IssData issData = new Gson().fromJson(json, IssData.class);

    issDataService.save(issData);
    issData.setDistance(issDataService.countDistance(issData));
    issData.setSpeed(issDataService.countSpeed(issData));
    issDataService.save(issData);

    return issData;
  }

  @PostMapping("/path")
  public void savePath(@RequestBody String jsonArray) {

    IssData[] jsonToArray;

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

    try {
      jsonToArray = objectMapper.readValue(jsonArray, IssData[].class);

      Path path = new Path();
      path.setIssDataList(Arrays.asList(jsonToArray));
      path.setAverageSpeed(pathService.countAverageSpeed(path));
      path.setDistance(pathService.countDistance(path));
      path.setDuration(
          Integer.valueOf(jsonToArray[jsonToArray.length - 1].getTimestamp())
              - (Integer.valueOf(jsonToArray[0].getTimestamp())));

      pathService.save(path);

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
