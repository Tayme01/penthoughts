package com.capstne.penthoughts.model;

import java.util.ArrayList;
import java.util.List;

public class Entries {
    private List<Entry> entryList;

    public List<Entry> getEntryList() {
        if (entryList == null){
            entryList = new ArrayList<>();
        }
        return entryList;
    }

    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }
}

