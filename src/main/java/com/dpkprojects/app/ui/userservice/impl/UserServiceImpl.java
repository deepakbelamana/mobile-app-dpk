package com.dpkprojects.app.ui.userservice.impl;

import com.dpkprojects.app.ui.models.requestModels.UserDetailsRequestModel;
import com.dpkprojects.app.ui.models.responseModels.UserRest;
import com.dpkprojects.app.ui.shared.Utils;
import com.dpkprojects.app.ui.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    //Map<String,UserRest> users = new HashMap<>();

    Utils utils;

    /**
     * @param utils
     *
     * constructor based dependency injection
     * parameterized constructor has been annotated with
     * @@autowired, such that spring will try to create the instance of Utils class.
     * to create the instance of Utils class we need to annotate the
     * Utils class with @Service in {@link Utils} class
     *
     */
    @Autowired
    public UserServiceImpl(Utils utils){
        this.utils=utils;
    }
    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails,Map<String,UserRest> users) {
         UserRest responseUser = new UserRest();
        responseUser.setEmail(userDetails.getEmail());
        responseUser.setLastname(userDetails.getLastname());
        responseUser.setFirstname(userDetails.getFirstname());
        String userID = this.utils.generateUserId();
        responseUser.setUserId(userID);
        if(users==null) {
            users = new HashMap<>();
        } else{
            users.put(userID,responseUser);
        }
        return responseUser;
    }
}
