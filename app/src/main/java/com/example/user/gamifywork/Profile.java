package com.example.user.gamifywork;

/**
 * Created by user on 12.08.2017.
 */

public class Profile {
    //id, user_id, name, role, coins
    private String name;
    private String role;
    private int id;
    private int user_id;
    private int coins;

    public Profile(String name, String role, int id, int user_id, int coins) {
        this.name = name;
        this.role = role;
        this.id = id;
        this.user_id = user_id;
        this.coins = coins;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
