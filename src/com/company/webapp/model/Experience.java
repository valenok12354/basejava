package com.company.webapp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Experience implements Serializable {
    private  static final long serialVersionUID = 1L;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String title;
    private final String description;

    public Experience(LocalDate startDate, LocalDate endDate, String title, String description) {
        Objects.requireNonNull(startDate, "startDate shouldn't be null");
        Objects.requireNonNull(endDate, "endDate shouldn't be null");
        Objects.requireNonNull(title, "title shouldn't be null");
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience experience = (Experience) o;
        return Objects.equals(startDate, experience.startDate) &&
                Objects.equals(endDate, experience.endDate) &&
                Objects.equals(title, experience.title) &&
                Objects.equals(description, experience.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, title, description);
    }

    @Override
    public String toString() {
        return "Experience{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
