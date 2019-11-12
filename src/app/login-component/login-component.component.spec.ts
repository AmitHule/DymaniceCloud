import { LoginComponentComponent, User } from "./login-component.component"
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { async } from 'q';

describe('Component: Login',() => {

  let component: LoginComponentComponent;
  let fixture : ComponentFixture<LoginComponentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports : [ReactiveFormsModule,FormsModule],
      declarations: [LoginComponentComponent]
    });

    fixture = TestBed.createComponent(LoginComponentComponent);
    component = fixture.componentInstance;  
    component.ngOnInit();
  });

  //Form validity blank form is invalid.
  it('form invalid when empty',() => {
      expect(component.form.valid).toBeFalsy();
  })

  // email field should initially be invalid (Field validity)
  it('email field validity', () => {
    let email = component.form.controls['email']; 
    expect(email.valid).toBeFalsy(); 
  });

  it('email required field validity', () => {
    let errors = {};
    let email = component.form.controls['email'];
    errors = email.errors || {};
    expect(errors['required']).toBeTruthy(); 
  });

  it('email required with some content field validity', () => {
    let errors = {};
    let email = component.form.controls['email'];
    email.setValue("kanika");
    errors = email.errors || {};
    expect(errors['required']).toBeFalsy(); 
  });

  
  it('email pattern not match validaty', () => {
    let errors = {};
    let email = component.form.controls['email'];
    email.setValue("kanika");
    errors = email.errors || {};
    expect(errors['pattern']).toBeTruthy(); 
  });

  it('email pattern match validaty', () => {
    let errors = {};
    let email = component.form.controls['email'];
    email.setValue("kanika@");
    errors = email.errors || {};
    expect(errors['pattern']).toBeFalsy(); 
  });

  it('password field validity', () => {
    let password = component.form.controls['password']; 
    expect(password.valid).toBeFalsy(); 
  });

  it('password field length validity', () => {
    let errors = {};
    let password = component.form.controls['password'];
    password.setValue("kanika");
    errors = password.errors || {};
    expect(errors['minLength']).toBeFalsy(); 
    //expect(password.hasError('minLength')).toBeTruthy();
  });

  // it('password field length invalidity', () => {
  //   let errors = {};
  //   let password = component.form.controls['password'];
  //   password.setValue("kanik6688");
  //   errors = password.errors || {};
  //   expect(errors['minLength']).toBeTruthy(); 
  // });

  it('submitting a form emits a user', () => {
    expect(component.form.valid).toBeFalsy();
    component.form.controls['email'].setValue("test@test.com");
    component.form.controls['password'].setValue("123456789");
    expect(component.form.valid).toBeTruthy();

    let user: User;
    // Subscribe to the Observable and store the user in a local variable.
    component.loggedIn.subscribe((value) => user = value);

    // Trigger the login function
    component.login();

    // Now we can check to make sure the emitted value is correct
    expect(user.email).toBe("test@test.com");
    expect(user.password).toBe("123456789");
  });

});
