package com.zerobase.fastlms.member;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class MemberInput {

    private String userId;
    private String userName;
    private String password;
    private String phone;

}
