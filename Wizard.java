import java.util.*;

public class Wizard{
    
    private int health;
    private int mana;
    private boolean isBurned;
    private boolean isFrostbitten;
    private boolean isThunderstruck;
    
    private playerHasActed;
    
    
    public Wizard(){
        health = 100;
        mana = 40;
        isBurned = false;
        isFrostbitten = false;
        isThunderstruck = false;
        Scanner input = new Scanner(System.in);
        playerHasActed = false;
    }

    public Wizard(int h, int m){
        health = h;
        mana = m;
        isBurned = false;
        isFrostbitten = false;
        isThunderstruck = false;
        Scanner input = new Scanner(System.in);
        playerHasActed = false;
    }
    
    public void turn(){
        
        checkStatus(); //do all the ticks / effects at the start
        
    }
    
    public void checkStatus(){
        if(isBurned == true){
            health -= 7;
        }
        
        else if(isFrostbitten){
            System.out.println("Frostbite is making your body brittle.\nDamage taken is increased.");
        }
        
        else if(isThunderstruck){
            System.out.println("Thunder is paralyzing you.\nTurn is skipped.");
        }
    }
    
    public void playerAttack(){
        while(PlayerHasActed == false){
        System.out.print("Please choose an attack:\n");
        System.out.println("\t1 - Fireball (4 mp) *Inflicts burning.");
        System.out.println("\t2 - Blizzard (8 mp) *Inflicts frostbite.");
        System.out.println("\t3 - Thunderstrike (14 mp) *Has a 40% chance to inflict Thunderstruck.");
        System.out.println("\t0 - Information on Statuses.");
        choice = input.nextInt()
        if(choice!=0){
            
        }
        
        }
    }
    
    public void fireball(Wizard target){
        target.    
    }
    
    public void Blizzard(){
        
    }
    
    public void thunderStrike(){
        
    }
}
