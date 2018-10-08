package com.company.webapp;

import com.company.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        field.set(r, "new_uuid");

        Method StringMethod = r.getClass().getMethod("toString");
        StringMethod.invoke(r);
        System.out.println(r);
    }
}