package testfinproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import testfinproj.entities.dto.CaptchaResponseDto;
import testfinproj.entities.forLoging.User;
import testfinproj.service.impl.UserServiceImpl;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class RegistrationController {

    private final static String CAPTCHA_URL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";

    @Value("${recaptcha.secret}")
    protected String secret;

    @Autowired
    private RestTemplate restTemplate;

    private final UserServiceImpl userService;

    public RegistrationController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public ModelAndView registration(ModelAndView modelAndView){
        modelAndView.setViewName("registration");
        return modelAndView;
    }
    @PostMapping("/registration")
    public ModelAndView addUser(
            @RequestParam("g-recaptcha-response") String captchaResponse,
            @Valid User user, BindingResult bindingResult,
            ModelAndView modelAndView
    ) {

        String url = String.format(CAPTCHA_URL, secret, captchaResponse);
        CaptchaResponseDto response = restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponseDto.class);

        if (!response.isSuccess()){
            modelAndView.addObject("captchaError", "fill captcha");
        }

        if (bindingResult.hasErrors() || !response.isSuccess()){
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            modelAndView.addAllObjects(errorsMap);
            modelAndView.addObject("user", user);
            modelAndView.setViewName("registration");
            return modelAndView;
        }else {
            if (!userService.addUser(user)) {
                modelAndView.addObject("message", "User exists!");
                modelAndView.setViewName("registration");
                return modelAndView;
            }
        }

        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }


}
