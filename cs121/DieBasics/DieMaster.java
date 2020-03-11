
public class DieMaster {

	public static void main(String[] args) {
		
		/* Create a six sided die */
		Die die1 = new Die();
		die1.roll();
		//System.out.println("The value of die1 is: " + die1.getFaceValue());
		System.out.println("Die1: " + die1);
		
		/* Create a 16 sided die */
		Die die2 = new Die(16);
		die2.roll();
		//System.out.println("The value of die2 is: " + die2.getFaceValue());
		System.out.println("Die2: " + die2.toString());
		
		/* Test the compareTo() methods to make sure it is 
		 *   functioning properly */
		if (die1.compareTo(die2) < 0) {
			System.out.println("Die 2 is the winner!");
		} else if (die1.compareTo(die2)>0) {
			System.out.println("Die 1 is the winner!");
		} else {
			System.out.println("Tie game");
		}

	}

}
