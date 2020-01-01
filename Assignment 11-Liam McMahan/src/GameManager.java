//tester 

/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GameManager {

    public static ArrayList<Game> collection = new ArrayList<>();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Le Game Manager!");
        while (true) {
            System.out.print(prompt());
            int choice = input.nextInt();
            System.out.println("");
            switch (choice - 1) {
                case 0:
                    //read data from save file
                    readData();
                    System.out.println("Data loaded!");
                    break;
                case 1:
                    //display the list
                    display();
                    System.out.println("");
                    break;
                case 2:
                    //sort by name
                    sortByName();
                    break;
                case 3:
                    //sort by price
                    sortByPrice();
                    break;
                case 4:
                    //add a game
                    addGame();
                    break;
                case 5:
                    //edit an existing game
                    editGame();
                    break;
                case 6:
                    //delete a game :(
                    deleteGame();
                    break;
                case 7:
                    //save and archive to text files
                    saveAndArchive();
                    break;
                case 8:
                    //initialize defaults
                    initializeDefaults();
                    break;
                case 9:
                    //close
                    System.out.println("...Thank you for your...INPUT! :) :) :) Get it?");
                    System.exit(0);
                    break;
            }
        }
    }

    public static String prompt() {
        String result = "";
        result += "Please choose an option..." + "\n" + "\n";
        result += "------------------------------------------------" + "\n";
        result += "1) Read Data from Text File" + "\n";
        result += "2) Display the List" + "\n";
        result += "3) Sort by Name" + "\n";
        result += "4) Sort by Price" + "\n";
        result += "5) Add Game :)" + "\n";
        result += "6) Change Game" + "\n";
        result += "7) Delete Game :(" + "\n";
        result += "8) Save and Archive" + "\n";
        result += "9) Initialize Defaults" + "\n";
        result += "10) Close Program" + "\n";
        result += "------------------------------------------------" + "\n";
        return result;
    }

    public static void editGame() {
        //edit item (have them go through all elements)
        System.out.println("Which game you like to alter? (Enter index)");
        int alter = input.nextInt();
        input.nextLine();
        System.out.println("What's the new game called?");
        String newName = input.nextLine();
        input.nextLine();
        System.out.println("What's the age rating? C through M");
        String newAgeRating = input.nextLine();
        input.nextLine();
        System.out.println("What type of game is it?");
        String newGenre = input.nextLine();
        System.out.println("How much was it sold for?");
        double newPrice = input.nextDouble();
        System.out.println("And finally, when did it come out?");
        int newDebutYear = input.nextInt();
        collection.set(alter - 1, new Game(newName, newAgeRating, newGenre, newPrice, newDebutYear));
        System.out.println("Game Changed.");
        System.out.println("");
    }

    public static void addGame() {
        input.nextLine();
        System.out.println("What's the new game called?");
        String newName = input.nextLine();
        System.out.println("What's the age rating? C through M");
        String newAgeRating = input.nextLine();
        System.out.println("What type of game is it?");
        String newGenre = input.nextLine();
        System.out.println("How much was it sold for?");
        double newPrice = input.nextDouble();
        System.out.println("And finally, when did it come out?");
        int newDebutYear = input.nextInt();
        collection.add(new Game(newName, newAgeRating, newGenre, newPrice, newDebutYear));
        System.out.println("Game Added.");
        System.out.println("");
    }

    public static void deleteGame() {
        System.out.println("Which game do you want to...remove   :(");
        int delete = input.nextInt();
        System.out.println("Are you sure you want to do this??? 0=no,1=yes");
        int theCruelChoice = input.nextInt();
        if (theCruelChoice == 1) {
            collection.remove(delete - 1);
            System.out.println("You cruel monster...");
            System.out.println("");
        } else {
            System.out.println("Whew! That was close! :)");
            System.out.println("");
        }
    }

    public static void saveAndArchive() throws IOException {
        //save
        try {
            FileWriter fw = new FileWriter("Collection.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < collection.size(); i++) {
                pw.println(collection.get(i).toSaveString());
            }
            pw.close();
        } catch (IOException ex) {
            System.out.println("Couldn't Save. :(");
        }
        //archive
        try {
            FileWriter fw = new FileWriter("Collection.bak");
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < collection.size(); i++) {
                pw.println(collection.get(i).toString());
            }
            System.out.println("Saved and Archived!");
            pw.close();
        } catch (IOException ex) {
            System.out.println("Couldn't Save. :(");
        }
        System.out.println("");
    }

    public static void readData() throws IOException {
        try {
            BufferedReader input = new BufferedReader(new FileReader("Collection.txt"));
            String line;
            line = input.readLine();
            while (line != null) {
                StringTokenizer st = new StringTokenizer(line, "|");
                String imName = st.nextToken();
                String imAgeRating = st.nextToken();
                String imGenre = st.nextToken();
                double imPrice = Double.parseDouble(st.nextToken());
                int imDebutYear = Integer.parseInt(st.nextToken());
                collection.add(new Game(imName, imAgeRating, imGenre, imPrice, imDebutYear));
                line = input.readLine();
            }
            input.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void display() {
        System.out.println("Name" + "\t" + "\t" + "\t" + "\t" + "\t" + "Age Rating" + "\t" + "Genre" + "\t" + "\t" + "\t" + "Price" + "\t" + "Debut year");
        System.out.println("-------------------------------------------------------------------------------------------------");
        //dsiplay with an array list and a toString
        for (int i = 0; i < collection.size(); i++) {
            System.out.println(collection.get(i).toString());
        }
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    public static void initializeDefaults() {
        collection.add(new Game("Xenoblade Chronicles 2", "T", "JRPG", 59.99, 2017));
        collection.add(new Game("The Legend Of Zelda: Ocarina Of Time", "E", "Adventure", 49.99, 1998));
        collection.add(new Game("Undertale", "T", "Indie RPG", 9.99, 2015));
        collection.add(new Game("Pikmin 2", "E", "Real Time Strategy", 49.99, 2004));
        collection.add(new Game("Celeste", "T", "Indie Platformer", 19.99, 2018));
        System.out.println("Initialized!");
        System.out.println("");
    }

    public static void sortByName() {
        Collections.sort(collection);
        System.out.println("Sorted By Name!");
    }

    public static void sortByPrice() {
        Collections.sort(collection, Game.GamePriceComparator);
        System.out.println("Sorted By Price!");
    }
}
