import { Component, OnInit, Input } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
}) // child component
export class ContactComponent {

  // I'm informing the app that the parent component will pass data to this component
  @Input() someProperty: string = '';

  text: string = 'contact page';
  contactForm: FormGroup; // this property may remain undefined by changing line 8 of your tsconfig.json

  contact = {
    name: '',
    email: '',
    text: ''
  }

  submitted: boolean = false;
// ngOnInit is called AFTER the constrcutor

  constructor() {
    // when the component is instatiated , set the controls for the form group
    this.createForm();
   }

   // because we passed this thru the constructor, we invoke the method when it's instantiated
  createForm(): void {
    // the purpose of this form is to build a contact object
    this.contactForm = new FormGroup({
      'name': new FormControl(this.contact.name, [
          Validators.required, // there needs to be some text!
          Validators.minLength(4)
      ]),
      'email': new FormControl(this.contact.email, [
          Validators.required,
          Validators.email
      ]),
      'text': new FormControl(this.contact.text, Validators.required)
  });
  }

  onSubmit(): void  {
    this.submitted = true;
  }
}
