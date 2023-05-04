package com.wangyue.domain.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfo1 {
    private String pass;
    private String checkPass;
    private String phone;
    private String id;
    private String nickname;
}
