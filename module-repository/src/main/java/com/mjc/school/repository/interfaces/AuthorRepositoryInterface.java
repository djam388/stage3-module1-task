package com.mjc.school.repository.interfaces;

import com.mjc.school.repository.model.Author;


import java.util.List;

public interface AuthorRepositoryInterface {
    List<Author> readAllNews();
    Author readById (long id);
    void update(Author author);
    void delete(long id);
}
