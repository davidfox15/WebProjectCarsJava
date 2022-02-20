package tubryansk.lisitsyn.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tubryansk.lisitsyn.cars.entity.Role;
import tubryansk.lisitsyn.cars.entity.User;
import tubryansk.lisitsyn.cars.repository.UserRepo;

import java.util.Collections;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;

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
        user.setRoles(Collections.singleton(Role.ADMIN));
        userRepo.save(user);
        return "redirect:/login";
    }

    @GetMapping("/account")
    public String account(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        boolean isAdmin = user.getRoles().contains(Role.ADMIN);
        model.addAttribute("isAdmin",isAdmin);
        return "account";
    }
}
