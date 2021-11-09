package com.deltatempest.main;

import java.util.ArrayList;

public class Enemy {
    private String names;
    private int baseHealth = 0, baseAttack = 0;
    private Weapon weapon =  new Weapon();
    private Armor armor = new Armor();
    private int maxHp = 0, attackPower = 0;

    public Enemy(String names, int baseAttack, int baseHealth, Weapon weapon, Armor armor) {
        this.names = names;
        this.baseAttack = baseAttack;
        this.baseHealth = baseHealth;
        maxHp = baseHealth + armor.getDefenceBonus();
        attackPower = baseAttack + weapon.getAttackBonus();
        this.weapon = weapon;
        this.armor = armor;




    }

    public String getWeaponName() {
        return weapon.getWeaponName();
    }


    public Enemy(String names) {
        this.names = names;
    }

    public Enemy(String names, int baseAttack, int baseHealth) {
        this.names = names;
        this.baseAttack = baseAttack;
        this.baseHealth = baseHealth;
        maxHp = baseHealth + armor.getDefenceBonus();

    }

    public int getMaxHealth() {
        return maxHp;
    }

    public int getAttackPower() {
        return baseAttack + weapon.getAttackBonus();
    }

    public String getNames() {
        return this.names;
    }


    public void setMaxHealth(int maxHealth) {
        maxHp = maxHealth;
    }


}
