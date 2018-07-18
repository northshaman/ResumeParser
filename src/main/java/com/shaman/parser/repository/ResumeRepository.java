package com.shaman.parser.repository;


import com.shaman.parser.entity.Resume;
import org.apache.regexp.RE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    Resume getByIdOriginal(long idOriginal);
    List<Resume> getAllByCityContainsAndWageLevelContainsAndExperienceContainsAndAgeEqualsAndPositionNameContains(String city, String wageLevel, String experience, Integer age, String positionName);
    List<Resume> getAllByCityContainsAndWageLevelContainsAndExperienceContainsAndPositionNameContains(String city, String wageLevel, String experience, String positionName);

}
