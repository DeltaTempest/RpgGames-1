package com.deltatempest.main;

import java.util.Scanner;

public class Main {

    static int numbers, hp = 10, attackPower = 1;
    static Scanner scanner = new Scanner(System.in);
    static Enemy firstStranger = new Enemy("Muly");


    public static void main(String[] args) {

        while(true) {
            if (startingGames() == 1) {
                break;
            }
            if (firstMeetStranger() == 1) {
                break;
            }

    }


    }
    static void displayPlayerStats() {
        System.out.println("Your HP: " + hp + "\nYour Attack: " + attackPower);
    }

    static void firstLine() {
        System.out.print("=========================================================\n\n");
    }
    static void lastLine() {
        System.out.print("=========================================================");
    }

    static void battlePhase() {
        firstLine();
        displayPlayerStats();
        System.out.println("\nStranger: Wait what are you doing?\n\t1. Attack\n\t2. Run");
        numbers = scanner.nextInt();
        if (numbers == 1) {

        }

    }

    static int firstMeetStranger() {
        firstLine();
        System.out.println("The game begins!\n");
        lastLine();
        System.out.println("\n" +
                "You wake up in the forest with empty hand" +
                "\n" +
                "You didnt know who are you and how you get here" +
                "\n" +
                "Stranger: Hey are you okay? i see you laying around in this middle forest\n" +
                "\n" +
                "\t1. Say that you are ok\n\t" +
                "2. Fight him\n\t" +
                "3. Just leave");
        lastLine();
        System.out.println();

        numbers = scanner.nextInt();
        if (numbers == 1) {
            System.out.println("You: Im okay thanks for asking. Umm can i know what place is this?");
            return 1;
        } else if (numbers == 2) {
            battlePhase();
            return 1;
        } else if (numbers == 3) {
            System.out.println("You leave him just like that\n\n" +
                    "Stranger: What i'm just asking you know, well nmv\n" +
                    "\nU see two path west and east. Where you wanna go?");
            return 1;
        }
        return 0;
    }

    static int startingGames() {
        firstLine();
        System.out.print("Hello Player!\nWelcome to Rpg Text Games!" +
                "\nWhat is your name?\n\n");
        lastLine();
        System.out.println();
        String names = scanner.nextLine();

        firstLine();
        System.out.println("Hello " + names + "! do you wanna continue playing?\n\t1. Continue\n\t2. Exit\n");
        lastLine();

        System.out.println("");
        numbers = scanner.nextInt();
        if (numbers == 2) {
            System.out.println("Hope we can meet in other time!");
            return 1;
        }

        return 0;
    }
}
