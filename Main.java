public class Main
{
	public static void main(String[] args) {
		
		Wizard w = new Wizard();
		int failsafe = 0;
		
		while(failsafe < 10){
		    w.playerAttack();
		    failsafe+=1;
		}
	}
}
