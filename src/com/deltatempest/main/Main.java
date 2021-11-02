package com.deltatempest.main;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static int numbers, playerHp = 10, playerAttackPower = 5;
    static Scanner scanner = new Scanner(System.in);
    static Enemy firstStranger = new Enemy("Muly");
    static Random rand = new Random();
    String weapon = "Hand";


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
    static void displayEnemyStats (Enemy enemy) {
        System.out.println("Enemy Hp: "+enemy.getBaseHealth() + "\nEnemy AttackPower: " + enemy.getBaseAttack());
    }
    static void displayPlayerStats() {
        System.out.println("Your HP: " + playerHp + "\nYour Attack: " + playerAttackPower);
    }
    static void firstLine() {
        System.out.print("=========================================================\n\n");
    }
    static void lastLine() {
        System.out.print("=========================================================");
    }
    static boolean battlePhase(Enemy enemy) {
        boolean isPlayerWin = false;
        firstLine();
        displayPlayerStats();
        System.out.println();
        displayEnemyStats(enemy);
        System.out.println("\n");
        lastLine();
        System.out.println("\n");

        while (enemy.getBaseHealth() > 0 || playerHp > 0) {
            firstLine();
            System.out.println("Enemy: Come on attack me!\n\t1. Attack\n\t2. Run");
            numbers = scanner.nextInt();
            //Check if user attack or running
            if (numbers == 1) {
                //user attacking
                int randNumber = rand.nextInt(2); //rand for making dodge possible
                if (randNumber == 0) {
                    randNumber = -1;
                    //enemy taking damage
                    System.out.println("Ouch");
                    int enemyHealth = firstStranger.getBaseHealth();
                    enemyHealth = enemyHealth - playerAttackPower;// decrement stranger health with playerattackpower
                    firstStranger.setBaseHealth(enemyHealth);
                    if (enemy.getBaseHealth() <= 0) {
                        isPlayerWin = true;
                        break;
                    }
                    System.out.println("You gonna pay for that, take this!");
                    randNumber = rand.nextInt(2);
                    //enemy attack user
                    if (randNumber == 0) {
                        randNumber = -1;
                        //if user failed to dodge
                        System.out.println("You got hit by " + enemy.getBaseAttack() + " damage");
                        if (playerHp <= 0) {
                            System.out.println("Player die");
                            isPlayerWin = false;
                            break;
                        }
                        playerHp = playerHp - enemy.getBaseAttack();
                        displayPlayerStats();
                        displayEnemyStats(enemy);
                    } else if (randNumber == 1) {
                        randNumber = -1;
                        //if user successfully dodge
                        System.out.println("You dodge the attack!");
                        displayPlayerStats();
                        displayEnemyStats(enemy);

                    }

                } else if (randNumber == 1) {
                    randNumber = -1;
                    //if enemy dodge it
                    System.out.println("Hah u think u can hit me? Take this!\n");
                    randNumber = rand.nextInt(2);
                    //enemy attack user
                    if (randNumber == 0) {
                        randNumber = -1;
                        //if user failed to dodge
                        System.out.println("You got hit by " + enemy.getBaseAttack() + " damage");
                        playerHp = playerHp - enemy.getBaseAttack();
                        displayPlayerStats();
                        System.out.println();
                        displayEnemyStats(enemy);
                    } else if (randNumber == 1) {
                        randNumber = -1;
                        //if user successfully dodge
                        System.out.println("You dodge the attack!");
                        displayPlayerStats();
                        System.out.println();
                        displayEnemyStats(enemy);

                    }


                }
            } else if (numbers == 2) {
                System.out.println("What a coward!\n");
                displayPlayerStats();
                isPlayerWin = false;
                break;
            }
        }
        return isPlayerWin;


    }
    static int firstMeetStranger() {
        boolean isPlayerWin = false;
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
            System.out.println("Why you suddenly fight me?\n");
            isPlayerWin = battlePhase(firstStranger);
            if (isPlayerWin == true) {

            }
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
