package ringoranch.models;

public abstract class Player {

	protected int money;
	protected int locationIndex;

	public int getMoney() {
		return this.money;
	}

	public int getLocationIndex() {
		return this.locationIndex;
	}

	public void setMoney(int money) {
	   this.money = money;
   }

}
