/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
import java.util.Scanner;

public class TidBitStore {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Scanner

        //initialize
        boolean done = false;
        int monthCount = 0;
        float compCost = 0f,
                annualInterest = 0f,
                downPaymentPercent = 0f,
                downPayment = 0f,
                toPay = 0f;
        float start[] = new float[100];//
        start[0] = 0;
        float interest[] = new float[100];//
        interest[0] = 0;
        float principal[] = new float[100];//
        principal[0] = 0;
        float end[] = new float[100];//
        end[0] = 0;

        //prompt
        System.out.println("I am the Tidbit Store!");
        System.out.println("Come to us for all of your computer needs!");
        System.out.println("");
        System.out.println("But first things first!");
        System.out.println("Please enter the cost of your computer...");
        compCost = input.nextFloat();
        System.out.println("Next, enter your annual interest rate, ex 10 for 10%");
        annualInterest = input.nextFloat() / 100;
        System.out.println("Finally, enter a down payment percentage, ex 20 for 20%");
        downPaymentPercent = input.nextFloat() / 100;

        //logic
        System.out.println("");
        downPayment = compCost * downPaymentPercent;
        start[monthCount] = compCost - (compCost * downPaymentPercent);//get starting value
        end[monthCount] = downPayment;
        toPay = .05f * (compCost - downPayment);
        //the math
        interest[monthCount] = start[monthCount] * annualInterest / 12;
        principal[monthCount] = toPay - interest[monthCount];
        end[monthCount] = start[monthCount] - principal[monthCount];

        //begin output
        System.out.format("%-5s         %-5s    %-8s    %-9s    %-7s    %-3s%n", "Month", "Start", "Interest", "Principal", "Payment", "End");

        //the math
        interest[monthCount] = start[monthCount] * annualInterest / 12;
        principal[monthCount] = toPay - interest[monthCount];
        end[monthCount] = start[monthCount] - principal[monthCount];

        while (end[monthCount] > 0) {

//            //bug fixer
//            if ((0 < compCost && compCost <= 12000)
//                    || (0 < annualInterest && annualInterest <= .2)
//                    || (0 <= downPaymentPercent && downPaymentPercent <= .5)) {
//                System.out.println("");
//                System.out.println("Stay within these bounds next time...");
//                System.out.println("0<cost<=12,000");
//                System.out.println("0<annual rate<=20");
//                System.out.println("0<=down payment %<=50");
//                done = true;
//                break;
//            }
            //rounders
            round(interest[monthCount]);
            round(toPay);
            round(principal[monthCount]);
            round(end[monthCount]);

            //print
            System.out.format("%-2d %,6.2f %4.2f %4.2f %4.2f %,6.2f%n", monthCount + 1, start[monthCount], interest[monthCount], principal[monthCount], toPay, end[monthCount]);
            //System.out.println(monthCount + 1 + "|" + start[monthCount] + "|" + interest[monthCount] + "|" + principal[monthCount] + "|" + toPay + "|" + end[monthCount]);

            //end becomes start
            start[monthCount + 1] = end[monthCount];//next month's start
            round(start[monthCount]);

            //next month
            monthCount++;

            //the math
            interest[monthCount] = start[monthCount] * annualInterest / 12;
            principal[monthCount] = toPay - interest[monthCount];
            end[monthCount] = start[monthCount] - principal[monthCount];
        }

        //end of loop
        if (done == false) {

            //final math conversion
            principal[monthCount] = start[monthCount];
            toPay = start[monthCount] + interest[monthCount];
            end[monthCount] = start[monthCount] - principal[monthCount];

            //rounders
            round(interest[monthCount]);
            round(toPay);
            round(principal[monthCount]);
            round(end[monthCount]);

            //print last line :)
            System.out.format("%-2d %,6.2f %4.2f %4.2f %4.2f %,6.2f%n", monthCount + 1, start[monthCount], interest[monthCount], principal[monthCount], toPay, end[monthCount]);
            //System.out.println(monthCount + 1 + "|" + start[monthCount] + "|" + interest[monthCount] + "|" + principal[monthCount] + "|" + toPay + "|" + end[monthCount]);
        }
        System.out.println("Have a good day! :)");
    }

    public static float round(float num) {
        num = num * 100; //move the decimal over 2 places
        num = (int) (num + .5); //add .5 and then chop off decimal
        num = num / 100;
        return num;
    }
}
