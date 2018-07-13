package com.shaman.parser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller
 */
@Controller
@RequestMapping("/resumes")
public class ResumeController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
//    @ResponseBody
    public String getResume(ModelMap model){
//        return new ModelAndView("resume");
        model.addAttribute("greeting", "Hello World from Spring 4 MVC");
        return "resume";
    }

}
