package com.church.YPortal.mapper;

import com.church.YPortal.dto.user.CreateUserRequest;
import com.church.YPortal.dto.user.UpdateUserRequest;
import com.church.YPortal.dto.user.UserResponse;
import com.church.YPortal.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    User toEntity(CreateUserRequest request);

    UserResponse toResponse(User user);

    List<UserResponse> toResponseList(List<User> users);


    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    void updateEntity(
            UpdateUserRequest request,
            @MappingTarget User user
    );
}
