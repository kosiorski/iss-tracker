package pl.kosiorski.isstracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"", "/home"})
public class HomepageController {

  @GetMapping
  public String showHomepage() {

    return "/index";
  }
}
