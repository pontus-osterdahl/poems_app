import { Component, OnInit } from '@angular/core';
import { Poem } from '../poem';
import { PoemService } from '../poem.service';
import { BibliographyService } from '../bibliography-service.service';

@Component({
  selector: 'app-poems',
  templateUrl: './poems.component.html',
  styleUrls: ['./poems.component.css']
})
export class PoemsComponent implements OnInit {
  
    public poems: Poem[] = [];
    public selectedPoem?: Poem;


    constructor(private poemService : PoemService, private bibliographyService : BibliographyService) { 
       
   }
  
    onSelect(poem: Poem): void {
        this.selectedPoem = poem;
    }


   
  
    ngOnInit(): void {
      this.poemService.getPoems().subscribe(foundpoems => this.poems = foundpoems);
    }

}
