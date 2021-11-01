package com.deltatempest.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hello Player!\nWelcome to Rpg Text Games!\nIm Delta, your bot ai companies on this Rpg text games!" +
                "\nWhat is your name?: ");
        String names = scanner.nextLine();
        Player player1 = new Player(names);
        System.out.print("Hello " + names + "! do you wanna skip the tutorial?\n\t1. Skip\n\t2. Don't skip\n");
        int numbers = scanner.nextInt();

        if (numbers == 1) {
            System.out.println("Wow what a pro, ok just continue then to level 1");
        } else {
            System.out.println("Ok let me explain what this gam to you." +
                    "\n As i said before this game is Rpg games with 3 classes\n\t1. Warrior class\n\n" +
                    );
        }



    }
}
