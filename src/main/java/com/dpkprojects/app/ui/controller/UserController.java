package com.dpkprojects.app.ui.controller;

import com.dpkprojects.app.ui.exception.exceptionClasses.UserServiceExceptionClass;
import com.dpkprojects.app.ui.models.requestModels.UpdateUserDetailsRequestModel;
import com.dpkprojects.app.ui.userservice.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dpkprojects.app.ui.models.requestModels.UserDetailsRequestModel;
import com.dpkprojects.app.ui.models.responseModels.UserRest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserService userService;
	Map<String,UserRest> users = new HashMap<>();
	@GetMapping(path="/{userId}",produces= {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		if(users.containsKey(userId)){
			return new ResponseEntity<UserRest>(users.get(userId),HttpStatus.OK);
		} else{
			throw new UserServiceExceptionClass("user not found for user id "+userId);
		}
	}

	@GetMapping()
	public String getUser(@RequestParam(value = "page") int page, @RequestParam(value="limit",required=false,defaultValue="50")int limit ) {
		return "get user was called with users for page " +page+" & limit ="+limit;
	}
	
	@PostMapping(consumes= {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	},produces= {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		UserRest responseUser = userService.createUser(userDetails,users);
		return new ResponseEntity<UserRest>(responseUser,HttpStatus.CREATED);
		
	}

	@PutMapping(path="/{userId}",consumes= {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	},produces= {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	})
	public UserRest updateUser(@PathVariable String userId ,
							 @Valid @RequestBody UpdateUserDetailsRequestModel updateUserDetailsRequestModel) {
		UserRest storedUser = users.get(userId);
		storedUser.setFirstname(updateUserDetailsRequestModel.getFirstname());
		storedUser.setLastname(updateUserDetailsRequestModel.getLastname());
		users.put(userId,storedUser);
		return storedUser;
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		users.remove(userId);
		return  ResponseEntity.noContent().build();
	}
}
