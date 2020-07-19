package com.github.jstN0body.datamanager;

import java.io.File;

public class Database {

    public File file;

    public Database(File file) {
        this.file = file;
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
        return "a";
    }

    public boolean contains(double d) {
        return false;
    }

    public boolean contains(String s) {
        return false;
    }
}
