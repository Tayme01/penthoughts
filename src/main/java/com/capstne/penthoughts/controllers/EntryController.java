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

        Boolean success = entryDAO.addEntry(entry);

        if(success){
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(entry.getId())
                    .toUri();
            return ResponseEntity.created(location).build();
        }
        else{
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping(path="/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Entry> updateEntry(@RequestBody Entry updatedEntry, @PathVariable long id)
    {
        Entry currentEntry = entryDAO.getEntry(id);
        Entry result = entryDAO.updateEntry(currentEntry, updatedEntry);
        return new ResponseEntity<Entry>(result, HttpStatus.OK);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Long> deleteEntry(@PathVariable long id)
    {
        Entry entry = entryDAO.getEntry(id);
        Boolean isRemoved = entryDAO.deleteEntry(entry);
        if (!isRemoved){
            return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
