package com.zeed.zeechat.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
@Builder @Getter @Setter
public class User implements Serializable {

    @Id
    private String id;
    
    private String username;
    
    private String firstName;
    
    private String lastName;
    
    private String email;

    private String password;

    private String profilePicture;

    private Date createdTime;
}
