
/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                  Sauce Code: 17                    #
 *#                                                    #
 *######################################################
 */
public class SummitDont extends Character {

    //special wariables
    public int mp;
    public int maxMp;

    //gets regular wariables
    public SummitDont(String aName, int anHp, int aMaxHp, int anX, int aY, int anMp, int aMaxMp) {
        super(aName, anHp, aMaxHp, anX, aY);
        mp = anMp;
        maxMp = aMaxMp;
        
        //put character file here and then refer to it in the intro part of the main!
        file="";
    }

    //paralyze
    @Override
    public void action() {
        //enemy within two spaces is healed
        if (hp > 0 && mp > 2) {
            if (Math.abs(Game.Spooker.x - x) < 3//within 2 horizontal spaces
                    && Math.abs(Game.Spooker.y - y) < 3) {//within 2 vertical spaces
                if (Game.Spooker.hp > 0) {
                    Game.Spooker.hp = Game.Spooker.maxHp;
                    mp -= 2;
                    System.out.println("Summit Don't healed Slime guy!");
                } else if (Math.abs(Game.Mallard.x - x) < 3//within 2 horizontal spaces
                        && Math.abs(Game.Mallard.y - y) < 3) {//within 2 vertical spaces
                    if (Game.Mallard.hp > 0) {
                        Game.Mallard.hp = Game.Mallard.maxHp;
                        mp -= 2;
                        System.out.println("Summit Don't healed Mr. Mallard!");
                    }
                }
            }
        }
    }
}
