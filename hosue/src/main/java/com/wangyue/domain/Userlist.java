package com.wangyue.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Userlist {
    private Integer id;
    private String name;
    private String idcard;
    private String phone;
    private Integer user_id;
    private String nickname;
    private String password;
    private List<Apply> apply;
    private List<Zulist> zulist;
    private List<Checkout> checkout;
    private List<Applyout> applyout;
    private User user;
}
