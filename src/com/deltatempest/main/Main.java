package com.deltatempest.main;

import java.util.*;

public class Main {

    static ArrayList<Weapon> weapons = new ArrayList<>();

    static ArrayList<Armor> armors = new ArrayList<>();

    static ArrayList<Enemy> enemies = new ArrayList<>();

    static PlayerStats player = new PlayerStats();
    static int numbers, playerHp, playerAttackPower;

    static PlayerInventory playerInventory = new PlayerInventory();


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
            System.out.println( "\nDo you wanna continue? \n\t1. Continue\n\t2. Stats\n\t3. See your inventory\n\t4. Exit");
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



            } else if (numbers == 3) {
                seeInventory();
            } else {
                return 1;

            }

        }
        lineNoEnter();

        return 0;
    }
    static int firstMeetWithStranger() {
        //return 1 = buat memberhentikan while loop di main method
        boolean isPlayerWin = false;

        System.out.println("\n\nThe game begins!\n");
        lineWithDoubleEnter();
        System.out.print("" +
                "You wake up in the forest with empty hand" +
                "\n" +
                "You didnt know who are you and how you get here\nand then you see an Stranger coming to you" +
                "\n" +
                "Stranger: Hey are you okay? I see you laying around in this middle forest\n" +
                "\n" +
                "\t1. Ask where you are\n\t" +
                "2. Try to attack him");
        lineWithDoubleEnterBeforeAndAfter();


        numbers = scanner.nextInt();

        //User choose say that you are okay
        if (numbers == 1) {
            lineWithDoubleEnter();
            System.out.println("You: Im okay thanks for asking. Umm can i know what place is this?\nStranger: We are now in the Wooden Forest near Etna Town" +
                    "\n\t1. Ask the stranger if he is know who you are\n\t2. Ask the stranger his name");
            lineWithEnterBeforeAndAfter();
            numbers = scanner.nextInt();

            //User say who am i
            if (numbers == 1) {
                lineWithDoubleEnterBeforeAndAfter();
                System.out.println("\nYou: Do you now who am i?\n" +
                        "Stranger: Ummm, i think this is first time we meet. Ahh yes let me introduce myself!\n" +
                        "Jacob: My name is jacob! I'm an Adventurer!");
            //User ask stranger about his name
            } else if (numbers == 2) {
                lineWithDoubleEnterBeforeAndAfter();
                System.out.println("You: Who are you?\nStranger: Ah yes sorry i'm too late to introduce myself\nJacob: My name is Jacob, Im an Adventurer!");
            }

            System.out.println("\n\t1. Ask where Etnan Town is\n\t2. Ask for some sort of weapon");
            lineWithEnterBeforeAndAfter();
            numbers = scanner.nextInt();

            //If user choose to ask where is Etnan Town is
            if (numbers == 1) {



            //If user ask for some sort of weapon
            } else if (numbers == 2) {

            }
            return 1;


        //User choose to fight him
        } else if (numbers == 2) {
            System.out.println();
            lineNoEnter();
            System.out.println();
            System.out.println("Stranger: Wait why your trying to attack me?\n");

            if (battlePhase(enemies.get(0))) {
                System.out.println("\nThe Stranger is dead." + showItemThatPlayerGet(enemies.get(0)));


            } else {
                lineWithDoubleEnter();
                System.out.print("Stranger: What a rude man, you suddenly attacking me out of no where\nStranger: I'm just gonna leave");
                wayToNorthAndSouth();

            }


            //mereturn 1 untuk nge break while loop di main method
            return 1;



        }

        return 0;
    }

    static void seeInventory() {
        lineWithDoubleEnterBeforeAndAfter();
        playerInventory.seeAllItem();
        lineWithDoubleEnterBeforeAndAfter();
    }

    static String showItemThatPlayerGet(Enemy enemy) {


        return "\n\t1.You got " + enemy.getWeaponName();
    }
    static void loadAllEntities() {
        //Load Player stats
        player = new PlayerStats(10, 0, 100, new Weapon("Fist", 1));
        playerHp = player.getMaxHp();
        playerAttackPower = player.getAttackPower();

        //Load enemy stats
        enemies.add(0, new Enemy("Jacob", 1, 10, weapons.get(1), armors.get(0)));


    }

    static void loadAllArmors() {

        armors.add(0, new Armor("Rookie Armor", 1)); // ID = 0
        armors.add(new Armor("Leather Armor", 2));
    }

    static void loadAllWeapons() {
        weapons.add(new Weapon("Fist", 0)); // ID = 0
        weapons.add(new Weapon("Knife", 1)); // ID = 1

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
    static void lineWithDoubleEnterBeforeAndAfter() {
        System.out.print("\n\n=========================================================\n\n");
    }
    static void lineWithEnterBeforeAndAfter() {
        System.out.print("\n=========================================================\n");
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
        lineWithDoubleEnterBeforeAndAfter();
        System.out.println("You see a two ways\n\t1. North\n\t2. South\n\t3. Your stats");
    }

}
