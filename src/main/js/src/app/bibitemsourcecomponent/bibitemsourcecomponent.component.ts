import { Component, OnInit } from '@angular/core';
import { BibliographyService } from '../bibliography-service.service';
import { BibliographySource } from '../bibliography-source';

@Component({
  selector: 'app-bibitemsourcecomponent',
  templateUrl: './bibitemsourcecomponent.component.html',
  styleUrls: ['./bibitemsourcecomponent.component.css']
})
export class BibitemsourcecomponentComponent implements OnInit {

  constructor(private bibItemService : BibliographyService) { }

  bibSource : BibliographySource = {
     name: "",
     host: "",
     interfaceType: ""
  }

  addBibSource(): void {
    console.log("tjoho");
    this.bibItemService.addBibliographySource(this.bibSource);
    console.log("tjoho");
  }

  ngOnInit(): void {
  }

}
