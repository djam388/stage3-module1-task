package com.mjc.school.repository.datasource;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;


import java.io.InputStream;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class DataSource {
    private List<NewsModel> newsModelList;
    private List<AuthorModel> authorModelList;
    private static DataSource INSTANCE;
    private Random rnd = new Random();

    private DataSource() {
        newsModelList = new ArrayList<>();
        authorModelList = new ArrayList<>();
        List<String> newsLines = new ArrayList<>();
        List<String> titleLines = new ArrayList<>();
        List<String> authorLines = new ArrayList<>();


            newsLines.addAll(loadFile("News.txt"));
            titleLines.addAll(loadFile("Titles.txt"));
            authorLines.addAll(loadFile("Authors.txt"));

        int countNewsLines = newsLines.size();
        int countAuthorLines = authorLines.size();


        for (int i = 0; i < countAuthorLines; i++) {
            authorModelList.add(i, new AuthorModel(i, authorLines.get(i)));

        }

        for (int i = 0; i < countNewsLines; i++) {
            LocalDateTime date = getRandomDate();
            newsModelList.add(i, new NewsModel(i,
                    titleLines.get(i),
                    newsLines.get(i),
                    date,
                    date,
                    authorModelList.get(i).getId()));
        }

    }

    public static DataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataSource();
        }
        return INSTANCE;
    }

    public List<NewsModel> getNewsAll() {
        return newsModelList;
    }

    public List<AuthorModel> getAuthorsAll() {
        return authorModelList;
    }

    private LocalDateTime getRandomDate() {
        LocalDate date = LocalDate.now().minusDays(rnd.nextInt(10));
        LocalTime time = LocalTime.of(rnd.nextInt(24), rnd.nextInt(60), rnd.nextInt(60));
        return LocalDateTime.of(date, time);
    }

    private List<String> loadFile(String fileName) {
        List<String> readLines = new ArrayList<>();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);
        Scanner s = new Scanner(is).useDelimiter("\\A");

        while (s.hasNext()) {
            readLines.add(s.nextLine());
        }
        return readLines;
    }


}
