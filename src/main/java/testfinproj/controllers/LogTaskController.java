package testfinproj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import testfinproj.entities.LogTask;
import testfinproj.entities.People;
import testfinproj.entities.Task;
import testfinproj.service.impl.LogTaskServiceImpl;
import testfinproj.service.impl.PeopleServiceImpl;
import testfinproj.service.impl.TaskServiceImpl;

import java.util.List;

@Controller
public class LogTaskController {
    private final PeopleServiceImpl peopleService;
    private final TaskServiceImpl taskService;
    private final LogTaskServiceImpl logTaskService;

    public LogTaskController(PeopleServiceImpl peopleService, TaskServiceImpl taskService, LogTaskServiceImpl logTaskService) {
        this.peopleService = peopleService;
        this.taskService = taskService;
        this.logTaskService = logTaskService;
    }

    @GetMapping("/tasks/{idPeople}/logs/{idTask}")
    public ModelAndView allLogsOfOneTask(ModelAndView modelAndView, @PathVariable("idPeople") long idPeople,
                                         @PathVariable("idTask") long idTask) {
        People people = peopleService.getOnePeople(idPeople);
        Task task = taskService.getOneTask(idTask);
        List<LogTask> logList = logTaskService.getAllLogsFromTask(task);
        modelAndView.addObject("people", people);
        modelAndView.addObject("logList", logList);
        modelAndView.addObject("task", task);
        modelAndView.setViewName("logs");
        return modelAndView;
    }


    @GetMapping("/tasks/{idPeople}/task/{idTask}/addLog")
    public ModelAndView addLog(ModelAndView modelAndView, @PathVariable("idPeople") long idPeople,
                               @PathVariable("idTask") long idTask) {
        People people = peopleService.getOnePeople(idPeople);
        Task task = taskService.getOneTask(idTask);
        modelAndView.addObject("people", people);
        modelAndView.addObject("task", task);
        modelAndView.setViewName("addLog");
        return modelAndView;
    }

    @PostMapping("/tasks/{idPeople}/task/{idTask}/addLog")
    public ModelAndView addLog(ModelAndView modelAndView, @PathVariable("idPeople") long idPeople,
                               @PathVariable("idTask") long idTask, @ModelAttribute("logTask") LogTask logTask) {
        Task task = taskService.getOneTask(idTask);
        logTask.setTask(task);
        logTaskService.addLogTask(logTask);
        modelAndView.setViewName("redirect:/tasks/" + idPeople + "/logs/" + idTask);
        return modelAndView;
    }

}
