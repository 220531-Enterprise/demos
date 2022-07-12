import { UserService } from 'src/app/services/user.service';
import { ClientMessage } from './../../models/client-message';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';


@Component({
  selector: 'app-find',
  templateUrl: './find.component.html',
  styleUrls: ['./find.component.css']
})
export class FindComponent {

  title: string = 'Find User By Id'
  userId: number = 0;
  user: User = new User(0, '', '', '', '', '', [])
  clientMessage: ClientMessage = new ClientMessage('');

  constructor(private userService: UserService) { }

  findUser() {
    // call the user service's findUserById() method and  pass that thru
    this.userService.findUserById(this.userId)
      .subscribe(
        data => {
          this.user = data;
          this.clientMessage.message = '';
        },
        // rejection callback in the case it doesn't work out
        () => this.clientMessage.message = `Can't find the User with id ${this.userId}`
      );
  }
}
