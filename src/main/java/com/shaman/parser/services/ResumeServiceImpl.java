package com.shaman.parser.services;


import com.shaman.parser.entity.Resume;
import com.shaman.parser.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {


    private final ResumeRepository repository;

    @Autowired
    public ResumeServiceImpl(ResumeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Resume> getAll() {
        return repository.findAll();
    }

    @Override
    public Resume getByID(long id) {
        return repository.findOne(id);
    }

    @Override
    public Resume update(Resume resume) {
        return repository.saveAndFlush(resume);
    }

    @Override
    public Resume add(Resume resume) {
        System.out.println("Trying to add new resume to DB");
        if (repository.getByIdOriginal(resume.getIdOriginal()) != null) {
            System.out.println("Allready have one!");
            //        TODO: delete SOUT add loging and couner
            return null;
        } else
            return repository.saveAndFlush(resume);
    }

    @Override
    public void remove(long id) {
        repository.delete(id);
    }

    @Override
    public Resume getByIdOriginal(long idOriginal) {
        return repository.getByIdOriginal(idOriginal);
    }
}
