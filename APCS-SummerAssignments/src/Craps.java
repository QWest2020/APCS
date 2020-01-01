/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */

import java.util.Random;
import java.util.Scanner;

public class Craps {

    static Random r = new Random();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); //Scanner

        //variables
        int introChoice = 0, pointValue = 0, numRockCandies = 100, wager = 0, rollInish = 1;
        int dice1 = 0, dice2 = 0, diceSum = 0, numRolls = 0, playAgain = 0;
        boolean end = false;

        //intro
        System.out.println("Welcome to Craps! Coded by Liam McMahan");
        System.out.println("");

        //prints craps ascii
        System.out.println("         $$$$$$\\  $$$$$$$\\   $$$$$$\\  $$$$$$$\\   $$$$$$\\  $$\\       \n"
                + "        $$  __$$\\ $$  __$$\\ $$  __$$\\ $$  __$$\\ $$  __$$\\ $$ |      \n"
                + "        $$ /  \\__|$$ |  $$ |$$ /  $$ |$$ |  $$ |$$ /  \\__|$$ |      \n"
                + "        $$ |      $$$$$$$  |$$$$$$$$ |$$$$$$$  |\\$$$$$$\\  $$ |      \n"
                + "        $$ |      $$  __$$< $$  __$$ |$$  ____/  \\____$$\\ \\__|      \n"
                + "        $$ |  $$\\ $$ |  $$ |$$ |  $$ |$$ |      $$\\   $$ |          \n"
                + "        \\$$$$$$  |$$ |  $$ |$$ |  $$ |$$ |      \\$$$$$$  |$$\\       \n"
                + "         \\______/ \\__|  \\__|\\__|  \\__|\\__|       \\______/ \\__|");

        System.out.println("");
        System.out.println("Would you like to hear the rules of the game?");
        System.out.println("Enter 1 for yes");
        System.out.println("If not, Enter 0");
        introChoice = input.nextInt();
        if (introChoice == 1) {
            //rules
            System.out.println("In the game of craps, a player rolls 2 six sided dice and adds up the sum. \n"
                    + "What happens with the sum determines whether you win or loose. The first roll\n"
                    + "however is unique; a player can either win or lose instantly on the first roll!\n"
                    + "\n"
                    + "If the sum of the first roll is a 7 or 11, INSTANT WINNER and the round is over.\n"
                    + " If a player rolls a sum of 2, 3 or 12, INSTANT LOSER. If none of the above are rolled, the player goes\n"
                    + "into a phase where they continually roll the 2 dice until one of two events occur;\n"
                    + "1) the player rolls the intial number (known as the point value) the player WINS\n"
                    + "2) the player rolls a 7, the player LOSES.\n"
                    + "\n"
                    + "• Examples of dice roll sequences and results\n"
                    + "i. Roll a 7 on first roll -> WIN\n"
                    + "ii. Roll an 11 on first roll -> WIN\n"
                    + "iii. Roll a 2 on first roll ->LOSE\n"
                    + "iv. Roll a 3 on first roll -> LOSE\n"
                    + "v. Roll a 12 on first roll -> LOSE\n"
                    + "vi. Roll a 5, 9, 12, 6 and then a 5 to WIN since you rerolled the point\n"
                    + "vii. Roll a 5, 9, 12, 6 and then a 7 to LOSE since you rolled a 7 when\n"
                    + "attempting to reroll the point\n"
                    + "viii. Roll 8, 2, 3, 11, 12, 9, 3, 3, 5, 9, 10, 8 to win since you rerolled the point\n"
                    + "\n"
                    + "At the begining of each turn, you may make a wager.\n"
                    + "You have been given 100 Candies to use as you wish.\n"
                    + "-Rules originally written by: Mr.Hanley\n"
                    + "-Rules revised by: Liam McMahan\n");
        } else {
        }
        System.out.println("");
        System.out.println("Let's get started!");
        while (true) {

            //re initialize variables
            end = false;
            playAgain = 0;
            numRolls = 0;

            //enter wager
            System.out.println("How much would you like to wager?");
            System.out.println("You have " + numRockCandies + " Candies.");
            wager = input.nextInt();
            if (wager == numRockCandies) {//if all in
                System.out.println("ALL IN!");
            } else if (wager > numRockCandies || wager < 0) {// if wager is too high or too low
                System.out.println("No Can dooey Hong Kong Fooey!   -Mr. Hanley");
                System.out.println("You don't have enough Candies! :");
                break;
            } else {
                System.out.println("Good Luck!");
            }
            System.out.println("ROUND BEGIN!");

            //prompt roll
            while (end == false) {
                System.out.println("");
                System.out.println("Press 0 to roll");
                rollInish = input.nextInt();

                //roll action
                dice1 = r.nextInt(5) + 1;
                dice2 = r.nextInt(5) + 1;
                diceSum = dice1 + dice2;
                numRolls++;

                //show roll and set point value
                System.out.println("You rolled a total of " + diceSum);
                if (numRolls == 1) {
                    pointValue = diceSum;
                    System.out.println("Your Point value is " + pointValue);
                } else {
                }

                //first roll win or loose
                if (numRolls == 1) {//if its the first roll
                    if (diceSum == 7 || diceSum == 11) {//win
                        //if win how many Candies earned?
                        System.out.println("");
                        System.out.println("$$$$$$$$$$$ IMMEDIATE WINNER $$$$$$$$$$$$$$");
                        System.out.println("You have earned " + wager + " Candies!");
                        numRockCandies += wager;
                        end = true;
                    }
                    if (diceSum == 2 || diceSum == 3 || diceSum == 12) {//loose
                        //if lose how many Candies lost?
                        System.out.println("");
                        System.out.println("===========IMMEDIATE LOSER=================");
                        System.out.println("You have lost " + wager + " Candies.");
                        numRockCandies -= wager;
                        end = true;
                    } else if (diceSum != 7 || diceSum != 11 || diceSum != 2 || diceSum != 3 || diceSum != 12) {
                        System.out.println("No immediate wins...");
                    }
                } else {
                    //not the first roll
                    if (diceSum == 7) {//they get a 7 after their first roll
                        System.out.println("");
                        System.out.println("================LOSER======================");
                        System.out.println("You have lost " + wager + " Candies.");
                        numRockCandies -= wager;
                        end = true;
                    }
                    if (diceSum == pointValue) {//they get their point value without getting 7
                        System.out.println("");
                        System.out.println("$$$$$$$$$$$$$$$$ WINNER $$$$$$$$$$$$$$$$$$$");
                        System.out.println("You have earned " + wager + " Candies!");
                        numRockCandies += wager;
                        end = true;
                    } else {//rolls again   
                    }
                }
            }
            //ask play again (if they decide to leave, break and tell them their final candy quantity)
            System.out.println("Would you like to play another round?");
            System.out.println("Enter 1 for yes");
            System.out.println("If not, Enter 0");
            playAgain = input.nextInt();
            if (playAgain == 1) {//plays again
                System.out.println("Go get 'em!");
            } else {//ends game
                break;
            }
        }
        System.out.println("                                                 ##;..+@                                            \n"
                + "                                                ##,,..:##                                           \n"
                + "                                               ##,.,...+#                                           \n"
                + "                                              +#;,......#,                                          \n"
                + "                                             `##:,......#.                                          \n"
                + "                           `+@#######+.      ##:::.....:#                                           \n"
                + "                         ##+###+''+#####'   ;#;::,.....:#                                           \n"
                + "                      `####:,,,:,,,::,:###. +#,::,,....,#;                                          \n"
                + "                     ###;...`.`.........,####.::.:....,.##'                                         \n"
                + "                    ###,,``````.::,,,....,###.,,::,.....,##`                                        \n"
                + "                  .##::.````....:::::::,...##.,.,,,,,.,...#:                                        \n"
                + "                 `##,:..``......,:::::::,..,#+,,:::::,...:#                                         \n"
                + "                 +#,,...,.......,:::::::,...##.,:::::,...'#                                         \n"
                + "                @#::..::,........,:::::::,..;#`..,:::,...:#`                                        \n"
                + "               ,#;:,.:::,........,:::::::,..,##;:::::,....##                                        \n"
                + "  .;+':`       ##,.,::::,........,:::::::,..,####+,::,..,.+#                                        \n"
                + "'#########:   `#:,,::::::.........,:::::::,.:# .######'''##+`                                       \n"
                + " #;....:####@`++..:::::::.........,:::::::,.##    :#@##+###+                                        \n"
                + " +'....,,::+####,.,::::::,........,:::::::,,##                                                      \n"
                + " #'.....,::,,'##,.,::::::,.........,:::::;:'#`                                                      \n"
                + " #;.....,,::,.@#..,:::::::.........,::::::,##                                                       \n"
                + " #',.....,::::##.,,,::::::,........,::::::##                                                        \n"
                + " @+.......,::.:#,.,,:::::::........,:::::##;                                                        \n"
                + "  ##.....,,.,,.##..,:::::::,........::::##+                                                         \n"
                + "  `##....`.,:,.'#'..,::::::,,.......,:,@#'                                                       \n"
                + "   :+,...,::::,,##;.,:::::::,.......,+##,                                 \n"
                + "    #:...,:::,:,+###.,::::::,....,.;###                                \n"
                + "   :#....,:;.::#+ '###:::::::,..:####.                             \n"
                + "   ;#.....,:::'#; ` #+##@####@####+`  `          `                 \n"
                + "    ##.....:::#@      `+#######;                                \n"
                + "    .##....,,##                                 \n"
                + "     ,#,...,@#`                                 \n"
                + "      #+,,'##                                    \n"
                + "      @#:###`                                    \n"
                + "      :###:                                      \n"
                + "       @: ");
        System.out.println("Enjoy your " + numRockCandies + " Candies!");
        System.out.println("Have a great day! It's been fun! :)");
    }
}
