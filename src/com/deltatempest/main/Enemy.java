package com.deltatempest.main;

import java.util.ArrayList;

public class Enemy {
    private String names;
    private int baseHealth = 8, baseAttack = 0;
    private Weapon weapon;
    private Armor armor;







    public Enemy(String names, int baseAttack, int baseHealth, Weapon weapon, Armor armor) {
        this.names = names;
        this.baseAttack = baseAttack;
        this.baseHealth = baseHealth;
        this.weapon = weapon;
        this.armor = armor;


    }



    public Enemy(String names) {
        this.names = names;
    }

    public Enemy(String names, int baseAttack, int baseHealth) {
        this.names = names;
        this.baseAttack = baseAttack;
        this.baseHealth = baseHealth;
    }


    public int getMaxHealth() {
        return baseHealth + armor.getDefenceBonus();
    }

    public int getAttackPower() {
        return baseAttack + weapon.getAttackBonus();
    }

    public String getNames() {
        return this.names;
    }



    public void setBaseHealth(int baseHealth) {
        this.baseHealth = baseHealth;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }
}
