package com.mjc.school.repository;

import com.mjc.school.model.AuthorModel;


import java.util.List;

public interface Author {
    List<AuthorModel> readAll();
    AuthorModel create (AuthorModel authorModel);
    AuthorModel readBy (Long id);
    AuthorModel update(AuthorModel authorModel);
    Boolean delete(Long id);
}
