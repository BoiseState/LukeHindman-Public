import java.util.ArrayList;

/**
 * @author lhindman
 *
 */
public class CupOfDice {
	
	
	/* Instance variables */
	private ArrayList<Die> cup;
	
	
	/* Constructor */
	public CupOfDice() {
		/* create a new empty cup */
		this.cup = new ArrayList<Die>();
		
		int desiredNumberOfDice = 5;
		
		/* Create individual dices and add them to the cup */
		for ( int i = 0; i < desiredNumberOfDice; i++) {
			Die d1 = new Die();
			this.cup.add(d1);
		}
	}
	
	public CupOfDice(int numDice, int numSides) {
		/* create a new empty cup */
		this.cup = new ArrayList<Die>();
		
		int desiredNumberOfDice = numDice;
		
		/* Create individual dices and add them to the cup */
		for ( int i = 0; i < desiredNumberOfDice; i++) {
			Die d1 = new Die(numSides);
			this.cup.add(d1);
		}
	}
	
	
	
	
	/* Other Methods */
	
	public void shake() {
		for (Die d: this.cup) {
			d.roll();
		}
	}
	
	public int getScore() {
		
		int score = 0;
		for (Die d: this.cup) {
			score += d.getFaceValue();
		}
		
		return score;
	}
	
	public String toString() {
		String output = "";
		
		for (Die d: this.cup) {
			output += d.toString() + "\n";
		}
		
		return output;
	}
 
}
