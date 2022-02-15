package tubryansk.lisitsyn.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import tubryansk.lisitsyn.cars.entity.*;
import tubryansk.lisitsyn.cars.repository.CarRepo;
import tubryansk.lisitsyn.cars.repository.UserRepo;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class MainController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CarRepo carRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String main(@RequestParam(name = "name", required = false, defaultValue = "David") String name, Model model) {
        model.addAttribute("name", name);
        return "main";
    }

    @GetMapping("/catalog")
    public String catalog(Model model) {
        Iterable<Car> cars = carRepo.findAll();
        for (Car car : cars) {
            System.out.println(car.getImageName());
        }
        model.addAttribute("cars", cars);
        return "catalog";
    }

    @PostMapping("/delete")
    public String catalog(Model model, Integer id) {
        Car carFromDb = carRepo.findById(id);
        //ADD FILE DELETE
        carRepo.delete(carFromDb);
        Iterable<Car> cars = carRepo.findAll();
        model.addAttribute("cars", cars);
        return "redirect:/catalog";
    }

    @GetMapping("/add-car")
    public String add(Model model) {
//        Iterable<CarBrand> carBrands = Arrays.asList(CarBrand.values());
        model.addAttribute("CarBrand", Arrays.asList(CarBrand.values()));
        model.addAttribute("CarEngineType", Arrays.asList(CarEngineType.values()));
        model.addAttribute("CarDrive", Arrays.asList(CarDrive.values()));
        model.addAttribute("CarWheel", Arrays.asList(CarWheel.values()));
        model.addAttribute("CarTransmission", Arrays.asList(CarTransmission.values()));
        model.addAttribute("CarBody", Arrays.asList(CarBody.values()));
        return "add-car";
    }

    @PostMapping("/add-car")
    public String add(Model model,
                      @RequestParam(name = "year") Integer year,
                      @RequestParam(name = "run") Integer run,
                      @RequestParam(name = "engineHp") Integer engineHp,
                      @RequestParam(name = "engineVolume") Float engineVolume,
                      @RequestParam(name = "drive") String drive,
                      @RequestParam(name = "transmission") String transmission,
                      @RequestParam(name = "wheel") String wheel,
                      @RequestParam(name = "engineType") String engineType,
                      @RequestParam(name = "body") String body,
                      @RequestParam(name = "color") String color,
                      @RequestParam(name = "comment") String comment,
                      @RequestParam(name = "brand") String brand,
                      @RequestParam(name = "carModel") String carModel,
                      @RequestParam("file") MultipartFile file
    ) throws IOException {
        Car car = new Car(
                year,
                run,
                engineHp,
                engineVolume,
                CarBrand.valueOf(brand),
                CarDrive.valueOf(drive),
                CarTransmission.valueOf(transmission),
                CarWheel.valueOf(wheel),
                CarEngineType.valueOf(engineType),
                CarBody.valueOf(body),
                carModel,
                new Date().toString(),
                color
        );

        if (comment == null) {
            car.setComment("");
        } else {
            car.setComment(comment);
        }

        if (file != null) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadDir.getPath() + "/" + resultFileName));
            car.setImageName(resultFileName);
        }

        carRepo.save(car);
        return "redirect:/catalog";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
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
