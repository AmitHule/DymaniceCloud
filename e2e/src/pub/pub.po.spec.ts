import { PubPo} from './pub.po';
import { browser, logging } from 'protractor';

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


});



