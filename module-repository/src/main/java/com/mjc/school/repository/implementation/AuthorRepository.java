package com.mjc.school.repository.implementation;

import com.mjc.school.repository.datasources.DataSource;
import com.mjc.school.repository.interfaces.AuthorRepositoryInterface;
import com.mjc.school.repository.model.AuthorModel;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository implements AuthorRepositoryInterface {
    private final DataSource dataSource = DataSource.getInstance();
    private final List<AuthorModel> authorModelList = new ArrayList<>();

    public AuthorRepository() {
        authorModelList.addAll(dataSource.getAuthorsAll());
    }

    @Override
    public List<AuthorModel> readAll() {
        return authorModelList;
    }

    @Override
    public AuthorModel create(AuthorModel authorModel) {
        if (authorModelList.size() > 0) {
            authorModel.setId(authorModelList.size() + 1);
            authorModelList.add(authorModel);
        }
        else {
            authorModel.setId(1L);
            authorModelList.add(0, authorModel);
        }
        return authorModel;
    }

    @Override
    public AuthorModel readBy(Long id) {
        return authorModelList.get(id.intValue() - 1);
    }

    @Override
    public AuthorModel update(AuthorModel authorModel) {
        authorModelList.remove((int) authorModel.getId() - 1);
        authorModelList.add((int) authorModel.getId() - 1, authorModel);
        return authorModel;
    }

    @Override
    public Boolean delete(Long id) {
        authorModelList.remove(id.intValue());
        return true;
    }
}
