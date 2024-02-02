package com.FinalProject.Coders.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/doctor")
@RequiredArgsConstructor
public class DoctorControllers {

    private final DoctorService;
}
