package com.neuedu.entity;

import org.springframework.stereotype.Component;

import java.util.Date;


public class LogAspectJ {
    private  int id;
    private int user_id;
    private Date create_time ;
    private String operation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public LogAspectJ() {
    }

    public LogAspectJ(int user_id, Date create_time, String operation) {

        this.user_id = user_id;
        this.create_time = create_time;
        this.operation = operation;
    }

    public LogAspectJ(int id, int user_id, Date create_time, String operation) {
        this.id = id;
        this.user_id = user_id;
        this.create_time = create_time;
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "AspectJqml{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", create_time=" + create_time +
                ", operation='" + operation + '\'' +
                '}';
    }
}
