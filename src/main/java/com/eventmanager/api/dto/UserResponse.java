package com.eventmanager.api.dto;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    protected int id;
    protected String phone;
    protected String email;
    protected String firstName;
    protected String lastName;
    protected String role;
}
