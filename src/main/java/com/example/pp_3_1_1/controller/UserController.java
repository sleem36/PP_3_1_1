package com.example.pp_3_1_1.controller;


import com.example.pp_3_1_1.exception.NoSuchUserException;
import com.example.pp_3_1_1.model.User;
import com.example.pp_3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String all (Model model) {
        model.addAttribute("test", "All users");
        List<User> allUs = userService.getAll();
        model.addAttribute("users",  allUs);
        return "index";
    }

    @GetMapping("/{id}")
    public String getUser (@PathVariable int id, Model model) {
        model.addAttribute("users", userService.getUser(id));

        if (userService.getUser(id) == null) {
            throw new NoSuchUserException("Error user id ");
        }

        return "index";
    }

    @GetMapping("/new")
    public String addUser (Model model) {
        User user = new User();
        model.addAttribute("userAdd",  user);
        return "index-info";
    }

    @PostMapping()
    public String saveUser (@ModelAttribute("userAdd") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String updateUser(@RequestParam("userId") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("userAdd", user);
        return "index-info";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") int id, Model model) {
        User user = userService.deleteUser(id);
        return "redirect:/users";
    }
}
