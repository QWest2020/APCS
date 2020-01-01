/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
/*
 * The Circle class models a circle with a radius and color.
 */
public class Circle {
   // private instance variable, not accessible from outside this class
   //This initializes our object with 2 varibles, a radius and a color.
   private double radius;
   private String color;
   
   public Circle() {
   // constructor with direct values
      radius = 1.0;
      color = "red";
   }
   public Circle(double r) {
   // 2nd constructor with indirect radius. This will be retrieved in our tester
      radius = r;
      color = "red";
   }
   
   // A public method for retrieving the radius
   public double getRadius() {
     return radius; 
   }
   
   // A public method for computing the area of circle
   public double getArea() {
      double area=radius*radius*Math.PI;
      area=round(area);
      return area;
   }
   
   //round method
   public static double round(double num) {
        num = num * 100; //move the decimal over 2 places
        num = (int) (num + .5); //add .5 and then chop off decimal
        num = num / 100;
        return num;
    }
}
