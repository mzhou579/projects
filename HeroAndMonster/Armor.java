public class Armor{
    private int x_axis;
    private int y_axis;
    public Armor(){
        x_axis = (int)(Math.random()*10)+1;
        y_axis = (int)(Math.random()*10)+1;
    }
    
    public int getX(){
        return x_axis;
    }
    
    public int getY(){
        return y_axis;
    }
    
    
}