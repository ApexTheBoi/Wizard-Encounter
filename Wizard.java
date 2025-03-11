import java.util.*;

public class Wizard {

	//Wizard attributes
	private String name;
	private int health;
	private int mana;

	//Ailments
	private boolean isBurned;
	private boolean isFrostbitten;
	private boolean isThunderstruck;

	//Game fundamentals
	private Scanner input;
	private boolean playerHasActed; // <-----
	private boolean enemyHasActed;  // <-----maybe I can comebine the two into one "acted" boolean?
	private int randomNum;


	public Wizard() { //Only ever used for enemy wizard initialization.
		name = "Logrith"; //Enemy Wizard
		health = 100;
		mana = 40;
		isBurned = false;
		isFrostbitten = false;
		isThunderstruck = false;
		playerHasActed = false;
	}

	public Wizard(String n, int h, int m) { //player's initialization
		name = n;
		health = h;
		mana = m;
		isBurned = false;
		isFrostbitten = false;
		isThunderstruck = false;
		playerHasActed = false;
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getMana() {
		return mana;
	}

	public void heal() {
		if(this.getMana() >= 8) {
			this.mana -= 8;
			this.health+= 15;
			System.out.println(this.getName() + "heals 15 health at the expense of 8 mana.");
		}

		else {
			System.out.println(this.getName() + "failed to heal.");
		}
	}

	public void focus() {
		this.mana += 12;
		System.out.println(this.getName() + " gains 12 mana.");
	}

	/*public void manabrace(){

	}*/

	public void useMana(int n) {
		this.mana -= n;
		System.out.println(this.getName() + " used " + n + " mana! (" + this.getMana() + " mana remaining.)");
	}

	public void dealDamage(int d) {
		this.health -= d;
		System.out.println(this.getName() + " takes " + d + " damage!");
	}

	public void turn(Wizard wizard) { //the main method used to initiate turns.

		checkStatus(); //do all the ticks / effects at the start
		if(this.isThunderstruck == false) {
			input = new Scanner(System.in); //to get the choices

			if(this.getName().equals("Logrith"))
			{
				enemyAttack(wizard); //passing in the player's wizard
			}//enemy's turn

			else {
				System.out.println("Please choose an option : ");
				System.out.println("1 - Attack\n2 - Heal\n3 - Focus\n4 - Manabrace\n0 - Get Info on Abilities"); //15 health for 8mp
				int choice = input.nextInt();
				if(choice == 1) {
					playerAttack(wizard);
				}

				else if(choice == 2) {
					heal();
				}

				else if(choice == 3) {
					focus();
				}

				//else if(choice == 4){

				//}

				else if(choice == 0) {
					printChoiceInfo();
				}
			}
		}

		else {
			System.out.println(this.getName() + " is paralyzed. Cannot act.\nThe paralysis wears off.");
			isThunderstruck = false;
			System.out.println("-----------------------------");
		}


	}

	public void printInfo(Wizard w) { //passes in the enemy
		System.out.println(this.getName() + " : " + this.getHealth() + " Health | " + this.getMana() + " Mana.");//prints player's Information
		System.out.println(w.getName() + " : " + w.getHealth() + " Health | " + w.getMana() + " Mana");
		System.out.println("-----------------------------");
	}

	public void printChoiceInfo() {
		System.out.println("1 - Attack | Deal damage to the opponent.");
		System.out.println("2 - Heal | Heal 10 health at the expense of 8 mana.");
		System.out.println("3 - Focus | Regain 12 mana.");
		System.out.println("4 - Manabrace | Mitigate ~20% of the next attack at the expense of 8 mana.");
	}

	public void checkStatus() {
		if(isBurned == true) {
			System.out.println("Burns engulf the body. 7 Damage dealt.");
			health -= 7;
		}

		else if(isFrostbitten) {
			System.out.println("Frostbite is making your body brittle.\nDamage taken is increased.");
		}

		else if(isThunderstruck) {
			System.out.println("Thunder is paralyzing " + this.getName() + ".\nTurn is skipped.");
		}
	}

	public void playerAttack(Wizard wizard) {

		input = new Scanner(System.in); //creating a scanner for the user input.

		while(playerHasActed == false) { //If they haven't acted yet, ask them to.
			System.out.print("Please choose an attack:\n");
			System.out.println("\t1 - Fireball (4 mp) *Inflicts burning.");
			System.out.println("\t2 - Blizzard (8 mp) *Inflicts frostbite.");
			System.out.println("\t3 - Thunderstrike (14 mp) *Has a 40% chance to inflict Thunderstruck.");
			System.out.println("\t0 - Information on Statuses.");
			int choice = input.nextInt(); //Getting the user input.
			System.out.println("-----------------------------");
			if(choice==1) {
				fireball(wizard);
				playerHasActed = true;
			}

			else if(choice == 2) {
				blizzard(wizard);
				playerHasActed = true;
			}

			else if(choice == 3) {
				thunderstrike(wizard);
				playerHasActed = true;
			}

			else if(choice ==0) {
				getStatusInfo();
			}

		}
		playerHasActed = false;
		System.out.println("-----------------------------");
	}

	public void enemyAttack(Wizard w) {//parameter is the target
		while(enemyHasActed == false) {

			int choice = (int)(Math.random() * 3) + 1; //generates 1-3 (1,2,3)

			if(choice == 1) {
				fireball(w);
				enemyHasActed = true;
			}

			else if(choice ==2) {
				blizzard(w);
				enemyHasActed = true;
			}

			else if(choice == 3) {
				thunderstrike(w);
				enemyHasActed = true;
			}

			else {
				System.out.println("Enemy attack code went wrong...");
				enemyHasActed = true;
			}
		}
		enemyHasActed = false;
		System.out.println("-----------------------------");
	}

	public void getStatusInfo() {
		System.out.println("-----------------------------\n-----------------------------");
		System.out.println("Burning - Flames sear the flesh of the afflicted, dealing 4 damage for the next 2 turns.");
		System.out.println("Frostbite - Frost makes the flesh of the afflicted brittle. The next attack taken will deal double damage.");
		System.out.println("Thunderstruck - Thunder renders the body inactive. The next turn of the afflicted will be skipped.");
		System.out.println("-----------------------------\n-----------------------------");
	}

	public void fireball(Wizard wizard) { //target is getting hit
		if(this.getMana() >= 4) {
			System.out.println(this.getName() + " casts fireball!"); //this works for some reason
			this.useMana(4);
			wizard.dealDamage(8);
		}

		else {
			System.out.println(this.getName() + " attempted to cast fireball, but failed due to lack of mana. (" + this.getMana() + " mana remaining.)");
		}
	}

	public void blizzard(Wizard wizard) {
		if(this.getMana() >= 8) {
			System.out.println(this.getName() + " casts blizzard!");
			this.useMana(8);
			wizard.dealDamage(12);
		}
		else {
			System.out.println(this.getName() + " attempted to cast blizard, but failed due to lack of mana. (" + this.getMana() + " mana remaining.)");
		}
	}

	public void thunderstrike(Wizard wizard) {
		if(this.getMana() >= 14) {
			randomNum = (int)(Math.random() * 100) + 1; //just initializing so it doesnt yell at me later.
			System.out.println(this.getName() + " casts thunderstrike!");
			this.useMana(14);
			wizard.dealDamage(20);
			if(randomNum <= 40) {
				wizard.isThunderstruck = true;
				System.out.println("Critical hit! Thunderstruck has been applied to " + wizard.getName() + "!");
			}
		}

		else {
			System.out.println(this.getName() + " attempted to cast thunderstrike, but failed due to lack of mana. (" + this.getMana() + " mana remaining.)");
		}
	}
}
