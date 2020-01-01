/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */

import java.util.Scanner;

public class BouncyBallExperiment {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Scanner
        int expChoice = 0, initHeight = 0, numBounces = 0;
        double bounceIndex = 0, distance = 0, currentHeight = 0;
        System.out.println("Welcome to the bouncy ball experiment!");
        System.out.println("Would you care to hear the background behind the experiment?");
        System.out.println("Press 1 for yes");
        System.out.println("Press 0 for no");
        expChoice = input.nextInt();
        if (expChoice == 1) {
            System.out.println("A standard experiment is to drop a ball to see how high it bounces. Once the\n"
                    + "\"bounciness\" of the ball is determined, the ratio gives a bounciness index. For\n"
                    + "example, if a ball dropped from a height of 10 feet bounces 6 feet high, the index is\n"
                    + "0.6 and the total distance traveled by the ball is 16 feet after one bounce. If the ball\n"
                    + "continues bouncing, the distance after two bounces would be 10 + 6 + 6+ 3.6 = 25.6\n"
                    + "feet. Note that the distance traveled for each bounce is the distance to the floor\n"
                    + "plus 0.6 of that distance as the ball comes back up.\n");
        }
        if (expChoice == 0) {
            System.out.println("Excellent!");
        }
        System.out.println("");
        System.out.println("What would height (in feet) would you like the ball to start at?");
        initHeight = input.nextInt();
        currentHeight = initHeight;
        System.out.println("What would you like the bounciness index to be?");
        System.out.println("(How bouncy do you want the ball to be?)");
        System.out.println("Must be 0 <= x <= 1");
        bounceIndex = input.nextDouble();
        System.out.println("And how many bounces will you allow?");
        numBounces = input.nextInt();
        int numInc = (numBounces * 2) - 1;//gets the number of increments given that the ball starts going down

        for (int i = 0; i < numInc; i++) {
            if (bounceIndex < 0 || bounceIndex > 1) {
                System.out.println("Don't be cringey...");
                break;
            }
            if(currentHeight<0.000001){
                break;
            }
            if (i % 2 != 0) {//the ball is going up
                currentHeight *= bounceIndex;
                distance += currentHeight;
            }
            if (i % 2 == 0 || i == 0) {//the ball is going down
                distance += currentHeight;
            }
        }
        distance = distance * 100; //move the decimal over 2 places
        distance = (int) (distance + .5); //add .5 and then chop off decimal
        distance = distance / 100;
        System.out.println("");
        System.out.println( "            + @@+                                                             \n"
                + "          .#+'''''##.                                                         \n"
                + "        ;#+''''''''''+@                                                ;`     \n"
                + "       @+''''''''''''''#;                                          ` +#       \n"
                + "      #''''''''';.:`.'''+:                                         ,@         \n"
                + "    `#'''''''''';,:,:''''+:                                       @+`         \n"
                + "    #''''''''''';`.`.'''';#                                      @`           \n"
                + "   ;+''''''''''''.:.,''''''@                                   `@`            \n"
                + "   #'''''''''''''''''''''''#`                                  @.             \n"
                + "` `+'''''''''''''''''''''''';                                 @.              \n"
                + "  ++''''''''''''''''''''''''@                                @`               \n"
                + "  @'''''''''''''''''''''''''#                               @`                \n"
                + "  @'''''''''''''''''''''''''+                              ,+                 \n"
                + "  @'''''''''''''''''''''''''#                              @                  \n"
                + "  @'''''''''''''''''''''''''@                            `@                   \n"
                + "  @''''''''''''''''''''''''';                           `@                    \n"
                + "  ,++++''''''''''''''''''''+                            :'`                   \n"
                + "   ++++''''''''''''''''''''#                            @                     \n"
                + "   @'+++'''''''''''''''''''.                           @`                     \n"
                + "   ;++++++''''''''''''''''#` `                        `;                      \n"
                + "    @+++++'''''''''''''''''                           @                       \n"
                + "     #+'++++'''''''''''''#                           '.                       \n"
                + "     ,+++++++'''''''''''#`'@                         @                        \n"
                + "      +#''++++'''''''''@    @                       @.                        \n"
                + "      ``@+++'+'''''''+#     `;                     `@                         \n"
                + "         `@#+++'''''#@;      `                     @`                         \n"
                + "                      '#+     #                    @                          \n"
                + "                        @@     `                  @                           \n"
                + "                         @@,   ;                  @                           \n"
                + "                          '@    ;                ;                            \n"
                + "                           #@                    @                            \n"
                + "                            +@   ,              .`                            \n"
                + "                             @@  `;             @                             \n"
                + "                              @:   `            @                             \n"
                + "                               #               `,                             \n"
                + "                              `+@              #                              \n"
                + "                                @'             @                              \n"
                + "                                 @             +                              \n"
                + "                                 @@           #`                              \n");
        System.out.println("The ball's total distance was " + distance + " feet!");
        if (bounceIndex == 1) {
            System.out.println("The ball without changing it's height...");
        }
        System.out.println("Have a great day! :)");
    }
}
