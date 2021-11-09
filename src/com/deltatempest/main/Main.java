package com.deltatempest.main;

import java.util.*;

public class Main {

    static ArrayList<Weapon> weapons = new ArrayList<>();

    static ArrayList<Armor> armors = new ArrayList<>();
    static Map<String, Enemy> enemies = new HashMap<>();
    static ArrayList<Enemy> enemis = new ArrayList<>();

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
            if (firstMeetWithStranger() == 1) {
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
        enemis.add(0, new Enemy("Jacob", 1, 10, weapons.get(1), armors.get(0)));


    }

    static void loadAllArmors() {

        armors.add(new Armor("Rookie Armor", 1)); // ID = 0
    }

    static void loadAllWeapons() {
        weapons.add(new Weapon("Fist", 0)); // ID = 0
        weapons.add(new Weapon("knife", 1)); // ID = 1

    }

    static void displayEnemyStats (Enemy enemy) {
        System.out.println("Enemy Hp: "+enemy.getMaxHealth() + "\nEnemy AttackPower: " + enemy.getAttackPower());
    }
    static void displayEnemyStats (Enemy enemy, Weapon weapon) {
        System.out.println("Enemy Hp: "+enemy.getMaxHealth() + "\nEnemy AttackPower: " + enemy.getAttackPower() + "\nWeapon: " +
                enemy.getWeaponName());
    }

    static void displayPlayerStats() {
        System.out.println("Your HP: " + playerHp + "\nYour Attack: " + playerAttackPower);
    }
    static void lineWithEnterBeforeAndAfter() {
        System.out.print("\n\n=========================================================\n\n");
    }
    static void lineWithDoubleEnter() {
        System.out.print("=========================================================\n\n");
    }
    static void lineNoEnter() {
        System.out.print("=========================================================");
    }
    static boolean battlePhase(Enemy enemy) {
        //TODO mengganti playerHp, playerAttackPower dengan player.getMaxHp dan player.getAttackPower

        boolean isPlayerWin = false;

        displayPlayerStats();
        System.out.println();
        displayEnemyStats(enemy, weapons.get(1));
        System.out.println();


        while (enemy.getMaxHealth() > 0 && playerHp > 0) {
            lineWithDoubleEnter();

            //Mengeluarkan option
            System.out.println("Your turn\n\t1. Attack\n\t2. Run");
            numbers = scanner.nextInt();

            lineNoEnter();
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
                    enemy.setMaxHealth(enemyHealth);

                    //mengecek apakah enemy sudah mati atau belum
                    if (enemy.getMaxHealth() <= 0) {
                        System.out.println("\nYou win the fight!");
                        lineNoEnter();
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

    static void wayToNorthAndSouth() {
        lineWithEnterBeforeAndAfter();
        System.out.println("You see a two ways\n\t1. North\n\t2. South\n\t3. Your stats");
    }
    static int firstMeetWithStranger() {
        //return 1 = buat memberhentikan while loop di main method
        boolean isPlayerWin = false;

        System.out.println("\n\nThe game begins!\n");
        lineNoEnter();
        System.out.println("\n" +
                "You wake up in the forest with empty hand" +
                "\n" +
                "You didnt know who are you and how you get here\nand then you see an Stranger coming to you" +
                "\n" +
                "Stranger: Hey are you okay? I see you laying around in this middle forest\n" +
                "\n" +
                "\t1. Say that you are ok\n\t" +
                "2. Try to attack him");
        lineWithDoubleEnter();


        numbers = scanner.nextInt();

        //User choose say that you are okay
        if (numbers == 1) {
            System.out.println("You: Im okay thanks for asking. Umm can i know what place is this?");
            return 1;


        //User choose to fight him
        } else if (numbers == 2) {
            System.out.println();
            lineNoEnter();
            System.out.println();
            System.out.println("Stranger: Wait why your trying to attack me?\n");

            if (battlePhase(enemis.get(0))) {
                System.out.println("\nThe enemies die.\nYou Got:\n\n1. Rookie armor");

            } else {
                System.out.println("");
                lineNoEnter();
                System.out.println();
                System.out.println("Why you suddenly attack me? im just trying to help you\nwhat a rude man!\nThe Stranger leaves...");
                wayToNorthAndSouth();

            }


            //mereturn 1 untuk nge break while loop di main method
            return 1;



        }

        return 0;
    }
    static int startingGames() {
        lineWithDoubleEnter();
        System.out.print("Hello Player!\nWelcome to Rpg Text Games!" +
                "\nWhat is your name?\n\n");
        lineNoEnter();
        System.out.println();
        String names = scanner.nextLine();

        lineWithDoubleEnter();
        System.out.println("Hello " + names);

        while (true) {
            System.out.println( "\nDo you wanna continue? \n\t1. Continue\n\t2. Stats\n\t3. Exit\n");
            lineNoEnter();



            System.out.println("");
            numbers = scanner.nextInt();

            if (numbers == 1) {
                break;
            } else if (numbers == 2) {
                lineWithDoubleEnter();
                displayPlayerStats();
                System.out.println("");
                lineNoEnter();



            } else {
                return 1;

            }

        }
        lineNoEnter();

        return 0;
    }
}
