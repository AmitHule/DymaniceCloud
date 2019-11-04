import { browser, by, element } from 'protractor';
import {PublishComponent} from "../../../src/app/publish/publish.component";

export class PubPo {

  registerForm: PublishComponent;

  navigateTo() {
    return browser.get('/')
  }

  getTitleText() {
    return element(by.css('app-root h3')).getText() as Promise<string>;
  }

  getbold()
  {
    return element(by.css('app-root b')).getText() as Promise<string>;
  }
  getbuttontext()
  {
    return element(by.css('#publish')).getText() as Promise<string>;
  }

  getpublish_option()
  {
   return element(by.css("input[formControlName=publish_option]: checked")).getAttribute('Azure');
  }
  getbasicname()
  {
    return element(by.css("input[formControlName=basicname]"));
  }
  getDisplayname()
  {
    return element(by.css("input[formControlName=Displayname]"));
  }
  getBasicdescription(){
    return element(by.css("input[formControlName=Basicdescription]"));
  }

  getbussiness_domain(){
    return element(by.css("input[formControlName=bussiness_domain]"));
  }
  getBasicpath(){
    return element(by.css("input[formControlName=Basicpath]"));
  }
  getApplication_name(){
    return element(by.css("input[formControlName=Application_name]"));
  }
  getchangesapp(){
    return element(by.css("input[formControlName=changesapp]"));
  }
  getdefinition_upload(){
    return element(by.css("input[formControlName=definition_upload]"));
  }
  getbackend_url(){
    return element(by.css("input[formControlName=backend_url]"));
  }
  getproduct_name(){
    return element(by.css("input[formControlName=product_name]"));
  }
  getproduct_desp(){
    return element(by.css("input[formControlName=product_desp]"));
  }
  getno_of_requests(){
    return element(by.css("input[formControlName=no_of_requests]"));

  }
  getno_of_minutes(){
    return element(by.css("input[formControlName=no_of_minutes]"));

  }

  getSubmitButton()
  {
    return element(by.css('#publish'));
  }

}
