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
  showinfopoems: number[] = []


  showInfo(xmlnameid : number): void {
    
    const index = this.showinfopoems.indexOf(xmlnameid, 0);
    if (index > -1) {
      this.showinfopoems.splice(index, 1);
    }
    else {
      this.showinfopoems.push(xmlnameid);
    }
}

infotobeshown(xmlnameid : number): boolean {
  return this.showinfopoems.includes(xmlnameid);
}

  show(xmlnameid : number): void {
    
      const index = this.shownpoems.indexOf(xmlnameid, 0);
      if (index > -1) {
        this.shownpoems.splice(index, 1);
      }
      else {
        this.shownpoems.push(xmlnameid);
      }
  }

  delete(xmlnameid : number): void {
    this.xmlpoemService.deleteXmlPoem(xmlnameid).subscribe(p => this.getXmlNames());
  }

  tobeshown(xmlnameid : number): boolean {
    return this.shownpoems.includes(xmlnameid);
  }

  constructor(private xmlpoemService : XmlpoemService) { }

  getXmlNames(): void {
    this.xmlpoemService.getXmlNames().subscribe(name => this.xmlpoems = name);

  }

  ngOnInit(): void {
    this.getXmlNames();
  }

}
