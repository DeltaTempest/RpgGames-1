package com.deltatempest.main;

public class Weapon {
    private String names;
    private int damageBonus;

    public Weapon(String names, int damageBonus) {
        this.names = names;
        this.damageBonus = damageBonus;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getDamageBonus() {
        return damageBonus;
    }

    public void setDamageBonus(int damageBonus) {
        this.damageBonus = damageBonus;
    }
}
