package com.shaman.parser.controllers;

import com.shaman.parser.entity.Resume;
import com.shaman.parser.services.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Controller
 */
@Controller
@CrossOrigin(value = "*")
public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllResumes(Model model) {

        List<Resume> resumeList = resumeService.getAll();
        model.addAttribute("resumes", resumeList);
        return "resumes";
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public String getResume(@PathVariable("id") long resumeID, Model model) {
        model.addAttribute("resume", resumeService.getByID(resumeID));
        return "resume";
    }

    // there should be DELETE OR POST method!
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteResume(@PathVariable("id") long resumeID) {
        resumeService.remove(resumeID);
        return new ModelAndView("redirect:/");
    }

    //method for Json
    @RequestMapping(value = "get/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Resume updateResume(@PathVariable("id") Resume resume) {
        return resumeService.update(resume);
    }


    @RequestMapping(value = "filter/city={city}/wageLevel={wageLevel}/experience={experience}/age={age}/positionName={positionName}", method = RequestMethod.GET)
    public String getMagic(Model model,
                           @PathVariable("city") String city,
                           @PathVariable("wageLevel") String wageLevel,
                           @PathVariable("experience") String experience,
                           @PathVariable("age") Integer age,
                           @PathVariable("positionName") String positionName) {
        model.addAttribute("resumes", resumeService.getAllByCityContainsAndWageLevelContainsAndExperienceContainsAndAgeEqualsAndPositionNameContains(city, wageLevel, experience, age, positionName));
        return "resumes";
    }

    @RequestMapping(value = "filter/city={city}/wageLevel={wageLevel}/experience={experience}/positionName={positionName}", method = RequestMethod.GET)
    public String getMagic(Model model,
                           @PathVariable("city") String city,
                           @PathVariable("wageLevel") String wageLevel,
                           @PathVariable("experience") String experience,
                           @PathVariable("positionName") String positionName) {
        model.addAttribute("resumes", resumeService.getAllByCityContainsAndWageLevelContainsAndExperienceContainsAndPositionNameContains(city, wageLevel, experience, positionName));
        return "resumes";
    }

}
