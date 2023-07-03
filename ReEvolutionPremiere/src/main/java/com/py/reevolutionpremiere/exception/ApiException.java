package com.py.reevolutionpremiere.exception;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;
public record ApiException(
        String path,
        Map<String, String> errorMap,
        int statusCode,
        LocalDateTime localDateTime
        ) {

}
