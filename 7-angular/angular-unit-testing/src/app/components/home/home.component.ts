import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  propertyToPass: string = `I'm passing data!!!!!`
  
  constructor() { }

  ngOnInit(): void {
  }

}
