/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                  Sauce Code: 17                    #
 *#                                                    #
 *######################################################
 */
public abstract class Character {
//wariables
public int hp,maxHp,x,y;
public String name, file;
public boolean isParalyzed, isPoisoned;
    
//constructor
    public Character(String aName, int anHp, int aMaxHp, int anX, int aY){
        //stats
        hp=anHp;
        maxHp=aMaxHp;
        
        //starting positions
        x=anX;
        y=aY;
        
        //name
        name=aName;
        
        //set status wariables
        isParalyzed=false;
        isPoisoned=false;
        
        //info
        file="";
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
//action method
    public abstract void action();
}
