package ringoranch.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import ringoranch.directors.GameDirector;
import ringoranch.util.Input;
import ringoranch.util.GameStateEvent;

@Controller
public class InputController {

	@MessageMapping("/api/input")
	@SendTo("/game-state")
	public GameStateEvent submitInput(Input input) {
	   if (!GameDirector.isGameRunning()) {
	      GameDirector.startGame();
      }

	   GameDirector.processInput(input);

		return GameDirector.getGame().getLatestEvent();
	}

}
