package com.shaman.parser.controllers;

import com.shaman.parser.entity.Resume;
import com.shaman.parser.services.ResumeService;
import com.shaman.parser.utils.SiteParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
    public String putResumes(ModelMap model) {
        System.out.println("We are here!");
        List<Resume> newResumeList = parserService.getNewResumeList();
//        TODO: fix this controller
        System.out.println("List done -> " + newResumeList.size());
        newResumeList.forEach(r -> {
            System.out.println(r);
            resumeService.add(r);
        });
        System.out.println("added to BD!");
        model.addAttribute("greeting", "Добавлено 50 новых резюме");
        return "resumes";
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseBody
    public String getMagic() {
        System.out.println("We are here!");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Добавлено 50 новых резюме";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String saveResume(ModelMap model) {
//        TODO: fix controller method
        Resume resume = new Resume();
        resume.setFio("VASYA");
        resume.setAge(22);
        resume.setIdOriginal(120);
        resume.setCity("Mine");
        resume = resumeService.add(resume);
        model.addAttribute("greeting", resume!=null ? "Добавлено резюме " +resume.getFio() : "такое резюме уже есть!");
        return "resume";
    }

    @RequestMapping(value = "/vasya/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Resume getResume(@PathVariable("id") long originalID) {
        return resumeService.getByIdOriginal(originalID);
    }
}
