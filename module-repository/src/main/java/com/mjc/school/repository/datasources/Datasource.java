package com.mjc.school.repository.datasources;

import com.mjc.school.repository.model.Author;
import com.mjc.school.repository.model.News;


import java.io.InputStream;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Datasource {
    private List<News> newsList;
    private List<Author> authorList;
    private static Datasource INSTANCE;
    private Random rnd = new Random();

    private Datasource() {
        newsList = new ArrayList<>();
        authorList = new ArrayList<>();
        List<String> newsLines = new ArrayList<>();
        List<String> titleLines = new ArrayList<>();
        List<String> authorLines = new ArrayList<>();


            newsLines.addAll(loadFile("News.txt"));
            titleLines.addAll(loadFile("Titles.txt"));
            authorLines.addAll(loadFile("Authors.txt"));

        int countNewsLines = newsLines.size();
        int countAuthorLines = authorLines.size();


        for (int i = 0; i < countAuthorLines; i++) {
            authorList.add(i, new Author(i + 1, authorLines.get(i)));

        }

        for (int i = 0; i < countNewsLines; i++) {
            LocalDateTime date = getRandomDate();
            newsList.add(i, new News(i + 1,
                    titleLines.get(i),
                    newsLines.get(i),
                    date,
                    date,
                    authorList.get(i).getId()));
        }

//        newsList.add(new News(
//            id,
//            title,
//            content,
//            createDate,
//            lastUpdateDate,
//            authorId
//        ));
    }

    public static Datasource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Datasource();
        }
        return INSTANCE;
    }

    public List<News> getNewsAll() {
        return newsList;
    }

    public List<Author> getAuthorsAll() {
        return authorList;
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
