package com.FinalProject.Coders.services;

import com.FinalProject.Coders.DTOs.DTO;
import com.FinalProject.Coders.DTOs.GeneralDTO;
import com.FinalProject.Coders.DTOs.dashboardUserDetails;
import com.FinalProject.Coders.entities.Attachment;
import com.FinalProject.Coders.entities.PatientInfo;
import com.FinalProject.Coders.entities.UserEntity;
import com.FinalProject.Coders.repositories.AttachmentRepo;
import com.FinalProject.Coders.repositories.PatientRepo;
import com.FinalProject.Coders.repositories.UserRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Data
@Slf4j
public class dashboardService {
    private final UserRepo userRepo;
    private final AttachmentRepo attachmentRepo;
    private final PatientRepo patientRepo;
    private final AttachmentService attachmentService;
    @Transactional
    public GeneralDTO gettingUserDetails(UserEntity user) {
        GeneralDTO DTO = new GeneralDTO();
//        try {


            log.info("1");
            log.info("2");
            dashboardUserDetails userDetails = new dashboardUserDetails();
            System.out.println("3");
            userDetails.setName(user.getFirstName());
            System.out.println("4");
            userDetails.setSurname(user.getLastName());
            System.out.println("5");
            if(user.getPatientInfo() != null)
            {

//                PatientInfo patientInfo = patientRepo.findById(user.getPatientInfo().getId()).orElseThrow(RuntimeException::new);
                PatientInfo patientInfo = user.getPatientInfo();
//                assert patientInfo != null;
                userDetails.setHeight(patientInfo.getHeight());
                userDetails.setWeight(patientInfo.getWeight());
                userDetails.setBlood(patientInfo.getBlood().toString());

            }

            System.out.println("7");

            System.out.println("8!");
            userDetails.setAge(user.getAge());
            if (user.getAttachment() == null) {
                System.out.println("9!");
                userDetails.setPhoto(null);
            } else {
                Attachment attachment = attachmentRepo.findById(user.getAttachment().getId()).orElse(null);
                System.out.println("10!");
                assert attachment != null;
                Resource photo = attachmentService.getPhoto(attachment.getPhoto());
                System.out.println("11!");
                userDetails.setPhoto(photo);
            }
            DTO.setDTO(userDetails);
//        } catch (NullPointerException e)
//        {
//            log.error("Exception occurred!");
//            DTO.setStatusCode(HttpStatus.BAD_REQUEST);
//        }
        return DTO;


    }
}
