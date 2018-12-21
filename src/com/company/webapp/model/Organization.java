package com.company.webapp.model;

import java.util.List;
import java.util.Objects;

public class Organization {
    private List<Experience> experiences;
    private final Link homePage;

    public Organization(String name, String url, List<Experience> experiences) {
        this.homePage = new Link(name, url);
        this.experiences = experiences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(experiences, that.experiences) &&
                Objects.equals(homePage, that.homePage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(experiences, homePage);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "experiences=" + experiences +
                ", homePage=" + homePage +
                '}';
    }
}
