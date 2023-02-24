package com.mjc.school.repository.interfaces;

import com.mjc.school.repository.model.AuthorModel;


import java.util.List;

public interface AuthorRepositoryInterface {
    List<AuthorModel> readAllNews();
    AuthorModel readById (long id);
    void update(AuthorModel authorModel);
    void delete(long id);
}
