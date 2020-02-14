package com.tongo.backend.controllers;


import com.tongo.backend.services.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performance")
public class PerformanceController {

    @Autowired
    PerformanceService performanceService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity getPerformances() { return new ResponseEntity(performanceService.getPerformances(), HttpStatus.OK); }



}


