package com.github.jstN0body.datamanager.column;

import java.io.File;

public class Column {

    protected final File FILE;
    protected final String LABEL;
    public static String pathToFolder;

    public Column(String label, String pathToFolder) {

        Column.pathToFolder = pathToFolder;
        this.FILE = new File(pathToFolder + label + ".column");
        this.LABEL = label;
    }

    public String getLabel() {
        return LABEL;
    }

    public void loadData(File file) {
    }

    public void addData(double... doubles) {
    }

    public void addData(String... strings) {
    }

    public double getDouble(int index) {
        return 0;
    }

    public String getString(int index) {
        return "";
    }

    public boolean contains(double d) {
        return false;
    }

    public boolean contains(String s) {
        return false;
    }
}
