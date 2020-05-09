package com.capstne.penthoughts.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/entry")
public class EntryController {

    @GetMapping(path="/", produces = "application/json")
    public String getAllEntries()
    {
        return "Hello!";
    }
}
