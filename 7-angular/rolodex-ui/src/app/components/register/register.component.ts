import { UserService } from 'src/app/services/user.service';
import { ClientMessage } from './../../models/client-message';
import { Component, OnInit } from '@angular/core';
import { Address, User } from 'src/app/models/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  title = 'Register User'

  user: User = new User(0, ``, ``, ``, ``, ``,[])
  address: Address = new Address('', '', '', '', '');
  clientMessage: ClientMessage = new ClientMessage('');

  constructor(private userService: UserService) { }

  registerUser(): void {

    this.user.addresses.push(this.address);

    this.userService.registerUser(this.user)
    .subscribe(
      data => this.clientMessage.message = `Successfully Registered ${data.firstName}`,
      error => this.clientMessage.message = `Something went wrong.  Error ${error}`
    )
  }


}
