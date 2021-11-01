package com.deltatempest.main;

public class Player {
    private String names;
    private int baseHealth = 100, baseAttack = 10, baseDefence = 5;

    public Player(String names, int baseAttack, int baseHealth, int baseDefence) {
        this.names = names;
        this.baseAttack = baseAttack;
        this.baseHealth = baseHealth;
        this.baseDefence = baseDefence;
    }

    public Player(String names) {
        this.names = names;
    }

    public String getNames() {
        return this.names;
    }

    public void setNames(String names) {
        this.names = names;
    }




}
