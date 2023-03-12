package com.mjc.school.repository.interfaces;

import com.mjc.school.repository.model.AuthorModel;


import java.util.List;

public interface AuthorRepository {
    List<AuthorModel> readAll();
    AuthorModel create (AuthorModel authorModel);
    AuthorModel readBy (Long id);
    AuthorModel update(AuthorModel authorModel);
    Boolean delete(Long id);
}
