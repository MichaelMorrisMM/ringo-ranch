package ringoranch.models;

import java.util.List;

public class Banker {

   private final RuleSet rules;

   public Banker(RuleSet rules) {
      this.rules = rules;
   }

   public void assignStartingMoney(List<Player> players) {
      for (Player player : players) {
         player.setMoney(this.rules.getPlayerStartingMoney());
      }
   }

}
