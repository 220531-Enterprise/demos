import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Rolodex UI';

  // make it public so other components (like our login component can toggle this property)
  public isLoggedIn: boolean = false;
}
