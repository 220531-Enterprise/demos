import { BrowserModule, By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';
import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { ContactComponent } from './contact.component';

// Define the test suite
describe('ContactComponent', () => {
  let component: ContactComponent;
  let fixture: ComponentFixture<ContactComponent>;
  let de: DebugElement; //  using this element you can query the dom for further tests
  let el: HTMLElement; // used to store elements retrieved with the debug elemetn

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContactComponent ],
      imports: [
        FormsModule,
        ReactiveFormsModule,
        BrowserModule
      ]
    })
    // AFTER we've compiled our components, intialize our variables to test
    .compileComponents().then(() => {
      
    fixture = TestBed.createComponent(ContactComponent);
    component = fixture.componentInstance;
    
     // we are testing the beahvior of the FORM
    de = fixture.debugElement.query(By.css('form')) // import from the same place you got BrowserModule
    el = de.nativeElement;  // save the queried form element to a variable
    });
  }); 

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should set submitted to true', waitForAsync(() => {
    component.onSubmit(); // WHEN this happens
    expect(component.submitted).toBeTruthy(); // we expect the property to be changed
  }))

  // test for a falsey form
  it('form should be invalid', waitForAsync(() => {

    component.contactForm.controls['email'].setValue('bobmail'); // no @ , ., violates validator
    component.contactForm.controls['name'].setValue('bob');
    component.contactForm.controls['text'].setValue('');

    expect(component.contactForm.valid).toBeFalsy();
  }))

  // ng test

});
