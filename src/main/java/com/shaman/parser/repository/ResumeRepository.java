package com.shaman.parser.repository;


import com.shaman.parser.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    Resume getByIdOriginal(long idOriginal);
    List<Resume> getAllByAgeBetweenAndCityContains(Integer age, Integer age2, String city);
    List<Resume> getAllByAgeEqualsAndCityContains(Integer age, String city);

}
