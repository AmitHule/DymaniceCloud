import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get(browser.baseUrl) as Promise<any>;
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
}
