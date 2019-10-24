import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SucessComponent } from './sucess.component';
import {DataService} from "../data.service";
import {Data} from "../data";

describe('SucessComponent', () => {
  let component: SucessComponent;
  let fixture: ComponentFixture<SucessComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      providers: [DataService,Data],
      declarations: [ SucessComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SucessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
