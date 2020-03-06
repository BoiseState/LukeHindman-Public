
public class DieMaster {

	public static void main(String[] args) {
		
		/* Create a six sided die */
		Die die1 = new Die();
		die1.roll();
		//System.out.println("The value of die1 is: " + die1.getFaceValue());
		System.out.println(die1);
		
		/* Create a 16 sided die */
		Die die2 = new Die(16);
		die2.roll();
		//System.out.println("The value of die2 is: " + die2.getFaceValue());
		System.out.println(die2.toString());
		
		

	}

}
