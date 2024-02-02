package com.FinalProject.Coders.services;


import com.FinalProject.Coders.DTOs.GeneralDTO;

import com.FinalProject.Coders.entities.Attachment;
import com.FinalProject.Coders.entities.UserEntity;
import com.FinalProject.Coders.repositories.AttachmentRepo;
import com.FinalProject.Coders.repositories.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AttachmentService {
    private final UserRepo userRepo;
    private final AttachmentRepo attachmentRepo;
    private final ResourceLoader resourceLoader;

    @Transactional()
    public GeneralDTO uploadImage(MultipartFile file , UserEntity user){
        GeneralDTO DTO = new GeneralDTO();
        Attachment attachment;
        if(user.getAttachment() == null)
        {
            attachment = new Attachment();
        }
        else attachment = user.getAttachment();


        if (file.isEmpty()) {
            DTO.setStatusCode(HttpStatus.BAD_REQUEST);
            return DTO;
        }

        try {
            String uploadDir = "/opt/java_projects/coders/Coders/src/main/java/com/FinalProject/Coders/attachments";
            // Create the directory if it doesn't exist
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String fileName = file.getOriginalFilename();
            String filePath = uploadDir + File.separator + fileName;


            attachment.setPhoto(filePath);

            File dest = new File(filePath);
            file.transferTo(dest);

            attachmentRepo.save(attachment);
            user.setAttachment(attachment);
            userRepo.save(user);
            DTO.setStatusCode(HttpStatus.ACCEPTED);
            return DTO;
        } catch (IOException e) {
            e.printStackTrace();
            DTO.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            return DTO;
        }
    }

    public Resource getPhoto(String photoPath)
    {
        return resourceLoader.getResource(photoPath);
    }
}
