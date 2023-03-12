package com.mjc.school.repository.implementation;

import com.mjc.school.repository.datasource.DataSource;
import com.mjc.school.repository.model.AuthorModel;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository implements com.mjc.school.repository.interfaces.AuthorRepository {
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
