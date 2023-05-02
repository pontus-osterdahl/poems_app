import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { XmlPoem } from './xmlpoem';
import { Xmlnameid } from './xmlnameid';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class XmlpoemService {


  poems_url = "http://localhost:8080/xmlPoem";
  poemnames_url = "http://localhost:8080/xmlPoemNames";

  constructor(private httpClient : HttpClient) { }

  getXmlPoem(id: number) : Observable<XmlPoem> {
    console.log(this.poems_url + `/${id}`);
    return this.httpClient.get<XmlPoem>(this.poems_url + "/" + id);
  }

  getXmlNames() : Observable<Xmlnameid[]> {
    return this.httpClient.get<Xmlnameid[]>(this.poemnames_url);
  }

}
