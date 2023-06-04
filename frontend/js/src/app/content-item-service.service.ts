import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ContentItem } from './content-item';
import { Apophthegm } from './apophthegm';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ContentItemServiceService {


  contentItemsUrl = 'http://localhost:8080/contentItems';
  bibItemsurl = 'http://localhost:8080/bibItem';


  constructor( private http: HttpClient ) { }

  getContentItemByTextId(text : String) {
    console.log(1);
    console.log(this.contentItemsUrl + `/textId/${text}`);
    //return this.http.get<ContentItem>(this.contentItemsUrl + `/textId/${text}`);
    return this.http.get<Apophthegm>(this.contentItemsUrl + `/textId/${text}`);
  } 

  getContentItems() {
     return this.http.get<ContentItem[]>(this.contentItemsUrl);
  }

  url : String = "http://localhost:8080/contentItems/contentItemTextbyText";

  getApophthegms(id : number) {
//   return this.http.get<Apophthegm[]>("http://localhost:8080/apophthegms/" + id);
     return this.http.get<Apophthegm[]>("http://localhost:8080/contentItems/byXmlPoemId/" + id);
  }

}
