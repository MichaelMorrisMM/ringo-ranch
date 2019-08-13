import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IStartGameResponse } from '../models/istart-game-response.model';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  	constructor(private httpClient: HttpClient) { 
 	}

	public startGame(): Observable<IStartGameResponse> {
		return this.httpClient.post<IStartGameResponse>("/start-game", {});
	}
	
	public getStompClient(): Stomp.Client {
		let ws: WebSocket = new SockJS("http://localhost:8080/websocket");
		let stompClient: Stomp.Client = Stomp.over(ws);
		return stompClient;
	} 

}
