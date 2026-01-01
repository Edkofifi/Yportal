package com.church.YPortal.service;

import com.church.YPortal.dto.branch.BranchResponse;
import com.church.YPortal.dto.branch.CreateBranchRequest;
import com.church.YPortal.dto.member.MemberResponse;
import com.church.YPortal.dto.member.UpdateMemberRequest;
import com.church.YPortal.dto.user.CreateUserRequest;
import com.church.YPortal.dto.user.UpdateUserRequest;
import com.church.YPortal.dto.user.UserResponse;
import com.church.YPortal.entity.BranchChurch;
import com.church.YPortal.entity.Member;
import com.church.YPortal.entity.User;
import com.church.YPortal.mapper.UserMapper;
import com.church.YPortal.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;


/**
 * UserService
 *
 * This service contains the BUSINESS LOGIC related to user.
 * Controllers should call this service instead of talking
 * directly to the repository.
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse createUser(CreateUserRequest request) {

        // generate password and hash it
        String rawPassword = UUID.randomUUID().toString().substring(0, 8);
        String hashedPassword = passwordEncoder.encode(rawPassword);


        // Convert request DTO into entity
        User user = userMapper.toEntity(request);

        // add to user
        user.setPassword(hashedPassword);

        // log it for now
        System.out.println("User passsword: " + hashedPassword);
        // Save entity and convert to response DTO
        return userMapper.toResponse(
                userRepository.save(user)
        );
    }

    /**
     * Fetches all users from the database.
     *
     * @return list of UserResponse DTOs
     */
    public List<UserResponse> getAllUsers() {

        // Fetch all entities and map them to response DTOs
        return userMapper.toResponseList(
                userRepository.findAll()
        );
    }

    /**
     * Fetches a single user by ID.
     *
     * @param id UUID of the user
     * @throws EntityNotFoundException if user  is not found
     */
    public UserResponse getUserById(UUID id) {

        // Find user or throw error if not found
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Member not found"));

        // Convert entity to response DTO
        return userMapper.toResponse(user);
    }

    /**
     * Updates an existing user.
     * - Only non-null fields from UpdateUserRequest will be updated
     * - This is handled by MapStruct in the mapper
     */
    @Transactional
    public UserResponse updateUser(UUID id, UpdateUserRequest request) {

        // Fetch existing entity
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        // Update entity fields using mapper (null values are ignored)
        userMapper.updateEntity(request, user);

        // Save updated entity and return response
        return userMapper.toResponse(
                userRepository.save(user)
        );
    }

    /**
     * Deletes a user by ID.
     *
     * @throws EntityNotFoundException if user does not exist
     */
    @Transactional
    public void deleteUser(UUID id) {

        // Check if user exists before deleting
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found");
        }

        // Delete member from database
        userRepository.deleteById(id);
    }

}
