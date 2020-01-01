/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
import java.util.Scanner;
public class TestCircle {  // Save as "TestCircle.java"
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in); //Scanner
      // Declare an instance of Circle class called c1.
      // Construct the instance c1 by invoking the "default" constructor
      // which sets its radius and color to their default value.
      int rad=0;
       System.out.println("Please enter a radius for circle 1");
       rad=input.nextInt();
      Circle c1 = new Circle(rad);
      // Invoke public methods on instance c1, via dot operator.
      //this alows us to use the methods we created in the Circle class.
      //thus, the Circle class contains the two methods getRadius and getArea.
      System.out.println("The circle has radius of " 
         + c1.getRadius() + " and area of " + c1.getArea());
      // Declare an instance of class circle called c2.
      // Construct the instance c2 by invoking the second constructor
      // with the given radius and default color.
      Circle c2 = new Circle(rad*2);
      // Invoke public methods on instance c2, via dot operator.
      System.out.println("The circle has radius of " 
         + c2.getRadius() + " which is double that of the first circle, and area of " + c2.getArea());
   }
}
