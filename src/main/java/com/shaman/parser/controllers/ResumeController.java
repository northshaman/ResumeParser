package com.shaman.parser.controllers;

import com.shaman.parser.utils.SiteParserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    SiteParserService parserService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
//    @ResponseBody
    public String getResume(ModelMap model){
//        return new ModelAndView("resume");
        model.addAttribute("greeting", "Привет МИР from Spring 4 MVC");
        return "resume";
    }

}
