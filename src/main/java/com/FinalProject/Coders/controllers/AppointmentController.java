package com.FinalProject.Coders.controllers;

import com.FinalProject.Coders.DTOs.GeneralDTO;
import com.FinalProject.Coders.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;
    @GetMapping("/appointments")
    public ResponseEntity<GeneralDTO> getAll(@RequestParam("id")Long id){
        GeneralDTO generalDTO=new GeneralDTO();
        generalDTO.setStatusCode(HttpStatus.OK);
        generalDTO.setDTO(appointmentService.getAppointments(id));
        return ResponseEntity.ok(generalDTO);
    }

//    @PostMapping("/appointment")
//    public ResponseEntit
}
