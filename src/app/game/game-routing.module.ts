import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateNewGameComponent } from './create-new-game/create-new-game.component';


const routes: Routes = [
	{
		path: 'new',
		component: CreateNewGameComponent
	}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GameRoutingModule { }
