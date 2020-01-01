import java.text.DecimalFormat;
//Student Class

/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
//Java Class
public class Student {
//--------------------------------------------------------------//
//------------------------ V A R I A B L E S -------------------//
//--------------------------------------------------------------//

    public static double a1=0;//student one average
    public static double a2=0;//student two average
    public static double a3=0;//student three average
    public static double classAverage=0;//average of all three
    private String name;
    private double average;
    private double quizSum = 0;//sum of quiz grades
    private int numQuizes = 0;//number of quizes taken

//////////////////////////////////////////////////////////////////
////////////////// C O N S T R U C T O R S ///////////////////////
//////////////////////////////////////////////////////////////////
    public Student(String aName) {
        name = aName;
        quizSum = 0;
        average = 0;
    }

//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
//AAAAAAAAAAAAAAA A C C E S S O R S AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    public String getName() {
        return name; //gets name
    }

    public double getAverage() {
        return average;
    }

    public int getQuizes() {
        return numQuizes;
    }

    public double getQuizSum() {
        return quizSum;
    }
    
    public String toString(String n, int q, double a){
        return n + "\t" + "\t" + q + "\t" + "\t" + a;
    }
    public double getClassAverage(){
        return classAverage;
    }

//MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
//MMMMMMMMMMMMMMM M U T A T O R S MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
//MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    public void clearData() {
        average = 0;
        numQuizes = 0;
        quizSum = 0;
    }
    public void setAverage1(double newAverage){
        a1=newAverage;
    }
    public void setAverage2(double newAverage){
        a2=newAverage;
    }
    public void setAverage3(double newAverage){
        a3=newAverage;
    }
    public void setClassAverage(){
        classAverage=(a1+a2+a3)/3;
        round(classAverage);
    }

    public void setName(String newName) {
        name = newName;
    }

    public void addQuiz(double newQuiz) {
        quizSum += newQuiz;//creates a new ARRAY
        numQuizes++;
    }

    public void refreshAverage() {
        average = quizSum / numQuizes;
        round(average);
    }

    public void initAverage(double aNumQuizes) {
        average = quizSum / aNumQuizes;
    }

    public void setNumQuizes(int aNumQuizes) throws IllegalArgumentException {
        if (aNumQuizes > 0) {
            numQuizes = aNumQuizes;
        } else {
            throw new IllegalArgumentException("CAN'T HAVE A NEGATIVE AMOUNT OF QUIZES!");
        } 
    }

    public void setQuizSum(double aQuizSum) {
        quizSum = aQuizSum;
    }

    public void round(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.0");
        System.out.println(decimalFormat.format(d));
    }
}
