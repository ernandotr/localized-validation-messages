package dev.completo.localizedvalidationmessages.controllers;

import dev.completo.localizedvalidationmessages.requests.UserRequest;
import dev.completo.localizedvalidationmessages.responses.CreateUserResponse;
import dev.completo.localizedvalidationmessages.responses.InputFieldError;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid UserRequest request, BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()) {
            List<InputFieldError> fieldErrorList = bindingResult.getFieldErrors().stream()
                    .map(error -> {
                        return new InputFieldError(error.getField(), error.getDefaultMessage());
                    })
                    .collect(Collectors.toList());

            CreateUserResponse createUserResponse = new CreateUserResponse(fieldErrorList);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(createUserResponse);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateUserResponse(1, request.getEmail()));
    }
}
