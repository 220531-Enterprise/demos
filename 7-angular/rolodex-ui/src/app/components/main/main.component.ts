import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent  {

  title = 'Rolodex UI'
  image = "assets/network.png";

  constructor(public appComponent: AppComponent) {}

}
