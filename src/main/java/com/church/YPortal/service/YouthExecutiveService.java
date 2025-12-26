package com.church.YPortal.service;

import com.church.YPortal.dto.youthExecutives.CreateExecutiveRequest;
import com.church.YPortal.dto.youthExecutives.ExecutiveResponse;
import com.church.YPortal.entity.Member;
import com.church.YPortal.entity.YouthExecutive;
import com.church.YPortal.mapper.YouthExecutiveMapper;
import com.church.YPortal.repository.MemberRepository;
import com.church.YPortal.repository.YouthExecutiveRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class YouthExecutiveService {

    private final MemberRepository memberRepository;
    private final YouthExecutiveRepository youthExecutiveRepository;
    private final YouthExecutiveMapper youthExecutiveMapper;



    public ExecutiveResponse createYouthExecutive(
            CreateExecutiveRequest createExecutiveRequest){

        // check if memeber id exists
        Member member = memberRepository.findById(createExecutiveRequest.getMemberId())
                .orElseThrow(() -> new EntityNotFoundException("Member not found"));


        // convert to entity
        YouthExecutive youthExecutive = youthExecutiveMapper.toEntity(createExecutiveRequest);
        youthExecutive.setMember(member);

        return youthExecutiveMapper.toResponse(youthExecutive);
    }

    public List<ExecutiveResponse> getAllExecutives(){
        return youthExecutiveMapper.toResponseList(
                youthExecutiveRepository.findAll()
        );
    }


    public void deleteYouthExecutive(
            UUID id
    ){
        //check if youth executive exists

        YouthExecutive youthExecutive = youthExecutiveRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Youth executive not found"));

        //delete
        youthExecutiveRepository.delete(youthExecutive);
    }


}
