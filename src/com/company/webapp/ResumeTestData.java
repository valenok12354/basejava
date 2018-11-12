package com.company.webapp;

import com.company.webapp.model.*;

import java.time.LocalDate;
import java.util.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("1", "Freddy Cruger");
        List<String> contactDescription = new ArrayList<>(Arrays.asList("12345", "54321", "Cruger12345"));
        ListSection listSectionAchievement = new ListSection(Arrays.asList("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven.", "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike", "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM\n"));
        ListSection listSectionPersonal = new ListSection(Arrays.asList("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.\n"));
        ListSection listSectionQualification = new ListSection(Arrays.asList("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2", "Version control: Subversion, Git, Mercury, ClearCase, Perforce\n"));
        ListSection listSectionObjective = new ListSection(Arrays.asList("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям\n"));

        List<Organization> experienceList = new ArrayList<>();
        List<Organization> educationalList = new ArrayList<>();

        Organization firstOrganozaton = new Organization("ZTE", "www.zte.com", LocalDate.of(2013, 9, 1), LocalDate.now(), "Java ZTE", "this is description");
        Organization secondOrganozaton = new Organization("Xiaomi", "www.xiaomi.com", LocalDate.of(2011, 9, 1), LocalDate.of(2013, 9, 1), "Java ZTE", "this is description");

        experienceList.add(0, firstOrganozaton);
        experienceList.add(1, secondOrganozaton);

        Organization firstEducational = new Organization("MAI", "www.mai.ru", LocalDate.of(2004, 9, 1), LocalDate.of(2010, 9, 1), "Student", "this is description");
        Organization secondEducational = new Organization("School", "www.edu.ru", LocalDate.of(1994, 9, 1), LocalDate.of(2004, 9, 1), "schooler", "this is description");

        educationalList.add(0, firstEducational);
        educationalList.add(1, secondEducational);

        Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);
        sections.put(SectionType.ACHIEVEMENT, listSectionAchievement);
        sections.put(SectionType.PERSONAL, listSectionPersonal);
        sections.put(SectionType.QUALIFICATIONS, listSectionQualification);
        sections.put(SectionType.OBJECTIVE, listSectionObjective);
        sections.put(SectionType.EXPERIENCE, new OrganizationSection(experienceList));
        sections.put(SectionType.EDUCATION, new OrganizationSection(educationalList));

        Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
        for (ContactType testContact : ContactType.values()) {
            contacts.put(testContact, contactDescription.get(testContact.ordinal()));
        }
        resume.setContacts(contacts);
        resume.setSections(sections);

        System.out.println(resume);
    }
}