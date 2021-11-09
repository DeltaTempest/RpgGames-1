package com.deltatempest.main;

public class PlayerStats {
    private int baseHp = 0, baseDefense = 0, baseAttack = 0;
    private Weapon weapon = new Weapon();
    private Armor armor = new Armor();


    public PlayerStats(int baseHp, int baseDefense, int baseAttack, Weapon weapon, Armor armor) {
        this.baseHp = baseHp;
        this.baseDefense = baseDefense;
        this.baseAttack = baseAttack;
    }

    public PlayerStats() {

    }

    public PlayerStats(int baseHp, int baseDefense, int baseAttack, Weapon weapon) {
        this.baseHp = baseHp;
        this.baseDefense = baseDefense;
        this.baseAttack = baseAttack;
    }


    public int getAttackPower() {

        return this.baseAttack + weapon.getAttackBonus();
    }
    public int getMaxHp() {
        return this.baseHp + this.baseDefense;
    }









}
