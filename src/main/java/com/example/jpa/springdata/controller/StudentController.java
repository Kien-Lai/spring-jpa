package com.example.jpa.springdata.controller;

import com.example.jpa.springdata.model.Student;
import com.example.jpa.springdata.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentServiceImpl service;

    @RequestMapping("/")
    public ModelAndView getListStudent(){
        ModelAndView mav = new ModelAndView();
        List<Student> students = service.getListStudent();
        mav.addObject("students", students);
        mav.setViewName("home");
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteARecord(@PathVariable("id") Integer id){
        try {
            service.deleteARecord(id);
        } catch (Exception e){
            System.out.println(e);
            return "home";
        }

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showUpdatePage(@PathVariable("id") Integer id){
        ModelAndView mav = new ModelAndView();
        Student student = service.getOne(id);
        mav.addObject("student",student);
        mav.setViewName("update");
        return mav;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public String editARecord(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("age") Integer age, @RequestParam("sex") String sex){
        Student s = service.getOne(id);
        if(name.length()!= 0){
            s.setName(name);
        }
        if(age > 0){
            s.setAge(age);
        }
        if(sex.length()!=0){
            s.setSex(sex);
        }
        service.save(s);
        return "redirect:/";
    }

}
