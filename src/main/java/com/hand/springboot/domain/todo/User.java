package com.hand.springboot.domain.todo;

/**
 * description
 *
 * @author liangwusun 2021/03/29 10:25
 */
public class User {

    private int id;
    private String name;
    private String motto;

    public User(int id,String name,String motto){
        this.id = id;
        this.name = name;
        this.motto = motto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }
}
