import { PubPo} from './pub.po';
import { browser, logging } from 'protractor';
import {PublishComponent} from "../../../src/app/publish/publish.component";

describe('Pub.Po', () => {

  let page: PubPo;


  beforeEach(async () => {
    page = new PubPo();
    await page.navigateTo();

  });


  it('should ', async () => {

    //await page.getpublish_option().sendKeys('Azure');
    await page.getbasicname().sendKeys('first');
    await page.getBasicdescription().sendKeys('first details');
    await page.getBasicpath().sendKeys('first');
    await page.getDisplayname().sendKeys('first');
   // await page.getbussiness_domain().sendKeys('First');
    await page.getApplication_name().sendKeys('first');
    await page.getchangesapp().sendKeys('first');
    await page.getdefinition_upload().sendKeys('first');
    await page.getbackend_url().sendKeys('first');
    await page.getproduct_name().sendKeys('first');
  //  await page.getproduct_desp().sendKeys('first');
    await page.getno_of_minutes().sendKeys('12');
    await page.getno_of_requests().sendKeys('16');
    await browser.driver.sleep(5000);
   // await page.getSubmitButton().click();
  });


});



