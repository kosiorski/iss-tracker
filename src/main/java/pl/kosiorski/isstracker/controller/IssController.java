package pl.kosiorski.isstracker.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.kosiorski.isstracker.model.Astronaut;
import pl.kosiorski.isstracker.model.AstronautData;
import pl.kosiorski.isstracker.model.Position;
import pl.kosiorski.isstracker.model.Tracker;
import pl.kosiorski.isstracker.service.AstronautDataService;
import pl.kosiorski.isstracker.service.AstronautService;
import pl.kosiorski.isstracker.service.IssDataService;
import pl.kosiorski.isstracker.service.TrackerService;

import java.util.List;

@RestController
public class IssController {

  private final IssDataService issDataService;
  private final TrackerService trackerService;
  private final AstronautService astronautService;
  private final AstronautDataService astronautDataService;

  @Autowired
  public IssController(
      IssDataService issDataService,
      TrackerService trackerService,
      AstronautService astronautService,
      AstronautDataService astronautDataService) {
    this.issDataService = issDataService;
    this.trackerService = trackerService;
    this.astronautService = astronautService;
    this.astronautDataService = astronautDataService;
  }

//  @GetMapping("/iss")
//  public IssData getIssData() {
//
//    HomepageController.getIssDataFromJson(issDataService);
//
//    return issData;
//  }

  @GetMapping("/astronauts")
  public List<Astronaut> getAstronauts() {

    final String url = "http://api.open-notify.org/astros.json";

    RestTemplate restTemplate = new RestTemplate();
    String json = restTemplate.getForObject(url, String.class);

    AstronautData astronautData = new Gson().fromJson(json, AstronautData.class);
    astronautDataService.save(astronautData);

    // TODO
    return astronautDataService.findAllAstronauts(1L);
  }

  @GetMapping("/distance")
  public double getDistance() {
    Tracker tracker = new Tracker();

    Position startPosition = new Position(-51.1757, -65.2334);
    Position endPosition = new Position(-51.257, -64.3006);

    return trackerService.countDistance(startPosition, endPosition);
  }
}
