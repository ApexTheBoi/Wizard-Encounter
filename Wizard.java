import java.util.*;

public class Wizard{
    
    private int health;
    private int mana;
    private boolean isBurned;
    private boolean isFrostbitten;
    private boolean isThunderstruck;
    private Scanner input;
        
    private boolean playerHasActed;
    
    
    public Wizard(){
        health = 100;
        mana = 40;
        isBurned = false;
        isFrostbitten = false;
        isThunderstruck = false;
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
        
        input = new Scanner(System.in); //creating a scanner for the user input.
        
        while(playerHasActed == false){ //If they haven't acted yet, ask them to.
            System.out.print("Please choose an attack:\n");
            System.out.println("\t1 - Fireball (4 mp) *Inflicts burning.");
            System.out.println("\t2 - Blizzard (8 mp) *Inflicts frostbite.");
            System.out.println("\t3 - Thunderstrike (14 mp) *Has a 40% chance to inflict Thunderstruck.");
            System.out.println("\t0 - Information on Statuses.");
            int choice = input.nextInt(); //Getting the user input.
            if(choice==1){
                fireball();
                playerHasActed = true;
            }
            
            else if(choice == 2){
                blizzard();
                playerHasActed = true;
            }
            
            else if(choice == 3){
                thunderstrike();
                playerHasActed = true;
            }
            
            else if(choice ==0){
                getStatusInfo();
            }
        
        }
        playerHasActed = false;
    }
    
    public void getStatusInfo(){
        System.out.println("-----------------------------\n-----------------------------");
        System.out.println("Burning - Flames sear the flesh of the afflicted, dealing 4 damage for the next 2 turns.");
        System.out.println("Frostbite - Frost makes the flesh of the afflicted brittle. The next attack taken will deal double damage.");
        System.out.println("Thunderstruck - Thunder renders the body inactive. The next turn of the afflicted will be skipped.");
        System.out.println("-----------------------------\n-----------------------------");
    }
    
    public void fireball(){
        System.out.println("Wizard casts fireball!");
    }
    
    public void blizzard(){
        System.out.println("Wizard casts blizzard!");
    }
    
    public void thunderstrike(){
        System.out.println("Wizard casts thunderstrike!");
    }
}
