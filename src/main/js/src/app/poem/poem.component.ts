import { Component, Input, OnInit } from '@angular/core';
import { Poem } from '../poem';
import { Bibitem } from '../bibitem';
import { BibliographyService } from '../bibliography-service.service';

@Component({
  selector: 'app-poem',
  templateUrl: './poem.component.html',
  styleUrls: ['./poem.component.css']
})
export class PoemComponent implements OnInit {


  
  @Input() poem?: Poem;
  public displayBibliography: boolean = false;
  public bibItems : Bibitem[] = [];


  showBibliography(): void {
    if(this.displayBibliography == false) {
      this.displayBibliography = true;
      if (this.poem != null) {
      //this.bibliographyService.getBibItemsByPoem(this.poem.id).subscribe(foundBibItems => this.bibItems = foundBibItems);
      }
    } 
    else {
      this.displayBibliography = false;
      this.bibItems = [];
    }
  }
  
  constructor() {
      
  }

  ngOnInit(): void {
  }

}
