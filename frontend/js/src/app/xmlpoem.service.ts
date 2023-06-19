import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { XmlPoem } from './xmlpoem';
import { Xmlnameid } from './xmlnameid';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class XmlpoemService {

  savepoems_url = "http://localhost:8080/save-poem";
  poems_url = "http://localhost:8080/xmlPoem";
  poemnames_url = "http://localhost:8080/xmlPoemNames";

  constructor(private httpClient : HttpClient) { }

  getXmlPoem(id: number) : Observable<XmlPoem> {
    return this.httpClient.get<XmlPoem>(this.poems_url + "/" + id);
  }

  getXmlNames() : Observable<Xmlnameid[]> {
    return this.httpClient.get<Xmlnameid[]>(this.poemnames_url);
  }

  saveXmlPoem(file : File) : void {
    const formdata = new FormData();
    formdata.append("file", file);
    this.httpClient.post<XmlPoem>(this.savepoems_url, formdata).subscribe(); 
  }

}
