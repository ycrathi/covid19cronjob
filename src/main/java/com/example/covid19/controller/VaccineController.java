package com.example.covid19.controller;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
@ComponentScan
public class VaccineController {

    @GetMapping("/pune")
    public List<String> check() {
        RunPinCodeJob runPinCodeJob = new RunPinCodeJob();
        return runPinCodeJob.findVaccineInPuneLocation();
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to find checking website";
    }
}
