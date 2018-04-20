package com.undead.nosavvy.menuspluspersistence.models;

import com.orm.dsl.Table;

/**
 * Created by nosavvy on 4/20/18.
 */
@Table
public class User {
    private Long id;
    private String fullname;
    private String nickname;

    public User(){

    }

    public User( String fullname, String nickname, String email, String password) {
        this.fullname = fullname;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    private String email;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
