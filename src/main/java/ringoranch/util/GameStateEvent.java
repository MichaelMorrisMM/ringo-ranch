package ringoranch.util;

import ringoranch.models.Action;
import ringoranch.models.Event;
import ringoranch.models.GameSnapshot;
import ringoranch.models.Player;

import java.util.List;

public class GameStateEvent {

	private final Event event;
	private final Player activePlayer;
	private final List<Action> availableActions;
	private final GameSnapshot snapshot;

	public GameStateEvent(Event event, Player activePlayer, List<Action> availableActions, GameSnapshot snapshot) {
		this.event = event;
		this.activePlayer = activePlayer;
		this.availableActions = availableActions;
		this.snapshot = snapshot;
	}

	public Event getEvent() {
		return this.event;
	}

	public Player getActivePlayer() {
	   return this.activePlayer;
   }

   public List<Action> getAvailableActions() {
	   return this.availableActions;
   }

   public GameSnapshot getSnapshot() {
	   return this.snapshot;
   }

}
