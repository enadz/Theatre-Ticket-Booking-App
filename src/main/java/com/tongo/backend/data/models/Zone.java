package com.tongo.backend.data.models;

import java.util.ArrayList;
import java.util.List;

public class Zone {

    ArrayList<Row> rows;
    public int zoneId;
    public int zoneNumber;

    public Zone(int zoneId) {
        this.zoneId = zoneId;
        this.rows = new ArrayList<>();
    }

    public void addRow(Row row){
        rows.add(row);
    }

    public ArrayList<Row> getRows() {
        return rows;
    }
}
