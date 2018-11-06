package com.company.webapp;

import com.company.webapp.model.*;

import java.util.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("1", "Freddy Cruger");
        List<String> contactDescription = new ArrayList<>(Arrays.asList("12345", "54321", "Cruger12345"));
        ListSection listSection1 = new ListSection(Arrays.asList("1Певец"));
        ListSection listSection2 = new ListSection(Arrays.asList("2Жнец"));
        ListSection listSection3 = new ListSection(Arrays.asList("1И на дуде игрец"));

        Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
        Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);

        for (ContactType testContact : ContactType.values()) {
            contacts.put(testContact, contactDescription.get(testContact.ordinal()));
        }
        resume.setContacts(contacts);

        sections.put(SectionType.PERSONAL, listSection1);
        sections.put(SectionType.OBJECTIVE, listSection2);
        sections.put(SectionType.ACHIEVEMENT, listSection3);

        resume.setSections(sections);
        System.out.println(resume);

    }
}