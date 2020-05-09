package com.capstne.penthoughts.controllers;

import com.capstne.penthoughts.daos.EntryDAO;
import com.capstne.penthoughts.model.Entries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
