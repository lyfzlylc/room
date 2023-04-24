package com.wangyue.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Music {
    private String name;
    private String url;
    private String artist;
    private String cover;
}
