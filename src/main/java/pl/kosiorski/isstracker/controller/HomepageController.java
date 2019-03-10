package pl.kosiorski.isstracker.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import pl.kosiorski.isstracker.model.IssData;
import pl.kosiorski.isstracker.service.IssDataService;

@Controller
@RequestMapping("/home")
public class HomepageController {

  private final IssDataService issDataService;

  @Autowired
  public HomepageController(IssDataService issDataService) {
    this.issDataService = issDataService;
  }

  @GetMapping
  public String showHomepage(Model model) {

    //      model.addAttribute("firstPosition", new Position(51.1757, -65.2334));

    final String url = "http://api.open-notify.org/iss-now.json";

    RestTemplate restTemplate = new RestTemplate();
    String json = restTemplate.getForObject(url, String.class);

    IssData issData = new Gson().fromJson(json, IssData.class);

    model.addAttribute("currentPosition", issData.getIss_position());

    return "/index";
  }
}
