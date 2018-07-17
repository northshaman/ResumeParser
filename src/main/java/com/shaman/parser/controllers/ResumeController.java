package com.shaman.parser.controllers;

import com.shaman.parser.entity.Resume;
import com.shaman.parser.services.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public Resume getResume(@PathVariable("id") long resumeID) {

        return resumeService.getByID(resumeID);
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

}
