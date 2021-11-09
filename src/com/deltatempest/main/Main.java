package com.deltatempest.main;

import java.util.*;

public class Main {

    static ArrayList<Weapon> weapons = new ArrayList<>();

    static ArrayList<Armor> armors = new ArrayList<>();
    static Map<String, Enemy> enemies = new HashMap<>();

    static PlayerStats player = new PlayerStats();
    static int numbers, playerHp, playerAttackPower;


    static Scanner scanner = new Scanner(System.in);

    static Random rand = new Random();



    public static void main(String[] args) {



        loadAllWeapons();
        loadAllArmors();
        loadAllEntities();


        while(true) {
            if (startingGames() == 1) {
                break;
            }
            if (firstMeetStranger() == 1) {
                break;
            }

    }


    }
    static void loadAllEntities() {
        //Load Player stats
        player = new PlayerStats(10, 0, 1, new Weapon("Fist", 1));
        playerHp = player.getMaxHp();
        playerAttackPower = player.getAttackPower();

        //Load enemy stats
        enemies.put("firstStranger", new Enemy("Jacob", 1, 10, weapons.get(0), armors.get(0)));

    }

    static void loadAllArmors() {

        armors.add(new Armor("Leather Armor", 1)); // ID = 0
    }

    static void loadAllWeapons() {
        weapons.add(new Weapon("Fist", 0)); // ID = 0
        weapons.add(new Weapon("knife", 1)); // ID = 1

    }

    static void displayEnemyStats (Enemy enemy) {
        System.out.println("Enemy Hp: "+enemy.getMaxHealth() + "\nEnemy AttackPower: " + enemy.getAttackPower());
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
        //TODO mengganti playerHp, playerAttackPower dengan player.getMaxHp dan player.getAttackPower

        boolean isPlayerWin = false;

        displayPlayerStats();
        System.out.println();
        displayEnemyStats(enemy);
        System.out.println();


        while (enemy.getMaxHealth() > 0 || playerHp > 0) {
            firstLine();

            //Mengeluarkan option
            System.out.println("Your turn\n\t1. Attack\n\t2. Run");
            numbers = scanner.nextInt();

            lastLine();
            //Check if user attack or running
            if (numbers == 1) {
                //user attacking
                int randNumber = rand.nextInt(2); //rand for making cpu dodge
                if (randNumber == 0) {
                    randNumber = -1;
                    //enemy taking damage or failed to dodge
                    System.out.println("\nYou hit the enemy with " + playerAttackPower + " Attack damage");

                    //membuat variabel baru dengan isi healthnya musuh
                    int enemyHealth = enemy.getMaxHealth();
                    enemyHealth = enemyHealth - playerAttackPower;// decrement enemy baseHealth with playerattackpower
                    enemy.setBaseHealth(enemyHealth);

                    //mengecek apakah enemy sudah mati atau belum
                    if (enemy.getMaxHealth() <= 0) {
                        System.out.println("\nPlayer Wins!");
                        lastLine();
                        isPlayerWin = true;
                        break;
                    }

                    //enemy attack user
                    System.out.println("Enemy turn!\n");
                    randNumber = rand.nextInt(2); // rand number for user trying dodge

                    //if user failed to dodge
                    if (randNumber == 0) {
                        randNumber = -1;
                        //if user failed to dodge
                        System.out.println("You got hit by " + enemy.getAttackPower() + " damage\n");

                        //mengecek apakah Hp user telah habis atau belum
                        if (playerHp <= 0) {
                            System.out.println("Player die");
                            isPlayerWin = false;
                            break;
                        }
                        playerHp = playerHp - enemy.getAttackPower();

                        displayPlayerStats();
                        System.out.println();
                        displayEnemyStats(enemy);


                    // if user dodge
                    } else if (randNumber == 1) {
                        randNumber = -1;
                        //if user successfully dodge
                        System.out.println("You dodge the attack!\n");

                        displayPlayerStats();
                        System.out.println();
                        displayEnemyStats(enemy);

                    }


                // kalau enemy berhasil dodge
                } else if (randNumber == 1) {
                    randNumber = -1;
                    System.out.println("\nThe enemy dodge your attack\n");

                    //enemy attack user
                    System.out.println("Enemy turns\n");
                    randNumber = rand.nextInt(2); // rand number for user trying dodge

                    //user failed to dodge
                    if (randNumber == 0) {
                        randNumber = -1;

                        System.out.println("You got hit by enemy for " + enemy.getAttackPower() + " damage\n");
                        playerHp = playerHp - enemy.getAttackPower();
                        displayPlayerStats();
                        System.out.println();
                        displayEnemyStats(enemy);

                    // user berhasil dodge
                    } else if (randNumber == 1) {
                        randNumber = -1;

                        System.out.println("You dodge the attack!\n");
                        displayPlayerStats();
                        System.out.println();
                        displayEnemyStats(enemy);

                    }


                }
            } else if (numbers == 2) {
                //if user run from fight
                System.out.println("\nYou run from a fight\n");
                displayPlayerStats();
                isPlayerWin = false;
                break;
            }
        }

        //return isPlayerWin untuk kondisi battlenya
        return isPlayerWin;


    }


    static int firstMeetStranger() {
        //return 1 = buat memberhentikan while loop di main method
        boolean isPlayerWin = false;

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

        //User choose say that you are okay
        if (numbers == 1) {
            System.out.println("You: Im okay thanks for asking. Umm can i know what place is this?");
            return 1;


        //User choose to fight him
        } else if (numbers == 2) {
            System.out.println();
            lastLine();
            System.out.println();
            System.out.println("Stranger: Wait why you wanna attack me?\n");

            if (battlePhase(enemies.get("firstStranger"))) {
                System.out.println("\nYou win the battle.\nYou took his weapon.");
            } else {
                System.out.println("");
                lastLine();
                System.out.println();
                System.out.println("Why you suddenly attack me? im just trying to help you\n");
                lastLine();
            }


            //mereturn 1 untuk nge break while loop di main method
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
        System.out.println("Hello " + names);

        while (true) {
            System.out.println( "\nDo you wanna continue? \n\t1. Continue\n\t2. Stats\n\t3. Exit\n");
            lastLine();



            System.out.println("");
            numbers = scanner.nextInt();

            if (numbers == 1) {
                break;
            } else if (numbers == 2) {
                firstLine();
                displayPlayerStats();
                System.out.println("");
                lastLine();



            } else {
                return 1;

            }

        }
        lastLine();

        return 0;
    }
}
