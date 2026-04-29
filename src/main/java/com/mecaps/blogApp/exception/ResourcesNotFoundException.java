package com.mecaps.blogApp.exception;

public class ResourcesNotFoundException extends RuntimeException{


    public ResourcesNotFoundException(String message){
        super(message);
    }
}
