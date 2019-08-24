package ringoranch.models;

import ringoranch.util.GameStateEvent;
import ringoranch.util.Input;

import java.util.LinkedList;
import java.util.List;

public class Game {

	private final RuleSet rules;
	private final Banker banker;
	private final List<Player> players;
	private final Board board;
	private final List<Die> dice;
	private LinkedList<Event> log;

	private Player activePlayer;
	private List<Action> activePlayerAvailableActions;

	public Game(RuleSet rules, Banker banker, List<Player> players, Board board, List<Die> dice) {
		this.rules = rules;
		this.banker = banker;
		this.players = players;
		this.board = board;
		this.dice = dice;
		this.log = new LinkedList<>();

		this.activePlayer = this.players.get(0);

		this.banker.assignStartingMoney(this.players);

		this.log.add(new Event("Game has been started"));

		this.activePlayerAvailableActions = this.determineActivePlayersAvailableActions();
	}

	private List<Action> determineActivePlayersAvailableActions() {
	   Player activePlayer = this.getActivePlayer();
	   BoardSquare currentSquare = this.board.getSquares().get(activePlayer.locationIndex);

	   List<Action> actions = new LinkedList<>();

	   if (!activePlayer.getHasRolledDice()) {
         actions.add(Action.ROLL_DICE);
      } else {
         // TODO
         if (currentSquare.getChargesRent() && currentSquare.getHasOwner() && !currentSquare.getOwner().equals(activePlayer)) {
            actions.add(Action.RENT);
         } else {
            if (currentSquare.getForSale() && activePlayer.getMoney() >= currentSquare.getPrice()) {
               actions.add(Action.BUY);
            }
            actions.add(Action.END_TURN);
         }
      }

	   return actions;
   }

   public void handlePlayerInput(Input input) {
	   // TODO
      if (input.getIdPlayer() == this.getActivePlayer().getIdPlayer() && this.activePlayerAvailableActions.contains(input.getAction())) {
         /*
         switch (input.getAction()) {
            case ROLL_DICE -> this.doRollDice();
            case RENT -> this.doRent();
            case BUY -> this.doBuy();
            case END_TURN -> this.doEndTurn();
         }
          */
      } else {
         this.log.add(new Event("Invalid player input received"));
      }
   }

   private void doRollDice() {
	   Player activePlayer = this.getActivePlayer();

	   int sum = 0;
	   for (Die die : this.getDice()) {
	      sum += die.roll();
      }

	   int newLocationIndex = (activePlayer.getLocationIndex() + sum) % this.getBoard().getSquares().size();
	   activePlayer.setLocationIndex(newLocationIndex);
	   activePlayer.setHasRolledDice(true);
	   this.activePlayerAvailableActions = this.determineActivePlayersAvailableActions();

	   this.log.add(new Event("Player " + activePlayer.getName() + " rolled " + sum));
   }

   private void doRent() {
	   // TODO
   }

   private void doBuy() {
	   // TODO
   }

   private void doEndTurn() {
	   Player formerActivePlayer = this.getActivePlayer();
	   int nextIndex = this.players.indexOf(formerActivePlayer) + 1;
	   if (nextIndex == this.players.size()) {
	      nextIndex = 0;
      }

	   this.activePlayer = this.players.get(nextIndex);
	   this.activePlayerAvailableActions = this.determineActivePlayersAvailableActions();

	   this.log.add(new Event("Player " + formerActivePlayer + " ended turn."));
   }

	public RuleSet getRules() {
		return this.rules;
	}

	public Banker getBanker() {
		return this.banker;
	}

	public List<Player> getPlayers() {
		return this.players;
	}

	public Board getBoard() {
		return this.board;
	}

	public List<Die> getDice() {
		return this.dice;
	}

	public List<Event> getLog() {
		return this.log;
	}

	public Player getActivePlayer() {
	   return this.activePlayer;
   }

   public List<Action> getActivePlayerAvailableActions() {
	   return this.activePlayerAvailableActions;
   }

   public GameSnapshot getSnapshot() {
	   // TODO
	   return null;
   }

   public GameStateEvent getLatestEvent() {
	   return new GameStateEvent(this.log.getLast(), this.getActivePlayer(), this.getActivePlayerAvailableActions(), this.getSnapshot());
   }

}
