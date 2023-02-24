package com.mjc.school.repository.implementation;

import com.mjc.school.repository.datasources.Datasource;
import com.mjc.school.repository.interfaces.AuthorRepositoryInterface;
import com.mjc.school.repository.model.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository implements AuthorRepositoryInterface {

    private List<Author> authorList = new ArrayList<>();

    public AuthorRepository() {
        authorList.addAll(Datasource.getInstance().getAuthorsAll());
    }

    @Override
    public List<Author> readAllNews() {
        return authorList;
    }

    @Override
    public Author readById(long id) {
        return authorList.get((int) id);
    }

    @Override
    public void update(Author author) {
        authorList.add((int) author.getId(), author);
    }

    @Override
    public void delete(long id) {
        authorList.remove((int) id);
    }
}
