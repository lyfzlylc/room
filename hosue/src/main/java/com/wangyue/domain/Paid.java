package com.wangyue.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Paid {
    private Integer id;
    private String house_id;
    private String address;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;
    private Double price;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date paydate;
    private String name;
    private Integer user_id;
    private String status;
}
