package com.capstne.penthoughts.daos;

import com.capstne.penthoughts.model.Entries;
import com.capstne.penthoughts.model.Entry;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class EntryDAO {
    private static Entries entriesList = new Entries();

    static
    {
        entriesList.getEntryList().add(new Entry(1, LocalDateTime.now(), null, "My first entry", "Random Content here"));
        entriesList.getEntryList().add(new Entry(2, LocalDateTime.now(), null, "My second entry", "Random content here"));
        entriesList.getEntryList().add(new Entry(3, LocalDateTime.now(), null, "My third entry", "Random content here"));
    }

    public Entries getEntriesList(){
        return entriesList;
    }

    public void addEntry(Entry entry){
        entriesList.getEntryList().add(entry);
    }
}
