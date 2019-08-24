package ringoranch.models;

import java.util.Set;

public abstract class Player {

   protected int idPlayer;
   protected String name;
	protected int money;
	protected int locationIndex;
	protected Set<BoardSquare> properties;
	protected boolean hasRolledDice;

	@Override
   public boolean equals(Object other) {
	   if (other instanceof Player) {
	      return this.getIdPlayer() == ((Player) other).getIdPlayer();
      }

	   return false;
   }

	public int getIdPlayer() {
	   return this.idPlayer;
   }

   public String getName() {
	   return this.name;
   }

	public int getMoney() {
		return this.money;
	}

	public int getLocationIndex() {
		return this.locationIndex;
	}

	public void setLocationIndex(int locationIndex) {
	   this.locationIndex = locationIndex;
   }

	public void setMoney(int money) {
	   this.money = money;
   }

   public Set<BoardSquare> getProperties() {
	   return this.properties;
   }

   public boolean getHasRolledDice() {
	   return this.hasRolledDice;
   }

   public void setHasRolledDice(boolean hasRolledDice) {
      this.hasRolledDice = hasRolledDice;
   }
}
