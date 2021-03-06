import { AppPage } from './app.po';
import { browser, logging } from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
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
