/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                  Sauce Code: 17                    #
 *#                                                    #
 *######################################################
 */
public class Samurai extends Character {

    //special wariables
    public int ap; //value of hp reduction of opponent (left to a single number for simplicity)
    //gets regular wariables and an attack power

    public Samurai(String aName, int anHp, int aMaxHp, int anX, int aY, int anAp) {
        super(aName, anHp, aMaxHp, anX, aY);
        ap = anAp;
        
        //put character file here and then refer to it in the intro part of the main!
        file="";
    }

    //attack the other character
    @Override
    public void action() {
        if (hp > 0) {
            //attack the slime
            if (Math.abs(Game.Spooker.x - x) < 3//within 2 horizontal spaces
                    && Math.abs(Game.Spooker.y - y) < 3) {//within 2 horizontal spaces
                if (Game.Spooker.hp > 0) {
                    Game.Spooker.hp -= ap;
                    System.out.println("Samurai Jintoku Attacked Slime Guy!");
                    //if he's out for the count
                    if (Game.Spooker.hp <= 0) {
                        System.out.println("Slime guy is down for the count!");
                    }
                }
            } //attack the trickster
            else if (Math.abs(Game.Mallard.x - x) < 3//within 2 horizontal spaces
                    && Math.abs(Game.Mallard.y - y) < 3) {//within 2 horizontal spaces
                if (Game.Mallard.hp > 0) {
                    Game.Mallard.hp -= ap;
                    System.out.println("Samurai Jintoku Attacked Mr. Mallard!");
                    //if he's out for the count
                    if (Game.Mallard.hp <= 0) {
                        System.out.println("Mr. Mallard is down for the count!");
                    }
                }
            } //attack the sentient soda
            else if (Math.abs(Game.Soda.x - x) < 3//within 2 horizontal spaces
                    && Math.abs(Game.Soda.y - y) < 3) {//within 2 horizontal spaces
                if (Game.Soda.hp > 0) {
                    Game.Soda.hp -= ap;
                    System.out.println("Samurai Jintoku Attacked Summit Don't!");
                    //if he's out for the count
                    if (Game.Soda.hp <= 0) {
                        System.out.println("Summit Don't is down for the count!");
                    }
                }
            }
        }
    }
}
