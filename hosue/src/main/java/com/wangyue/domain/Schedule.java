package com.wangyue.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Schedule {
	private Integer id;
	private String date;
	private String content;
}
