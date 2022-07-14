import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';

// describes the testing SUITE (for which components are these unit tests for )
describe('AppComponent', () => {

  beforeEach(async () => {
    // configure the environemnt for the class we want to test
    await TestBed.configureTestingModule({
      imports: [ // declare the modules we need for the component to function
        RouterTestingModule
      ],
      declarations: [
        AppComponent // app that we're testing 
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  // what are we testing for 
  it(`should have as title 'Angular Unit Testing'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    // similar to an assertion in JUnit
    expect(app.title).toEqual('Angular Unit Testing');
  });

  it('should render title in an h1 tag', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h1')?.textContent).toContain('Angular Unit Testing');
  });
});
