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

    /**
     *
     * @return List of all resumes in base
     */
    @Override
    public List<Resume> getAll() {
        return repository.findAll();
    }

    /**
     *
     * @param id  - native id in DB
     * @return Single Resume from base finding by ID
     */
    @Override
    public Resume getByID(long id) {
        return repository.findOne(id);
    }

    /**
     *
     * @param resume entity
     * @return the saved entity
     */
    @Override
    public Resume update(Resume resume) {
        return repository.saveAndFlush(resume);
    }

    /**
     *
     * @param resume entity
     * @return added resume or null if resume exist already
     */
    @Override
    public Resume add(Resume resume) {
        if (repository.getByIdOriginal(resume.getIdOriginal()) != null) {
            return null;
        } else
            return repository.saveAndFlush(resume);
    }

    /**
     *
     * @param id delete single resume from DB
     */
    @Override
    public void remove(long id) {
        repository.delete(id);
    }

    /**
     *
     * @param idOriginal original ID from parsed site
     * @return resume obj if exist
     */
    @Override
    public Resume getByIdOriginal(long idOriginal) {
        return repository.getByIdOriginal(idOriginal);
    }
}
