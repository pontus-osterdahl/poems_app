import { Component, OnInit } from '@angular/core';
import { BibliographyService } from '../bibliography-service.service';

@Component({
  selector: 'app-bibliography',
  templateUrl: './bibliography.component.html',
  styleUrls: ['./bibliography.component.css']
})
export class BibliographyComponent implements OnInit {

  constructor() {}
  
  ngOnInit(): void {
  }

}
