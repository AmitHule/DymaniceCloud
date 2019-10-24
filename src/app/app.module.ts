import { BrowserModule } from '@angular/platform-browser';
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';

import { AppComponent } from './app.component';
import { PublishComponent } from './publish/publish.component';
import {Router, Routes} from "@angular/router";
import { SucessComponent } from './sucess/sucess.component';
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {ReactiveFormsModule} from "@angular/forms";
import {DataService} from "./data.service";
import {Data} from "./data";

const appRoutes: Routes = [
  {path: '', redirectTo: '/publish', pathMatch: 'full'} ,
  { path: 'publish', component: PublishComponent },  // you must add your component here
  { path: 'success', component: SucessComponent }  // you must add your component here

];
@NgModule({
  declarations: [
    AppComponent,
    PublishComponent,
    SucessComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    ReactiveFormsModule
  ],

  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],
  providers: [DataService,Data],
  bootstrap: [AppComponent]
})
export class AppModule { }
