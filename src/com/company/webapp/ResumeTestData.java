package com.company.webapp;

import com.company.webapp.model.*;

import java.time.LocalDate;
import java.util.*;

public class ResumeTestData {

    public static Resume getInstance(String uuid, String name) {
        Resume resume = new Resume("1", "Григорий Кислин");
        List<String> contactDescription = new ArrayList<>(Arrays.asList("+7(921) 855-04825", "grigory.kislin", "gkislin@yandex.ru", "Профиль LinkedIn", "Профиль GitHub", "Профиль Stackoverflow", "Домашняя страница"));

        ListSection listSectionAchievement = new ListSection(Arrays.asList("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.\n" +
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.\n" +
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.\n" +
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.\n" +
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).\n" +
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."));

        TextSection listSectionPersonal = new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.\n");

        ListSection listSectionQualification = new ListSection(Arrays.asList("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2\n" +
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce\n" +
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,\n" +
                "MySQL, SQLite, MS SQL, HSQLDB\n" +
                "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,\n" +
                "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,\n" +
                "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).\n" +
                "Python: Django.\n" +
                "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js\n" +
                "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka\n" +
                "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.\n" +
                "Инструменты: Maven + plugin development, Gradle, настройка Ngnix,\n" +
                "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.\n" +
                "Отличное знание и опыт применения концепций ООП, SOA, шаблонов\n" +
                "проектрирования, архитектурных шаблонов, UML, функционального\n" +
                "программирования\n" +
                "Родной русский, английский \"upper intermediate\"\n"));

        ListSection listSectionObjective = new ListSection(Arrays.asList("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям\n"));

        List<Organization> experienceList = new ArrayList<>();
        List<Organization> educationalList = new ArrayList<>();
        Experience experience1 = new Experience(LocalDate.of(2013, 10, 1), LocalDate.now(), "Автор проекта", "Создание, организация и проведение Java онлайн проектов и стажировок.");
        Experience experience2 = new Experience(LocalDate.of(2014, 10, 1), LocalDate.of(2016, 01, 1), "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        List<Experience> experince = new ArrayList();
        experince.add(experience1);
        experince.add(experience2);

        Organization firstOrganizaton = new Organization("Java Online Projects", "www.javaops.com", experince);
        Organization secondOrganizaton = new Organization("Wrike", "www.wrike.com", experince);

        experienceList.add(0, firstOrganizaton);
        experienceList.add(1, secondOrganizaton);
        Experience experience3 = new Experience(LocalDate.of(1987, 9, 1), LocalDate.of(1993, 7, 1),
                "Инженер (программист Fortran, C)", "");
        Organization firstEducational = new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, " +
                "механики и оптики", "www.ifmo.ru", experince );


        educationalList.add(0, firstEducational);
//        educationalList.add(1, secondEducational);

        Map<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);
        sections.put(SectionType.ACHIEVEMENT, listSectionAchievement);
        sections.put(SectionType.PERSONAL, listSectionPersonal);
        sections.put(SectionType.QUALIFICATIONS, listSectionQualification);
        sections.put(SectionType.OBJECTIVE, listSectionObjective);
        sections.put(SectionType.EXPERIENCE, new

                OrganizationSection(experienceList));
        sections.put(SectionType.EDUCATION, new

                OrganizationSection(educationalList));

        Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);

        for (
                ContactType testContact : ContactType.values()) {
            contacts.put(testContact, contactDescription.get(testContact.ordinal()));
        }

        resume.setContacts(contacts);
        resume.setSections(sections);

        System.out.println(resume.getFullName() + " " + contacts);
        System.out.println(sections.values());

        return new Resume(uuid, name);
    }
}