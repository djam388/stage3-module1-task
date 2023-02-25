package com.mjc.school.repository.interfaces;

import com.mjc.school.repository.model.AuthorModel;


import java.util.List;

public interface AuthorRepositoryInterface {
    List<AuthorModel> readAll();
    AuthorModel create (AuthorModel authorModel);
    AuthorModel readBy (long id);
    AuthorModel update(AuthorModel authorModel);
    boolean delete(long id);
}
