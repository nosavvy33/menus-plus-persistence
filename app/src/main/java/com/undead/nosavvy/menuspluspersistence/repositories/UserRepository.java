package com.undead.nosavvy.menuspluspersistence.repositories;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.widget.Toast;

import com.orm.SugarDb;
import com.orm.SugarRecord;
import com.orm.util.SugarCursor;
import com.undead.nosavvy.menuspluspersistence.DashboardActivity;
import com.undead.nosavvy.menuspluspersistence.LoginActivity;
import com.undead.nosavvy.menuspluspersistence.models.User;

import java.util.Iterator;
import java.util.List;

/**
 * Created by nosavvy on 4/20/18.
 */

public class UserRepository {
    public static List<User> list(){
        List<User> user2s = SugarRecord.listAll(User.class);
        return user2s;
    }

    public static void create(String fullname, String nickname,String email, String password){
        User user = new User(fullname, nickname, email, password);
        SugarRecord.save(user);
    }

    public static String login(String email, String password){
        String data = "";
            List<User> users = SugarRecord.listAll(User.class);
            for (User user: users) {
                data = (user.getEmail().equals(email) && user.getPassword().equals(password) ? "ok" : "failed");
            }
        return data;
    }




}
