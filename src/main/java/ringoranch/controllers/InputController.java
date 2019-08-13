package ringoranch.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import ringoranch.directors.GameDirector;
import ringoranch.util.Input;
import ringoranch.util.GameStateEvent;

@Controller
public class InputController {

	@MessageMapping("/input")
	@SendTo("/game-state")
	public GameStateEvent submitInput(Input input) {
	   if (!GameDirector.isGameRunning()) {
	      GameDirector.startGame();
      }

		return GameDirector.getGame().getLatestEvent();
	}

}
