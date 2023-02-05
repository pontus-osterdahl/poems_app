import { Injectable } from '@angular/core';
import { Poem } from './poem';

@Injectable({
  providedIn: 'root'
})
export class PoemSearchService {

  constructor() { }

  indexUrl = 'https://localhost:8080/poems';

}
