package com.ys.swagger_demo.controller;

import com.ys.swagger_demo.annotation.Flag;
import com.ys.swagger_demo.bean.User;
import com.ys.swagger_demo.repository.UserRepository;
import com.ys.swagger_demo.vo.CodeEnum;
import com.ys.swagger_demo.vo.ResponseData;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @auther wcc
 * @create 2019-12-25 23:00
 */
@RestController
@RequestMapping("/fk")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ApiOperation("删除用户")
    @GetMapping("/deleteUser/{id}/{username}")
    public ResponseData<User> deleteUser(@ApiParam(name = "id", value = "用户ID", required = true) @PathVariable("id") Integer id,
                                         @ApiParam(name = "username", value = "用户名", required = true) @PathVariable("username")String username){
        User dbUser = userRepository.deleteUser(id);
        System.out.println(username);
        return dbUser == null ?
                ResponseData.out(CodeEnum.NO_USER_SELECT, null) : ResponseData.out(CodeEnum.SUCCESS, dbUser);
    }

    @ApiOperation("添加用户")
    @PostMapping("/insertUser")
    public ResponseData<User> insertUser(@ApiParam(name = "user", value = "用户", required = true) @RequestBody User user){
        User dbUser = userRepository.insertUser(user);
        return dbUser == null ?
                ResponseData.out(CodeEnum.SUCCESS, null) : ResponseData.out(CodeEnum.REPEAT_INSERT, dbUser);
    }

    @ApiOperation("查找用户")
    @GetMapping("/selectUserById/{id}")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好", response = Exception.class)
    })
    @Flag
    //只要定义好接口的返回值ResponseData<User>，参数就可以的到接口API的描述
    public ResponseData<User> selectUserById(@ApiParam(name = "id", value = "用户ID", required = true) @PathVariable("id") Integer id){
        User user = userRepository.selectUserById(id);
        return user == null ?
                ResponseData.out(CodeEnum.NO_RESULT, null) : ResponseData.out(CodeEnum.SUCCESS, user);
        //return null;
    }

}
