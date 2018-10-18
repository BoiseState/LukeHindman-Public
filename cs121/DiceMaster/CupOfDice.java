import java.util.ArrayList;

/**
 * @author lhindman
 * This class will be used to represent a cup of dice
 */
public class CupOfDice {
	
	/* Instance Variables */
	private ArrayList<Die> cup;
	
	/* Constructors, both default and initial value */
	public CupOfDice() {
		cup = new ArrayList<Die>();
		cup.add(new Die());
		cup.add(new Die());
		cup.add(new Die());
		cup.add(new Die());
		cup.add(new Die());
		
	}
	
	public CupOfDice(int numDice, int numSides) {
		cup = new ArrayList<Die>();
		for(int i = 0; i < numDice; i++) {
			cup.add(new Die(numSides));
		}
	}
	
	/* Methods */
	
	public void shake() {
		for (Die d: this.cup) {
			d.roll();
		}
	}
	
	public int getScore() {
		int score = 0;
		
		for (Die d: cup) {
			score += d.getFaceValue();
		}
		
		return score;
	}
	
	public String toString() {
		String output = "";
		
		output += "This is the contents of my cup:\n";
		output += "-------------------------------\n";
		for (Die d: this.cup) {
			output += d.toString() + "\n";
		}
		
		return output;
	}

}
