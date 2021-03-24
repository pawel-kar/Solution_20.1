package pl.bootcamp.ex20;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class UserController {
    private final UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/add")
    String addUser(@RequestParam(required = false, defaultValue = "") String firstName, @RequestParam String lastName, @RequestParam int age) {
        if (isFilled(firstName)) {
            userRepository.addUser(new User(firstName, lastName, age));
            return "redirect:/success.html";
        }
        return "redirect:/error.html";
    }

    private boolean isFilled(String firstName) {
        return !firstName.equals("");
    }

    @ResponseBody
    @GetMapping("/users")
    String printUsers() {
        StringBuilder users = new StringBuilder();
        for (User user : userRepository.getUserList()) {
            users.append(user).append("</br>");
        }
        return users.toString();
    }
}
