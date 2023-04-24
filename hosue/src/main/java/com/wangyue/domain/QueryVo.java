package com.wangyue.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QueryVo {
private String zuname;
private String fromdate;
private String todate;
private Integer user_id;
}
