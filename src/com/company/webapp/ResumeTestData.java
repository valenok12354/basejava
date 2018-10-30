package com.company.webapp;

import com.company.webapp.model.Link1;
import com.company.webapp.model.Resume;
import com.company.webapp.model.SectionType;

import java.util.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("1", "Barack Obama");
        List<String> items = new ArrayList<>();

        items.add("\nВедущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        items.add("\nАналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и .");
        items.add("\nС 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.\n" +
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.\n");
        items.add("\nJEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2\n" +
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce\n" +
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,");

        Map<String, String> map = new HashMap<>();
        Link1 link1 = new Link1("ya.ru", "Yandex");


        for (SectionType s : SectionType.values()) {
            map.put(s.getTitle(), items.get(s.ordinal()));
        }
        for (Map.Entry<String, String> pair : map.entrySet()) {
            System.out.println(pair);
        }
    }
}