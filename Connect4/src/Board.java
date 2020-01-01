
/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Board {

    //wariables
    public char[][] spaces = new char[6][7]; //size of the board
    public char SPACE = ' ';
    public char BLUE = 'O';
    public char RED = 'X';
    public String sF = " "+"|"+" ";

    //constructors
    public Board() {
        for (int i = 0; i < spaces.length; i++) {
            for (int j = 0; j < spaces[0].length; j++) {
                spaces[i][j] = SPACE;
            }
        }
    }

    //player actions
    public void blueTurn(int c) {
        for (int i = spaces.length - 1; i > 0; i--) {
            if (spaces[i][c] == SPACE) {
                spaces[i][c] = BLUE;
                break;
            }
        }
    }

    public void redTurn(int c) {
        for (int i = spaces.length - 1; i > 0; i--) {
            if (spaces[i][c] == SPACE) {
                spaces[i][c] = RED;
                break;
            }
        }
    }

    //check for wins
    public boolean checkForWin(char color) {
        //horizontal
        for (int i = 0; i < spaces.length; i++) {
            int numH = 0; //we can reset this here since were checking by row
            for (int j = 0; j < spaces[i].length; j++) {
                if (j < spaces[i].length - 1
                        && spaces[i][j] == color
                        && spaces[i][j] == spaces[i][j + 1]) {
                    numH++;
                }
                if (numH >= 3) {
                    return true;
                }
            }
        }

        //vertical
        for (int j = 0; j < spaces[0].length; j++) {
            int numV = 0; //we can reset this here since were checking by column
            for (int i = 0; i < spaces.length; i++) {
                if (i < spaces.length - 1
                        && spaces[i][j] == color
                        && spaces[i][j] == spaces[i + 1][j]) {
                    numV++;
                }
                if (numV >= 3) {
                    return true;
                }
            }
        }

        //upper right diagonal
        for (int i = 0; i < spaces.length; i++) {
            for (int j = 0; j < spaces[i].length; j++) {
                //prerequisites
                if (i <= spaces.length - 3 && j <= spaces[i].length - 3 && spaces[i][j] == color) {
                    //if there is a diagonal
                    if (spaces[i][j] == spaces[i + 1][j + 1]
                            && spaces[i + 1][j + 1] == spaces[i + 2][j + 2]
                            && spaces[i + 2][j + 2] == spaces[i + 3][j + 3]) {
                        return true;
                    }
                }
            }
        }
        //upper left diagonal
        for (int i = 0; i < spaces.length; i++) {
            for (int j = 0; j < spaces[i].length; j++) {
                //prerequisites
                if (i <= spaces.length - 3 && j >= 3 && spaces[i][j] == color) {
                    //if there is a diagonal
                    if (spaces[i][j] == spaces[i + 1][j - 1]
                            && spaces[i + 1][j - 1] == spaces[i + 2][j - 2]
                            && spaces[i + 2][j - 2] == spaces[i + 3][j - 3]) {
                        return true;
                    }
                }
            }
        }
        //if it gets to this point
        return false;
    }

    //print the board
    public void printBoard() {
        for (int i = 0; i < spaces.length; i++) {
            System.out.print(sF + "");
            for (int j = 0; j < spaces[0].length; j++) {
                System.out.print(spaces[i][j] + "" + sF);
                if (j == spaces[i].length - 1) {
                    System.out.println(""); //next line
                }
            }
        }
        //make it look nice!
        System.out.println(" -----------------------------"); 
    }

    //is it filled?
    public boolean filled() {
        for (int i = 0; i < spaces.length; i++) {
            for (int j = 0; j < spaces[i].length; j++) {
                if (spaces[i][j] == SPACE) {
                    return false;
                }
            }
        }
        //if it gets to this point
        return true;
    }

    //title display
    public void title() {
        System.out.println("                                                                                              \n"
                + "                                                                                         ,--, \n"
                + "  ,----..                                                         ___                  ,--.'| \n"
                + " /   /   \\                                                      ,--.'|_             ,--,  | : \n"
                + "|   :     :  ,---.        ,---,      ,---,                      |  | :,'         ,---.'|  : ' \n"
                + ".   |  ;. / '   ,'\\   ,-+-. /  | ,-+-. /  |                     :  : ' :         ;   : |  | ; \n"
                + ".   ; /--` /   /   | ,--.'|'   |,--.'|'   |   ,---.     ,---. .;__,'  /          |   | : _' | \n"
                + ";   | ;   .   ; ,. :|   |  ,\"' |   |  ,\"' |  /     \\   /     \\|  |   |           :   : |.'  | \n"
                + "|   : |   '   | |: :|   | /  | |   | /  | | /    /  | /    / ':__,'| :           |   ' '  ; : \n"
                + ".   | '___'   | .; :|   | |  | |   | |  | |.    ' / |.    ' /   '  : |__         \\   \\  .'. | \n"
                + "'   ; : .'|   :    ||   | |  |/|   | |  |/ '   ;   /|'   ; :__  |  | '.'|         `---`:  | ' \n"
                + "'   | '/  :\\   \\  / |   | |--' |   | |--'  '   |  / |'   | '.'| ;  :    ;              '  ; | \n"
                + "|   :    /  `----'  |   |/     |   |/      |   :    ||   :    : |  ,   /               |  : ; \n"
                + " \\   \\ .'           '---'      '---'        \\   \\  /  \\   \\  /   ---`-'                '  ,/  \n"
                + "  `---`                                      `----'    `----'                          '--'   \n"
                + "                                                                                              ");
    }

    //win displays
    public void blueWon() {
        System.out.println(" /$$$$$$$  /$$                           /$$      /$$                     /$$\n"
                + "| $$__  $$| $$                          | $$  /$ | $$                    | $$\n"
                + "| $$  \\ $$| $$ /$$   /$$  /$$$$$$       | $$ /$$$| $$  /$$$$$$  /$$$$$$$ | $$\n"
                + "| $$$$$$$ | $$| $$  | $$ /$$__  $$      | $$/$$ $$ $$ /$$__  $$| $$__  $$| $$\n"
                + "| $$__  $$| $$| $$  | $$| $$$$$$$$      | $$$$_  $$$$| $$  \\ $$| $$  \\ $$|__/\n"
                + "| $$  \\ $$| $$| $$  | $$| $$_____/      | $$$/ \\  $$$| $$  | $$| $$  | $$    \n"
                + "| $$$$$$$/| $$|  $$$$$$/|  $$$$$$$      | $$/   \\  $$|  $$$$$$/| $$  | $$ /$$\n"
                + "|_______/ |__/ \\______/  \\_______/      |__/     \\__/ \\______/ |__/  |__/|__/\n"
                + "                                                                             \n");
    }

    public void redWon() {
        System.out.println(" _______                   __        __       __                      __ \n"
                + "/       \\                 /  |      /  |  _  /  |                    /  |\n"
                + "$$$$$$$  |  ______    ____$$ |      $$ | / \\ $$ |  ______   _______  $$ |\n"
                + "$$ |__$$ | /      \\  /    $$ |      $$ |/$  \\$$ | /      \\ /       \\ $$ |\n"
                + "$$    $$< /$$$$$$  |/$$$$$$$ |      $$ /$$$  $$ |/$$$$$$  |$$$$$$$  |$$ |\n"
                + "$$$$$$$  |$$    $$ |$$ |  $$ |      $$ $$/$$ $$ |$$ |  $$ |$$ |  $$ |$$/ \n"
                + "$$ |  $$ |$$$$$$$$/ $$ \\__$$ |      $$$$/  $$$$ |$$ \\__$$ |$$ |  $$ | __ \n"
                + "$$ |  $$ |$$       |$$    $$ |      $$$/    $$$ |$$    $$/ $$ |  $$ |/  |\n"
                + "$$/   $$/  $$$$$$$/  $$$$$$$/       $$/      $$/  $$$$$$/  $$/   $$/ $$/ \n"
                + "                                                                         \n");
    }

    public void tie() {
        System.out.println(" __     ______   ______        ______        ______   __     ______    \n"
                + "/\\ \\   /\\__  _\\ /\\  ___\\      /\\  __ \\      /\\__  _\\ /\\ \\   /\\  ___\\   \n"
                + "\\ \\ \\  \\/_/\\ \\/ \\ \\___  \\     \\ \\  __ \\     \\/_/\\ \\/ \\ \\ \\  \\ \\  __\\   \n"
                + " \\ \\_\\    \\ \\_\\  \\/\\_____\\     \\ \\_\\ \\_\\       \\ \\_\\  \\ \\_\\  \\ \\_____\\ \n"
                + "  \\/_/     \\/_/   \\/_____/      \\/_/\\/_/        \\/_/   \\/_/   \\/_____/ \n"
                + "                                                                       ");
    }

    //load a preloaded board
    public void preload(int fileNum) throws IOException {
        File f;
        switch(fileNum){
                case 1: f = new File("C:\\NetBeanz\\Connect4\\preloads\\1.txt");
                    break;
                case 2: f = new File("C:\\NetBeanz\\Connect4\\preloads\\2.txt");
                    break;
                case 3: f = new File("C:\\NetBeanz\\Connect4\\preloads\\3.txt");
                    break;
                case 4: f = new File("C:\\NetBeanz\\Connect4\\preloads\\4.txt");
                    break;
                default: f = new File("C:\\NetBeanz\\Connect4\\preloads\\1.txt");
                    break;
        }
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        int count=0;
        while ((line = br.readLine()) != null) {
            if(count%2==0)
                blueTurn(Integer.parseInt(line));
            else
                redTurn(Integer.parseInt(line));
            count++;
        }
    }
}
