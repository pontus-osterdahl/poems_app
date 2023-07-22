import { Component, OnInit } from '@angular/core';
import { XmlPoem } from '../xmlpoem';
import { XmlpoemService } from '../xmlpoem.service';
import { FormControl } from '@angular/forms';
import { SearchType } from '../search-type';

@Component({
  selector: 'app-xmlpoemsearch',
  templateUrl: './xmlpoemsearch.component.html',
  styleUrls: ['./xmlpoemsearch.component.css']
})
export class XmlpoemsearchComponent implements OnInit{
  
  public criteria = [
    "all",
    "word",
    "title",
  ];

  public poems: XmlPoem[] = [];

  searchterm = new FormControl('');

  public selectCriterium = "";

  constructor(private poemService : XmlpoemService) { 
     
 }

 onSelected(value: string) : void {
    this.selectCriterium = value;
 }

 search(): void {
   /**  switch (this.selectCriterium) {
      case "all": {
        this.poemService.getPoemsByAll();
        break;
      }
      case "title": {
        this.poemService.getPoemsByTitle();
        break;
      }
      case "word": {
        this.poemService.getPoemsByWord();
        break;
      }
     
    }*/
    if (this.searchterm.value != null)
        this.poemService.getPoemsByWord(SearchType.ALL,this.searchterm.value).subscribe(foundpoems => this.poems = foundpoems);
 }

  ngOnInit(): void {
    this.selectCriterium = this.criteria[0];
  }



}
