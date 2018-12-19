package com.company.webapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Organization {
    private List<Job> jobs = new ArrayList<>();
    private final Link homePage;

    public Organization(String name, String url, List<Job> jobs) {
        this.homePage = new Link(name, url);
        this.jobs = jobs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(jobs, that.jobs) &&
                Objects.equals(homePage, that.homePage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobs, homePage);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "jobs=" + jobs +
                ", homePage=" + homePage +
                '}';
    }
}
