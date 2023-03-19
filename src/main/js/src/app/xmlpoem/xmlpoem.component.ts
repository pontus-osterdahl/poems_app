import { Component, OnInit } from '@angular/core';
import { XmlPoem } from '../xmlpoem';
import { XmlpoemService } from '../xmlpoem.service';
@Component({
  selector: 'app-xmlpoem',
  templateUrl: './xmlpoem.component.html',
  styleUrls: ['./xmlpoem.component.css']
})
export class XmlpoemComponent implements OnInit {

  poem? : XmlPoem;

  showOrig : boolean = true;
  showReg : boolean = true;

  constructor(private xmlpoemService : XmlpoemService) { }

  ngOnInit(): void {
    console.log("log");
    this.xmlpoemService.getXmlPoem("15381").subscribe(poem => this.poem = poem);
  }

}
