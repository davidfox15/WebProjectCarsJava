package tubryansk.lisitsyn.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import tubryansk.lisitsyn.cars.entity.Car;
import tubryansk.lisitsyn.cars.entity.Role;
import tubryansk.lisitsyn.cars.entity.User;
import tubryansk.lisitsyn.cars.repository.CarRepo;
import tubryansk.lisitsyn.cars.repository.UserRepo;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

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
        model.addAttribute("cars", cars);
        return "catalog";
    }

    @GetMapping("/add-car")
    public String add(Model model) {
        return "add-car";
    }

    @PostMapping("/add-car")
    public String add(Model model,
                      @RequestParam(name = "brand") String brand,
                      @RequestParam(name = "carModel") String carModel,
                      @RequestParam(name = "year") Integer year,
                      @RequestParam("file") MultipartFile file
    ) throws IOException {
        Car car = new Car(brand, carModel, year, new Date().toString());
        if (file != null) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(resultFileName));

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
}
