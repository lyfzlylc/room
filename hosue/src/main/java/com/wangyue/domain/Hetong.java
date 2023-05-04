package com.wangyue.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hetong {
private Integer id;
private String chuzu;
private String chuzu_idcard;
private String zuke;
private String zuke_idcard;
private String fromdate;
private String todate;
private double price;
private String address;
private String house_id;
private Integer payday;
}
