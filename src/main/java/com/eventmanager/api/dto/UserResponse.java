package com.eventmanager.api.dto;

import lombok.*;

import java.util.UUID;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    protected UUID id;
    protected String phone;
    protected String email;
    protected String firstName;
    protected String lastName;
    protected String role;
}
