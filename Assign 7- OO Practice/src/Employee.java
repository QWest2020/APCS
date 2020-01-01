 //Employee Class
/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */

//Java Class
public class Employee {

//--------------------------------------------------------------//
//------------------------ V A R I A B L E S -------------------//
//--------------------------------------------------------------//
    public static int numEmployeesEver = 0;
    public static double totalSalaryEver = 0;
    private double salary;
    private String name;

//////////////////////////////////////////////////////////////////
////////////////// C O N S T R U C T O R S ///////////////////////
//////////////////////////////////////////////////////////////////
    public Employee() {
        name = "";
        salary = 0;
        numEmployeesEver++;
    }

    public Employee(String aName, double aSalary) {
        name = aName;
        salary = aSalary;
        numEmployeesEver++;
    }

//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
//AAAAAAAAAAAAAAA A C C E S S O R S AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    public String getName() {
        if (name.equals("")) {
            return "NO EMPLOYEE";
        } else {
            return name; //gets name
        }
    }

    public double getSalary() {
        return salary; //gets salary
    }

    public String toString(String n, double s) {
        return n + " " + s;
    }

    public int getNumEmployeesEver() {
        return numEmployeesEver;
    }

//MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
//MMMMMMMMMMMMMMM M U T A T O R S MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
//MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    public void raiseSalary(double byPercent)throws IllegalArgumentException {
        if(byPercent>0){
        byPercent = byPercent / 100;
        double changeSal = salary * byPercent; //gets raise value
        salary += changeSal; //adds to original
        round(salary);
        }else
             throw new IllegalArgumentException("CAN'T USE NEGATIVE PERCENTAGE!");
    }

    public void changeName(String newName) { //returns an error message if it's not a string
            name = newName;
            numEmployeesEver++;
    }

    public void changeSalary(double sal){
        salary=sal;
        }

    public static double round(double num) {
        num = num * 100; //move the decimal over 2 places
        num = (int) (num + .5); //add .5 and then chop off decimal
        num = num / 100;
        return num;
    }
}
