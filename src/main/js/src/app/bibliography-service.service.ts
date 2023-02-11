import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BibliographyComponent } from './bibliography/bibliography.component';
import { BibliographySource } from './bibliography-source';
import { Observable } from 'rxjs';
import { Bibitem } from './bibitem';

@Injectable({
  providedIn: 'root'
})

export class BibliographyService {


  poemsUrl = 'http://localhost:8080/bibItemSources';

  constructor( private http : HttpClient ) { 

  }

  getBibItemsFromSource(id: number, query: String) {
     return this.http.get<Bibitem[]>(`http://localhost:8080/getResultsFromBibItemSourceQuery?id=${id}&query=${query}`);
  }

  getBibliographySources() {
     return this.http.get<BibliographySource[]>(this.poemsUrl);
  }

  addBibliographySource(bibliographySource: BibliographySource){
    console.log("jobobo");
    this.http.post<BibliographySource>(this.poemsUrl, bibliographySource).subscribe(bibliographySource => bibliographySource);
  }


}
