import { Component, OnInit } from '@angular/core';
import { BibliographyService } from '../bibliography-service.service';

@Component({
  selector: 'app-bibliography-display',
  templateUrl: './bibliography-display.component.html',
  styleUrls: ['./bibliography-display.component.css']
})
export class BibliographyDisplayComponent implements OnInit {

  constructor(private bibliographyService : BibliographyService) { 
    
  }



  ngOnInit(): void {
  }

}
