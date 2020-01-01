/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                  Sauce Code: 17                    #
 *#                                                    #
 *######################################################
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;

public class house extends JFrame {

    public house() {
        //Set JFrame title  
        super("Draw A House In JFrame");

        //Set default close operation for JFrame  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set JFrame size  
        setSize(1750, 1000);

        //Make JFrame visible   
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int xShift = 0, yShift = 0, rowSpace = 0, initXOffset = 50, initYOffset = 70; //starts 50 units right and 10 units down
        double scale = 1;

        for (int i = 0; i < 10; i++) { //draw 10 houses

            //wariables to shorten terms
            int houseX=initXOffset + xShift;//the X point at which the house begins in the iteration
            int houseY=initYOffset + yShift;//the Y point at which the house begins in the iteration
            int doorWidth = (int) (10 * scale);
            int doorHeight = (int) (25 * scale);
            int houseWidth = (int) (100 * scale);
            int houseHeight = (int) (50 * scale);
            int midpointX=(houseX+(houseX+houseWidth))/2;
            int roofHeightCheat=(int) (houseY-(2*(doorHeight/3))); //:)

            //drawing!
            //draw the base
            drawBase(g,
                    houseX,
                    houseY,
                    (int) (100 * scale),
                    (int) (50 * scale));
            
            //draw the chimeny!
            drawChimeny(g, 
                    houseX+(houseWidth/8),
                    houseY-doorHeight,
                    doorWidth, doorHeight);
            
            //draw the roof!
            drawRoof(g,
                    houseX,houseY,
                    houseX+houseWidth,houseY,
                    midpointX,roofHeightCheat);
            
            //draw the windows!
            drawWindows(g,
                    (houseWidth/8)+houseX,
                    (houseWidth-(6*(houseWidth/16)))+houseX,
                    (houseHeight/2)+houseY,
                    doorHeight,
                    doorWidth);
            
            //draw the door!
            drawDoor(g, 
                    (houseWidth / 2) + houseX - 5,
                    houseHeight - doorHeight + houseY,
                    doorWidth, doorHeight);
            
            //draw the doorknob!
            drawKnob(g,
                    (houseWidth / 2) + houseX - 10 + (doorWidth),
                    houseHeight - doorHeight + houseY + (doorHeight / 2),
                    4);

            //update horizontal shift and scale
            xShift += (150 * scale);
            scale += .28; //YOU CAN CHANGE THIS WITHOUT WORRY!!! :)

            //update rows
            if (i == 3 || i == 6) {
                xShift = 0;
                yShift += 175 + rowSpace;//shifts down to the next "row"
                rowSpace += 75;//accomodates for the space between rows
            }
        }

    }

    public static void main(String[] args) {
        house daCrib = new house();
    }

    public static void drawBase(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);  // House base
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);  // House outline
    }

    public static void drawRoof(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3) {
        Polygon poly = new Polygon();                // Roof Polygon
        poly.addPoint(x1, y1);
        poly.addPoint(x2, y2);
        poly.addPoint(x3, y3);
        g.setColor(Color.black);
        g.fillPolygon(poly);
    }

    public static void drawWindows(Graphics g, int x1, int x2, int y, int width, int height) {
        g.setColor(Color.yellow);
        g.fillRect(x1,y,width,height);   // Window 1
        g.fillRect(x2,y,width,height);  // Window 2    
    }

    public static void drawDoor(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.blue);
        g.fillRect(x, y, width, height);  // Door
    }

    public static void drawKnob(Graphics g, int x, int y, int diameter) {
        g.setColor(Color.green);
        g.fillOval(x, y, diameter, diameter);    // Door knob
    }
    
    public static void drawChimeny(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.gray);
        g.fillRect(x, y, width, height);  // Chimeny
    }
}
