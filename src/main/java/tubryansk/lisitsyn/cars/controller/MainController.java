package tubryansk.lisitsyn.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tubryansk.lisitsyn.cars.entity.*;
import tubryansk.lisitsyn.cars.repository.CarRepo;

import java.util.*;


@Controller
public class MainController {
    @Autowired
    private CarRepo carRepo;

    @GetMapping("/")
    public String main(Model model) {
        return "main";
    }

    @GetMapping("/catalog")
    public String catalog(Model model) {
        Iterable<CarEngineType> carEngineTypes = Arrays.asList(CarEngineType.values());
        model.addAttribute("carEngineTypes", carEngineTypes);
        Iterable<CarDrive> carDrives = Arrays.asList(CarDrive.values());
        model.addAttribute("carDrives", carDrives);
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

    @PostMapping("/catalog")
    public String filter(
            Model model,
            @RequestParam(name = "yearMin", required = false) Integer yearMin,
            @RequestParam(name = "yearMax", required = false) Integer yearMax,
            @RequestParam(name = "DIESEL", defaultValue = "false") Boolean isDIESEL,
            @RequestParam(name = "PETROL", defaultValue = "false") Boolean isPETROL,
            @RequestParam(name = "HUBRID", defaultValue = "false") Boolean isHUBRID,
            @RequestParam(name = "FRONT", defaultValue = "false") Boolean isFRONT,
            @RequestParam(name = "ALL", defaultValue = "false") Boolean isALL,
            @RequestParam(name = "BACK", defaultValue = "false") Boolean isBACK,
            @RequestParam(name = "engineHPmin", required = false) Integer engineHPmin,
            @RequestParam(name = "engineHPmax", required = false) Integer engineHPmax,
            @RequestParam(name = "color", required = false) String color
    ) {
        if (yearMax == null && yearMin == null && !isALL && !isBACK && !isDIESEL && !isFRONT && !isHUBRID && !isPETROL && engineHPmax == null && engineHPmin == null && color.isEmpty()) return "redirect:/catalog";
        //Год выпуска
        Set<Car> filterCars = new HashSet<>(Collections.emptySet());
        if (yearMin != null) {
            if (yearMax != null && yearMax > yearMin) {
                for (int i = yearMin; i < yearMax; i++) {
                    filterCars.addAll(carRepo.findAllByYear(i));
                }
            } else {
                filterCars.addAll(carRepo.findAllByYear(yearMin));
            }
        }
        //Мощность двигателя
        if (engineHPmin != null) {
            if (engineHPmax != null && engineHPmax > engineHPmin) {
                for (int i = engineHPmin; i < engineHPmax; i++) {
                    filterCars.addAll(carRepo.findAllByEngineHp(i));
                }
            } else {
                filterCars.addAll(carRepo.findAllByEngineHp(yearMin));
            }
        }
        //Тип двигателя
        if (isDIESEL) filterCars.addAll(carRepo.findAllByEngineType(CarEngineType.valueOf("DIESEL")));
        if (isPETROL) filterCars.addAll(carRepo.findAllByEngineType(CarEngineType.valueOf("PETROL")));
        if (isHUBRID) filterCars.addAll(carRepo.findAllByEngineType(CarEngineType.valueOf("HUBRID")));
        //Тип привода
        if (isFRONT) filterCars.addAll(carRepo.findAllByDrive(CarDrive.valueOf("FRONT")));
        if (isBACK) filterCars.addAll(carRepo.findAllByDrive(CarDrive.valueOf("BACK")));
        if (isALL) filterCars.addAll(carRepo.findAllByDrive(CarDrive.valueOf("ALL")));
        //Цвет
        if (color != null && !color.isEmpty()) filterCars.addAll(carRepo.findAllByColor(color.toLowerCase()));

        model.addAttribute("carEngineTypes", Arrays.asList(CarEngineType.values()));
        model.addAttribute("carDrives", Arrays.asList(CarDrive.values()));

        List<Car> cars = new ArrayList<>(Collections.emptyList());
        cars.addAll(filterCars);
        model.addAttribute("cars", cars);
        return "catalog";
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
