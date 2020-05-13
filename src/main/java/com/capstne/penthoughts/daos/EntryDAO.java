package com.capstne.penthoughts.daos;

import com.capstne.penthoughts.model.Entries;
import com.capstne.penthoughts.model.Entry;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

@Repository
public class EntryDAO {
    private static Entries entriesList = new Entries();

    static
    {
        entriesList.getEntryList().add(new Entry(1, LocalDateTime.now(), null, "My first entry", "Random Content here"));
        entriesList.getEntryList().add(new Entry(2, LocalDateTime.now(), null, "My second entry", "Random content here"));
        entriesList.getEntryList().add(new Entry(3, LocalDateTime.now(), null, "My third entry", "Random content here"));
    }

    private static <T> BinaryOperator<T> singleObjectOnly()
    {
        return (a, b) -> {throw new RuntimeException("Duplicate elements found: " + a + " and " + b);};
    }

    public Entries getEntriesList(){
        return entriesList;
    }

    public Entry getEntry(long id){
        Predicate<Entry> byId = entry -> entry.getId() == id;
        return entriesList.getEntryList().stream().filter(byId).reduce(singleObjectOnly()).get();
    }

    public Entry updateEntry(Entry currentEntry, Entry updatedEntry) {
        int id = entriesList.getEntryList().indexOf(currentEntry);

        updatedEntry.setCreatedTime(currentEntry.getCreatedTime());
        updatedEntry.setId(currentEntry.getId());
        updatedEntry.setUpdatedTime(LocalDateTime.now());

        entriesList.getEntryList().set(id, updatedEntry);
        return updatedEntry;
    }
    public void addEntry(Entry entry){
        entriesList.getEntryList().add(entry);
    }
}
