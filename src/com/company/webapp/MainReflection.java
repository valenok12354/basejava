package com.company.webapp;

import com.company.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Resume resume = new Resume("uuid2", "");
        Field field = resume.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        field.set(resume, "new_uuid");

        Method stringMethod = resume.getClass().getMethod("toString");
        System.out.println(stringMethod.invoke(resume));
    }
}