package com.shaman.parser.services;


import com.shaman.parser.entity.Resume;

import java.util.List;

/**
 *
 */
public interface ResumeService {
    List<Resume> getAll();
    Resume getByID(long id);
    Resume update(Resume resume);
    Resume add(Resume resume);
    void remove(long id);

    Resume getByIdOriginal(long idOriginal);
}
