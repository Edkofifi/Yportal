package com.church.YPortal.dto.education;

import com.church.YPortal.entity.Education;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEducationRequest {

    private Education.Level level;
    private String institutionName;
    private String course;
    private String specialization;
}
