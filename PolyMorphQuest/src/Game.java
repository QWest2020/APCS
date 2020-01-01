/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                  Sauce Code: 17                    #
 *#                                                    #
 *######################################################
 */
import java.util.Scanner;
import java.util.Random;

public class Game {

    // Initialize
    //global scanner
    private static Scanner input = new Scanner(System.in);

    //map size
    public static int mapSize = 16; //makes a 16x16 board (including the walls)
    public static boolean firstMapMade = false;

    //characters
    static Samurai Jintoku = new Samurai("Samurai Jintoku", 10, 10, 14, 13, 10); //int anHp, int aMaxHp, int anX, int aY, int anAp
    static RamenChef Sakura = new RamenChef("Chef Sakura", 15, 15, 14, 12, 10, 10); //int anHp, int aMaxHp, int anX, int aY, int anMp, int aMaxMp
    static Cam Cam = new Cam("Cam", 5, 5, 14, 11, 15, 15); //int anHp, int aMaxHp, int anX, int aY, int anMp, int aMaxMp
    static Ghost Spooker = new Ghost("Spooker", 20, 20, 10, 10, 5); //int anHp, int aMaxHp, int anX, int aY, int anAp
    static Duck Mallard = new Duck("Mallard", 5, 5, 10, 11, 5, 5); //int anHp, int aMaxHp, int anX, int aY, int aTp, int aMaxTp
    static SummitDont Soda = new SummitDont("Summit Don't", 15, 15, 10, 12, 10, 10); //int anHp, int aMaxHp, int anX, int aY, int anMp,  int aMaxMp

    // Sprites
    static String[][] map = new String[mapSize][mapSize];
    static String WALL = "\u2588" + "\u2588";
    static String SPACE = "  ";
    static String SPACEFACTOR = "    ";
    static String SAMURAI = "J/";
    static String CHEF = "S+";
    static String CAM = "C.";
    static String GHOST = "00";
    static String DUCK = "Ml";
    static String SODA = "SD";

    public static void main(String[] args) {

        //print the title screen!
        printTitle();
        System.out.println("");
        System.out.println("*BEST PLAYED WHEN THE CONSOLE IS DRAGGED UP!!!*");
        //read the prologue?
        int choice;
        System.out.println("");
        System.out.println("Is this your first time playing? 1=yes, 0=no");
        choice = input.nextInt();
        if (choice == 1) {
            //print the pages
            printPrologue();
            printControls();
        } else {
            System.out.println("Excellent");
        }

        //start the game?
        int startChoice;
        System.out.println("Start the game? 1=yes, 0=no");
        startChoice = input.nextInt();
        if (startChoice == 1) {
            //game code goes in here!
            while ((Jintoku.hp > 0 || Sakura.hp > 0 || Cam.hp > 0)
                    || (Spooker.hp > 0 || Mallard.hp > 0 || Soda.hp > 0)) {//run the game while the characters still have hp and an enemy still exists
                printStats();
                map();
                heroTurn();
                enemyTurn();
                System.out.println("");
                System.out.println("---------------------------------EVENTS!!!---------------------------------");
                actions();
            }
            if ((Jintoku.hp < 0 && Sakura.hp < 0 && Cam.hp < 0)) {//players have lost...
                System.out.println("You loose!");
                System.out.println("");
                //leave the program
                System.exit(0);
            }
            if (Spooker.hp < 0 && Mallard.hp < 0 && Soda.hp < 0) {//enemies have lost
                printCredits();
            }
        } else {
            System.out.println("See ya!");
            //leave the program
            System.exit(0);
        }
    }

    public static void map() {

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (i == 0
                        || j == 0
                        || i == mapSize - 1
                        || j == mapSize - 1) {//set the outer border
                    map[i][j] = WALL;
                } //for each character!
                //JINTOKU
                else if (Jintoku.hp > 0 && j == Jintoku.getX() && i == Jintoku.getY()) {
                    map[i][j] = SAMURAI;
                } //SAKURA
                else if (Sakura.hp > 0 && j == Sakura.getX() && i == Sakura.getY()) {
                    map[i][j] = CHEF;
                } //CAM
                else if (Cam.hp > 0 && j == Cam.getX() && i == Cam.getY()) {
                    map[i][j] = CAM;
                } //SPOOKER
                else if (Spooker.hp > 0 && j == Spooker.getX() && i == Spooker.getY()) {
                    map[i][j] = GHOST;
                } //MALLARD
                else if (Mallard.hp > 0 && j == Mallard.getX() && i == Mallard.getY()) {
                    map[i][j] = DUCK;
                } //SUMMIT DONT 
                else if (Soda.hp > 0 && j == Soda.getX() && i == Soda.getY()) {
                    map[i][j] = SODA;
                } //just make the rest of them spaces
                else {
                    map[i][j] = SPACE;
                }
                System.out.print(map[i][j] + SPACEFACTOR);
            }
            System.out.println("");
        }
    }

    public static void printTitle() {
        System.out.println("Welcome to...");
        System.out.println("");
        System.out.println("             ____         ___                                                __         \n"
                + "            /\\  _`\\      /\\_ \\             /'\\_/`\\                          /\\ \\        \n"
                + "            \\ \\ \\L\\ \\ ___\\//\\ \\    __  __ /\\      \\     ___    _ __   _____ \\ \\ \\___    \n"
                + "             \\ \\ ,__// __`\\\\ \\ \\  /\\ \\/\\ \\\\ \\ \\__\\ \\   / __`\\ /\\`'__\\/\\ '__`\\\\ \\  _ `\\  \n"
                + "              \\ \\ \\//\\ \\L\\ \\\\_\\ \\_\\ \\ \\_\\ \\\\ \\ \\_/\\ \\ /\\ \\L\\ \\\\ \\ \\/ \\ \\ \\L\\ \\\\ \\ \\ \\ \\ \n"
                + "               \\ \\_\\\\ \\____//\\____\\\\/`____ \\\\ \\_\\\\ \\_\\\\ \\____/ \\ \\_\\  \\ \\ ,__/ \\ \\_\\ \\_\\\n"
                + "                \\/_/ \\/___/ \\/____/ `/___/> \\\\/_/ \\/_/ \\/___/   \\/_/   \\ \\ \\/   \\/_/\\/_/\n"
                + "                                       /\\___/                           \\ \\_\\           \n"
                + "                                       \\/__/                             \\/_/           \n"
                + "                             _____                             __      \n"
                + "                            /\\  __`\\                          /\\ \\__   \n"
                + "                            \\ \\ \\/\\ \\   __  __     __     ____\\ \\ ,_\\  \n"
                + "                             \\ \\ \\ \\ \\ /\\ \\/\\ \\  /'__`\\  /',__\\\\ \\ \\/  \n"
                + "                              \\ \\ \\\\'\\\\\\ \\ \\_\\ \\/\\  __/ /\\__, `\\\\ \\ \\_ \n"
                + "                               \\ \\___\\_\\\\ \\____/\\ \\____\\\\/\\____/ \\ \\__\\\n"
                + "                                \\/__//_/ \\/___/  \\/____/ \\/___/   \\/__/");
    }

    public static void printPrologue() {
        System.out.println("");
        System.out.println("      ____               ___                                     \n"
                + "     /\\  _`\\            /\\_ \\                                    \n"
                + "     \\ \\ \\L\\ \\_ __   ___\\//\\ \\     ___      __   __  __     __   \n"
                + "      \\ \\ ,__/\\`'__\\/ __`\\\\ \\ \\   / __`\\  /'_ `\\/\\ \\/\\ \\  /'__`\\ \n"
                + "       \\ \\ \\/\\ \\ \\//\\ \\L\\ \\\\_\\ \\_/\\ \\L\\ \\/\\ \\L\\ \\ \\ \\_\\ \\/\\  __/ \n"
                + "        \\ \\_\\ \\ \\_\\\\ \\____//\\____\\ \\____/\\ \\____ \\ \\____/\\ \\____\\\n"
                + "         \\/_/  \\/_/ \\/___/ \\/____/\\/___/  \\/___L\\ \\/___/  \\/____/\n"
                + "                                            /\\____/              \n"
                + "                                            \\_/__/ ");
        System.out.println("");

        //put new intro here!
        System.out.println("From across space and time, I have called three loyal heros...\n"
                + "into a virtual world, known as New Tokyork... \n"
                + "Jintoku, a Samurai from the historic Feudal era of Japan…\n"
                + "Sakura, a skillful, attractive, yet goofy ramen chef…\n"
                + "And Cam, a curmudgeon who doesn’t really bring much to the table...\n"
                + "Each called together to protect me, the honorable King Daruma...\n"
                + "The royal monarch of New Tokyork (which was once a democracy, but that’s not important right now (hehe)…)\n"
                + "Which now remains in a very suspenseful Jeopardy…\n"
                + "\n"
                + "With you host...Alex Trebek! ...\n"
                + "How’d he get here!? ...\n"
                + "You see, I secretly went on the notorious American quiz show one night ...\n"
                + "And accidentally signed a resignation deed instead of an application form for the show! ...\n"
                + "Sadly, I lost and only got one of those crumby Advil consolation prizes. ...\n"
                + "But now the devilish host has come to claim the land!!! ...\n"
                + "And he’s not alone! ...\n"
                + "Please protect New Tokyork with the aid of my trusty heroes!\n"
                + "\n"
                + "-Your boi King Daruma");
        System.out.println("");
        //controls
        System.out.println("      ___           ___           ___           ___           ___           ___           ___       ___     \n"
                + "     /\\  \\         /\\  \\         /\\__\\         /\\  \\         /\\  \\         /\\  \\         /\\__\\     /\\  \\    \n"
                + "    /::\\  \\       /::\\  \\       /::|  |        \\:\\  \\       /::\\  \\       /::\\  \\       /:/  /    /::\\  \\   \n"
                + "   /:/\\:\\  \\     /:/\\:\\  \\     /:|:|  |         \\:\\  \\     /:/\\:\\  \\     /:/\\:\\  \\     /:/  /    /:/\\ \\  \\  \n"
                + "  /:/  \\:\\  \\   /:/  \\:\\  \\   /:/|:|  |__       /::\\  \\   /::\\~\\:\\  \\   /:/  \\:\\  \\   /:/  /    _\\:\\~\\ \\  \\ \n"
                + " /:/__/ \\:\\__\\ /:/__/ \\:\\__\\ /:/ |:| /\\__\\     /:/\\:\\__\\ /:/\\:\\ \\:\\__\\ /:/__/ \\:\\__\\ /:/__/    /\\ \\:\\ \\ \\__\\\n"
                + " \\:\\  \\  \\/__/ \\:\\  \\ /:/  / \\/__|:|/:/  /    /:/  \\/__/ \\/_|::\\/:/  / \\:\\  \\ /:/  / \\:\\  \\    \\:\\ \\:\\ \\/__/\n"
                + "  \\:\\  \\        \\:\\  /:/  /      |:/:/  /    /:/  /         |:|::/  /   \\:\\  /:/  /   \\:\\  \\    \\:\\ \\:\\__\\  \n"
                + "   \\:\\  \\        \\:\\/:/  /       |::/  /     \\/__/          |:|\\/__/     \\:\\/:/  /     \\:\\  \\    \\:\\/:/  /  \n"
                + "    \\:\\__\\        \\::/  /        /:/  /                     |:|  |        \\::/  /       \\:\\__\\    \\::/  /   \n"
                + "     \\/__/         \\/__/         \\/__/                       \\|__|         \\/__/         \\/__/     \\/__/    ");
        System.out.println("");
        System.out.println("Your characters are controled by your movement commands during the Hero Phase");
        System.out.println("You control them by telling them which direction to go!");
        System.out.println("But these guys are smart! If they are in range with an enemy, they will attack");
        System.out.println("on their own!");
        System.out.println("");
        System.out.println("After that, the enemies get to go.");
        System.out.println("But you can stop them by knocking their health down to zero.");
        System.out.println("That's how you win!");
        System.out.println("");
        System.out.println("HEROES");
        System.out.println("");
        System.out.println(SAMURAI + " = Samurai Jintoku");
        System.out.println(CHEF + " = Master Sakura");
        System.out.println(CAM + " = Cam");
        System.out.println("");
        System.out.println("Samurai Jintoku will attack an enemy within 2 spaces");
        System.out.println("Chef Sakura will heal any adjacent allies with her Ramen dish!");
        System.out.println("Cam will paralyze an enemy that's within 3 spaces for a single turn.");
        System.out.println("");
        System.out.println("ENEMIES");
        System.out.println("");
        System.out.println(GHOST + " = Spooker");
        System.out.println(DUCK + " = Mallard");
        System.out.println(SODA + " = Summit Don't");
        System.out.println("");
        System.out.println("Spooker will damage and paralyze an adjacent hero for a single turn");
        System.out.println("Mallard will poison an enemy within 3 spaces. The poison doesn't wear off, so be careful!");
        System.out.println("Summit Don't will heal an enemy within 2 spaces with his sinister sugary deliciousness! He is our biggest threat!");
        System.out.println("");
        System.out.println("Have fun!");
        System.out.println("");
        System.out.println("(Scroll up until you see prologue and start reading from there!!!)");
        //Character files: (ask to see these)
    }

    public static void heroTurn() {
        System.out.println("");
        System.out.println("---------------------------------HERO PHASE---------------------------------");
        System.out.println("");

        //input
        System.out.println("Move Jintoku! Up=8, Left=4, Down=2, Right=6");
        int samMove = input.nextInt();
        System.out.println("Move Sakura! Up=8, Left=4, Down=2, Right=6");
        int ramenMove = input.nextInt();
        System.out.println("Move your Cam! Up=8, Left=4, Down=2, Right=6");
        int monkMove = input.nextInt();

        //Jintoku
        if (Jintoku.isParalyzed != true) {
            switch (samMove) {
                case 8: //up
                    if (Jintoku.y - 1 != 0) {
                        Jintoku.y--;
                    }
                    break;
                case 4: //left
                    if (Jintoku.x - 1 != 0) {
                        Jintoku.x--;
                    }
                    break;
                case 2: //down
                    if (Jintoku.y + 1 != 20) {
                        Jintoku.y++;
                    }
                    break;
                case 6: //right
                    if (Jintoku.x + 1 != 20) {
                        Jintoku.x++;
                    }
                    break;
            }
        }

        //Sakura
        if (Sakura.isParalyzed != true) {
            switch (ramenMove) {
                case 8: //up
                    if (Sakura.y - 1 != 0) {
                        Sakura.y--;
                    }
                    break;
                case 4: //left
                    if (Sakura.x - 1 != 0) {
                        Sakura.x--;
                    }
                    break;
                case 2: //down
                    if (Sakura.y + 1 != 20) {
                        Sakura.y++;
                    }
                    break;
                case 6: //right
                    if (Sakura.x + 1 != 20) {
                        Sakura.x++;
                    }
                    break;
            }
        }

        //Cam
        if (Cam.isParalyzed != true) {
            switch (monkMove) {
                case 8: //up
                    if (Cam.y - 1 != 0) {
                        Cam.y--;
                    }
                    break;
                case 4: //left
                    if (Cam.x - 1 != 0) {
                        Cam.x--;
                    }
                    break;
                case 2: //down
                    if (Cam.y + 1 != 20) {
                        Cam.y++;
                    }
                    break;
                case 6: //right
                    if (Cam.x + 1 != 20) {
                        Cam.x++;
                    }
                    break;
            }
        }

        //collision detection
        //moves the hero if it is in another hero's space
        if ((Jintoku.x == Cam.x && Jintoku.y == Cam.y)
                || (Jintoku.x == Sakura.x && Jintoku.y == Sakura.y)) {
            Jintoku.x--;//push them one space left always. (this could be a strat!)
        } //moves the hero if it is in another hero's space
        if ((Sakura.x == Cam.x && Sakura.y == Cam.y)
                || (Sakura.x == Jintoku.x && Sakura.y == Jintoku.y)) {
            Sakura.x--;//push them one space left always. (this could be a strat!)
        } //moves the hero if it is in another hero's space
        if ((Cam.x == Jintoku.x && Cam.y == Jintoku.y)
                || (Cam.x == Sakura.x && Cam.y == Sakura.y)) {
            Cam.x--;//push them one space left always. (this could be a strat!)
        }

    }

    public static void printControls() {

    }

    public static void printStats() {
        //print the character stats above the map every time it's reprinted!
        System.out.println("");
        System.out.println("---------------------------------Stats---------------------------------");
        System.out.println("Name" + "\t" + "\t" + "HP" + "\t" + "maxHP" + "\t" + "Special" + "\t" + "Max Special");
        System.out.println(Jintoku.name + "\t" + Jintoku.hp + "\t" + Jintoku.maxHp + "\t" + "----" + "\t" + "----");
        System.out.println(Sakura.name + "\t" + Sakura.hp + "\t" + Sakura.maxHp + "\t" + Sakura.mp + "\t" + Sakura.maxMp);
        System.out.println(Cam.name + "\t" + Cam.hp + "\t" + Cam.maxHp + "\t" + Cam.mp + "\t" + Cam.maxMp);
        System.out.println(Spooker.name + "\t" + Spooker.hp + "\t" + Spooker.maxHp + "\t" + "----" + "\t" + "----");
        System.out.println(Mallard.name + "\t" + Mallard.hp + "\t" + Mallard.maxHp + "\t" + Mallard.tp + "\t" + Mallard.maxTp);
        System.out.println(Soda.name + "\t" + Soda.hp + "\t" + Soda.maxHp + "\t" + Soda.mp + "\t" + Soda.maxMp);
    }

    public static void enemyTurn() { //make the enemies move randomly

        //random number
        Random r = new Random();

        //random wariables (make X's and Y's)
        //should generate -1 to 1
        int GhostMoveX = r.nextInt(2) - 1;
        int GhostMoveY = r.nextInt(2) - 1;
        int TrickMoveX = r.nextInt(2) - 1;
        int TrickMoveY = r.nextInt(2) - 1;
        int SodaMoveX = r.nextInt(2) - 1;
        int SodaMoveY = r.nextInt(2) - 1;

        //paralysis
        if (Spooker.isParalyzed == true) {
            GhostMoveX = 0;
            GhostMoveY = 0;
        }
        if (Mallard.isParalyzed == true) {
            TrickMoveX = 0;
            TrickMoveY = 0;
        }
        if (Soda.isParalyzed == true) {
            SodaMoveX = 0;
            SodaMoveY = 0;
        }

        //movement
        if (Spooker.x + 1 != 20 && Spooker.x - 1 != 0) {//not near the walls
            Spooker.x += GhostMoveX;
        }
        if (Spooker.y + 1 != 20 && Spooker.y - 1 != 0) {//not near the walls
            Spooker.y += GhostMoveY;
        }
        if (Mallard.x + 1 != 20 && Mallard.x - 1 != 0) {//not near the walls
            Mallard.x += TrickMoveX;
        }
        if (Mallard.y + 1 != 20 && Mallard.y - 1 != 0) {//not near the walls
            Mallard.y += TrickMoveY;
        }
        if (Soda.x + 1 != 20 && Soda.x - 1 != 0) {//not near the walls
            Soda.x += SodaMoveX;
        }
        if (Soda.y + 1 != 20 && Soda.y - 1 != 0) {//not near the walls
            Soda.y += SodaMoveY;
        }

        //collision detection
        //moves the hero if it is in another hero's space
        if ((Spooker.x == Soda.x && Spooker.y == Soda.y)
                || (Spooker.x == Mallard.x && Spooker.y == Mallard.y)) {
            Spooker.x++;//push them one space right always.
        } //moves the hero if it is in another hero's space
        if ((Mallard.x == Soda.x && Mallard.y == Soda.y)
                || (Mallard.x == Spooker.x && Mallard.y == Spooker.y)) {
            Mallard.x--;//push them one space right always.
        } //moves the hero if it is in another hero's space
        if ((Soda.x == Spooker.x && Soda.y == Spooker.y)
                || (Soda.x == Mallard.x && Soda.y == Mallard.y)) {
            Soda.x--;//push them one space right always.
        }
    }

    public static void actions() { //does actions for ALL characters behind the scenes

        //poison status 
        if (Jintoku.isPoisoned == true) {
            Jintoku.hp--;
        }
        if (Sakura.isPoisoned == true) {
            Sakura.hp--;
        }
        if (Cam.isPoisoned == true) {
            Cam.hp--;
        }

        //action phase
        Jintoku.action();
        Sakura.action();
        Cam.action();
        Spooker.action();
        Mallard.action();
        Soda.action();
    }

    public static void printCredits() {
        System.out.println("You win!");
        System.out.println("");
        System.out.println("---------------------------------Secret Credits!!!---------------------------------");
        System.out.println("");
        System.out.println("Programming: QWestWaker");
        System.out.println("Story board: QWestWaker");
        System.out.println("Level and Character Design: QWestWaker");
        System.out.println("Made With: Netbeans");
        System.out.println("Gameplay inspiration: Fire Emblem");
        System.out.println("");
        System.out.println("Special Thanks:");
        System.out.println("To everyone who believes in my dream of game design and has supported me along the way. :)");
        System.out.println("");
        System.out.println("Thanks for playing my very first game!");
    }
}
