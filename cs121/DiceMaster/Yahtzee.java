
public class Yahtzee {

	public static void main(String[] args) {
		CupOfDice myCup = new CupOfDice();
//		CupOfDice myCup = new CupOfDice(10,17);
		
		myCup.shake();
		
		int myScore = myCup.getScore();
		
		System.out.println("The value of my cup is: " + myScore);
		System.out.println("");
		
		System.out.println(myCup);
		
		

	}

}
