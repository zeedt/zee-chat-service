package com.zeed.zeechat.usermanagement.service;


import com.zeed.zeechat.entities.User;
import com.zeed.zeechat.repository.UserRepository;
import com.zeed.zeechat.usermanagement.UserOperation;
import com.zeed.zeechat.usermanagement.apimodel.UserSignUpResponseModel;
import com.zeed.zeechat.usermanagement.apimodel.UserSignupRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService  implements UserOperation {

    @Autowired
    @Qualifier("customPasswordEncoder")
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserSignUpResponseModel signupUser(UserSignupRequestModel signupRequestModel) {

        User existingUser = userRepository.findTopByUsernameOrEmail(signupRequestModel.getUsername(), signupRequestModel.getEmail());

        if (existingUser != null && existingUser.getEmail().equals(signupRequestModel.getEmail())) {
            return UserSignUpResponseModel.builder().message("User already exist with the same Email address").build();
        }

        if (existingUser != null && existingUser.getUsername().equals(signupRequestModel.getUsername())) {
            return UserSignUpResponseModel.builder().message("User already exist with the same username").build();
        }

        User user = new User();
        user.setFirstName(signupRequestModel.getFirstName());
        user.setLastName(signupRequestModel.getLastName());
        user.setPassword(passwordEncoder.encode(signupRequestModel.getPassword()));
        user.setEmail(signupRequestModel.getEmail());
        user.setUsername(signupRequestModel.getUsername());

        userRepository.save(user);

        return UserSignUpResponseModel.builder()
                .message("Registration successful").build();
    }


}
