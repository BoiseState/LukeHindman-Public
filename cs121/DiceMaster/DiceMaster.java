
public class DiceMaster {

	public static void main(String[] args) {
		
		Die die1 = new Die(20);
		Die die2 = new Die(20);
		
		die1.roll();
		die2.roll();
		
		System.out.println("Die1: " + die1);
		System.out.println("Die2: " + die2);

	}

}
