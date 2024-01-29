package com.FinalProject.Coders.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class dashboardUserDetails implements DTO{
    private String name;
    private String surname;
    private String blood;
    private Integer height;
    private Integer weight;
    private Resource photo;
    private Integer age;
}
