import java.util.Random;

public class Die {
	
	/* Instance Variables */
	private int numSides;
	private int faceValue;
	private Random rand;
	
	/* Constructor(s) */
	public Die() {
		this.numSides = 6;
		this.faceValue = 1;
		this.rand = new Random();
	}
	
	public Die(int numSides) {
		this.numSides = numSides;
		this.faceValue = 1;
		this.rand = new Random();
	}
	
	/* Other methods */
	public int roll() {
		this.faceValue = rand.nextInt(numSides) + 1;
		return this.faceValue;
	}

	public void setFaceValue(int value) {
		if (value >= 1 && value <= numSides) {
			this.faceValue = value;
		}
	}
	
	public int getFaceValue() {
		return faceValue;
	}
	
	public String toString() {
		String output = "";
		output += "The value of my beautiful " + numSides + " sided die is " + faceValue;
		
		return output;
	}
	
}
