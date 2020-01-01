/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                  Sauce Code: 17                    #
 *#                                                    #
 *######################################################
 */
public class Ghost extends Character {

    //special wariables
    public int ap;

    //gets regular wariables
    public Ghost(String aName, int anHp, int aMaxHp, int anX, int aY, int anAp) {
        super(aName, anHp, aMaxHp, anX, aY);
        ap = anAp;
        
        //put character file here and then refer to it in the intro part of the main!
        file="";
    }

    //paralyze
    @Override
    public void action() {
        //other character is paralyzed and damaged for one turn
        if (hp > 0) {
            //attack the samurai
            if (Math.abs(Game.Jintoku.x - x) < 2//within 1 horizontal space
                    && Math.abs(Game.Jintoku.y - y) < 2) {//within 1 vertical space
                if (Game.Jintoku.hp > 0) {
                    Game.Jintoku.hp -= ap;
                    Game.Jintoku.isParalyzed = true;
                    System.out.println("Slime Guy attacked and paralyzed Samurai Jintoku!");
                    //if he's out for the count
                    if (Game.Jintoku.hp <= 0) {
                        System.out.println("Samurai Jintoku is down for the count!");
                    }
                }
            } //attack the chef
            else if (Math.abs(Game.Sakura.x - x) < 2//within 1 horizontal space
                    && Math.abs(Game.Sakura.y - y) < 2) {//within 1 vertical space
                if (Game.Jintoku.hp > 0) {
                    Game.Sakura.hp -= ap;
                    Game.Sakura.isParalyzed = true;
                    System.out.println("Slime Guy attacked and paralyzed the Master Sakura!");
                    //if he's out for the count
                    if (Game.Sakura.hp <= 0) {
                        System.out.println("Master Sakura is down for the count!");
                    }
                } //attack the monk
                else if (Math.abs(Game.Cam.x - x) < 2//within 1 horizontal space
                        && Math.abs(Game.Cam.y - y) < 2) {//within 1 vertical space
                    if (Game.Cam.hp > 0) {
                        Game.Cam.hp -= ap;
                        Game.Cam.isParalyzed = true;
                        System.out.println("Slime Guy attacked and paralyzed Cam the monk!");
                        //if he's out for the count
                        if (Game.Cam.hp <= 0) {
                            System.out.println("Cam the Monk is down for the count!");
                        }
                    }
                }
            }
        }
    }
}