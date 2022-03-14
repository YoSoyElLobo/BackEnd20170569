package com.back.tesis.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class RestResponse {
    private HttpStatus status;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object payload;

    public RestResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public RestResponse(HttpStatus status, String message, Object payload) {
        this(status, message);
        this.payload = payload;
    }
}
