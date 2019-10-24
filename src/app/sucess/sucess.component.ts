import { Component, OnInit } from '@angular/core';
import {Data} from '../data';

@Component({
  selector: 'app-sucess',
  templateUrl: './sucess.component.html',
  styleUrls: ['./sucess.component.css']
})
export class SucessComponent implements OnInit {
  private _publish_option: any;
  private _basicname : any;
  private _Displayname: any;
  private _Basicdescription: any;
  private _bussiness_domain: any;
  private _Basicpath: any;
  private _Application_name: any;
  private _changesapp: any;
  private _definition_upload: any;
  private _backend_url: any;
  private _product_name: any;
  private _product_desp :any;
  private _no_of_requests:any;
  private _no_of_minutes: any;

  constructor(private data: Data) { }

  ngOnInit() {
    this._publish_option=this.data.getpublish_option();
   this._basicname=this.data.getbasicname();
    this._Displayname=this.data.getDisplayname();
   this._Basicdescription=this.data.getBasicdescription();
   this._bussiness_domain=this.data.getbussiness_domain();
  this._Basicpath=this.data.getBasicpath();
   this._Application_name=this.data.getApplication_name();
  this._changesapp=this.data.getchangesapp();
  this._definition_upload=this.data.getdefinition_upload();
  this._backend_url=this.data.getbackend_url();
  this._product_name=this.data.getproduct_name();
this._product_desp=this.data.getproduct_desp();
  this._no_of_requests=this.data.getno_of_requests();
  this._no_of_minutes=this.data.getno_of_minutes();
  console.log(this._product_desp);


  }

}
