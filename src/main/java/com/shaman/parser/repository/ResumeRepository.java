package com.shaman.parser.repository;


import com.shaman.parser.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    Resume getByIdOriginal(long idOriginal);

}
