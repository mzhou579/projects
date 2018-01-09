import java.util.*;
import java.io.*;
public class Tester{
    public static void main(String args[]){
        Object[][]map = new Object[10][10];
        Monster[] monster = new Monster[6];
        Potion[] potion = new Potion[2];
        Farmer[] farmer = new Farmer[2];
        Boss[] boss = new Boss[1];
        System.out.println("**** Hero & Monster***");
        System.out.println("*The map has been generated*");
        System.out.println("*The enemies have been places*");
        String x="",y="";        
        fillMap(map);
        int x_axis = (int)(Math.random()*10);
        int y_axis = (int)(Math.random()*10);
        int a =1;
        int b =0, c = 0;
        int esc = 0, esd = 0, po = 0;
        if(x_axis > 5){
            x ="east";
        }else if(x_axis < 5){
            x ="west";
        }
        
        if(y_axis > 5){
            y ="North";
        }else if(y_axis < 5){
            y ="South";
        }
        
        if(x_axis == 5 && y_axis == 5){
            System.out.println("Hero begins at the middle of Yore.");
        }else{
            System.out.println("Hero begins his journey in the "+y+x+" corner of Yore.");
        }
        
        
        while(b < monster.length){
            monster[b] = new Monster();
            if(map[monster[b].getX()][monster[b].getY()] == "-------"){
                map[monster[b].getX()][monster[b].getY()] = "monster";
                b++;
            }
        }
        
        while(c < potion.length){
            potion[c] = new Potion();
            if(map[potion[c].getX()][potion[c].getY()] == "-------"){
                    map[potion[c].getX()][potion[c].getY()] = "apotion";
                    c++;
            }
        }
        c=0;
        while(c < farmer.length){
            farmer[c] = new Farmer(c);
            if(map[farmer[c].getX()][farmer[c].getY()] == "-------"){
                    map[farmer[c].getX()][farmer[c].getY()] = "farmer"+c;
                    c++;
            }
        }
        c=0;
        while(c < 1){
            boss[c] = new Boss();
            if(map[boss[c].getX()][boss[c].getY()] == "-------"){
                map[boss[c].getX()][boss[c].getY()] = " Boss  ";
                c++;
            }
        }
        
        fillMap(map);
        Hero hero = new Hero();
        updateHero(map,hero);
        printMap(map);
        
        int count = 0;
        while(a ==1){
            
            Scanner choice = new Scanner(System.in);
            System.out.println("Type hero to check Hero's statue.");
            System.out.println("Enter direction (north, south, east, west): ");
            String direction = choice.nextLine();
            if(direction.equals("Yes")){
                hero.pickPotion();
            }
            if(direction.equals("north")||direction.equals("w")){
                if(map[hero.getX()][hero.getY()]!="Deadmos"&& map[hero.getX()][hero.getY()]!="monster"&& map[hero.getX()][hero.getY()]!="farmers"){
                    map[hero.getX()][hero.getY()] = "a clear";
                }
                hero.heroMove("n");
                updateHero(map,hero);
                printMap(map);
            }else if(direction.equals("south")||direction.equals("s")){
                if(map[hero.getX()][hero.getY()]!="Deadmos"&&map[hero.getX()][hero.getY()]!="monster"&& map[hero.getX()][hero.getY()]!="farmers"&& map[hero.getX()][hero.getY()]!= " Boss  "){
                    map[hero.getX()][hero.getY()] = "a clear";
                }
                hero.heroMove("s");
                updateHero(map,hero);
                printMap(map);
            }else if(direction.equals("west")||direction.equals("a")){
                if(map[hero.getX()][hero.getY()]!="Deadmos"&&map[hero.getX()][hero.getY()]!="monster"&& map[hero.getX()][hero.getY()]!="farmers"&& map[hero.getX()][hero.getY()]!= " Boss  "){
                    map[hero.getX()][hero.getY()] = "a clear";
                }
                hero.heroMove("w");
                updateHero(map,hero);
                printMap(map);
            }else if(direction.equals("east")||direction.equals("d")){
                if(map[hero.getX()][hero.getY()]!="Deadmos"&&map[hero.getX()][hero.getY()]!="monster"&& map[hero.getX()][hero.getY()]!="farmers"&& map[hero.getX()][hero.getY()]!= " Boss  "){
                    map[hero.getX()][hero.getY()] = "a clear";
                }
                hero.heroMove("e");
                updateHero(map,hero);
                printMap(map);
            }else if(direction.equals("hero")){
                System.out.println(hero);
            }else{
                System.out.println("Please enter the direction..");
            }
            
            for(int i = 0; i< potion.length; i++){
                if(checkpotion(potion[i],hero,map)){
                    po++;
                    System.out.println("Do you want to use your potion?");
                    
                    map[hero.getX()][hero.getY()] = "a clear";
                }
            }
            
            for(int i = 0; i< farmer.length; i++){
                if(checkFarmers(farmer[i],hero,map)){
                    System.out.println(farmer[i]);
                    map[hero.getX()][hero.getY()] = "farmers";
                    if(count >= 2 && i == 0){
                        System.out.println("Congraduations! You killed two monsters and you are eligible for my rewards! \n You may take my daughter's hand in marriage!!");
                        hero.setArmor(1);
                        System.out.println("Hero gets the armor.");
                        map[hero.getX()][hero.getY()] = "a clear";
                    }
                    if(count >=4 && i ==1){
                        System.out.println("Congraduations! You killed four monsters and you are eligible for my rewards!  \n You may take my daughter's hand in marriage!!");
                        hero.SwitchWeapon();
                        System.out.println("Hero gets the sword.");
                        map[hero.getX()][hero.getY()] = "a clear";
                    }
                }
            }
            
            if(checkBoss(boss[0],hero)){
                System.out.println("The Boss is nearby, please be careful.");
            }
            if(checkBosses(boss[0],hero,map)&& boss[0].getHealth()>=0){
                map[hero.getX()][hero.getY()] = "Vs.Boss";
                System.out.println("Hero engaged with the Boss!!");
                printMap(map);
                System.out.println(boss[0]);
                while(esd == 0){
                    Scanner ye = new Scanner(System.in);
                    System.out.println("Enter an action (run, attack): ");
                    String sb = ye.nextLine();
                    if(sb.equals("hero")){
                        System.out.println(hero);
                    }
                    if(sb.equals("run")||sb.equals("r")){
                        System.out.println("You have successfully ran away!");
                        map[hero.getX()][hero.getY()]=" Boss  ";
                        esd = 1;
                    }
                    if(sb.equals("attack")||sb.equals("f")){
                        System.out.println("Hero attacked, the monster's energy goes down to "+(boss[0].getHealth()-hero.getDamage()));
                        System.out.println("The monster attacks! Hero's energy goes down to "+(hero.getHealth() - boss[0].getAttack(hero))+"/100");
                        boss[0].setHealth(boss[0].getHealth() - hero.getDamage());
                        hero.setHealth(hero.getHealth() - boss[0].getAttack(hero));
                        if(hero.Death()){
                            System.out.println("** Hero collapses and is struck a deadly blow by monster **");
                            System.out.println("Game Over!!!!");
                            esc = 1;
                            a = 2;
                        }
                        if(boss[0].getHealth() <= 0){
                            System.out.println("You kill the Boss!!");
                            map[boss[0].getX()][boss[0].getY()] = "Deadbos";
                            System.out.println("Nice works, the Boss is die.");
                            System.out.println(" ");
                            esd = 1;
                            count = 6;
                        } 
                    }
                }
            }
            
            for(int i = 0; i< monster.length; i++){
                if(checkMon(monster[i],hero)){
                    System.out.println("The monster is nearby, please be careful.");
                }
                if(check(monster[i],hero,map) && monster[i].getHealth()>=0){
                    map[hero.getX()][hero.getY()] = "Battles";
                    System.out.println("Hero engaged with a monster!");
                    printMap(map);
                    System.out.println("Hero encounters a monster! The monster engages!");
                    System.out.println(monster[i]);
                    while(esc == 0){
                        Scanner re = new Scanner(System.in);
                        System.out.println("Enter an action (run, attack): ");
                        String bat = re.nextLine();
                        if(bat.equals("hero")){
                            System.out.println(hero);
                        }
                        if(bat.equals("run")||bat.equals("r")){
                            if(monster[i].getSpeed() == 3){
                                System.out.println("Hero tries to run! The monster is too fast!");
                                System.out.println("The monster attacks! Hero's energy goes down to " + (hero.getHealth() - monster[i].getAttack(hero))+" /100");
                                hero.setHealth(hero.getHealth() - monster[i].getAttack(hero));
                            }
                            if(monster[i].getSpeed() == 2){
                                int chance = (int)(Math.random()*4+1);
                                if(chance == 1){
                                    System.out.println("You have successfully ran away!");
                                    map[hero.getX()][hero.getY()]="monster";
                                    esc = 1;
                                }else{
                                    System.out.println("Hero tries to run! The monster is too fast!");
                                    System.out.println("The monster attacks! Hero's energy goes down to " + (hero.getHealth() - monster[i].getAttack(hero))+" /100");
                                    hero.setHealth(hero.getHealth() - monster[i].getAttack(hero));
                                    if(hero.Death()){
                                        System.out.println("** Hero collapses and is struck a deadly blow by monster **");
                                        System.out.println("Game Over!!!!");
                                        esc = 1;
                                        a=2;
                                    }
                                }
                            }
                            if(monster[i].getSpeed() == 1){
                                int chance = (int)(Math.random()*2+1);
                                if(chance == 1){
                                    System.out.println("You have successfully ran away!");
                                    map[hero.getX()][hero.getY()]="monster";
                                    esc = 1;
                                }else{
                                    System.out.println("Hero tries to run! The monster is too fast!");
                                    System.out.println("The monster attacks! Hero's energy goes down to " + (hero.getHealth() - monster[i].getAttack(hero))+"/100");
                                    hero.setHealth(hero.getHealth() - monster[i].getAttack(hero));
                                    if(hero.Death()){
                                        System.out.println("** Hero collapses and is struck a deadly blow by monster **");
                                        System.out.println("Game Over!!!!");
                                        esc = 1;
                                        a=2;
                                    }
                                }
                            }
                            if(monster[i].getSpeed() == 0){
                                int chance = (int)(Math.random()*4+1);
                                if(chance == 2|| chance ==3 || chance == 4){
                                    System.out.println("You have successfully ran away!");
                                    map[hero.getX()][hero.getY()]="monster";
                                    esc = 1;
                                }else{
                                    System.out.println("Hero tries to run! The monster is too fast!");
                                    System.out.println("The monster attacks! Hero's energy goes down to " + (hero.getHealth() - monster[i].getAttack(hero))+"/100");
                                    hero.setHealth(hero.getHealth() - monster[i].getAttack(hero));
                                }
                                if(hero.Death()){
                                    System.out.println("** Hero collapses and is struck a deadly blow by monster **");
                                    System.out.println("Game Over!!!!");
                                    esc = 1;
                                    a=2;
                                }
                            }
                        }
                        
                        if(bat.equals("attack")||bat.equals("f")){
                            System.out.println("Hero attacked, the monster's energy goes down to "+(monster[i].getHealth()-hero.getDamage()));
                            System.out.println("The monster attacks! Hero's energy goes down to "+(hero.getHealth() - monster[i].getAttack(hero))+"/100");
                            monster[i].setHealth(monster[i].getHealth() - hero.getDamage());
                            hero.setHealth(hero.getHealth() - monster[i].getAttack(hero));
                            if(hero.Death()){
                                System.out.println("** Hero collapses and is struck a deadly blow by monster **");
                                System.out.println("Game Over!!!!");
                                esc = 1;
                                a=2;
                            }
                        }
                        if(monster[i].getHealth() <= 0){
                            System.out.println("You kill the monster!!");
                            map[monster[i].getX()][monster[i].getY()] = "Deadmos";
                            System.out.println("Nice works, the monster is die.");
                            System.out.println("Hero gains 15 exps.");
                            System.out.println(" ");
                            hero.setLevel(15);
                            count ++;
                            esc = 1;
                        }
                        if(hero.getExp()>=hero.getLevelUp()){
                            System.out.println("COOOOOOOLLLL!!!!!! You level up, You level is "+ hero.getLevel());
                        }
                    }
                }
            }
            esc = 0;
            if(count == 6){
                System.out.println("Hero Kills all the six monsters or the boss, hero successfully protect the country!!!");
                a = 2;
            }
        }
    }
    
    public static void fillMap(Object[][]map){
        for(int i = 0; i< map.length; i++){
            for(int j = 0; j< map[0].length;j++){
                map[i][j]="-------";
            }
        }
    }
    
    public static void printMap(Object[][] map){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length;j++){
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }
    }
    
    public static void updateHero(Object[][] map, Hero hero){
        map[hero.getX()][hero.getY()] = "bigHero";
    }
    
    public static boolean check(Monster monster, Hero hero, Object[][] map){
        if(hero.getX()==monster.getX()&&hero.getY()==monster.getY()&&map[hero.getX()][hero.getY()]!=""){
            return true;
        }
        return false;
    }
    
    public static boolean checkBosses(Boss monster, Hero hero, Object[][] map){
        if(hero.getX()==monster.getX()&&hero.getY()==monster.getY()){
            return true;
        }
        return false;
    }
    
    public static boolean checkpotion(Potion potion, Hero hero, Object[][] map){
        if(hero.getX()==potion.getX()&&hero.getY()==potion.getY()&&potion.noFound()){
             System.out.println("Hero pick up the potion.");
             potion.found();
             return true;
        }
        return false;
    }
    
    public static boolean checkFarmers(Farmer monster, Hero hero, Object[][] map){
        if(hero.getX()==monster.getX()&&hero.getY()==monster.getY()){
            return true;
        }
        return false;
    }
    
    public static boolean checkMon(Monster monster, Hero hero){
        if(hero.getX() == monster.getX()){
            if(hero.getY() == monster.getY() +1 || hero.getY() == monster.getY() -1){
                return true;
            }
        }else if(hero.getY() == monster.getY()){
            if(hero.getX() == monster.getX() +1 || hero.getX() == monster.getX() -1){
                return true;
            }

        }
        return false;
    }
    
    public static boolean checkBoss(Boss monster, Hero hero){
        if(hero.getX() == monster.getX()){
            if(hero.getY() == monster.getY() +1 || hero.getY() == monster.getY() -1){
                return true;
            }
        }else if(hero.getY() == monster.getY()){
            if(hero.getX() == monster.getX() +1 || hero.getX() == monster.getX() -1){
                return true;
            }

        }
        return false;
    }
}