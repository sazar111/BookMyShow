package com.example.bookmyshow;

import com.example.bookmyshow.controllers.UserController;
import com.example.bookmyshow.dtos.UserLoginRequestDto;
import com.example.bookmyshow.dtos.UserLoginResponseDto;
import com.example.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication implements CommandLineRunner {
    private UserController userController;

    public BookMyShowApplication(UserController userController) {
        this.userController = userController;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        UserLoginRequestDto userLoginRequestDto= new UserLoginRequestDto();
        userLoginRequestDto.setEmail("adhi12@email.com");
        userLoginRequestDto.setPassword("password");
        userLoginRequestDto.setName("Some Name");

        UserLoginResponseDto userLoginResponseDto= userController.signUp(userLoginRequestDto);
    }
}
