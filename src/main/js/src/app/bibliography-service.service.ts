import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BibliographyComponent } from './bibliography/bibliography.component';
import { BibliographySource } from './bibliography-source';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class BibliographyService {


  poemsUrl = 'http://localhost:8080/bibItemSources';

  constructor( private http : HttpClient ) { 

  }

  getBibliographySources() {
     return this.http.get<BibliographySource[]>(this.poemsUrl);
  }

  addBibliographySource(bibliographySource: BibliographySource){
    console.log("jobobo");
    this.http.post<BibliographySource>(this.poemsUrl, bibliographySource);
  }


}
