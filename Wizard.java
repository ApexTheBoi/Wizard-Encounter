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

	public int getMana() {
		return mana;
	}

	public void useMana(int n) {
		this.mana -= n;
		System.out.println(this.getName() + " used " + n + " mana! (" + this.getMana() + " mana remaining.)");
	}

	public void turn() { //the main method used to initiate turns.
		input = new Scanner(System.in); //to get the choices
		checkStatus(); //do all the ticks / effects at the start

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
			System.out.println("Thunder is paralyzing you.\nTurn is skipped.");
		}
	}

	public void playerAttack() {

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
				fireball();
				playerHasActed = true;
			}

			else if(choice == 2) {
				blizzard();
				playerHasActed = true;
			}

			else if(choice == 3) {
				thunderstrike();
				playerHasActed = true;
			}

			else if(choice ==0) {
				getStatusInfo();
			}

		}
		playerHasActed = false;
		System.out.println("-----------------------------");
	}

	public void enemyAttack() {
		while(enemyHasActed == false) {

			int choice = (int)(Math.random() * 3) + 1; //generates 1-3 (1,2,3)

			if(choice == 1) {
				fireball();
				enemyHasActed = true;
			}

			else if(choice ==2) {
				blizzard();
				enemyHasActed = true;
			}

			else if(choice == 3) {
				thunderstrike();
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

	public void fireball() {
		if(this.getMana() >= 4) {
			System.out.println(this.getName() + " casts fireball!"); //this works for some reason
			this.useMana(4);
		}

		else {
			System.out.println(this.getName() + " attempted to cast fireball, but failed due to lack of mana. (" + this.getMana() + " mana remaining.)");
		}
	}

	public void blizzard() {
		if(this.getMana() >= 8) {
			System.out.println(this.getName() + " casts blizzard!");
			this.useMana(8);
		}
		else {
			System.out.println(this.getName() + " attempted to cast blizard, but failed due to lack of mana. (" + this.getMana() + " mana remaining.)");
		}
	}

	public void thunderstrike() {
		if(this.getMana() >= 14) {
			System.out.println(this.getName() + " casts thunderstrike!");
			this.useMana(14);
		}

		else {
			System.out.println(this.getName() + " attempted to cast thunderstrike, but failed due to lack of mana. (" + this.getMana() + " mana remaining.)");
		}
	}
}
