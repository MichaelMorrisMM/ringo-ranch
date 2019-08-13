package ringoranch.models;

public abstract class BoardSquare {

	protected final String title;
	protected final int price;
	protected final int baseRent;
	protected Player owner;
	protected int rent;

	protected BoardSquare(String title, int price, int baseRent) {
		this.title = title;
		this.price = price;
		this.baseRent = baseRent;
	}

	public String getTitle() {
		return this.title;
	}

	public int getPrice() {
		return this.price;
	}

	public int getBaseRent() {
		return this.baseRent;
	}

	public Player getOwner() {
		return this.owner;
	}

	public int getRent() {
		return this.rent;
	}

}
