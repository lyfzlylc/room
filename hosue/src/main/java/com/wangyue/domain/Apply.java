package com.wangyue.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Apply {
private Integer id;
private String house_id;
private String address;
private double area;
private double price;
private Date apply_date;
private Integer user_id;
private String status;
private Userlist userlist;
}
