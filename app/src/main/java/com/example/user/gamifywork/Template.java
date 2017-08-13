package com.example.user.gamifywork;

/**
 * Created by user on 12.08.2017.
 */

public class Template {
    //id, title, description, coins, account-id
    private String title;
    private String description;
    private int coins;
    private int account_id;
    private int id;


    public Template(String title, String description, int coins, int account_id) {
        this.title = title;
        this.description = description;
        this.coins = coins;
        this.account_id = account_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCoins() {
        return coins;
    }

    public int getAccount_id() {
        return account_id;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
}
