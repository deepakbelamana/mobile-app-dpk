package com.dpkprojects.app.ui.userservice;

import com.dpkprojects.app.ui.models.requestModels.UserDetailsRequestModel;
import com.dpkprojects.app.ui.models.responseModels.UserRest;

import java.util.Map;

public interface UserService {

    UserRest createUser(UserDetailsRequestModel userDetails, Map<String,UserRest> users);
}
