package com.capstne.penthoughts.daos;

import com.capstne.penthoughts.model.Entries;
import com.capstne.penthoughts.model.Entry;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

@Repository
public class EntryDAO {
    private Entries entriesList = new Entries();

    private static <T> BinaryOperator<T> singleObjectOnly()
    {
        return (a, b) -> {throw new RuntimeException("Duplicate elements found: " + a + " and " + b);};
    }

    public List<Entry> getEntriesList(){
        return entriesList.getEntryList();
    }

    public Entry getEntry(long id){
        Predicate<Entry> byId = entry -> entry.getId() == id;
        return entriesList.getEntryList().stream().filter(byId).reduce(singleObjectOnly()).orElse(null);
    }

    public Entry updateEntry(Entry currentEntry, Entry updatedEntry) {
        int id = entriesList.getEntryList().indexOf(currentEntry);

        updatedEntry.setCreatedTime(currentEntry.getCreatedTime());
        updatedEntry.setId(currentEntry.getId());
        updatedEntry.setUpdatedTime(LocalDateTime.now());

        entriesList.getEntryList().set(id, updatedEntry);
        return updatedEntry;
    }
    public Boolean addEntry(Entry entry){
        entriesList.getEntryList().add(entry);
        return true;
    }

    public Boolean deleteEntry(Entry entry){
        return entriesList.getEntryList().remove(entry);
    }
}
