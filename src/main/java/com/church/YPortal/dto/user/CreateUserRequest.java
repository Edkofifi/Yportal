package com.church.YPortal.dto.user;

import com.church.YPortal.entity.User;
import lombok.Data;

@Data
public class CreateUserRequest {
    private String email;
    private User.Role role;

}
