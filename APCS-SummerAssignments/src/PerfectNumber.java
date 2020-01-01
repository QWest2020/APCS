/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
import java.util.Scanner;
public class PerfectNumber {

    public static void main(String[] args) {
        int numChoice = 0, rulesChoice = 0;
        Scanner input = new Scanner(System.in); //Scanner
        System.out.println("Hello! I am the integer checker. Would you like to hear my rules?");
        System.out.println("Press 1 for yes");
        System.out.println("Press 0 for no");
        rulesChoice = input.nextInt();
        if (rulesChoice == 1) {
            System.out.println("A perfect number is a positive integer such that the sum of the divisors equals the\n"
                    + "number. Thus, 28 = 1 + 2 + 4 + 7 + 14 is a perfect number. If the sum of the divisors\n"
                    + "is less than the number, it is deficient. If the sum exceeds the number, it is\n"
                    + "abundant. ");
        } else {
        }
        System.out.println("");
        System.out.println("Please enter your integer!");
        numChoice = input.nextInt();
        int sum = divisorSum(numChoice); //calls method and stores return value in sum
        if (sum == numChoice) {
            System.out.println("Your divisor sum is " + sum);
            System.out.println("Your integer is a perfect number!");
        }
        if (sum < numChoice) {
            System.out.println("Your divisor sum is " + sum);
            System.out.println("Your integer is deficient!");
            if (sum == 1) {
                System.out.println("");
                System.out.println("Because your integer is a prime number you dingus...");
            }
        }
        if (sum > numChoice) {
            System.out.println("Your divisor sum is " + sum);
            System.out.println("Your integer is abundant!");
        }
        System.out.println("");
        System.out.println("                       ::::;                          \n"
                + "                      .,,,:::.                        \n"
                + "                      .,,,,.,,,                       \n"
                + "                       ;::,,,,,`                      \n"
                + "                        ;;:,,,,`                      \n"
                + "                          ;,,,,                       \n"
                + "                                                      \n"
                + "                            .,,::,,,,`                \n"
                + "                    `.,,,,.,,,,,:::,,,,               \n"
                + "              ,:;;;;:;::,,,,.,,,:,.`..:,              \n"
                + "              ,:;;;;;;::::.` `.:;::,,,,,              \n"
                + "              :,,:;;,.`.,::::::::::::,::              \n"
                + "              ;::,..,...,,,,::::::::,.``              \n"
                + "               ;::,,....,,,,,.`                       \n"
                + "                 ;,,,,.`                              \n"
                + "                                                      \n"
                + "                       ,,,::.                         \n"
                + "                      ,:,,,:``                        \n"
                + "                      :;:::.:,,                       \n"
                + "                       ';;:::,,`                      \n"
                + "                         ;'::::`                      \n");
        System.out.println("Have a great day! :)");
    }

    public static boolean isDivisor(int num, int divisor) {
        boolean result = false;
        if (num % divisor == 0) {
            result = true;//this number is a divisor
        } else {
            result = false;//this number is not a divisor
        }
        return result;
    }

    public static int divisorSum(int number) {
        int divider = 1;
        int total = 0;
        for (divider = 1; divider < number; divider++) {//checks all numbers starting at 1
            isDivisor(number, divider);//runs isDivisor
            if (isDivisor(number, divider) == true) {//if its a divisor
                total += divider;//adds true divisor to the sum
            } else {//goes to next number without doing anything
            }
        }
        return total;
    }
}
