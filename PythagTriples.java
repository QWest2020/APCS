/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */

//the first number is the monthCount
//the second number is the day
//and the third number is the year!
import java.util.Scanner;

public class PythagTriples {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Scanner

        //initalization
        int 
        yearInput1 = 0,
        yearInput2 = 0,
        dayCount=1,
        monthCount = 0,
        yearCount = 0,
        numTriples = 0,
        yearOutput = 0;
        
        String 
        output = "";

        //days array
        int[] numDays = new int[12];
        numDays[0] = 31;
        numDays[1] = 28;
        numDays[2] = 31;
        numDays[3] = 30;
        numDays[4] = 31;
        numDays[5] = 30;
        numDays[6] = 31;
        numDays[7] = 31;
        numDays[8] = 30;
        numDays[9] = 31;
        numDays[10] = 30;
        numDays[11] = 31;

        //input
        System.out.println("Hello! I am the Pythagorean Year checker! (Whatever that is...)");
        System.out.println("Please enter your first year...");
        yearInput1 = input.nextInt();
        System.out.println("Please enter your second year...");
        yearInput2 = input.nextInt();

        //variable setting
        yearCount = yearInput1;//year count starts at the lowest year value
        yearOutput = yearInput1;//the years printed begins at the first entered year

        //logic
        while (yearCount <= yearInput2) {//starts at minimum year index and works its way to the max
            while (monthCount < 12) {//starts at 0 and goes to 11
                while (dayCount <= numDays[monthCount]) {//starts at 1 and goes to each month's max
                    if ((((monthCount + 1) * (monthCount + 1)) + (dayCount * dayCount) == ((yearCount%100) * (yearCount%100)))) {
                        output = output + ((monthCount + 1) + "," + dayCount + "," + yearCount%100 + ";" + yearOutput + "\n");//print format
                        numTriples++;
                    } else {
                    }
                    dayCount++;//next day
                }
                monthCount++;//next month
                dayCount = 1;
            }
            yearCount++;//next year
            yearOutput++;//display the next year
            monthCount = 0;
        }

        //final output
        System.out.println("");
        System.out.println("You found " + numTriples + " triples!");
        System.out.println("");
        System.out.println(output);
        System.out.println("Have a good day! :)");
    }
}