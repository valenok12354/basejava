package com.company.webapp;

import com.company.webapp.model.*;

import java.time.LocalDate;
import java.util.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("1", "Григорий Кислин");
        List<String> contactDescription = new ArrayList<>(Arrays.asList("+7(921) 855-04825", "grigory.kislin", "gkislin@yandex.ru", "Профиль LinkedIn", "Профиль GitHub", "Профиль Stackoverflow", "Домашняя страница"));

        ListSection listSectionAchievement = new ListSection(Arrays.asList("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.\n" +
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.\n" +
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.\n" +
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.\n" +
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).\n" +
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."));

        ListSection listSectionPersonal = new ListSection(Arrays.asList("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.\n"));

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

        Organization firstOrganizaton = new Organization("Java Online Projects", "www.javaops.com", LocalDate.of(2013, 10, 1), LocalDate.now(), "Автор проекта", "Создание, организация и проведение Java онлайн проектов и стажировок.");

        Organization secondOrganizaton = new Organization("Wrike", "www.wrike.com", LocalDate.of(2014, 10, 1), LocalDate.of(2016, 01, 1), "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");

        Organization thirdOrganizaton = new Organization("RIT Center", "www.rit.com", LocalDate.of(2012, 04, 1), LocalDate.of(2014, 10, 1), "Java архитектор", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python");

        experienceList.add(0, firstOrganizaton);
        experienceList.add(1, secondOrganizaton);
        experienceList.add(2, thirdOrganizaton);

        Organization firstEducational = new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "www.ifmo.ru", LocalDate.of(1987, 9, 1), LocalDate.of(1993, 7, 1), "Инженер (программист Fortran, C)", "");

        Organization secondEducational = new Organization("Заочная физико-техническая школа при МФТИ", "www.school.mipt.ru", LocalDate.of(1984, 9, 1), LocalDate.of(1987, 6, 1), "школьник", "закончил с отличием");

        educationalList.add(0, firstEducational);
        educationalList.add(1, secondEducational);

        Map<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);
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

        System.out.println(resume.getFullName() + " " + contacts);
        System.out.println(sections.values());
    }

}