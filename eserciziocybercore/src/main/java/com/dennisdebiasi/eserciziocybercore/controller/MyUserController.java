package com.dennisdebiasi.eserciziocybercore.controller;

import com.dennisdebiasi.eserciziocybercore.model.LocationResponseModel;
import com.dennisdebiasi.eserciziocybercore.model.UserRequestModel;
import com.dennisdebiasi.eserciziocybercore.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myUser")
public class MyUserController {

    @Autowired
    private MyUserService myUserService;

    @PostMapping("/home")
    public String createOrUpdateUser(@RequestBody UserRequestModel user){
        return myUserService.createOrUpdateUser(user);
    }

    @GetMapping("/home")
    public List<LocationResponseModel> getUserLocations(@RequestParam String username){
        return myUserService.getLocationsByUsername(username);
    }
}
