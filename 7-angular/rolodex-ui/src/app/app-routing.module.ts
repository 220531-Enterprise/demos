import { AllComponent } from './components/all/all.component';
import { MainComponent } from './components/main/main.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: 'main', component:MainComponent}, // at http://localhost:4200/main
  {path: 'all', component:AllComponent},

   // a WildCard Route is used to handle unknown paths (ALWAYS goes last)
  {path: '**', component:MainComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
