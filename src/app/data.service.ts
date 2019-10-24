import { Injectable } from '@angular/core';
import {Data} from "./data";

@Injectable({
  providedIn: 'root'
})
export class DataService {
 data_object: Data;

  constructor() { }


}
