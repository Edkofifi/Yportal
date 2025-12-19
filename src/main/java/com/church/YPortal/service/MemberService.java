package com.church.YPortal.service;

import com.church.YPortal.dto.member.CreateMemberRequest;
import com.church.YPortal.dto.member.MemberResponse;
import com.church.YPortal.dto.member.UpdateMemberRequest;
import com.church.YPortal.entity.Member;
import com.church.YPortal.mapper.MemberMapper;
import com.church.YPortal.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * MemberService
 *
 * This service contains the BUSINESS LOGIC related to Members.
 * Controllers should call this service instead of talking
 * directly to the repository.
 */
@Service
@RequiredArgsConstructor
public class MemberService {

    // Repository handles database operations (CRUD)
    private final MemberRepository memberRepository;

    // Mapper converts between Entity <-> DTOs
    private final MemberMapper mapper;

    /**
     * Creates a new member.
     *
     * Flow:
     * 1. Convert CreateMemberRequest DTO to Member entity
     * 2. Save entity to database
     * 3. Convert saved entity to MemberResponse DTO
     */
    public MemberResponse create(CreateMemberRequest request) {

        // Convert request DTO into entity
        Member member = mapper.toEntity(request);

        // Save entity and convert to response DTO
        return mapper.toResponse(
                memberRepository.save(member)
        );
    }

    /**
     * Fetches all members from the database.
     *
     * @return list of MemberResponse DTOs
     */
    public List<MemberResponse> getAll() {

        // Fetch all entities and map them to response DTOs
        return mapper.toResponseList(
                memberRepository.findAll()
        );
    }

    /**
     * Fetches a single member by ID.
     *
     * @param id UUID of the member
     * @throws EntityNotFoundException if member is not found
     */
    public MemberResponse getById(UUID id) {

        // Find member or throw error if not found
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Member not found"));

        // Convert entity to response DTO
        return mapper.toResponse(member);
    }

    /**
     * Updates an existing member.
     * - Only non-null fields from UpdateMemberRequest will be updated
     * - This is handled by MapStruct in the mapper
     */
    @Transactional
    public MemberResponse update(UUID id, UpdateMemberRequest request) {

        // Fetch existing entity
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Member not found"));

        // Update entity fields using mapper (null values are ignored)
        mapper.updateEntity(request, member);

        // Save updated entity and return response
        return mapper.toResponse(
                memberRepository.save(member)
        );
    }

    /**
     * Deletes a member by ID.
     *
     * @throws EntityNotFoundException if member does not exist
     */
    @Transactional
    public void delete(UUID id) {

        // Check if member exists before deleting
        if (!memberRepository.existsById(id)) {
            throw new EntityNotFoundException("Member not found");
        }

        // Delete member from database
        memberRepository.deleteById(id);
    }
}
