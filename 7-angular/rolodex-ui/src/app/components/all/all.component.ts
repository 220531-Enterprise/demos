import { ClientMessage } from './../../models/client-message';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-all',
  templateUrl: './all.component.html',
  styleUrls: ['./all.component.css']
})
export class AllComponent implements OnInit {

  title = 'All Users'
  users: User[] = [];
  clientMessage: ClientMessage = new ClientMessage('Sorry, no users to display')

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    // WHEN the component is initialized, invoke this method! (fill up the users array with users)
    this.findAllUsers();
  }

  findAllUsers() {
    this.userService.findAllUsers()
      .subscribe(data => {
        this.users = data; // set the users property equal to the array of data returned
      })
  }
}
