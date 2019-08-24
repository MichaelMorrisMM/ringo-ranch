package ringoranch.util;

import ringoranch.models.Action;

public class Input {

   private int idPlayer;
	private Action action;

	public Input(int idPlayer) {
	   this.idPlayer = idPlayer;
	}

	public Input(int idPlayer, Action action) {
	   this(idPlayer);
		this.action = action;
	}

	public int getIdPlayer() {
	   return this.idPlayer;
   }

   public void setIdPlayer(int idPlayer) {
	   this.idPlayer = idPlayer;
   }

	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

}
