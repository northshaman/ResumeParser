package com.shaman.parser.services;


import com.shaman.parser.entity.Resume;

import java.util.List;

/**
 * Service Interface for working with Resume Entity
 */
public interface ResumeService {
    List<Resume> getAll();
    Resume getByID(long id);
    Resume update(Resume resume);
    Resume add(Resume resume);
    void remove(long id);

    Resume getByIdOriginal(long idOriginal);

    List<Resume> getAllByCityContainsAndWageLevelContainsAndExperienceContainsAndAgeEqualsAndPositionNameContains(String city, String wageLevel, String experience, Integer age, String positionName);

    List<Resume> getAllByCityContainsAndWageLevelContainsAndExperienceContainsAndPositionNameContains(String city, String wageLevel, String experience, String positionName);
}
