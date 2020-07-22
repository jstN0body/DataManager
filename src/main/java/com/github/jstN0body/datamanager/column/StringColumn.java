package com.github.jstN0body.datamanager.column;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringColumn extends Column {

    private final List<String> list = new ArrayList<>();

    public StringColumn(String label, String pathToFolder) {
        super(label, pathToFolder);
    }


    @Override
    public void loadData(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }

            for (Object object : list.toArray()) {
                String s = (String) object;
                addData(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addData(String... strings) {
        for (String s : strings) {
            list.add(s);
            try {
                FileWriter fileWriter = new FileWriter(FILE, true);
                fileWriter.append(s + "\n");
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> toList() {
        List<String> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(this.FILE);
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String getString(int index) {
        List<String> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(FILE);
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.get(index);
    }

    @Override
    public boolean contains(String s) {
        return this.toList().contains(s);
    }
}
