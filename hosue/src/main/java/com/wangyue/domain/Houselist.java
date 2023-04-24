package com.wangyue.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Houselist {
  private Integer id;
  private String houseid;
  private String address;
  private double area;
  private double price;
  private String status;
}
