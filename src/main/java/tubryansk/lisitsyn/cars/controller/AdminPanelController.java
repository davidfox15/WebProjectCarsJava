package tubryansk.lisitsyn.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import tubryansk.lisitsyn.cars.entity.*;
import tubryansk.lisitsyn.cars.repository.CarRepo;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

@Controller
@RequestMapping("/adminpanel")
public class AdminPanelController {
    @Autowired
    private CarRepo carRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/catalog")
    public String catalog(Model model) {
        Iterable<Car> cars = carRepo.findAll();
        model.addAttribute("cars", cars);
        return "ap-catalog";
    }

    @PostMapping("/delete")
    public String deleteCarFromDB(Model model, Integer id) {
        Car carFromDb = carRepo.findById(id);
        // delete image with record from database
        File fileToDelete = new File(uploadPath + "/" + carFromDb.getImageName());
        boolean success = fileToDelete.delete();
        //if(success) System.out.println("DELETED!");
        carRepo.delete(carFromDb);
        Iterable<Car> cars = carRepo.findAll();
        model.addAttribute("cars", cars);
        return "redirect:/adminpanel/catalog";
    }

    @GetMapping("/add")
    public String addCarForm(Model model) {
        model.addAttribute("CarBrand", Arrays.asList(CarBrand.values()));
        model.addAttribute("CarEngineType", Arrays.asList(CarEngineType.values()));
        model.addAttribute("CarDrive", Arrays.asList(CarDrive.values()));
        model.addAttribute("CarWheel", Arrays.asList(CarWheel.values()));
        model.addAttribute("CarTransmission", Arrays.asList(CarTransmission.values()));
        model.addAttribute("CarBody", Arrays.asList(CarBody.values()));
        return "ap-add";
    }

    @PostMapping("/add")
    public String saveCarToDB(Model model,
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
                color.toLowerCase()
        );

        if (comment == null) {
            car.setComment("");
        } else {
            car.setComment(comment);
        }

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));
            car.setImageName(resultFileName);
        }

        carRepo.save(car);
        return "redirect:/adminpanel/catalog";
    }
}
