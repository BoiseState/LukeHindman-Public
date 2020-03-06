import java.util.Random;

/**
 * In class Die example
 * @author lhindman
 *
 */
public class Die {
	/* Step 1 - Instance Variables */
	private int faceValue;
	private int numSides;
	
	/* Step 2 - Constructor(s) */
	/**
	 * This constructor witll initialize the Die object with a faceValue of 1
	 *    and 6 sides.
	 */
	public Die() {
		faceValue = 1;
		numSides = 6;
	}
	
	/**
	 * This constructor will initize the Die object with a faceValue of 1
	 *    and the specified number of sides
	 * @param n The number of side for this Die object
	 */
	public Die(int numSides) {
		faceValue = 1;
		this.numSides = numSides;
	}
	
	/* Step 3  - Other methods */
	/**
	 * Roll the die
	 */
	public void roll() {
		Random rand = new Random();
		faceValue = rand.nextInt(numSides) + 1;
	}
	/**
	 * 
	 * @return The current faceValue of the Die
	 */
	public int getFaceValue() {
		return this.faceValue;
	}
	
	public void setFaceValue(int faceValue) {
		if(faceValue > 0 && faceValue <= numSides) {
			this.faceValue = faceValue;
		}
	}
	
	public String toString() {
		String output = "";
		
		output += "The value of my beautiful " + numSides + " sided die is " + faceValue + "!";
		
		return output;
	}
	
	
}
