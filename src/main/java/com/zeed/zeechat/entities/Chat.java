package com.zeed.zeechat.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Builder @Getter @Setter
public class Chat {

    @Id
    private String id;

    private String chatKey;

    private String sender;

    private String receiver;

    private String message;

    private List<String> attachments;

    private Date timeSent;
}
