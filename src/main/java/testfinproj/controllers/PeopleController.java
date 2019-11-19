package testfinproj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import testfinproj.entities.People;
import testfinproj.service.impl.PeopleServiceImpl;

import java.util.List;

@Controller
public class PeopleController {
    private final PeopleServiceImpl peopleService;

    public PeopleController(PeopleServiceImpl peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/allPeople")
    public ModelAndView allPeople(ModelAndView modelAndView) {
        List<People> peopleList = peopleService.getAll();
        modelAndView.setViewName("people");
        modelAndView.addObject("peopleList", peopleList);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editPeople(ModelAndView modelAndView, @PathVariable long id) {
        People people = peopleService.getOnePeople(id);
        modelAndView.addObject("people", people);
        modelAndView.setViewName("editPeople");
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editPeople(ModelAndView modelAndView, @PathVariable("id") long id, @ModelAttribute("people") People people) {
        people.setId(id);
        peopleService.editPeople(people);
        modelAndView.setViewName("redirect:/allPeople");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addPeople(ModelAndView modelAndView) {
        modelAndView.setViewName("editPeople");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addPeople(ModelAndView modelAndView, @ModelAttribute("people") People people) {
        peopleService.addPeople(people);
        modelAndView.setViewName("redirect:/allPeople");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deletePeople(ModelAndView modelAndView, @PathVariable("id") long id) {
        People people = peopleService.getOnePeople(id);
        peopleService.delete(people);
        modelAndView.setViewName("redirect:/allPeople");
        return modelAndView;
    }

}
