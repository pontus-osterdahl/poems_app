import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { XmlPoem } from './xmlpoem';
import { Xmlnameid } from './xmlnameid';
import { Observable } from 'rxjs';

@Injectable({;
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

  saveXmlPoem(xmlpoem : XmlPoem, file : File) : void {

    const formdata = new FormData();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'multipart/form-data'
      })
    }
    formdata.append("xmlpoem", "xmlpoem");
    formdata.append("file", "file")

    this.httpClient.post<XmlPoem>("http://localhost:8080/saveXmlPoem", formdata, httpOptions);
  }

}
