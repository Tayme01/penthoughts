package com.capstne.penthoughts.controllers;

import com.capstne.penthoughts.daos.EntryDAO;
import com.capstne.penthoughts.model.Entries;
import com.capstne.penthoughts.model.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/entry")
public class EntryController {

    @Autowired
    EntryDAO entryDAO;

    @GetMapping(path="/", produces = "application/json")
    public Entries getAllEntries()
    {
        return entryDAO.getEntriesList();
    }

    @GetMapping(path="/{id}", produces = "application/json")
    public ResponseEntity<Entry> getEntry(@PathVariable int id)
    {
        Entry myEntry = entryDAO.getEntry(id);
        return new ResponseEntity<Entry>(myEntry, HttpStatus.OK);
    }

    @PostMapping(path="/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Entry> addEntry(@RequestBody Entry entry){
        long id = entryDAO.getEntriesList().getEntryList().size() + 1;
        entry.setId(id);
        entry.setCreatedTime(LocalDateTime.now());
        entry.setUpdatedTime(null);

        entryDAO.addEntry(entry);
        return new ResponseEntity<Entry>(entry, HttpStatus.CREATED);
    }

    @PutMapping(path="/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Entry> updateEntry(@RequestBody Entry updatedEntry, @PathVariable long id)
    {
        Entry currentEntry = entryDAO.getEntry(id);
        Entry result = entryDAO.updateEntry(currentEntry, updatedEntry);
        return new ResponseEntity<Entry>(result, HttpStatus.OK);
    }
}
