package dev.completo.localizedvalidationmessages.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UserRequest {

    @NotEmpty(message = "{validation.email.notEmpty}")
    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
