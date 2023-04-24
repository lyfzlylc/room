package com.wangyue.controller;

import com.wangyue.service.UserlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserlistController {
    @Autowired
    private UserlistService userlistService;
}
