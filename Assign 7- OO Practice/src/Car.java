//Car Class
/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
//Java Class
public class Car {
//--------------------------------------------------------------//
//------------------------ V A R I A B L E S -------------------//
//--------------------------------------------------------------//

    public static double milesDriven = 0;//total miles driven
    private double efficiency;//mpg
    private double fuel;//in tank
    private String name = "";

//////////////////////////////////////////////////////////////////
////////////////// C O N S T R U C T O R S ///////////////////////
//////////////////////////////////////////////////////////////////
    public Car(double anEfficiency) {
        efficiency = anEfficiency;
        fuel = 0;
        name = "";
    }

    public Car(double anEfficiency, String aName) {
        efficiency = anEfficiency;
        fuel = 0;
        name = aName;
    }

    public Car() {
        efficiency = 0;
        fuel = 0;
        name = "";
    }

//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
//AAAAAAAAAAAAAAA A C C E S S O R S AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    public double getEfficiency() {
        return efficiency;
    }

    public String getName() {
        if (name.equals("")) {
            return "NO NAME";
        } else {
            return name;
        }
    }

    public double getFuel() {
        return fuel;
    }

    public String toString(String n, double e, double f) {
        if (name.equals("")) {
            return n + "\t" + "\t" + "\t" + e + "\t" + "\t" + f;
        } else {
            return n + "\t" + "\t" + e + "\t" + "\t" + f;
        }
    }

    public double getMilesDriven() {
        return milesDriven;
    }

//MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
//MMMMMMMMMMMMMMM M U T A T O R S MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
//MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    public void drive(double distance) {
        double fuelLost = distance / efficiency;
//        if(fuelLost>fuel){
//            System.out.println("NOT ENOUGH FUEL");
//        }
        fuel = fuel - fuelLost;
        milesDriven += distance;
    }

    public void addGas(double gas) throws IllegalArgumentException {
        if (gas > 0) {
            fuel += gas;
        } else {
            throw new IllegalArgumentException("TAKE A DRIVE TO USE GAS!");
        }
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setEfficiency(double newEfficiency) {
        efficiency = newEfficiency;
    }

    public void setFuel(double newFuel) {
        fuel = newFuel;
    }
}
