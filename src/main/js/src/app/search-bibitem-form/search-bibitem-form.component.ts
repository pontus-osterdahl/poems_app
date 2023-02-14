import { Component, OnInit } from '@angular/core';
import { BibliographyService } from '../bibliography-service.service';
import { BibliographySource } from '../bibliography-source';
import { Bibitem } from '../bibitem';

@Component({
  selector: 'app-search-bibitem-form',
  templateUrl: './search-bibitem-form.component.html',
  styleUrls: ['./search-bibitem-form.component.css']
})

export class SearchBibitemFormComponent implements OnInit {

  public bibItemSources: BibliographySource[] = []
  public selectedBibItemSource?: BibliographySource;
  public query: String = "";
  public maxRecords?: Number;
  public result: Bibitem[] = [];

  constructor(private bibliographyService : BibliographyService) { }

  public getBibItemSources() : void {
    this.bibliographyService.getBibliographySources().subscribe(found => this.bibItemSources = found);
    console.log(this.bibItemSources);
  }

  public performQuery(id : number) : void {
    this.bibliographyService.getBibItemsFromSource(id, this.query, this.maxRecords).subscribe(result => this.result = result);
  }

  ngOnInit(): void {
    this.getBibItemSources();
  }

}
