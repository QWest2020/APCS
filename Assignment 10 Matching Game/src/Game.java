/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
import java.util.Random;
import java.util.Scanner;


public class Game{
    /**
 * @param args
 */
public static void main(String[] args) {

    char[][] gridArray = new char[10][10];
    int randomRow; //randomization wariables
    int randomCol;
    int randomRow2;
    int randomCol2;
    String moveSelect;
    boolean validInput = true;

    int min = 0;
    int max = 9;

    Random tRNG = new Random();
    randomRow = tRNG.nextInt(max - min + 1) + min;
    randomCol = tRNG.nextInt(max - min + 1) + min;
    randomRow2 = tRNG.nextInt(max - min + 1) + min;
    randomCol2 = tRNG.nextInt(max - min + 1) + min;

    gridArray[randomRow][randomCol] = 'o';
    gridArray[randomRow2][randomCol2] = 'X';

    for (int i = 0; i < gridArray.length; i++)
    {
        for (int j = 0; j < gridArray.length; j++)
        {       
            if (gridArray[i][j] != gridArray[randomRow][randomCol] && gridArray[i][j] != gridArray[randomRow2][randomCol2])
            {
                gridArray[i][j] = '.';
            }
            System.out.print(gridArray[i][j]);
        }
        System.out.println("");  
    }

    System.out.println("Enter a movement choice W A S or D");
    do{

        Scanner keyboard = new Scanner(System.in);
        moveSelect = keyboard.nextLine();

        if ( moveSelect.equals("w"))
        {
            gridArray[randomRow][randomCol] = gridArray[randomRow+1][randomCol];
            gridArray[randomRow][randomCol] = ' ';
            validInput = true;      
        }

        else if ( moveSelect.equals("a"))
        {
            gridArray[randomRow][randomCol] = gridArray[randomRow][randomCol-1];
            gridArray[randomRow][randomCol] = ' ';
            validInput = true;
        }

        else if ( moveSelect.equals("s"))
        {
            gridArray[randomRow][randomCol] = gridArray[randomRow-1][randomCol];
            gridArray[randomRow][randomCol] = ' ';
            validInput = true;
        }

        else if (moveSelect.equals("d"))
        {
            gridArray[randomRow][randomCol] = gridArray[randomRow][randomCol+1];
            gridArray[randomRow][randomCol] = ' ';
            validInput = true;
        }

        else
        {
            System.out.println("Invalid Entry. Try again.");
            validInput = false;
        }

    } while (validInput == false);
}

}
//    //music creds to Toby Fox
//    public static void playBGMusic() throws Exception {
//        // open the sound file as a Java input stream
//        String bgmFile = "F:\\APCS and DIGITAL\\Assign 10 RPG\\sounds\\ruins.wav";
//        InputStream in = new FileInputStream(bgmFile);
//        // create an audiostream from the inputstream
//        AudioStream bgAudio = new AudioStream(in);
//        // play the audio clip with the audioplayer class
//        AudioPlayer.player.start(bgAudio);
//    }
//}