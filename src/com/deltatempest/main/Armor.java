package com.deltatempest.main;

public class Armor {
    private int defenceBonus = 0;
    private String armorNames;

    public Armor(String armorNames, int defenceBonus) {
        this.armorNames = armorNames;
        this.defenceBonus = defenceBonus;
    }


    public Armor() {

    }



    public void setDefenceBonus(int defenceBonus) {
        this.defenceBonus = defenceBonus;
    }

    public void setArmorNames(String armorNames) {
        this.armorNames = armorNames;
    }

    public String getArmorName() {
        return armorNames;
    }

    public int getDefenceBonus() {
        return defenceBonus;
    }
}
