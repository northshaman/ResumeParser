package com.shaman.parser.services;

import com.shaman.parser.entity.ResumeObj;

import java.util.List;

public interface ResumeService {

    List<ResumeObj> getAll();
    ResumeObj getByID(long id);
    ResumeObj save(ResumeObj resume);
    void remove(long id);

}
