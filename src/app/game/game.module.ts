import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { GameRoutingModule } from './game-routing.module';
import { CreateNewGameComponent } from './create-new-game/create-new-game.component';


@NgModule({
  declarations: [CreateNewGameComponent],
  imports: [
    CommonModule,
    GameRoutingModule
  ]
})
export class GameModule { }
