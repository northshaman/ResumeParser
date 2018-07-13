package com.shaman.parser.repository;

import com.shaman.parser.entity.ResumeObj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<ResumeObj, Long> {
}
