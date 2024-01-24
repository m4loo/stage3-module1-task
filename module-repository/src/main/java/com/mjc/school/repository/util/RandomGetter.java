package com.mjc.school.repository.util;

import com.mjc.school.repository.constants.PathConstants;
import com.mjc.school.repository.model.AuthorModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGetter {
    private final List<AuthorModel> allAuthorModels = new ArrayList<>();
    private final Random random = new Random();
    PathConstants pathConstants = new PathConstants();

    public List<AuthorModel> getAllAuthors() {
        return this.allAuthorModels;
    }

    public void createAuthorId() throws IOException {
        Path path = Path.of(pathConstants.getAuthorFileRepository());

        List<String> lines = Files.readAllLines(path);

        for (long i = 0; i < lines.size(); i++) {
            long authorId = i + 1;
            String authorName = lines.get((int) i);
            allAuthorModels.add(new AuthorModel(authorId, authorName));
        }
    }

    public long getRandomAuthorId() {
        int randomIndex = random.nextInt(allAuthorModels.size());
        return allAuthorModels.get(randomIndex).getAuthorId();
    }

    public String getRandomTitle() throws IOException {
        Path path = Path.of(pathConstants.getTitleFileRepository());
        List<String> allTitles = Files.readAllLines(path);

        int randomIndex = random.nextInt(allTitles.size());

        return allTitles.get(randomIndex);
    }

    public String getRandomContent() throws IOException {
        Path path = Path.of(pathConstants.getContentFileRepository());
        List<String> allContent = Files.readAllLines(path);

        int randomIndex = random.nextInt(allContent.size());

        return allContent.get(randomIndex);
    }

    public LocalDateTime getRandomDateTime() {
        int maxDaysInMonth = 31;
        int year = LocalDateTime.now().getYear() - random.nextInt(24);
        int month = 1 + random.nextInt(12);

        if (month == 2) maxDaysInMonth = Year.isLeap(year) ? 29 : 28;
        else if (month == 4 || month == 6 || month == 9 || month == 11) maxDaysInMonth = 30;

        int day = 1 + random.nextInt(maxDaysInMonth);
        int hour = random.nextInt(24);
        int minute = random.nextInt(60);
        int second = random.nextInt(60);

        return LocalDateTime.of(year, month, day, hour, minute, second);
    }

    public LocalDateTime getRandomCreatedDate() {
        return getRandomDateTime();
    }

    public LocalDateTime getRandomLastUpdatedDate(LocalDateTime createdDate) {
        LocalDateTime lastUpdatedDate = getRandomDateTime();
        while (lastUpdatedDate.isBefore(createdDate)) lastUpdatedDate = getRandomDateTime();
        return lastUpdatedDate;
    }
}