package com.controller;

import org.springframework.web.bind.annotation.RestController;

import com.model.Success;
import com.model.UserMaster;
import com.model.failure;
import com.service.UserMasterServiceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/UserMaster")
@CrossOrigin("*")
public class UserMasterController {
	
	@Autowired
	UserMasterServiceImpl userService;
	
	@PostMapping("/addUserMaster")
	public UserMaster addUserMaster(@RequestBody UserMaster user) {
		//TODO: process POST request
		
		return userService.addUserMaster(user);
	}
	
	@GetMapping("/getUserMaster")
	List<UserMaster> getUserMaster(){
		return userService.getUserMaster();
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Success> deleteUserMaster(@PathVariable int id) {
	  boolean isdeleted= userService.deleteUser(id);
	  if (isdeleted) {
		  Success success=new Success("Deleted Successfully");
		return new ResponseEntity<Success>(HttpStatus.ACCEPTED);
	}
	  else {
		  Success failure=new Success("Unable to delete");
		  return new ResponseEntity<Success>(HttpStatus.BAD_REQUEST);
	  }
	  }
	
	@PutMapping("updateUserMaster/{id}")
	public UserMaster updateUserMaster( @RequestBody UserMaster user,@PathVariable int id) {
		//TODO: process PUT request
		
		return userService.updateUser(user, id);
	}

}
