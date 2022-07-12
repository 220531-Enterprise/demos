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

  username: string = '';

  // update the username (user info) based on whoever is stored in the session
  updateUserData(username: string): void {
    this.username = username;
  }

  // flush the browser's session
  signOut(): void {
    window.location.reload();
  }

}
