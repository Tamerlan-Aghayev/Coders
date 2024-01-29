package com.FinalProject.Coders.controllers;

import com.FinalProject.Coders.DTOs.*;
import com.FinalProject.Coders.entities.UserEntity;
import com.FinalProject.Coders.security.JwtService;
import com.FinalProject.Coders.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthControllers {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<GeneralDTO> register(@RequestBody RegisterUser registerUserDto) {
        UserEntity registeredUser = authenticationService.signUp(registerUserDto);
        GeneralDTO DTO = new GeneralDTO();
        DTO.setStatusCode(HttpStatus.ACCEPTED);
        DTO.setDTO(registeredUser);
        return ResponseEntity.ok(DTO);
    }

    @PostMapping("/login")
    public ResponseEntity<GeneralDTO> authenticate(@RequestBody LoginUser loginUserDto) {
        UserEntity authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        GeneralDTO DTO = new GeneralDTO();
        DTO.setStatusCode(HttpStatus.ACCEPTED);
        DTO.setDTO(loginResponse);
        return ResponseEntity.ok(DTO);
    }

//    @PostMapping(value = "/registerDoctor")
////    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<GeneralDTO> registerDoctor(@RequestBody String email)
//    {
//        System.out.println("Working!");
//        boolean result = authenticationService.makeDoctor(email);
//        System.out.println(result);
//        GeneralDTO DTO = new GeneralDTO();
//        if(result)
//        {
//            DTO.setStatusCode(HttpStatus.ACCEPTED);
//            return ResponseEntity.ok().body(DTO);
//        }
//        else {
//            DTO.setStatusCode(HttpStatus.BAD_REQUEST);
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(DTO);
//        }
//    }

    @PostMapping("/signupAdmin")
    public ResponseEntity<GeneralDTO> registerAdmin(@RequestBody RegisterUser registerUserDto) {
        UserEntity registeredUser = authenticationService.signUpAdmin(registerUserDto);
        GeneralDTO DTO = new GeneralDTO();
        DTO.setDTO(registeredUser);
        DTO.setStatusCode(HttpStatus.ACCEPTED);
        return ResponseEntity.ok(DTO);
    }


}
