package com.mjc.school.implementation;

import com.mjc.school.datasource.DataSource;
import com.mjc.school.repository.Author;
import com.mjc.school.model.AuthorModel;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository implements Author {
    private final List<AuthorModel> authorModelList = new ArrayList<>();

    public AuthorRepository() {
        DataSource dataSource = DataSource.getInstance();
        authorModelList.addAll(dataSource.getAuthorsAll());
    }

    @Override
    public List<AuthorModel> readAll() {
        return authorModelList;
    }

    @Override
    public AuthorModel create(AuthorModel authorModel) {

            authorModel.setId(authorModelList.size() + 1);
            authorModelList.add(authorModel);

        return authorModel;
    }

    @Override
    public AuthorModel readBy(Long id) {
        return authorModelList.get(id.intValue());
    }

    @Override
    public AuthorModel update(AuthorModel authorModel) {
        authorModelList.set((int) authorModel.getId(), authorModel);
        return authorModel;
    }

    @Override
    public Boolean delete(Long id) {
        authorModelList.remove(id.intValue());
        return true;
    }
}
