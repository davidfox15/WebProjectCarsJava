package tubryansk.lisitsyn.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import tubryansk.lisitsyn.cars.entity.*;
import tubryansk.lisitsyn.cars.repository.CarRepo;


@Controller
public class MainController {
    @Autowired
    private CarRepo carRepo;

    @GetMapping("/")
    public String main(@RequestParam(name = "name", required = false, defaultValue = "David") String name, Model model) {
        model.addAttribute("name", name);
        return "main";
    }

    @GetMapping("/catalog")
    public String catalog(Model model) {
        Iterable<Car> cars = carRepo.findAll();
        model.addAttribute("cars", cars);
        return "catalog";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }

    @GetMapping("/catalog/{car}")
    public String carPage(Model model, @PathVariable Integer car) {
        Car carFromDb = carRepo.findById(car);
        model.addAttribute("car", carFromDb);
        return "car";
    }

//    @PostMapping("/search")
//    public String hello(Model model, @RequestParam(defaultValue = "") String searchName) {
//        List<List<String>> persons = repositoryService.getRepository();
//        List<List<String>> filterList = persons.stream()
//                .filter(p -> p.get(0).contains(searchName))
//                .collect(Collectors.toList());
//        model.addAttribute("persons", filterList);
//        model.addAttribute("lastSearch", searchName);
//        return "persons";
//    }
}
