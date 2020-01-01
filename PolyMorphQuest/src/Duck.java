/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                  Sauce Code: 17                    #
 *#                                                    #
 *######################################################
 */
public class Duck extends Character {

    //trap power
    public int tp; //tp is how many times he can poison
    public int maxTp;

    //gets regular wariables
    public Duck (String aName, int anHp, int aMaxHp, int anX, int aY, int aTp, int aMaxTp) {
        super(aName, anHp, aMaxHp, anX, aY);
        tp = aTp;
        maxTp = aMaxTp;
        
        //put character file here and then refer to it in the intro part of the main!
        file="";
    }

    @Override
    public void action() {
        //poison hero for three turns!
        if (hp > 0 && tp > 0) {
            //poison the samurai
            if (Math.abs(Game.Jintoku.x - x) < 3//within 2 horizontal spaces
                    && Math.abs(Game.Jintoku.y - y) < 3) {//within 2 horizontal spaces
                if (Game.Jintoku.hp > 0) {
                    Game.Jintoku.isPoisoned = true;
                    System.out.println("Mr. Mallard poisoned Samurai Jintoku!");
                    tp--;
                    //if he's out for the count
                    if (Game.Jintoku.hp <= 0) {
                        System.out.println("Samurai Jintoku is down for the count!");
                    }
                }
            } //poison the chef
            else if (Math.abs(Game.Sakura.x - x) < 3//within 2 horizontal spaces
                    && Math.abs(Game.Sakura.y - y) < 3) {//within 2 horizontal spaces
                if (Game.Sakura.hp > 0) {
                    Game.Sakura.isPoisoned = true;
                    System.out.println("Mr. Mallard poisoned the Master Sakura!");
                    tp--;
                    //if he's out for the count
                    if (Game.Sakura.hp <= 0) {
                        System.out.println("Master Sakura is down for the count!");
                    }
                }
            } //poison the monk
            else if (Math.abs(Game.Cam.x - x) < 3//within 2 horizontal spaces
                    && Math.abs(Game.Cam.y - y) < 3) {//within 2 horizontal spaces
                if (Game.Cam.hp > 0) {
                    Game.Cam.isPoisoned = true;
                    System.out.println("Mr. Mallard poisoned Cam the Monk!");
                    tp--;
                    //if he's out for the count
                    if (Game.Cam.hp <= 0) {
                        System.out.println("Cam the Monk is down for the count!");
                    }
                }
            }
        }
    }
}
