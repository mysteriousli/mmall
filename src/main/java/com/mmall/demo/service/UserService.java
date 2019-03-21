package com.mmall.demo.service;

import com.mmall.demo.common.ServerResponse;
import com.mmall.demo.pojo.User;

import java.util.List;

public interface UserService {
    ServerResponse<User> login(String username,String password);
}
