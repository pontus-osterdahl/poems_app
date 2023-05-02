import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Poem } from './poem';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PoemService {

  poemsUrl = 'http://localhost:8080/poems';

  constructor( private http : HttpClient ) { 

  }

  getPoemById(id : number) : Observable<Poem> {
    return this.http.get<Poem>(this.poemsUrl + `/getPoem/${id}`);
  }

  getPoemsByWord(word: String) : Observable<Poem[]> {
      return this.http.get<Poem[]>(this.poemsUrl + "/getbyword/" + word);
  }

  getPoems() {
     return this.http.get<Poem[]>(this.poemsUrl + "/poems");
  }

  addPoem(poem: Poem){
    console.log("jobobo");
    this.http.post<Poem>(this.poemsUrl + "/addPoem", poem).subscribe(poem => poem);
  }

  

}
