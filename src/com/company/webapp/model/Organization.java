package com.company.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Organization {
    private final Link homePage;
    private final String title;

    public Organization(String name, String url, LocalDate startDate, LocalDate endDate, String title, String description) {
        new Job(startDate, endDate, description);
        Objects.requireNonNull(title, "title shouldn't be null");
        this.homePage = new Link(name, url);
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(homePage, that.homePage) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, title);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", title='" + title + '\'' +
                '}';
    }

    public class Job {
        private final LocalDate startDate;
        private final LocalDate endDate;
        private final String description;

        public Job(LocalDate startDate, LocalDate endDate, String description) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.description = description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Job job = (Job) o;
            return Objects.equals(startDate, job.startDate) &&
                    Objects.equals(endDate, job.endDate) &&
                    Objects.equals(description, job.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startDate, endDate, description);
        }

        @Override
        public String toString() {
            return "Job{" +
                    "startDate=" + startDate +
                    ", endDate=" + endDate +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}
