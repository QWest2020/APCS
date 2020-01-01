
/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Game {

    //global scanner
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        //make the board
        Board b = new Board();
        //print title
        b.title();
        System.out.println("");
        System.out.println("Would you like to play?, 1=yes, 0=no");
        if (input.nextInt() != 1) {
            System.out.println("See ya!");
            System.exit(0);
        }
        
        //is there a preload?
        System.out.println("Would you like to use a preload?, 1=yes, 0=no");
        if(input.nextInt()==1){
            //preload
            System.out.println("Please enter the number of the preload file, 1-4");
            int num=input.nextInt();
            try {
                //try catch block
                b.preload(num);
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("File not found");
            }
        }
        //lets play!
        while (true) {
            
            //blueTurn
            //print the board
            b.printBoard();
            //prompt
            System.out.println("BLUE, Where would you like to drop a piece? 0-6");
            int column = input.nextInt();
            //make the turn
            b.blueTurn(column);
            //check if filled
            if (b.filled()) {
                b.tie();
                break;
            }
            //check for blue win
            if (b.checkForWin('B')) {
                b.printBoard();
                b.blueWon();
                break;
            }

            //redTurn
            //print the board
            b.printBoard();
            //prompt
            System.out.println("RED, Where would you like to drop a piece? 0-6");
            int selection = input.nextInt();
            //make the turn
            b.redTurn(selection);
            //check if filled
            if (b.filled()) {
                b.tie();
                break;
            }
            //check for red win
            if (b.checkForWin('R')) {
                b.printBoard();
                b.redWon();
                break;
            }
        }
    }
}
