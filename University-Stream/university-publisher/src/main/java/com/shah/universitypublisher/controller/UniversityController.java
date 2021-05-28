package com.shah.universitypublisher.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shah.universitypublisher.model.Universities;
import com.shah.universitypublisher.model.University;
import com.shah.universitypublisher.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    @Autowired
    UniversityService universityService;


    @GetMapping("/load")
    public String loadUni() throws IOException {
        ;
        return "Loaded ["+universityService.load()+"] universities to the stream";

    }
}
