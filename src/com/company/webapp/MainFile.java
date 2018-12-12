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
        print(file);
    }

    public static void print(File directory) {
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isDirectory()) {
                print(file);
            } else {
                System.out.println(file);
            }
        }
    }
}
