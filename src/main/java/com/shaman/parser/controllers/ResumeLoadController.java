package com.shaman.parser.controllers;

import com.shaman.parser.entity.Resume;
import com.shaman.parser.services.ResumeService;
import com.shaman.parser.utils.SiteParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for adding new Resumes from site
 */
@Controller
@CrossOrigin(value = "*")
@RequestMapping("/parse")
public class ResumeLoadController {

    private final SiteParserService parserService;

    private final ResumeService resumeService;

    @Autowired
    public ResumeLoadController(SiteParserService parserService, ResumeService resumeService) {
        this.parserService = parserService;
        this.resumeService = resumeService;
    }

    @RequestMapping(value = "/addPack", method = RequestMethod.POST)
    @ResponseBody
    public String putResumes() {
        System.out.println("We are here!");

        List<Resume> newResumeList = parserService.getNewResumeList();
        System.out.println("List done -> " + newResumeList.size());
        int counter = 0;
        for (Resume resume : newResumeList) {
            if (resumeService.add(resume) != null) {
                counter++;
            } else System.out.println("already have one!");
        }
        System.out.println(counter + " resumes added to BD!");
        return "Добавлено " + counter + " новых резюме";
    }

}
