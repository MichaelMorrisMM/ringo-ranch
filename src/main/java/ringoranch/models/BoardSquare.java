package ringoranch.models;

public abstract class BoardSquare {

	protected final String title;
	protected final int price;
	protected final int baseRent;
	protected Player owner;

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
		return this.baseRent;
	}

	public boolean getChargesRent() {
	   return this.getRent() > 0;
   }

	public boolean getHasOwner() {
	   return this.getOwner() != null;
   }

	public boolean getForSale() {
	   return this.getPrice() > 0 && !this.getHasOwner();
   }

}
