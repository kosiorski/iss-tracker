package pl.kosiorski.isstracker.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.kosiorski.isstracker.model.IssData;

@RestController
public class IssController {

  @GetMapping()
  public IssData getIssData() {

    final String url = "http://api.open-notify.org/iss-now.json";

    RestTemplate restTemplate = new RestTemplate();
    String json = restTemplate.getForObject(url, String.class);

    return new Gson().fromJson(json, IssData.class);
  }
}
