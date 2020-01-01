//Tester class
/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */

//Java Main Class
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Scanner;

public class Tester {

    static final char ur = '\u2557';
    static final char ul = '\u2554';
    static final char top = '\u2550';
    static final char side = '\u2551';
    static final char sideTL = '\u2560';
    static final char sideRL = '\u2563';
    static final char bl = '\u255A';
    static final char br = '\u255D';
    static final char one = '\u2776';
    static final char two = '\u2777';
    static final char thr = '\u2778';
    static final char fou = '\u2779';
    static final char fiv = '\u277A';
    static final char six = '\u277B';
    static final char sev = '\u277C';

    public static void main(String[] args) {
        Tester es = new Tester();  //invoke constructor
    }

    /**
     *
     * @param text give me a text expression
     * @param totalLength total length of String to be filled
     * @return a String of spaces to "pad" the region where length =
     * total.length-text.length
     */
    public String padding(String text, int totalLength) {
        int difference = totalLength - text.length();
        if (difference > 0) {

            for (int i = 0; i < difference; i++) {
                text += " ";
            }
        }
        return text;
    }

    public Tester() {
        menu();
    }

    //LIAM'S MODIFICATION
    String enterName = "";
    double enterSalary = 0;
    double enterEfficiency = 0;
    double enterFuel = 0;
    double enterQuizSum = 0;
    double enterAverage = 0;
    int enterNumQuizes = 0;

    public void menu() {
        while (true) {
            Date now = new Date();
            System.out.print("\t\t" + ul);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________");
            System.out.println(ur);
            System.out.println("\t\t" + side + "        OO Practice Main Menu            " + side);
            System.out.println("\t\t" + side + "  $@$ OO is Delicious and Nutritious $@$ " + side);
            System.out.print("\t\t" + sideTL);

            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________
            System.out.println(sideRL);
            System.out.println("\t\t" + side + "        " + one + " = Employee Example             " + side);
            System.out.println("\t\t" + side + "        " + two + " = Car Example                  " + side);
            System.out.println("\t\t" + side + "        " + thr + " = Student Example              " + side);
            System.out.println("\t\t" + side + "        " + fou + " = Enhanced Employee Example    " + side);
            System.out.println("\t\t" + side + "        " + fiv + " = Enhanced Car Example         " + side);
            System.out.println("\t\t" + side + "        " + six + " = Enhanced Student Example     " + side);
            System.out.println("\t\t" + side + "        " + sev + " = Exit                         " + side);
            System.out.println("\t\t" + side + "                                         " + side);
            System.out.print("\t\t" + bl);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //+"_________________________________________
            System.out.println(br);
            System.out.println("\t\tYour Selection?");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    employeeModule();
                    break;
                case 2:
                    carModule();
                    break;
                case 3:
                    studentModule();
                    break;
                case 4:
                    employeeModuleWithMods();
                    break;
                case 5:
                    carModuleWithMods();
                    break;
                case 6:
                    studentModuleWithMods();
                case 7:
                    System.exit(0);
            }
        }
    }

    public void employeeModule() {

        DecimalFormat df = new DecimalFormat("###,###,###");
        //Declare some Employees
        Employee e1 = new Employee();
        Employee e2 = new Employee("John Anderson", 52000);
        Employee e3 = new Employee("Steve Wozniak", 60000);
        while (true) {
            System.out.print("\t\t" + ul);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________");
            System.out.println(ur);
            System.out.println("\t\t" + side + "  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% " + side);
            System.out.println("\t\t" + side + "  E M P L O Y E E     M E N U            " + side);
            System.out.println("\t\t" + side + "  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% " + side);
            System.out.print("\t\t" + sideTL);

            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________
            System.out.println(sideRL);
            System.out.println("\t\t" + side + "        1 = Display Employees            " + side);
            System.out.println("\t\t" + side + "        2 = Recreate one Employee        " + side);
            System.out.println("\t\t" + side + "        3 = Give Raise                   " + side);
            System.out.println("\t\t" + side + "        4 = Exit to Main                 " + side);
            System.out.println("\t\t" + side + "        5 = Exit Program                 " + side);
            System.out.println("\t\t" + side + "                                         " + side);
            System.out.print("\t\t" + bl);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //+"_________________________________________
            System.out.println(br);
            System.out.println("\t\tYour Selection?");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("_____________Display Employees____________");
                    //LIAM APPROVED
                    System.out.println("");
                    System.out.println("1: " + e1.getName() + " " + e1.getSalary());
                    System.out.println("2: " + e2.getName() + " " + e2.getSalary());
                    System.out.println("3: " + e3.getName() + " " + e3.getSalary());
                    break;
                case 2:
                    System.out.println("_____________Recreate Employee____________");
                    System.out.println("Which employee? 1 2 or 3:");
                    int which = input.nextInt();
                    input.nextLine();//this is so you can put the string in.
                    System.out.println("Please enter a name for the employee...");
                    enterName = input.nextLine();
                    System.out.println("Please enter a salary for the employee...");
                    enterSalary = input.nextDouble();
                    //LIAM APPROVED
                    if (which == 1) {
                        e1.changeName(enterName);
                        e1.raiseSalary(enterSalary);
                    }
                    if (which == 2) {
                        e2.changeName(enterName);
                        e2.raiseSalary(enterSalary);
                    }
                    if (which == 3) {
                        e3.changeName(enterName);
                        e3.raiseSalary(enterSalary);
                    }
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    System.out.println("Employee " + which + " Updated");
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    break;
                case 3:
                    System.out.println("$$$$$$$$$$$ Give Employee Raise $$$$$$$$$$$");
                    System.out.println("Which employee? 1 2 or 3:");
                    int whichOne = input.nextInt();
                    System.out.println("What percentage?");
                    double percent = input.nextDouble();
                    //LIAM APPROVED
                    if (whichOne == 1) {
                        e1.raiseSalary(percent);
                    }
                    if (whichOne == 2) {
                        e2.raiseSalary(percent);
                    }
                    if (whichOne == 3) {
                        e3.raiseSalary(percent);
                    }
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    System.out.println("Employee " + whichOne + " Given Raise");
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

                case 4:
                    break;
                case 5:
                    System.exit(0);
            }
            if (choice == 4) {
                break;
            }
        }
    }

    public void employeeModuleWithMods() {
        DecimalFormat df = new DecimalFormat("###,###,###");
        //Declare some Employees
        Employee e1 = new Employee();
        Employee e2 = new Employee("John Anderson", 52000);
        Employee e3 = new Employee("Steve Wozniak", 60000);
        while (true) {
            System.out.print("\t\t" + ul);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________");
            System.out.println(ur);
            System.out.println("\t\t" + side + "  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% " + side);
            System.out.println("\t\t" + side + "  %       E M P L O Y E E     M E N U  % " + side);
            System.out.println("\t\t" + side + "  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% " + side);
            //
            //Num Employees Stuff
            //
            //FINISH in ASSIGN 8

//            for (int i = 0; i < 41; i++) {
//                System.out.print(top);
//            }
            //_________________________________________
//            System.out.println(sideRL);
            System.out.println("\t\t" + side + "        1 = Display Employees            " + side);
            System.out.println("\t\t" + side + "        2 = Recreate one Employee        " + side);
            System.out.println("\t\t" + side + "        3 = Give Raise                   " + side);
            System.out.println("\t\t" + side + "        4 = Exit to Main                 " + side);
            System.out.println("\t\t" + side + "        5 = Exit Program                 " + side);
            System.out.println("\t\t" + side + "                                         " + side);
            System.out.print("\t\t" + bl);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //+"_________________________________________
            System.out.println(br);
            System.out.println("\t\tYour Selection?");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("_____________Display Employees____________");
                    System.out.println("");
                    System.out.println("Employee 1:");
                    System.out.println(e1.toString(e1.getName(), e1.getSalary()));
                    System.out.println("");
                    System.out.println("Employee 2:");
                    System.out.println(e2.toString(e2.getName(), e2.getSalary()));
                    System.out.println("");
                    System.out.println("Employee 3");
                    System.out.println(e3.toString(e3.getName(), e3.getSalary()));
                    System.out.println("");
                    System.out.println("Total number of employees");
                    System.out.println(e1.getNumEmployeesEver());
                    System.out.println("");
                    System.out.println("Sum of Salaries (in US Dollars)");
                    System.out.println(e1.getSalary() + e2.getSalary() + e3.getSalary());
                    break;
                case 2:
                    System.out.println("_____________Recreate Employee____________");
                    System.out.println("Which employee? 1 2 or 3:");
                    int which = input.nextInt();
                    input.nextLine();//this is so you can put the string in.
                    System.out.println("Please enter a name for the employee...");
                    enterName = input.nextLine();
                    System.out.println("Please enter a salary for the employee...");
                    enterSalary = input.nextDouble();
                    //LIAM APPROVED
                    if (which == 1) {
                        e1.changeName(enterName);
                        e1.changeSalary(enterSalary);
                    }
                    if (which == 2) {
                        e2.changeName(enterName);
                        e2.changeSalary(enterSalary);
                    }
                    if (which == 3) {
                        e3.changeName(enterName);
                        e3.changeSalary(enterSalary);
                    }
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    System.out.println("Employee " + which + " Updated");
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    break;
                case 3:
                    System.out.println("$$$$$$$$$$$ Give Employee Raise $$$$$$$$$$$");
                    System.out.println("Which employee? 1 2 or 3:");
                    int whichOne = input.nextInt();
                    System.out.println("What percentage?");
                    double percent = input.nextDouble();
                    //LIAM APPROVED
                    if (whichOne == 1) {
                        e1.raiseSalary(percent);
                    }
                    if (whichOne == 2) {
                        e2.raiseSalary(percent);
                    }
                    if (whichOne == 3) {
                        e3.raiseSalary(percent);
                    }
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    System.out.println("Employee " + whichOne + " Given Raise");
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

                case 4:
                    break;
                case 5:
                    System.exit(0);
            }
            if (choice == 4) {
                break;
            }
        }
    }

    //____________________________________________________________________________________
    //CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*
    //CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*
    //CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*
    //  C A R  E X A M P L E
    //CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*
    //CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*
    //CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*
    //____________________________________________________________________________________
    public void carModule() {
        //Declare some Cars
        Car c1 = new Car();
        Car c2 = new Car(30); //honda accord with 30 mpg
        Car c3 = new Car(60); //Liam's test car )most likely a Prius or something XD
        //FINISH
        while (true) {
            System.out.print("\t\t" + ul);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________");
            System.out.println(ur);
            System.out.println("\t\t" + side + "  ______________________________________ " + side);
            System.out.println("\t\t" + side + "       C A R     M E N U                 " + side);
            System.out.println("\t\t" + side + "  ______________________________________ " + side);

            System.out.print("\t\t" + sideTL);

            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________
            System.out.println(sideRL);
            System.out.println("\t\t" + side + "        1 = Display Cars                 " + side);
            System.out.println("\t\t" + side + "        2 = Recreate one Car             " + side);
            System.out.println("\t\t" + side + "        3 = Fill Up                      " + side);
            System.out.println("\t\t" + side + "        4 = Drive                        " + side);
            System.out.println("\t\t" + side + "        5 = Exit to Main                 " + side);
            System.out.println("\t\t" + side + "        6 = Exit Program                 " + side);
            System.out.println("\t\t" + side + "                                         " + side);
            System.out.print("\t\t" + bl);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //+"_________________________________________
            System.out.println(br);
            System.out.println("\t\tYour Selection?");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("_____________Display Cars____________");
                    System.out.println("Name" + "\t" + "\t" + "\t" + "MPG" + "\t" + "\t" + "Gas In Tank");
                    System.out.println(c1.getName() + "\t" + "\t" + c1.getEfficiency() + "\t" + "\t" + c1.getFuel());
                    System.out.println("----" + "\t" + "\t" + "\t" + "----" + "\t" + "\t" + "---------");
                    //LIAM APPROVED
                    break;
                case 2:
                    System.out.println("_____________Recreate Car____________");
                    System.out.println("Which car? 1 2 or 3:");
                    int which = input.nextInt();
                    input.nextLine();//this is so you can put the string in.
                    System.out.println("Please enter a name for the car...");
                    enterName = input.nextLine();
                    System.out.println("Please enter an efficiency for the car...");
                    enterEfficiency = input.nextDouble();
                    System.out.println("Please enter a starting fuel value for the car. Don't be obnxious...");
                    enterFuel = input.nextDouble();
                    //LIAM APPROVED
                    if (which == 1) {
                        c1.setName(enterName);
                        c1.setEfficiency(enterEfficiency);
                        c1.setFuel(enterFuel);
                    }
                    if (which == 2) {
                        c2.setName(enterName);
                        c2.setEfficiency(enterEfficiency);
                        c2.setFuel(enterFuel);
                    }
                    if (which == 3) {
                        c3.setName(enterName);
                        c3.setEfficiency(enterEfficiency);
                        c3.setFuel(enterFuel);
                    }
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    System.out.println("Car " + which + " Updated");
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    break;
                case 3:
                    System.out.println("_____________Fill Up____________");
                    System.out.println("Which car? 1 2 or 3:");
                    int whichOne = input.nextInt();
                    System.out.println("How many gallons?");
                    double gallons = input.nextDouble();
                    //LIAM APPROVED
                    if (whichOne == 1) {
                        c1.addGas(gallons);
                    }
                    if (whichOne == 2) {
                        c2.addGas(gallons);
                    }
                    if (whichOne == 3) {
                        c3.addGas(gallons);
                    }
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    System.out.println("Car " + whichOne + " Added " + gallons + " gallons!");
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    break;
                case 4:
                    System.out.println("Which car? 1 2 or 3:");
                    int wh = input.nextInt();
                    System.out.println("How many miles will it go?");
                    double miles = input.nextDouble();
                    //LIAM APPROVED
                    if (wh == 1) {
                        c1.drive(miles);
                    }
                    if (wh == 2) {
                        c2.drive(miles);
                    }
                    if (wh == 3) {
                        c3.drive(miles);
                    }
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    System.out.println("Car " + wh + " Drove " + miles + " Miles");
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    break;
                case 5:
                    break;
                case 6:
                    System.exit(0);
            }
            if (choice == 5) {
                break;
            }
        }
    }

    public void carModuleWithMods() {
        //Declare some Cars
        Car c1 = new Car();
        Car c2 = new Car(30, "Honda Accord");
        Car c3 = new Car(60);
        //FINISH
        while (true) {
            System.out.print("\t\t" + ul);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________");
            System.out.println(ur);
            System.out.println("\t\t" + side + "  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ " + side);
            System.out.println("\t\t" + side + "    C A R  M E N U  W I T H  M O D S     " + side);
            System.out.println("\t\t" + side + "  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ " + side);
            //FINISH

//            for (int i = 0; i < 41; i++) {
//                System.out.print(top);
//            }
//            //_________________________________________
//            System.out.println(sideRL);
            System.out.println("\t\t" + side + "        1 = Display Cars                 " + side);
            System.out.println("\t\t" + side + "        2 = Recreate one Car             " + side);
            System.out.println("\t\t" + side + "        3 = Fill Up                      " + side);
            System.out.println("\t\t" + side + "        4 = Drive                        " + side);
            System.out.println("\t\t" + side + "        5 = Exit to Main                 " + side);
            System.out.println("\t\t" + side + "        6 = Exit Program                 " + side);
            System.out.println("\t\t" + side + "                                         " + side);
            System.out.print("\t\t" + bl);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //+"_________________________________________
            System.out.println(br);
            System.out.println("\t\tYour Selection?");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("_____________Display Cars____________");
                    System.out.println("Name" + "\t" + "\t" + "\t" + "MPG" + "\t" + "\t" + "Gas In Tank");
                    System.out.println("----" + "\t" + "\t" + "\t" + "---" + "\t" + "\t" + "---------");
                    System.out.println("Car 1");
                    System.out.println(c1.toString(c1.getName(), c1.getEfficiency(), c1.getFuel()));
                    System.out.println("");
                    System.out.println("Car 2");
                    System.out.println(c2.toString(c2.getName(), c2.getEfficiency(), c2.getFuel()));
                    System.out.println("");
                    System.out.println("Car 3");
                    System.out.println(c3.toString(c3.getName(), c3.getEfficiency(), c3.getFuel()));
                    System.out.println("");
                    System.out.println("Total Miles Driven:");
                    System.out.println(c1.getMilesDriven());
                    break;
                case 2:
                    System.out.println("_____________Recreate Car____________");
                    System.out.println("Which car? 1 2 or 3:");
                    int which = input.nextInt();
                    input.nextLine();//this is so you can put the string in.
                    System.out.println("Please enter a name for the car...");
                    enterName = input.nextLine();
                    System.out.println("Please enter an efficiency for the car...");
                    enterEfficiency = input.nextDouble();
                    System.out.println("Please enter a starting fuel value for the car. Don't be obnxious...");
                    enterFuel = input.nextDouble();
                    //LIAM APPROVED
                    if (which == 1) {
                        c1.setName(enterName);
                        c1.setEfficiency(enterEfficiency);
                        c1.setFuel(enterFuel);
                    }
                    if (which == 2) {
                        c2.setName(enterName);
                        c2.setEfficiency(enterEfficiency);
                        c2.setFuel(enterFuel);
                    }
                    if (which == 3) {
                        c3.setName(enterName);
                        c3.setEfficiency(enterEfficiency);
                        c3.setFuel(enterFuel);
                    }
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    // System.out.println("Car " + which + " Updated");
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    break;
                case 3:
                    System.out.println("_____________Fill Up____________");
                    System.out.println("Which car? 1 2 or 3:");
                    int whichOne = input.nextInt();
                    System.out.println("How many gallons?");
                    double gallons = input.nextDouble();
                    //LIAM APPROVED
                    if (whichOne == 1) {
                        c1.addGas(gallons);
                    }
                    if (whichOne == 2) {
                        c2.addGas(gallons);
                    }
                    if (whichOne == 3) {
                        c3.addGas(gallons);
                    }
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    System.out.println("Car " + whichOne + " Added " + gallons + " gallons!");
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    break;
                case 4:
                    System.out.println("Which car? 1 2 or 3:");
                    int wh = input.nextInt();
                    System.out.println("How many miles will it go?");
                    double miles = input.nextDouble();
                    //LIAM APPROVED
                    if (wh == 1) {
                        c1.drive(miles);
                    }
                    if (wh == 2) {
                        c2.drive(miles);
                    }
                    if (wh == 3) {
                        c3.drive(miles);
                    }
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    System.out.println("Car " + wh + " Drove " + miles + " Miles");
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    break;
                case 5:
                    break;
                case 6:
                    System.exit(0);
            }
            if (choice == 5) {
                break;
            }
        }
    }

    //____________________________________________________________________________________
    //STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*
    //STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*
    //STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*
    //  S T U D E N T    E X A M P L E
    //STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*
    //STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*
    //STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*
    //____________________________________________________________________________________
    public void studentModule() {

        DecimalFormat df = new DecimalFormat("###,###,###");
        Student s1 = new Student("Liam McMahan");
        Student s2 = new Student("Adam Dolezel");
        Student s3 = new Student("Jack Nelson");
        //FINISH
        char menuBox = '\u2660';
        while (true) {
            System.out.print("\t\t" + ul);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________");
            System.out.println(ur);
            System.out.print("\t\t" + side + "  ");
            for (int i = 0; i < 38; i++) {
                System.out.print(menuBox);
            }
            System.out.println(" " + side);
            System.out.println("\t\t" + side + "    S T U D E N T     M E N U            " + side);
            System.out.print("\t\t" + side + "  ");
            for (int i = 0; i < 38; i++) {
                System.out.print(menuBox);
            }
            System.out.println(" " + side);
            System.out.print("\t\t" + sideTL);

            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________
            System.out.println(sideRL);
            System.out.println("\t\t" + side + "        1 = Display Students             " + side);
            System.out.println("\t\t" + side + "        2 = Recreate one Student         " + side);
            System.out.println("\t\t" + side + "        3 = Add Quiz Grade               " + side);
            System.out.println("\t\t" + side + "        4 = Clear Grades                 " + side);
            System.out.println("\t\t" + side + "        5 = Exit to Main                 " + side);
            System.out.println("\t\t" + side + "        6 = Exit Program                 " + side);
            System.out.println("\t\t" + side + "                                         " + side);
            System.out.print("\t\t" + bl);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            System.out.println(br);
            System.out.println("\t\tYour Selection?");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < 50; i++) {
                        if (i % 2 == 0) {
                            System.out.print("\u263A");
                        } else {
                            System.out.print("\u263B");
                        }
                    }
                    System.out.println("");

                    System.out.println("             Display Students");
                    for (int i = 0; i < 50; i++) {
                        if (i % 2 == 0) {
                            System.out.print("\u263A");
                        } else {
                            System.out.print("\u263B");
                        }
                    }
                    System.out.println("");
                    System.out.println("Name\t\t\tQuizzes\t\tAverage");
                    System.out.println("----\t\t\t----\t\t---------");
                    System.out.println(s1.getName() + "\t" + "\t" + s1.getQuizes() + "\t" + "\t" + s1.getAverage());
                    System.out.println(s2.getName() + "\t" + "\t" + s2.getQuizes() + "\t" + "\t" + s2.getAverage());
                    System.out.println(s3.getName() + "\t" + "\t" + s3.getQuizes() + "\t" + "\t" + s3.getAverage());
                    for (int i = 0; i < 50; i++) {
                        if (i % 2 == 0) {
                            System.out.print("\u263A");
                        } else {
                            System.out.print("\u263B");
                        }
                    }
                    System.out.println("");
                    break;
                case 2:
                    for (int i = 0; i < 45; i++) {

                        System.out.print("\u2206");

                    }
                    System.out.println("");
                    System.out.println("_____________Recreate Student____________");
                    System.out.println("Which student? 1 2 or 3:");
                    int which = input.nextInt();
                    input.nextLine();//this is so you can put the string in.
                    System.out.println("Please enter a name for the student...");
                    enterName = input.nextLine();
                    System.out.println("How many quizes have they taken? ...");
                    enterNumQuizes = input.nextInt();
                    System.out.println("Please enter sum of quiz scores");
                    enterQuizSum = input.nextDouble();
                    //LIAM APPROVED
                    if (which == 1) {
                        s1.setName(enterName);//give name
                        s1.setNumQuizes(enterNumQuizes);//give number of quizes
                        s1.setQuizSum(enterQuizSum);//give the total number of quizes
                        s1.initAverage(enterNumQuizes);//gets the average first
                    }
                    if (which == 2) {
                        s2.setName(enterName);//give name
                        s2.setNumQuizes(enterNumQuizes);//give number of quizes
                        s2.setQuizSum(enterQuizSum);//give the total number of quizes
                        s2.initAverage(enterNumQuizes);//gets the average first
                    }
                    if (which == 3) {
                        s3.setName(enterName);//give name
                        s3.setNumQuizes(enterNumQuizes);//give number of quizes
                        s3.setQuizSum(enterQuizSum);//give the total number of quizes
                        s3.initAverage(enterNumQuizes);//gets the average first

                    }
                    System.out.println("((((((((((((()))))))))))))))))");
                    System.out.println("Student " + which + " Updated");
                    System.out.println("((((((((((((()))))))))))))))))");
                    break;
                case 3:
                    System.out.println("%^%^%^%^%^ Add Quiz %^%^%^%^%^");
                    System.out.println("Which student? 1 2 or 3:");
                    int whichOne = input.nextInt();
                    System.out.println("Enter Quiz Grade");
                    int score = input.nextInt();
                    //LIAM APPROVED
                    if (whichOne == 1) {
                        s1.addQuiz(score);
                        s1.refreshAverage();//updates average
                    }
                    if (whichOne == 2) {
                        s2.addQuiz(score);
                        s2.refreshAverage();//updates average
                    }
                    if (whichOne == 3) {
                        s3.addQuiz(score);
                        s3.refreshAverage();//updates average
                    }
                    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
                    System.out.println("Student " + whichOne + " added quiz");
                    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
                    break;
                case 4:
                    System.out.println("============Clear Student===========");
                    System.out.println("Which student? 1 2 or 3:");
                    int whichStu = input.nextInt();
                    //LIAM APPROVED
                    if (whichStu == 1) {
                        s1.clearData();
                    }
                    if (whichStu == 2) {
                        s2.clearData();
                    }
                    if (whichStu == 3) {
                        s3.clearData();
                    }
                    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
                    System.out.println("Student " + whichStu + " cleared");
                    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
                    break;

                case 6:
                    System.exit(0);
            }
            if (choice == 5) {
                break;
            }
        }
    }

    public void studentModuleWithMods() {
        DecimalFormat df = new DecimalFormat("###,###,###");
        Student s1 = new Student("Liam McMahan");
        Student s2 = new Student("Adam Dolezel");
        Student s3 = new Student("Jack Nelson");
        //FINISH
        char menuBox = '\u2660';

        while (true) {
            System.out.print("\t\t" + ul);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________");
            System.out.println(ur);
            System.out.print("\t\t" + side + "  ");
            for (int i = 0; i < 38; i++) {
                System.out.print(menuBox);
            }
            System.out.println(" " + side);
            System.out.println("\t\t" + side + "    S T U D E N T     M E N U            " + side);
            System.out.print("\t\t" + side + "  ");
            for (int i = 0; i < 38; i++) {
                System.out.print(menuBox);
            }
            System.out.println(" " + side);
            System.out.println("\t\t" + sideTL);

//            for (int i = 0; i < 41; i++) {
//                System.out.print(top);
//            }
//            //_________________________________________
//            System.out.println(sideRL);
            System.out.println("\t\t" + side + "        1 = Display Students             " + side);
            System.out.println("\t\t" + side + "        2 = Recreate one Student         " + side);
            System.out.println("\t\t" + side + "        3 = Add Quiz Grade               " + side);
            System.out.println("\t\t" + side + "        4 = Clear Grades                 " + side);
            System.out.println("\t\t" + side + "        5 = Exit to Main                 " + side);
            System.out.println("\t\t" + side + "        6 = Exit Program                 " + side);
            System.out.println("\t\t" + side + "                                         " + side);
            System.out.print("\t\t" + bl);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            System.out.println(br);
            System.out.println("\t\tYour Selection?");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < 50; i++) {
                        if (i % 2 == 0) {
                            System.out.print("\u263A");
                        } else {
                            System.out.print("\u263B");
                        }
                    }
                    System.out.println("");

                    System.out.println("             Display Students");
                    for (int i = 0; i < 50; i++) {
                        if (i % 2 == 0) {
                            System.out.print("\u263A");
                        } else {
                            System.out.print("\u263B");
                        }
                    }
                    System.out.println("");
                    System.out.println("Name\t\t\tQuizzes\t\tAverage");
                    System.out.println("----\t\t\t----\t\t---------");
                    System.out.println("");
                    System.out.println("Student 1");
                    System.out.println(s1.toString(s1.getName(), s1.getQuizes(), s1.getAverage()));
                    System.out.println("");
                    System.out.println("Student 2");
                    System.out.println(s2.toString(s2.getName(), s2.getQuizes(), s2.getAverage()));
                    System.out.println("");
                    System.out.println("Student 3");
                    System.out.println(s3.toString(s3.getName(), s3.getQuizes(), s3.getAverage()));
                    System.out.println("");
                    System.out.println("Total number of quizes:");
                    System.out.println(s1.getQuizes() + s2.getQuizes() + s3.getQuizes());
                    System.out.println("Class Average:");
                    s1.setAverage1(s1.getAverage());
                    s2.setAverage2(s2.getAverage());
                    s3.setAverage3(s3.getAverage());
                    s1.setClassAverage();//the s1 is irrelevant, because the methods uses all three averages
                    for (int i = 0; i < 50; i++) {
                        if (i % 2 == 0) {
                            System.out.print("\u263A");
                        } else {
                            System.out.print("\u263B");
                        }
                    }
                    System.out.println("");
                    break;
                case 2:
                    for (int i = 0; i < 45; i++) {

                        System.out.print("\u2206");

                    }
                    System.out.println("");
                    System.out.println("_____________Recreate Student____________");
                    System.out.println("Which student? 1 2 or 3:");
                    int which = input.nextInt();
                    input.nextLine();//this is so you can put the string in.
                    System.out.println("Please enter a name for the student...");
                    enterName = input.nextLine();
                    System.out.println("How many quizes have they taken? ...");
                    enterNumQuizes = input.nextInt();
                    System.out.println("Please enter sum of quiz scores");
                    enterQuizSum = input.nextDouble();
                    //LIAM APPROVED
                    if (which == 1) {
                        s1.setName(enterName);//give name
                        s1.setNumQuizes(enterNumQuizes);//give number of quizes
                        s1.setQuizSum(enterQuizSum);//give the total number of quizes
                        s1.initAverage(enterNumQuizes);//gets the average first
                    }
                    if (which == 2) {
                        s2.setName(enterName);//give name
                        s2.setNumQuizes(enterNumQuizes);//give number of quizes
                        s2.setQuizSum(enterQuizSum);//give the total number of quizes
                        s2.initAverage(enterNumQuizes);//gets the average first
                    }
                    if (which == 3) {
                        s3.setName(enterName);//give name
                        s3.setNumQuizes(enterNumQuizes);//give number of quizes
                        s3.setQuizSum(enterQuizSum);//give the total number of quizes
                        s3.initAverage(enterNumQuizes);//gets the average first

                    }
                    System.out.println("((((((((((((()))))))))))))))))");
                    System.out.println("Student " + which + " Updated");
                    System.out.println("((((((((((((()))))))))))))))))");
                    break;
                case 3:
                    System.out.println("%^%^%^%^%^ Add Quiz %^%^%^%^%^");
                    System.out.println("Which student? 1 2 or 3:");
                    int whichOne = input.nextInt();
                    System.out.println("Enter Quiz Grade");
                    int score = input.nextInt();
                    //LIAM APPROVED
                    if (whichOne == 1) {
                        s1.addQuiz(score);
                        s1.refreshAverage();//updates average
                    }
                    if (whichOne == 2) {
                        s2.addQuiz(score);
                        s2.refreshAverage();//updates average
                    }
                    if (whichOne == 3) {
                        s3.addQuiz(score);
                        s3.refreshAverage();//updates average
                    }
                    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
                    System.out.println("Student " + whichOne + " added quiz");
                    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
                    break;
                case 4:
                    System.out.println("============Clear Student===========");
                    System.out.println("Which student? 1 2 or 3:");
                    int whichStu = input.nextInt();
                    //LIAM APPROVED
                    if (whichStu == 1) {
                        s1.clearData();
                    }
                    if (whichStu == 2) {
                        s2.clearData();
                    }
                    if (whichStu == 3) {
                        s3.clearData();
                    }
                    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
                    System.out.println("Student " + whichStu + " cleared");
                    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}
