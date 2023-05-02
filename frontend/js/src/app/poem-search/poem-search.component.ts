import { Component, OnInit } from '@angular/core';
import { PoemService } from '../poem.service';
import { Poem } from '../poem';

@Component({
  selector: 'app-poem-search',
  templateUrl: './poem-search.component.html',
  styleUrls: ['./poem-search.component.css']
})

export class PoemSearchComponent implements OnInit {

  public criteria = [
    "word",
    "title",
  ];

  public poems: Poem[] = [];

  public searchterm = "";

  public selectCriterium = "";

  constructor(private poemService : PoemService) { 
     
 }

 onSelected(value: string) : void {
    this.selectCriterium = value;
 }

 search(): void {
    this.poemService.getPoemsByWord(this.searchterm).subscribe(foundpoems => this.poems = foundpoems);
 }

  ngOnInit(): void {
    this.selectCriterium = this.criteria[0];
  }



}
