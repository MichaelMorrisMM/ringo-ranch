package ringoranch.models;

import java.util.Random;

public class Die {
	
	private final int numberOfFaces;
	private final Random random = new Random();
	private int value;
	
	public Die() {
		this.numberOfFaces = 6;
	}
	
	public Die(int numberOfFaces) {
		this.numberOfFaces = numberOfFaces;
	}
	
	public int roll() {
		this.value = random.nextInt(this.numberOfFaces) + 1;
		return this.getValue();
	}
	
	public int getNumberOfFaces() {
		return this.numberOfFaces;
	}
	
	public int getValue() {
		return this.value;
	}

}
