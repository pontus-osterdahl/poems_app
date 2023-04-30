import { Component, OnInit } from '@angular/core';
import { XmlpoemService } from '../xmlpoem.service';
import { Xmlnameid } from '../xmlnameid';

@Component({
  selector: 'app-xmlpoems',
  templateUrl: './xmlpoems.component.html',
  styleUrls: ['./xmlpoems.component.css']
})
export class XmlpoemsComponent implements OnInit {

  showItem : boolean = false;
  xmlpoems : Xmlnameid[] = []

  shownpoems: number[] = []


  show(xmlnameid : number): void {
    
      const index = this.shownpoems.indexOf(xmlnameid, 0);
      if (index > -1) {
        this.shownpoems.splice(index, 1);
      }
      else {
        this.shownpoems.push(xmlnameid);
      }
  }

  tobeshown(xmlnameid : number): boolean {
    return this.shownpoems.includes(xmlnameid);
  }

  constructor(private xmlpoemService : XmlpoemService) { }

  ngOnInit(): void {
    this.xmlpoemService.getXmlNames().subscribe(name => this.xmlpoems = name);
  }

}
