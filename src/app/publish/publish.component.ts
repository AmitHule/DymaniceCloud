import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl,FormBuilder,Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {DataService} from "../data.service";
import {Data} from "../data";


@Component({
  selector: 'app-publish',
  templateUrl: './publish.component.html',
  styleUrls: ['./publish.component.css']
})
export class PublishComponent implements OnInit {

  business: ['first','sec','third'];
  registerForm: FormGroup;

  submitted = false;

  constructor(private  data: Data,private router: Router, private formBuilder: FormBuilder) {
  }


  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      publish_option: ['', Validators.required],
      basicname : ['', Validators.required],
      Displayname: ['', [Validators.required]],
      Basicdescription: ['', [Validators.required]],
      bussiness_domain: ['', [Validators.required]],
      Basicpath: ['', [Validators.required]],
      Application_name: ['', [Validators.required]],
      changesapp: ['', [Validators.required]],
      definition_upload: ['', [Validators.required]],
      backend_url: ['', [Validators.required]],
      product_name: ['', [Validators.required]],
      product_desp: ['', [Validators.required]],
      no_of_requests: ['', [Validators.required]],
      no_of_minutes: ['', [Validators.required]]

    });
  }

  onSubmit(): void {
    this.submitted=true;

   this.data.setpublish_option(this.registerForm.value.publish_option);
    this.data.setbasicname(this.registerForm.value.basicname);
    this.data.setDisplayname(this.registerForm.value.Displayname);
    this.data.setBasicdescription(this.registerForm.value.Basicdescription);
    this.data.setbussiness_domain(this.registerForm.value.bussiness_domain);
    this.data.setBasicpath(this.registerForm.value.Basicpath);
    this.data.setApplication_name(this.registerForm.value.Application_name);
    this.data.setchangesapp(this.registerForm.value.changesapp);
    this.data.setdefinition_upload(this.registerForm.value.definition_upload);
    this.data.setbackend_url(this.registerForm.value.backend_url);
    this.data.setproduct_name(this.registerForm.value.product_name);
    this.data.setproduct_desp(this.registerForm.value.product_desp);
    this.data.setno_of_requests(this.registerForm.value.no_of_requests);
    this.data.setno_of_minutes(this.registerForm.value.no_of_minutes);
 //console.log(this.registerForm.value.product_desp);
 this.router.navigate(['success']);
  }


}
