import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IStartGameResponse } from '../models/istart-game-response.model';
import { environment } from "../../environments/environment";
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  	constructor(private httpClient: HttpClient) {
 	}

	public startGame(): Observable<IStartGameResponse> {
		return this.httpClient.post<IStartGameResponse>("/api/start-game", {});
	}

	public getStompClient(): Stomp.Client {
		let ws: WebSocket = new SockJS(environment.websocketUrl);
		let stompClient: Stomp.Client = Stomp.over(ws);
		return stompClient;
	}

}
