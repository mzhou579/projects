public class Potion{
    private int x_axis;
    private int y_axis;
    private boolean foundPo;
    
    public Potion(){
        x_axis = (int)(Math.random()*10);
        y_axis =(int)(Math.random()*10);
        foundPo = true;
    }
    
    public boolean noFound(){
        return foundPo;
    }
    
    public void found(){
        foundPo = false;
    }
    
    public int getX(){
        return x_axis;
    }
    
    public int getY(){
        return y_axis;
    }
    
}   