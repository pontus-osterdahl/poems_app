import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { XmlPoem } from './xmlpoem';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class XmlpoemService {


  poems_url = "http://localhost:8080/xmlPoem";

  constructor(private httpClient : HttpClient) { }

  getXmlPoem(id: String) : Observable<XmlPoem> {
    console.log(this.poems_url + `/${id}`);
    return this.httpClient.get<XmlPoem>(this.poems_url + "/" + id);
  }

}
