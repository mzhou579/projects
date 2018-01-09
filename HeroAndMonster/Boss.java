public class Boss{
    private int attack;
    private int health;
    private int speed;
    private int x_axis;
    private int y_axis;
    public Boss(){
        attack = (int)(Math.random()*20)+1; 
        health = 300;
        speed = 0;
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
        return "The Boss has attack: " + attack + ", health: " + health + ", speed: " + speed + "\n";
    }
}