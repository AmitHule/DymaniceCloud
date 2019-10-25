import {async, ComponentFixture, fakeAsync, inject, TestBed, tick} from '@angular/core/testing';
import {ReactiveFormsModule} from "@angular/forms";
import { PublishComponent } from './publish.component';
import {RouterTestingModule} from "@angular/router/testing";
import {DataService} from "../data.service";
import {Data} from "../data";
import {By} from "@angular/platform-browser";
import {Router,RouterModule} from "@angular/router";
import {AppComponent} from "../app.component";
import {SucessComponent} from "../sucess/sucess.component";
import {Location} from "@angular/common";



describe('PublishComponent', () => {
  let component: PublishComponent;
  let router: Router;
  let location: Location;
  let fixture;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [ReactiveFormsModule,
        RouterTestingModule.withRoutes([
          {path: '', redirectTo: '/publish', pathMatch: 'full'} ,
          { path: 'publish', component: PublishComponent },  // you must add your component here
          { path: 'success', component: SucessComponent }
        ]),
        RouterTestingModule,
        RouterModule
      ],
      providers: [DataService, Data,Location],
      declarations: [PublishComponent,AppComponent,SucessComponent]
    })
      .compileComponents();
    router = TestBed.get(Router);
    location = TestBed.get(Location);
    fixture = TestBed.createComponent(AppComponent);
    router.initialNavigation();
  }));


  beforeEach(() => {
    fixture = TestBed.createComponent(PublishComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it("fakeAsync works", fakeAsync(() => {
    let promise = new Promise(resolve => {
      setTimeout(resolve, 10);
    });
    let done = false;
    promise.then(() => (done = true));
    tick(50);
    expect(done).toBeTruthy();
  }));



  it('navigate to " " redirects you to /publish', fakeAsync(() => {
    router.navigate(['']);
    tick();
    console.log(location.path());
   expect(location.path()).toBe('/publish');
  }));


  it('navigate to "success" takes you to /sucess', fakeAsync(() => {
    router.navigate(['publish']);
    tick();
    console.log(location.path());
   expect(location.path()).toBe('success');
  }));

  it('should navigate to success  page when user clicked publish button',
    async(inject([Router], (routerLocal: Router) => {
        const newAuditButton = fixture.debugElement.query(By.css('#publish'));
        newAuditButton.nativeElement.click();
        fixture.whenStable().then(() => {
          expect(routerLocal.url).toEqual('/success');
          console.log(location.path());
        });
      }
    )));


  it('on submit', async(() => {
    component.onSubmit();
    fixture.detectChanges();
    expect(component.submitted).toBeTruthy();
    fixture.detectChanges();
  }));

  it('name field validity', () => {
    let basicname = component.registerForm.controls['basicname'];
    expect(basicname.valid).toBeFalsy();


    basicname.setValue("");
    console.log(component.registerForm.value.basicname);
    expect( component.onSubmit()).toBeTruthy();
    expect(basicname.hasError('required')).toBeTruthy();
    fixture.detectChanges();

    basicname.setValue("Srishti");
    expect(basicname.hasError('minLength')).toBeFalsy();
    expect( component.onSubmit()).toBeTruthy();
    console.log(component.registerForm.value.basicname);
  });


  it('display name field validity', () => {
    let displayname = component.registerForm.controls['Displayname'];
    expect(displayname.valid).toBeFalsy();

    displayname.setValue("");
    console.log(component.registerForm.value.Displayname);
    expect(displayname.hasError('required')).toBeTruthy();
    fixture.detectChanges();

    displayname.setValue("VolkswagenITS");
    expect(displayname.hasError('minLength')).toBeFalsy();
    console.log(component.registerForm.value.Displayname);
  });


  it('Description', () => {
    let desp = component.registerForm.controls['Basicdescription'];
    expect(desp.valid).toBeFalsy();

    desp.setValue("");
    console.log(component.registerForm.value.Basicdescription);
    expect(desp.hasError('required')).toBeTruthy();
    fixture.detectChanges();
    desp.setValue("abc");
    console.log(component.registerForm.value.Basicdescription);
    expect(desp.hasError('required')).toBeFalsy();
    fixture.detectChanges();

    desp.setValue("VolkswagenITS");
    expect(desp.hasError('minLength')).toBeFalsy();
    console.log(component.registerForm.value.Basicdescription);
  });


  it('Basicpath', () => {
    let path = component.registerForm.controls['Basicpath'];
    expect(path.valid).toBeFalsy();

    path.setValue("");

    expect(path.hasError('required')).toBeTruthy();
    fixture.detectChanges();

    path.setValue("VolkswagenITS");
    expect(path.hasError('minLength')).toBeFalsy();

  });


  it('Application_name', () => {
    let app = component.registerForm.controls['Application_name'];
    expect(app.valid).toBeFalsy();

    app.setValue("");
    expect(app.hasError('required')).toBeTruthy();
    fixture.detectChanges();

    app.setValue("VolkswagenITS");
    expect(app.hasError('minLength')).toBeFalsy();

  });


  it(' definition_upload  swagger,open API', () => {
    let upload = component.registerForm.controls['definition_upload'];
    expect(upload.valid).toBeFalsy();

    upload.setValue("");
    expect(upload.hasError('required')).toBeTruthy();
    fixture.detectChanges();

    upload.setValue("VolkswagenITS");
    expect(upload.hasError('minLength')).toBeFalsy();

  });


  it('backend_url', () => {
    let url = component.registerForm.controls['backend_url'];
    expect(url.valid).toBeFalsy();

    url.setValue("");

    expect(url.hasError('required')).toBeTruthy();
    fixture.detectChanges();

    url.setValue("VolkswagenITS");
    expect(url.hasError('minLength')).toBeFalsy();

  });


  it('product_name:', () => {
    let pname = component.registerForm.controls['product_name'];
    expect(pname.valid).toBeFalsy();

    pname.setValue("");

    expect(pname.hasError('required')).toBeTruthy();
    fixture.detectChanges();
    pname.setValue("VolkswagenITS");
    expect(pname.hasError('minLength')).toBeFalsy();

  });


  it('product_desp', () => {
    let product_desp = component.registerForm.controls['product_desp'];
    expect(product_desp.valid).toBeFalsy();

    product_desp.setValue("");
    expect(product_desp.hasError('required')).toBeTruthy();
    fixture.detectChanges();

    product_desp.setValue("VolkswagenITS");
    expect(product_desp.hasError('minLength')).toBeFalsy();

  });


  it('no_of_requests', () => {
    let requests = component.registerForm.controls['no_of_requests'];
    expect(requests.valid).toBeFalsy();

    requests.setValue("");
    expect(requests.hasError('required')).toBeTruthy();
    fixture.detectChanges();

    requests.setValue("VolkswagenITS");
    expect(requests.hasError('minLength')).toBeFalsy();
    console.log(component.registerForm.value.no_of_requests);
  });


  it('Time in Minutes', () => {
    let mins = component.registerForm.controls['no_of_minutes'];
    expect(mins.valid).toBeFalsy();

    mins.setValue("");
    console.log(component.registerForm.value.no_of_minutes);
    expect(mins.hasError('required')).toBeTruthy();
    fixture.detectChanges();

    mins.setValue("VolkswagenITS");
    expect(mins.hasError('minLength')).toBeFalsy();
    console.log(component.registerForm.value.no_of_minutes);
  });

  it('Bussiness DOMAIN', () => {
    const select = fixture.debugElement.query(By.css('#business')).nativeElement;
    select.value = select.options[1].value;  // <-- select a new value
    select.dispatchEvent(new Event('change'));
    fixture.detectChanges();

    console.log(select.value);
  });












});

