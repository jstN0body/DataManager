package com.github.jstN0body.datamanager;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberDatabase extends Database {

    private final List<Double> list = new ArrayList<>();

    public NumberDatabase(File file) {
        super(file);
    }

    @Override
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

    @Override
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

    @Override
    public double getDouble(int index) {
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

    @Override
    public boolean contains(double d) {
        for (Object object : this.toList().toArray()) {
            double e = Double.parseDouble((String) object);
            if (d == e) return true;
        }
        return false;
    }
}
