package com.example.springmysql.Controllers;

import com.example.springmysql.Service.AssigneeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AssigneeController {

    AssigneeService assigneeService;

    public AssigneeController(AssigneeService assigneeService) {
        this.assigneeService = assigneeService;
    }

    @GetMapping("/assignees")
    public String assignees(Model model) {
        model.addAttribute("assignees", assigneeService.listAll());
        return "assignees";
    }
}
