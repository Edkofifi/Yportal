package com.church.YPortal.service;

import com.church.YPortal.dto.education.CreateEducationRequest;
import com.church.YPortal.dto.education.EducationResponse;
import com.church.YPortal.dto.education.UpdateEducationRequest;
import com.church.YPortal.entity.Education;
import com.church.YPortal.entity.Member;
import com.church.YPortal.mapper.EducationMapper;
import com.church.YPortal.repository.EducationRepository;
import com.church.YPortal.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EducationService {

    private final EducationMapper educationMapper;
    private final EducationRepository educationRepository;
    private final MemberRepository memberRepository;

    /**
     * Creates a new education.
     *
     * Flow:
     * 1. Convert CreateEducationRequest DTO to Education entity
     * 2. Save entity to database
     * 3. Convert saved entity to EducationResponse DTO
     */
    public EducationResponse createEducation(CreateEducationRequest request){

        //  load the parent member
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() ->
                         new EntityNotFoundException("Associated member not found"));

        // map the dto to education entity
        Education education = educationMapper.toEntity(request);

        education.setMember(member);
        return educationMapper.toResponse(
                educationRepository.save(education)
        );

    }
    /**
     * Fetches all educations from the database.
     *
     * @return list of EducationResponse DTOs
     */
    public List<EducationResponse> getAll(){
        return  educationMapper.toResponseList(
                educationRepository.findAll());

    }


    /**
     * Fetches a single education by ID.
     *
     * @param id UUID of that education
     * @throws EntityNotFoundException if education is not found
     */
    public EducationResponse getEducationById(UUID id){
        Education education = educationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Education not found"));

        return educationMapper.toResponse(education);
    }


    /**
     * Deletes a education by ID.
     *
     * @throws EntityNotFoundException if education does not exist
     */

    public void deleteEducation(UUID id){

        Education education = educationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Education not found"));

        educationRepository.deleteById(id);
    }



    /**
     * Updates an existing education.
     * - Only non-null fields from UpdateEducationRequest will be updated
     * - This is handled by MapStruct in the mapper
     */
    @Transactional
    public EducationResponse updateEducation(
            UUID id,
            UpdateEducationRequest request
    ){
        Education education = educationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Education not found"));

        // Update entity fields using mapper (null values are ignored)
        educationMapper.updateEntity(request, education);

        // Save updated entity and return response
        return educationMapper.toResponse(educationRepository.save(education));

    }
}
