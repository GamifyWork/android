package com.example.user.gamifywork;

/**
 * Created by user on 11.08.2017.
 */

public class Task {
    String title, description;

    int task_id, task_template_id, coins;
    Boolean verified, finished;

    public String getTitle() {
        return title;
    }

    public int getTask_id() {
        return task_id;
    }

    public int getTask_template_id() {
        return task_template_id;
    }

    public int getCoins() {
        return coins;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getVerified() {
        return verified;
    }

    public Boolean getFinished() {
        return finished;
    }

    public Task(String title, String description, int task_id, int task_template_id, int coins, Boolean verified, Boolean finished) {
        this.title = title;
        this.description = description;
        this.task_id = task_id;
        this.task_template_id = task_template_id;
        this.coins = coins;
        this.verified = verified;
        this.finished = finished;
    }
}
