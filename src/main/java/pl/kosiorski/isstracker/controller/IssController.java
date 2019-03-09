package pl.kosiorski.isstracker.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.kosiorski.isstracker.model.IssData;
import pl.kosiorski.isstracker.model.Position;
import pl.kosiorski.isstracker.model.Tracker;
import pl.kosiorski.isstracker.service.IssDataService;
import pl.kosiorski.isstracker.service.TrackerService;

@RestController
public class IssController {

  private final IssDataService issDataService;
  private final TrackerService trackerService;

  @Autowired
  public IssController(IssDataService issDataService, TrackerService trackerService) {
    this.issDataService = issDataService;
    this.trackerService = trackerService;
  }

  @GetMapping("/iss")
  public IssData getIssData() {

    final String url = "http://api.open-notify.org/iss-now.json";

    RestTemplate restTemplate = new RestTemplate();
    String json = restTemplate.getForObject(url, String.class);

    IssData issData = new Gson().fromJson(json, IssData.class);
    issDataService.save(issData);

    return issData;
  }

//  public List<Astronaut> getAstronauts(){
//
//
//
//  }

  @GetMapping("/distance")
  public double getDistance() {
    Tracker tracker = new Tracker();

    Position startPosition = new Position(-51.1757, -65.2334);
    Position endPosition = new Position(-51.257, -64.3006);

    return trackerService.countDistance(startPosition, endPosition);
  }
}
