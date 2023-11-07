package dev.completo.localizedvalidationmessages.responses;

import java.util.List;

public class CreateUserResponse {

    private List<InputFieldError> fieldErrors;
    private Integer id;
    private String name;

    public CreateUserResponse(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CreateUserResponse(List<InputFieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public List<InputFieldError> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<InputFieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
