package com.example.liberarylearning.bean;

import org.greenrobot.greendao.annotation.Entity;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by W on 2019/2/25.
 */

@Entity
public class User{


    private String account;
    private String password;
    @Generated(hash = 703476154)
    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public String getAccount() {
        return this.account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}
