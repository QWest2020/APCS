//game.java

/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
import java.util.Comparator;
public class Game implements Comparable<Game>{
//--------------------------------------------------------------//
//------------------------ V A R I A B L E S -------------------//
//--------------------------------------------------------------//

    public String name;
    public String ageRating; //1=c, 2=e, 3=E10+,etc. make note of this when you run it
    public String genre; // 
    public int debutYear;
    public double price;
//////////////////////////////////////////////////////////////////
////////////////// C O N S T R U C T O R S ///////////////////////
//////////////////////////////////////////////////////////////////

    public Game(String aName, String anAgeRating, String aGenre, double aPrice, int aDebutYear) {
        name = aName;
        ageRating = anAgeRating;
        genre = aGenre;
        price = aPrice;
        debutYear = aDebutYear; //not on leaderboard
    }

    public Game(String aName) {
        name = aName;
        ageRating = "E";
        genre = "Fun"; // :)
        debutYear = 0; //no debut year speicified
        price = 60.00; //full price scrub
    }
//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
//AAAAAAAAAAAAAAA A C C E S S O R S AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

    public String getName() {
        return name;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public String getGenre() {
        return genre;
    }

    public int getDebutYear() {
        return debutYear;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() { //work on the format here
        return String.format("%-40s", name) + String.format("%-16s", ageRating) + String.format("%-24s", genre) + String.format("%-8.2f", price) + String.format("%-4d", debutYear);
    }

    public String toSaveString() { //work on the format here
        String filler = "|";
        return name + filler + ageRating + filler + genre + filler + price + filler + debutYear;
    }
    //CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC
    //CCCCCCCCCCCCCCCCCCC C O M P A R E S CCCCCCCCCCCCCCCCCCCCCCCCCCCCC
    //CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC

    public int compareTo(Game compareGame) {
        int comparePrice = (int) ((Game) compareGame).getPrice();
        return (int) (this.price - comparePrice);
    }
    public static Comparator<Game> GamePriceComparator = new Comparator<Game>() {
        public int compare(Game g1, Game g2) {
            double g1Price = g1.getPrice();
            double g2Price = g2.getPrice();
            return (int) (g1Price-g2Price);
        }
    };
}


