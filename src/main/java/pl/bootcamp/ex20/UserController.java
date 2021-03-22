package pl.bootcamp.ex20;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class UserController {
    UserRepository userList;

    UserController(UserRepository userList) {
        this.userList = userList;
    }

    @PostMapping("/add")
    String hello(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
        if (isFilled(firstName)) {
            userList.addUser(new User(firstName, lastName, age));
            return "redirect:/success.html";
        } else {
            return "redirect:/error.html";
        }
    }

    private boolean isFilled(String firstName) {
        return !firstName.equals("");
    }

    @ResponseBody
    @GetMapping("/users")
    String printUsers() {
        StringBuilder users = new StringBuilder();
        for (User user : userList.getUserList()) {
            users.append(user).append("</br>");
        }
        return users.toString();
    }
}
