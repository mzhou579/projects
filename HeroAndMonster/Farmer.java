public class Farmer{
    private String line;
    private int number;
    private String daughter;
    private int x_axis;
    private int y_axis;
    public Farmer(int n){
        if(n == 0){
            line = "My sheep have been taken… My family is gone and\n I have nothing left except for bronze amor I have buried… Only a true hero will receive this.";
            daughter = "armor";
        }
        else if(n == 1){
            line = "I am the rich guy, and I have the sword, if you \ncan kill 4 monsters, I will give my daughter to you!";
            daughter = "board sword";
        }
        x_axis = (int)(Math.random()*10);
        y_axis = (int)(Math.random()*10);
    }
    
    public int getX(){
        return x_axis;
    }
    
    public int getY(){
        return y_axis;
    }
    
    public String toString(){
        return "the number "+number+1+" farmer says, \" "+line+".\"";
    }
}
