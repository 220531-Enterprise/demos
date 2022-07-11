import { AllComponent } from './components/all/all.component';
import { MainComponent } from './components/main/main.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './components/register/register.component';

const routes: Routes = [
  {path: 'main', component:MainComponent}, // at http://localhost:4200/main
  {path: 'all', component:AllComponent},
  {path: 'register', component:RegisterComponent},
   // a WildCard Route is used to handle unknown paths (ALWAYS goes last)
  {path: '**', component:MainComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
