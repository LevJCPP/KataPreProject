package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @GetMapping()
    public String getAllUsers(ModelMap model) {
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("user", new User());
        return "users";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String getEditUser(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit_user";
    }

    @PatchMapping()
    public String editUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(ModelMap model, @PathVariable("id") Long id) {
        userService.removeById(id);
        return "redirect:/users";
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
