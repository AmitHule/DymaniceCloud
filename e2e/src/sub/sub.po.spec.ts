import { SubPo} from './sub.po';
import { browser, logging } from 'protractor';

describe('Pub.Po', () => {

  let page: SubPo;

  beforeEach(() => {
    page = new SubPo();
  });

  it('should create an instance', () => {
    expect(new SubPo()).toBeTruthy();
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



