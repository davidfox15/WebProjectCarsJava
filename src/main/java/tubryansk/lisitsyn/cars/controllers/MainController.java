package tubryansk.lisitsyn.cars.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(@RequestParam(name = "name", required = false, defaultValue = "David") String name, Model model) {
        model.addAttribute("name", name);
        return "main";
    }
    @GetMapping("/catalog")
    public String catalog(Model model) {
        return "catalog";
    }
    @GetMapping("/login")
    public String login (Model model) {
        return "login";
    }
}
