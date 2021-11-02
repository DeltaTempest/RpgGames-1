package com.deltatempest.main;

public class Enemy {
    private String names;
    private int baseHealth = 8, baseAttack = 1;

    public Enemy(String names, int baseAttack, int baseHealth) {
        this.names = names;
        this.baseAttack = baseAttack;
        this.baseHealth = baseHealth;

    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public Enemy(String names) {
        this.names = names;
    }

    public String getNames() {
        return this.names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setBaseHealth(int baseHealth) {
        this.baseHealth = baseHealth;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }
}
