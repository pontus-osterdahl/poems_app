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

  show(): void {
    console.log("hallo","hallo");
    if (this.showItem == false) {
      this.showItem = true;
    }
    else {
      this.showItem = false;
    }

    //this.showItem = this.showItem == false ? true : false;
  }

  constructor(private xmlpoemService : XmlpoemService) { }

  ngOnInit(): void {
    this.xmlpoemService.getXmlNames().subscribe(name => this.xmlpoems = name);
  }

}
