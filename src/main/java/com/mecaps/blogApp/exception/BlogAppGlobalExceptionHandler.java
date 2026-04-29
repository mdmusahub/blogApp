package com.mecaps.blogApp.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
public class BlogAppGlobalExceptionHandler {

    @ExceptionHandler(ResourcesNotFoundException.class)
    public ErrorResponse resourcesNotFound(
            ResourcesNotFoundException resourcesNotFoundException,
                                           HttpServletRequest request) {

        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(resourcesNotFoundException.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .path(request.getRequestURI())
                .build();

        return errorResponse;

//        ErrorResponse errorResponse1 = new ErrorResponse(
//                LocalDateTime.now(),
//                HttpStatus.NOT_FOUND.value(),
//                resourcesNotFoundException.getMessage(),
//                request.getRequestURI()
//        );
//        return errorResponse1;

    }


    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse userNotFound(UserNotFoundException exception,
                                      HttpServletRequest request) {


        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(exception.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .path(request.getRequestURI())
                .build();

        return errorResponse;
    }

//    // Helper Method
//    public static ErrorResponse helperMethod(RuntimeException exception, HttpServletRequest request){
//        ErrorResponse errorResponse = ErrorResponse.builder()
//                .timestamp(LocalDateTime.now())
//                .message(exception.getMessage())
//                .statusCode(HttpStatus.NOT_FOUND.value())
//                .path(request.getRequestURI())
//                .build();
//
//        return errorResponse;
//    }

    @ExceptionHandler(Exception.class)
    public ErrorResponse exceptionError( HttpServletRequest request){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .message("Something went wrong.... from server side..")
                .statusCode(HttpStatus.BAD_GATEWAY.value())
                .path(request.getRequestURI())
                .build();
        return errorResponse;
    }


}

