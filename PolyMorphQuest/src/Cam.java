/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                  Sauce Code: 17                    #
 *#                                                    #
 *######################################################
 */
public class Cam extends Character {

    //special wariables
    public int mp; //value of hp reduction of opponent (left to a single number for simplicity)
    public int maxMp;
    //gets regular wariables and an attack power

    public Cam(String aName, int anHp, int aMaxHp, int anX, int aY, int anMp, int aMaxMp) {
        super(aName, anHp, aMaxHp, anX, aY);
        mp = anMp;
        maxMp = aMaxMp;
        
        //put character file here and then refer to it in the intro part of the main!
        file="";
    }

    //paralyze
    @Override
    public void action() {
        //other character is paralyzed for one turn
        if (hp > 0 && mp > 2) {
            //freeze the slime
            if (Math.abs(Game.Spooker.x - x) < 3//within 3 horizontal spaces
                    && Math.abs(Game.Spooker.y - y) < 3) {//within 3 vertical spaces
                if (Game.Spooker.hp > 0) {
                    Game.Spooker.isParalyzed = true;
                    mp -= 2;
                    System.out.println("Cam used a stasis sutra on Slime guy!");
                }
            }

            //freeze the trickster
            if (Math.abs(Game.Mallard.x - x) < 3//within 3 horizontal spaces
                    && Math.abs(Game.Mallard.y - y) < 3) {//within 3 vertical spaces
                if (Game.Mallard.hp > 0) {
                    Game.Mallard.isParalyzed = true;
                    mp -= 2;
                    System.out.println("Cam used a stasis sutra on Mr. Mallard!");
                }
            }

            //freeze the sentient soda
            if (Math.abs(Game.Soda.x - x) < 3//within 3 horizontal spaces
                    && Math.abs(Game.Soda.y - y) < 3) {//within 3 vertical spaces
                if (Game.Soda.hp > 0) {
                    Game.Soda.isParalyzed = true;
                    mp -= 2;
                    System.out.println("Cam used a stasis sutra on Summit Don't!");
                }
            }
        }
    }
}
