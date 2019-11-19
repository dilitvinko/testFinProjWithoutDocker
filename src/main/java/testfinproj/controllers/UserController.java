package testfinproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import testfinproj.entities.forLoging.Role;
import testfinproj.entities.forLoging.User;
import testfinproj.service.impl.UserServiceImpl;

import java.util.Map;

@Controller
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public ModelAndView userList(ModelAndView modelAndView){
        modelAndView.addObject("users", userService.allUsers());
        modelAndView.setViewName("userList");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public ModelAndView userEdit(ModelAndView modelAndView, @PathVariable User user){
        modelAndView.addObject("user", user);
        modelAndView.addObject("roles", Role.values());
        modelAndView.setViewName("userEdit");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ModelAndView userSave (
            ModelAndView modelAndView,
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ){
        userService.saveUser(user, username, form);

        modelAndView.setViewName("redirect:/user");
        return modelAndView;
    }
}
