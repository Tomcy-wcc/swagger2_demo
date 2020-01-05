package com.ys.swagger_demo.repository;

import com.ys.swagger_demo.bean.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @auther wcc
 * @create 2020-01-03 22:07
 */
@Service
public class UserRepository {

    private static final Map<Integer, User> users = new HashMap();

    public User insertUser(User user){
        return users.put(user.getId(), user);
    }

    public User deleteUser(Integer id){
        return users.remove(id);
    }

    public User selectUserById(Integer id){
        return users.get(id);
    }


}
