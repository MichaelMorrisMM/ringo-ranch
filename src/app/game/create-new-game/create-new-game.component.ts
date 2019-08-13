import { Component, OnInit } from '@angular/core';
import { GameService } from '../game.service';
import { IStartGameResponse } from 'src/app/models/istart-game-response.model';
import * as Stomp from 'stompjs';
import { IGameStateEvent } from 'src/app/models/igame-state-event.model';
import { IInput } from 'src/app/models/iinput.model';

@Component({
  selector: 'app-create-new-game',
  templateUrl: './create-new-game.component.html',
  styleUrls: ['./create-new-game.component.scss']
})
export class CreateNewGameComponent implements OnInit {
	
	public client: Stomp.Client;

  	constructor(private gameService: GameService) { }

  	ngOnInit() {
  	}

	public startNewGame(): void {
		this.gameService.startGame().subscribe((event: IStartGameResponse) => {
			console.log(event.note);
		}, () => {
			console.error("Start Game failed");
		});
	}
	
	public connect(): void {
		this.client = this.gameService.getStompClient();
		let that = this;
		this.client.connect({}, (frame: Stomp.Frame) => {
			console.log("Connected: " + frame);
			that.client.subscribe("/game-state", (message: Stomp.Message) => {
				let event: IGameStateEvent = JSON.parse(message.body);
				console.log(event.display);
			});
		}, (error: string | Stomp.Frame) => {
			console.error(error);
		});
	}
	
	public send(): void {
		let input: IInput = {
			action: "TEST ACTION"
		}
		let messageString = JSON.stringify(input);
		this.client.send("/app/input", {}, messageString);
	}

}
