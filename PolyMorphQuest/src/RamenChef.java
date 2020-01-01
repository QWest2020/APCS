/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                  Sauce Code: 17                    #
 *#                                                    #
 *######################################################
 */
public class RamenChef extends Character {

    //special wariables
    public int mp; //value of hp reduction of opponent (left to a single number for simplicity)
    public int maxMp;
    //gets regular wariables and an attack power

    public RamenChef(String aName, int anHp, int aMaxHp, int anX, int aY, int anMp, int aMaxMp) {
        super(aName, anHp, aMaxHp, anX, aY);
        mp = anMp;
        maxMp = aMaxMp;
        
        //put character file here and then refer to it in the intro part of the main!
        file="";
    }

    //heal a team member
    @Override
    public void action() {
        //heal adjacent heroes
        if (hp > 0 && mp > 2) {
            if (Math.abs(Game.Jintoku.x - x) < 2//within 1 horizontal space
                    && Math.abs(Game.Jintoku.y - y) < 2) {//within 1 vertical space
                if (Game.Jintoku.hp > 0) {
                    Game.Jintoku.hp = Game.Jintoku.maxHp;
                    mp -= 2;
                    System.out.println("Sakura healed Samurai Jintoku!");
                }
            } else if (Math.abs(Game.Cam.x - x) < 2//within 1 horizontal space
                    && Math.abs(Game.Cam.y - y) < 2) {//within 1 vertical space
                if (Game.Cam.hp > 0) {
                    Game.Cam.hp = Game.Cam.maxHp;
                    mp -= 2;
                    System.out.println("Sakura healed Cam (That rhymes)!");
                }
            }
        }
    }
}
