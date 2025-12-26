package com.church.YPortal.service;

import com.church.YPortal.dto.youthExecutives.CreateExecutiveRequest;
import com.church.YPortal.dto.youthExecutives.ExecutiveResponse;
import com.church.YPortal.entity.Member;
import com.church.YPortal.entity.YouthExecutive;
import com.church.YPortal.mapper.YouthExecutiveMapper;
import com.church.YPortal.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YouthExecutiveService {

    private final MemberRepository memberRepository;
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


}
