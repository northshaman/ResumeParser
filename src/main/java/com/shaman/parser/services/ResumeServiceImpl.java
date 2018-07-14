package com.shaman.parser.services;


import com.shaman.parser.entity.ResumeObj;
import com.shaman.parser.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {


    @Autowired
    private ResumeRepository repository;

    @Override
    public List<ResumeObj> getAll() {
        return repository.findAll();
    }

    @Override
    public ResumeObj getByID(long id) {
        return  repository.findOne(id);
    }

    @Override
    public ResumeObj save(ResumeObj resumeObj) {
        return repository.saveAndFlush(resumeObj);
    }

    @Override
    public void remove(long id) {
        repository.delete(id);
    }
}
