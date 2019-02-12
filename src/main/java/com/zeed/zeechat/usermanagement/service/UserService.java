package com.zeed.zeechat.usermanagement.service;


import com.zeed.zeechat.entities.User;
import com.zeed.zeechat.exception.ZeeChatException;
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

        User user = User.builder()
                .firstName(signupRequestModel.getFirstName())
                .lastName(signupRequestModel.getLastName())
                .password(passwordEncoder.encode(signupRequestModel.getPassword()))
                .email(signupRequestModel.getEmail())
                .username(signupRequestModel.getUsername()).build();

        userRepository.save(user);

        return UserSignUpResponseModel.builder()
                .message("Registration successful").successful(true).build();
    }

    @Override
    public User findUserByUsername(String username) {

        return userRepository.findTopByUsername(username);
    }

    @Override
    public User findUserByUsernameOrEmail(String username, String email) throws ZeeChatException {
        User user = userRepository.findTopByUsernameOrEmail(username, email);

        if (user == null)
            throw new ZeeChatException("User not found");

        return user;
    }


}
