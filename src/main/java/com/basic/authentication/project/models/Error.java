package com.basic.authentication.project.models;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Error {

    @NonNull
    @Schema(description = "Http status", required = true)
    private HttpStatus status;

    @JsonFormat(shape = Shape.STRING, pattern="yyyy/MM/dd HH:mm:ss")
    @Schema(description = "Expiration date",
            type = "string",
            anyOf = String.class,
            example = "2022/04/03 20:05:10")
    private LocalDateTime date;

    @NonNull
    @Schema(description = "Error message", required = true)
    private String message;
    
}
