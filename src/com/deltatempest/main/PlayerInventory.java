package com.deltatempest.main;

import java.util.ArrayList;

public class PlayerInventory {
    private ArrayList<Armor> armors = new ArrayList<>();
    private ArrayList<Weapon> weapons = new ArrayList<>();


    public PlayerInventory(Weapon weapon, Armor armor) {
        weapons.add(weapon);
        armors.add(armor);
    }

    public PlayerInventory(Weapon weapon) {
        weapons.add(weapon);
    }

    public PlayerInventory(Armor armor) {
        armors.add(armor);
    }

    public PlayerInventory() {

    }

    void seeAllItem() {
        System.out.println("Player Inventory");

        if (armors.size() > 0) {
            System.out.println("Your armor:");
            for (int i = 0; i < armors.size(); i++) {
                System.out.println("\t" + (i+1) + ". " + armors.get(i).getArmorName());
            }
        } else if (weapons.size() > 0) {
            System.out.println("Your Weapons:");
            for (int i = 0; i < weapons.size(); i++) {
                System.out.println("\t" + (i+1) + ". " + weapons.get(i).getWeaponName());
            }
        } else if (weapons.isEmpty() && armors.isEmpty()) {
            System.out.println("You don't have anything!");
        }








    }



    void addItem(Armor armor) {
        armors.add(armor);
    }

    void addItem(Weapon weapon) {
        weapons.add(weapon);

    }

}
