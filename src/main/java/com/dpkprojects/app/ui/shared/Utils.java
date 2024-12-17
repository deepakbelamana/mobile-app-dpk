package com.dpkprojects.app.ui.shared;

import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * annotated with @Service annotation , while component
 * scanning spring will create instance of this class
 * for dependency injection
 */
@Service
public class Utils {
    public String generateUserId(){
        return UUID.randomUUID().toString();
    }

}
