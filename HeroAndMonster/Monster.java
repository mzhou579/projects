public class Monster{
    private int attack;
    private int health;
    private int speed;
    private int x_axis;
    private int y_axis;
    public Monster(){
        attack = (int)(Math.random()*30)+1; 
        health = (int)(Math.random()*100)+1;
        speed = (int)(Math.random()*4);
        x_axis = (int)(Math.random()*10);
        y_axis = (int)(Math.random()*10);
    }
    
    public int getX(){
        return x_axis;
    }
    
    public int getY(){
        return y_axis;
    }
    
    public int getHealth(){
        return health;
    }
    
    public int getAttack(Hero hero){
        if(hero.checkArmor()){
            attack -= (int)(attack / 3);
        }
        return attack;
    }
    
    public void setHealth(int h){
        health = h;
    }
    
    public int getSpeed(){
        return speed;
    }
    
    public String toString(){
        return "The monster has attack: " + attack + ", health: " + health + ", speed: " + speed + "\n";
    }
}