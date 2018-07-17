package com.shaman.parser.controllers;

import com.shaman.parser.entity.Resume;
import com.shaman.parser.services.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller
 */
@Controller
@RequestMapping("/resumes")
public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllResumes(Model model) {

        List<Resume> resumeList = resumeService.getAll();
        model.addAttribute("resumes",resumeList);
        return "resumes";
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String getResume(@PathVariable("id") long resumeID, Model model) {
        model.addAttribute("resume",resumeService.getByID(resumeID));
        return "resume";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteResume(@PathVariable("id") long resumeID) {
        resumeService.remove(resumeID);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Resume updateResume(@PathVariable("id") Resume resume) {
        return resumeService.update(resume);
    }


    @RequestMapping(value = "/magic/{age1}/{age2}/{city}",method = RequestMethod.GET)
    @ResponseBody
    public List<Resume> getMagic(@PathVariable("age1") Integer age1,@PathVariable("age2") Integer age2,@PathVariable("city") String city){

        return resumeService.getFirstByAgeBetweenAndCityContains(age1,age2,city);
    }

    @RequestMapping(value = "/magic2/{age}/{city}",method = RequestMethod.GET)
    public String getMagic2(@PathVariable("age") Integer age,@PathVariable("city") String city, Model model){
            model.addAttribute("resumes", resumeService.getAllByAgeEqualsAndCityContains(age,city));
        return "resumes";
    }

}
