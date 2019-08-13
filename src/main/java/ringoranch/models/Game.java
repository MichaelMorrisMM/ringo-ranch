package ringoranch.models;

import ringoranch.util.GameStateEvent;

import java.util.LinkedList;
import java.util.List;

public class Game {

	private final RuleSet rules;
	private final Banker banker;
	private final List<Player> players;
	private final Board board;
	private final List<Die> dice;
	private List<Event> log;

	private int activePlayerIndex;
	private GameStateEvent latestEvent;

	public Game(RuleSet rules, Banker banker, List<Player> players, Board board, List<Die> dice) {
		this.rules = rules;
		this.banker = banker;
		this.players = players;
		this.board = board;
		this.dice = dice;
		this.log = new LinkedList<>();

		this.activePlayerIndex = 0;

		this.banker.assignStartingMoney(this.players);

		this.latestEvent = new GameStateEvent("Game has been started");
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
	   return this.players.get(this.activePlayerIndex);
   }

   public GameStateEvent getLatestEvent() {
	   return this.latestEvent;
   }

}
