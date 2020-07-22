package com.github.jstN0body.datamanager.column;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberColumn extends Column {


    private final List<Double> list = new ArrayList<>();

    public NumberColumn(String label, String pathToFolder) {
        super(label, pathToFolder);
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
                FileWriter fileWriter = new FileWriter(FILE, true);
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
            Scanner scanner = new Scanner(this.FILE);
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
            Scanner scanner = new Scanner(FILE);
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
        return this.toList().contains(d);
    }
}
