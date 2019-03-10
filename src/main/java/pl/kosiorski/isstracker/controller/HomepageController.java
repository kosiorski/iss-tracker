package pl.kosiorski.isstracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kosiorski.isstracker.model.Position;

@Controller
@RequestMapping("/home")
public class HomepageController {

  @GetMapping
  public String showHomepage(Model model) {

    model.addAttribute("firstPosition", new Position(51.1757, -65.2334));

    return "/index";
  }
}
