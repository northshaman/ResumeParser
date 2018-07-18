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
     * @return List of all resumes in base
     */
    @Override
    public List<Resume> getAll() {
        return repository.findAll();
    }

    /**
     * @param id - native id in DB
     * @return Single Resume from base finding by ID
     */
    @Override
    public Resume getByID(long id) {
        return repository.findOne(id);
    }

    /**
     * @param resume entity
     * @return the saved entity
     */
    @Override
    public Resume update(Resume resume) {
        return repository.saveAndFlush(resume);
    }

    /**
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
     * @param id delete single resume from DB
     */
    @Override
    public void remove(long id) {
        repository.delete(id);
    }

    /**
     * @param idOriginal original ID from parsed site
     * @return resume obj if exist
     */
    @Override
    public Resume getByIdOriginal(long idOriginal) {
        return repository.getByIdOriginal(idOriginal);
    }

    /**
     *  method for filtering exit collection of Resumes
     * @param city  - city contains parameter
     * @param wageLevel -contains parameter
     * @param experience -contains parameter
     * @param age -equal parameter
     * @param positionName-contains parameter
     * @return filtered list of resume
     */
    @Override
    public List<Resume> getAllByCityContainsAndWageLevelContainsAndExperienceContainsAndAgeEqualsAndPositionNameContains(String city, String wageLevel, String experience, Integer age, String positionName) {
        return repository.getAllByCityContainsAndWageLevelContainsAndExperienceContainsAndAgeEqualsAndPositionNameContains(city, wageLevel, experience, age, positionName);
    }

    /**
     *
     * @param city -contains parameter
     * @param wageLevel -contains parameter
     * @param experience -contains parameter
     * @param positionName -contains parameter
     * @return filtered list of resume
     */
    @Override
    public List<Resume> getAllByCityContainsAndWageLevelContainsAndExperienceContainsAndPositionNameContains(String city, String wageLevel, String experience, String positionName) {
        return repository.getAllByCityContainsAndWageLevelContainsAndExperienceContainsAndPositionNameContains(city, wageLevel, experience, positionName);
    }
}
