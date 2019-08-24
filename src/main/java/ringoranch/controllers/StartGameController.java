package ringoranch.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ringoranch.util.StartGameResponse;

@RestController
public class StartGameController {

	@RequestMapping(value = "/api/start-game", method = RequestMethod.POST)
	public StartGameResponse startGame() {
		return new StartGameResponse("Starting new game");
	}

}
