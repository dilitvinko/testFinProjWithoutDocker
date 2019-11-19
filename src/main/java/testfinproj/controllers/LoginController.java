package testfinproj.controllers;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class LoginController {
//
//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }
//}


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {


    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){



        modelAndView.setViewName("login");
        return modelAndView;
    }


}
