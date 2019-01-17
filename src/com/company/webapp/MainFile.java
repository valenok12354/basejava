package com.company.webapp;

import java.io.File;
import java.util.Objects;

public class MainFile {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\kwx641848\\basejava";
        File file = new File(filePath);
        File dir = new File(".\\src\\com\\company\\webapp");
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }
        printDirectoryDeeply(file, " ");
    }

    public static void printDirectoryDeeply(File dir, String space) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(space + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println(space + file.getName());
                    printDirectoryDeeply(file, space + "  ");
                }
            }
        }
    }
}

