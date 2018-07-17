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

    List<Resume> getFirstByAgeBetweenAndCityContains(Integer age, Integer age2, String city);

    List<Resume> getAllByAgeEqualsAndCityContains(Integer age, String city);
}
