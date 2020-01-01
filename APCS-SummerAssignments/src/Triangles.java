/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */

//Write a program that takes as inputs the lengths of three sides of a triangle and
//displays; first, whether or not the 3 values represent a triangle and then whether
//the triangle is scalene, isosceles, or equilateral. Useful facts:
//• In a triangle, the longest side must be less than the sum of the other two sides.
//• A scalene triangle has all sides unequal.
//• An isosceles triangle has two sides equal.
//• An equilateral triangle has all sides equal.
//HINTS for Testing: When testing, make sure you test with all sides the same and
//your program doesn’t report the triangle to be both isosceles and equilateral.
import java.util.Scanner;

public class Triangles {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Scanner

        int x = 0, y = 0, z = 0;
        System.out.println("Hello, I am the triangle checker!");
        System.out.println("I will make sure your triangle is legit!");
        System.out.println("Please enter your 3 lengths");
        System.out.println("side 1...");
        x = input.nextInt();
        System.out.println("side 2...");
        y = input.nextInt();
        System.out.println("side 3...");
        z = input.nextInt();

        if ((x >= y && x >= z && x < y + z)
                ||//x is the biggest side and it is a triangle
                (y >= x && y >= z && y < x + z)
                ||//y is the biggest side and it is a triangle
                (z >= y && z >= x && z < y + x)) {//z is the biggest side and it is a triangle
            System.out.println("");
            System.out.println("It's a triangle! :)");
            System.out.println("But what kind of triangle? ...");
            System.out.println("");

            System.out.println("                                        :                                        \n"
                    + "                                       ,::                                       \n"
                    + "                                       :,:`                                      \n"
                    + "                                      ::.::                                      \n"
                    + "                                      ,...:``                                    \n"
                    + "                                     ,,...:,                                     \n"
                    + "                                    ,:.....:,                                    \n"
                    + "                                    ::.....:,                                    \n"
                    + "                                   ::.......::                                   \n"
                    + "                                  `:,.......,:`                                  \n"
                    + "                                  ,:...``````:,                                  \n"
                    + "                                 `:...```````.:.                                 \n"
                    + "                                 ::...````````::                                 \n"
                    + "                                ,:...`````````.:,                                \n"
                    + "                                :,...``````````::                                \n"
                    + "                               ::....``````````.::                               \n"
                    + "                              `:,....``````````.,:`                              \n"
                    + "                              ::.......```````...::                              \n"
                    + "                             .:,........````......:.                             \n"
                    + "                             ::...................::                             \n"
                    + "                            ,:,,...................::                            \n"
                    + "                            ,,,,...................::`                           \n"
                    + "                           ::,,,,..................,::                           \n"
                    + "                          `,,,,,,,,...............,,,:`                          \n"
                    + "                          ::,,,,,,,,............,,,,,::`                         \n"
                    + "                         ,:,,,,,,,,,,,,,...,,,,,,,,,,,:,                         \n"
                    + "                         ::,,,,,,,,,,,,,,,,,,,,,,,,,,,::                         \n"
                    + "                        ::,,,,,,,,,,,,,,,,,,,,,,,,,,,,,::                        \n"
                    + "                       `::,,,,,,,,,,,,,,,,,,,,,,,,,,,,,::                        \n"
                    + "                       ::,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,:;                       \n"
                    + "                      .,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,;.                      \n"
                    + "                      :,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,;;                      \n"
                    + "                     ,:,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,;:                     \n"
                    + "                    `:::::::::::::::::::::::::::;;;;;;;;;;;;                     \n"
                    + "                    .                                       .                    \n"
                    + "                    :                                       ,                    \n"
                    + "                   ,,,                                     ,::                   \n"
                    + "                 ``:,,                                     :,:`                  \n"
                    + "                  :,,::                                   ::,:,                  \n"
                    + "                 ,,,,,:`                                 `,,.,,,                 \n"
                    + "                 ::,,,::                                 ::...::                 \n"
                    + "                ,,,,,,,:.                               .:.....:,                \n"
                    + "               `,,,,,,,,:                               :,.....,:`               \n"
                    + "               ::,,,,,,,,:                             ::.......::               \n"
                    + "              .:,,,,,,,,::                             ,,........:.              \n"
                    + "              ::,,,,,,,,,:,                           ::.........:,              \n"
                    + "             ,:,,,,,,,,,,,:`                         .:....```....:,             \n"
                    + "            `:,,.......,,,::                         ,,.```````...,:             \n"
                    + "            ::,.........,,,:,                       ,:..````````...::            \n"
                    + "           `:,.............,:                       :,``````````...,:`           \n"
                    + "           ,:...............::                     ,:.```````````...::           \n"
                    + "          .:...............,,:``                   ,,.```````````....:.          \n"
                    + "          :,.................::                   ::.````````````....::          \n"
                    + "         ::..................,:.                 .:....`````````......::         \n"
                    + "         :,.....``````........::                 :,......``````.......,:         \n"
                    + "        ::.....````````........::               ::.........```.........::        \n"
                    + "       `:.....``````````.......,:               :,....................,,:`       \n"
                    + "       :,.....``````````........::             ::......................,::       \n"
                    + "      .,......``````````........,;`           `:,,....................,,,:,      \n"
                    + "      ::......``````````........,;:           ::,,,.................,,,,,::      \n"
                    + "     ,:.......``````````........,,:,         `:,,,,,...............,,,,,,,;:     \n"
                    + "    `:,........````````.........,,::         ,,,,,,,,,,.........,,,,,,,,,,::     \n"
                    + "    ::..........``````.........,,,,:;       ,:,,,,,,,,,,,,,,,,,,,,,,,,,,,,,;;    \n"
                    + " ` .:.,........................,,,,::`     `,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,:,   \n"
                    + "   ,:,,........................,,,,,;;     ,:,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,;;   \n"
                    + "  ,:,,,,,....................,,,,,,,,;.   .:,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,;,  \n"
                    + "  :,,,,,,..................,,,,,,,,,,;;   ,:,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,:;  \n"
                    + " :,::::::::::::::::::::::::::::::::::::: ,::::::::::::::::::::::::::::::::::::;; \n"
                    + " :::::::::::::::::::::::::::;;;;;;;;;;;; :::::::::::::::::::::::::;:::;;;;;;;;;; ");
            System.out.println("");
            System.out.println("It's a triangle! :)");
            System.out.println("But what kind of triangle? ...");
            System.out.println("");
            if (x == y && x == z && y == z) {
                System.out.println("It's an equilateral triangle! So symetrical!");
            } else if ((x == y && x == z) && (y == x && y == z) && (z == x && z == y)) {
                System.out.println("It's an isosceles triangle! My favorite!");
            } else if (x != y && x != z && y != z) {
                System.out.println("It's a scalene triangle! so asymetrical!");
            }
        } else {
            System.out.println("");
            System.out.println("It's not a triangle! :(");
        }
        System.out.println("");
        System.out.println("Have a great day! :)");
    }
}
