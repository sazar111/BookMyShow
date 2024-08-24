package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.*;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserLoginResponseDto signUp(UserLoginRequestDto userLoginRequestDto) {
        UserLoginResponseDto userLoginResponseDto= new UserLoginResponseDto();
        try{
            User user= userService.signUp(
                    userLoginRequestDto.getName(),
                    userLoginRequestDto.getEmail(),
                    userLoginRequestDto.getPassword()
            );
            userLoginResponseDto.setUser(user);
            userLoginResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception ex){
            userLoginResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return userLoginResponseDto;
    }
}
