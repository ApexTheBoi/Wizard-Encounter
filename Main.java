import java.util.*;
public class Main
{
	public static void main(String[] args) {
		int failsafe = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("START GAME\n-------------------");
		System.out.print("Please input a name for your wizard : ");
		String name = scanner.nextLine(); //Player inputs a name for their wizard.
		
		Wizard player = new Wizard(name, 100, 40); //player's wizard
		final Wizard enemy = new Wizard();
		
		System.out.println("-------------------\nYour enemy is " + enemy.getName() + ". Good luck, " + name + "\n-------------------");
		
		while(failsafe < 4){
		    player.turn(enemy); //player's turn. Passes in the target
		    enemy.turn(player); //enemy's turn. Passes in the target
		    failsafe+=1;
		    player.printInfo(enemy); //to get the information.
		}
	}
}
