package dev.itboot.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dev.itboot.rest.model.Teacher;
import dev.itboot.rest.service.TeacherService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TeacherController {

    private final TeacherService service;

    @GetMapping("/")
    public String getAllTeachers(Model model) {
        model.addAttribute("page", service.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String addTeacherString(@ModelAttribute Teacher teacher) {
        return "form";
    }

    @PostMapping("/process")
    public String process(@Validated @ModelAttribute Teacher teacher, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        service.save(teacher);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editTeacher(@PathVariable Long id, Model model) {
        model.addAttribute("teacher", service.findById(id));
        return "from";
    }

    @GetMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/";
    }

}
