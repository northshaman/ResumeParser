package com.shaman.parser.controllers;

import com.shaman.parser.entity.ResumeObj;
import com.shaman.parser.services.ResumeService;
import com.shaman.parser.utils.SiteParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Controller
 */
@Controller
@RequestMapping("/resumes")
public class ResumeController {
    @Autowired
    private SiteParserService parserService;

    @Autowired
    private ResumeService resumeService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
//    @ResponseBody
    public String getResume(ModelMap model){
//        return new ModelAndView("resume");
        model.addAttribute("greeting", "Привет МИР from Spring 4 MVC");
        return "resume";
    }

    @RequestMapping(value = "/addPack", method = RequestMethod.GET)
    public String putResumes(ModelMap model){
        List<ResumeObj> newResumeList = parserService.getNewResumeList();
//        TODO: fix this controller
        System.out.println("List done");
        newResumeList.forEach(r->resumeService.save(r));
        System.out.println("added to BD!");
        model.addAttribute("greeting", "Добавлено 50 новых резюме");
        return "resume";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String saveResume(ModelMap model){
//        TODO: fix controller method
        ResumeObj resumeObj = new ResumeObj();
        resumeObj.setFio("VASYA");
        resumeObj.setAge(22);
        resumeObj.setIdOriginal(120);
        resumeObj.setCity("Mine");
        System.out.println(resumeObj);
        resumeService.save(resumeObj);
        model.addAttribute("greeting", "Добавили одного Васю");
        return "resume";
    }
}
