package com.example.bookmyshow.services;

import com.example.bookmyshow.models.User;
import com.example.bookmyshow.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User signUp(String name,String email, String password){

        Optional<User> userOptional = userRepository.findByEmail(email);
        User user;
        if(userOptional.isPresent()){
            //login function
            user = userOptional.get();
        }else{
            user = new User();
            user.setEmail(email);
            user.setPassword(new BCryptPasswordEncoder().encode(password));
            user.setName(name);
            user= userRepository.save(user);
        }
        return user;
    }
}
