package com.company.webapp;

import com.company.webapp.model.*;

import java.util.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("1", "Barack Obama");
        List<String> contactDescription = new ArrayList<>(Arrays.asList("1245", "54321", "valenok12345"));
        List<String> sectionDescription = new ArrayList<>(Arrays.asList("Ведущий стажировок", "Enterprise",  "технологиям"));

        ListSection listSection = new ListSection(sectionDescription);

        Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
        Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);

        for (ContactType testContact : ContactType.values()) {
            contacts.put(testContact, contactDescription.get(testContact.ordinal()));
        }
        resume.setContacts(contacts);

        for (SectionType testSection : SectionType.values()) {
            sections.put(testSection, listSection.getItems());
        }
        //sections.put(SectionType.PERSONAL, (Section) listSection.getItems());

        resume.setSections(sections);

        System.out.println(resume);

    }
}