package com.hand.springboot.api.controller;

import com.hand.springboot.config.exception.UserNotExistException;
import com.hand.springboot.domain.todo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author liangwusun 2021/03/29 10:31
 */
@RestController
@RequestMapping("/users")
public class UserController {


    @GetMapping("/{id}")
    public User query(@PathVariable int id){
        if(id > 2){
            throw new UserNotExistException(id);
        }
        return new User(id,"怀几","好好学习");
    }
}
