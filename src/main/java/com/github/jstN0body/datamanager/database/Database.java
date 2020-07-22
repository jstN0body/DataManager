package com.github.jstN0body.datamanager.database;

import com.github.jstN0body.datamanager.column.Column;
import com.github.jstN0body.datamanager.column.NumberColumn;
import com.github.jstN0body.datamanager.column.StringColumn;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {

    private final List<Column> columns = new ArrayList<>();

    public Database(Column... columns) {

        this.columns.addAll(Arrays.asList(columns));
    }

    public StringColumn getStringColumn(String label) {

        for (Column column : columns) {
            if (column.getLabel().equals(label)) {
                return (StringColumn) column;
            }
        }
        throw new NullPointerException("Could not find column with that label.");
    }

    public NumberColumn getNumberColumn(String label) {

        for (Column column : columns) {
            if (column.getLabel().equals(label)) {
                return (NumberColumn) column;
            }
        }
        throw new NullPointerException("Could not find column with that label.");
    }
}
