package com.church.YPortal.dto.user;

import com.church.YPortal.entity.User;
import lombok.Data;

@Data
public class CreateUserRequest {
    private String email;
    private String password;
    private User.Role role;


}
