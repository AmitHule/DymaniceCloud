import { PubPo} from './pub.po';
import { browser, logging } from 'protractor';
import {PublishComponent} from "../../../src/app/publish/publish.component";

describe('Pub.Po', () => {

  let page: PubPo;


  beforeEach(() => {
    page = new PubPo();
  });

  it('should create an instance', () => {
    expect(new PubPo()).toBeTruthy();
  });

  it('should display Publish Your API', () => {
    page.navigateTo();
    expect(page.getTitleText()).toEqual('Publish Your API');
  });

  it('should display text', () => {
    page.navigateTo();
    expect(page.getbold()).toEqual('2. Basic Information');
  });


  it('content on button ', () => {
    page.navigateTo();
    expect(page.getbuttontext()).toEqual('Publish');
  });



  it('Should publish the API', () => {
    page.getpublish_option().sendKeys('Azure');
    page.getbasicname().sendKeys('first');
    page.getBasicdescription().sendKeys('first details');
    page.getBasicpath().sendKeys('first');
    page.getDisplayname().sendKeys('first');
    page.getbussiness_domain().sendKeys('First');
    page.getApplication_name().sendKeys('first');
    page.getchangesapp().sendKeys('first');
    page.getdefinition_upload().sendKeys('first');
    page.getbackend_url().sendKeys('first');
    page.getproduct_name().sendKeys('first');
    page.getproduct_desp().sendKeys('first');
    page.getno_of_minutes().sendKeys('12');
    page.getno_of_requests().sendKeys('16');

    page.getSubmitButton().click();

  });

});



