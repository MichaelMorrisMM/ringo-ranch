package ringoranch.directors;

import ringoranch.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameDirector {

   private static Game game;

   public static boolean isGameRunning() {
      return game != null;
   }

   public static void startGame() {
      RuleSet rules = getDefaultRules();
      Banker banker = getDefaultBanker(rules);
      Board board = getDefaultBoard();
      List<Die> dice = getDefaultDice();

      List<Player> players = new ArrayList<>();
      players.add(new HumanPlayer());
      players.add(new HumanPlayer());

      game = new Game(rules, banker, players, board, dice);
   }

   public static RuleSet getDefaultRules() {
      return new RuleSet();
   }

   public static Banker getDefaultBanker(RuleSet rules) {
      return new Banker(rules);
   }

   public static Board getDefaultBoard() {
      List<BoardSquare> squares = Arrays.asList(
         new DogSquare("Golden", 100, 10),
         new DogSquare("Husko", 150, 15),
         new DogSquare("Poodle", 200, 20)
      );

      return new Board(squares);
   }

   public static List<Die> getDefaultDice() {
      return Arrays.asList(new Die(), new Die());
   }

   public static Game getGame() {
      return game;
   }

}
