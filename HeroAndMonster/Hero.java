
public class Hero{
    private int health;
    private int x_axis;
    private int y_axis;
    private Weapon weapon = new Weapon();
    private int armor = 0;
    private int x = 0;
    private int exp;
    private int level;
    private int levelUpExp;
    private int attack = 0;
    
    public Hero(){
        health = 100;
        weapon = new Weapon();
        x_axis = 0;
        y_axis = 9;
        exp = 0;
        level = 0;
        levelUpExp = 30;
        attack = 0;
    }
   
    public void upgrade(){
        level++;
        health += 30;
        exp = 0;
        levelUpExp += 10;
        attack += 5;
    }
    
    public void setLevel(int s){
        level += s;
    }
   
    public int getLevelUp(){
        return levelUpExp;
    }  
    
    public int getLevel(){
        return level;
    }
    
    public int getExp(){
        return exp;
    }
    
    public void heroMove(String direction){
        if(direction.equals("n")){
            x_axis -= 1;
        }else if(direction.equals("s")){
            x_axis += 1;
        }else if(direction.equals("w")){
            y_axis -= 1;
        }else if(direction.equals("e")){
            y_axis += 1;
        }
        if(x_axis > 9){
            x_axis = 9;
        }
        if(x_axis < 0){
            x_axis = 0;
        }
        if(y_axis > 9){
            y_axis = 9;
        }
        if(y_axis < 0){
            y_axis = 0;
        }
    }
    
    public boolean Death(){
        if(health <= 0){
            return true;
        }
        return false;
    }
    
    
    public int getX(){
        return x_axis;
    }
    
    public int getY(){
        return y_axis;
    }
    
    public int attack(){
        return attack;
    }
    
    public int getDamage(){
        int damage = 0;
        if(weapon.getName().equals("dagger")){
            damage = (int)(Math.random()*20)+11;
        }
        if(weapon.getName().equals("sword")){
            damage = (int)(Math.random()*30)+21;
        }
        return damage += attack();
    }
    
    public int getHealth(){
        return health;
    }
    
    public void pickPotion(){
        health = 100;
    }
    
    public void setHealth(int h){
        health = h;
    }
    
    public void setArmor(int i){
        armor = i;
    }
    
    public boolean checkArmor(){
       if(x== 0){
           if(armor == 1){
               x++;
               return true;
           }
       }
       return false;
    }
    
    public void SwitchWeapon(){
        weapon.switchWeapon();
    }
    
    public String toString(){
        return "Hero's health: "+getHealth()+ " Attack: "+getDamage()+ " Armor: "+ checkArmor() + " Weapon: "+ weapon.getName();
    }
}