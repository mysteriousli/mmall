package com.mmall.demo.service.serviceImpl;

import com.mmall.demo.common.ServerResponse;
import com.mmall.demo.dao.UserMapper;
import com.mmall.demo.pojo.User;
import com.mmall.demo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        int resultCount = userMapper.checkUsername(username);
        if (resultCount == 0){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        
        User user = userMapper.selectUser(username,password);
        if (user == null){
            return ServerResponse.createByErrorMessage("密码错误");
        }
        
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登陆成功",user);
    }
}
