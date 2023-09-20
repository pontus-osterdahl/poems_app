import { Component, Input } from '@angular/core';
import { XmlpoemService } from '../xmlpoem.service';
import { TeiHeader } from '../tei-header';

@Component({
  selector: 'app-teiheader',
  templateUrl: './teiheader.component.html',
  styleUrls: ['./teiheader.component.css']
})
export class TeiheaderComponent {

    
  @Input() xmlid? : number;

  teiHeader? : TeiHeader;

  constructor(private xmlPoemService : XmlpoemService) {}

  ngOnInit() : void {
    if(this.xmlid != null) {
      this.xmlPoemService.getTeiHeader(this.xmlid).subscribe(a => this.teiHeader = a);
  }
}
}
  

