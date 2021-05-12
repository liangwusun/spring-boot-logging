package com.hand.springboot.config.exception;

import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author liangwusun 2021/03/29 14:18
 */
public class UserNotExistException extends RuntimeException {

    private  int id;

    public UserNotExistException(int id) {
        super("user not exist");
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
