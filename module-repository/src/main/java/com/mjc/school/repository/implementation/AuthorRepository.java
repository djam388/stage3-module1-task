package com.mjc.school.repository.implementation;

import com.mjc.school.repository.datasources.Datasource;
import com.mjc.school.repository.interfaces.AuthorRepositoryInterface;
import com.mjc.school.repository.model.AuthorModel;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository implements AuthorRepositoryInterface {

    private List<AuthorModel> authorModelList = new ArrayList<>();

    public AuthorRepository() {
        authorModelList.addAll(Datasource.getInstance().getAuthorsAll());
    }

    @Override
    public List<AuthorModel> readAllNews() {
        return authorModelList;
    }

    @Override
    public AuthorModel readById(long id) {
        return authorModelList.get((int) id);
    }

    @Override
    public void update(AuthorModel authorModel) {
        authorModelList.add((int) authorModel.getId(), authorModel);
    }

    @Override
    public void delete(long id) {
        authorModelList.remove((int) id);
    }
}
