package com.github.jstN0body.datamanager;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {

    private final List<Double> list = new ArrayList<>();
    private final File file;

    public Database(File file) {
        this.file = file;
    }

    public void loadData(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextDouble()) {
                list.add(scanner.nextDouble());
            }

            for (Object object : list.toArray()) {
                double d = (double) object;
                addData(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addData(double... doubles) {
        for (double d : doubles) {
            list.add(d);
            try {
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.append(d + "\n");
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Double> toList() {
        List<Double> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(this.file);
            while (scanner.hasNextDouble()) {
                list.add(scanner.nextDouble());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public double getData(int index) {
        List<Double> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextDouble()) {
                list.add(scanner.nextDouble());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.get(index);
    }
}
