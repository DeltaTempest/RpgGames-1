package com.deltatempest.main;

import java.util.ArrayList;

public class Weapon {
    private int attackBonus = 0;
    private String weaponName = "CUk";



    public Weapon() {

    }
    public Weapon(String weaponName, int attackBonus) {
        this.weaponName = weaponName;
        this.attackBonus = attackBonus;
    }



    public int getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }
}
