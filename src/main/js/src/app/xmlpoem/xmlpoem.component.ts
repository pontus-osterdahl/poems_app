import { Component, Input, OnInit } from '@angular/core';
import { XmlPoem } from '../xmlpoem';
import { XmlpoemService } from '../xmlpoem.service';
@Component({
  selector: 'app-xmlpoem',
  templateUrl: './xmlpoem.component.html',
  styleUrls: ['./xmlpoem.component.css']
})
export class XmlpoemComponent implements OnInit {

  poem? : XmlPoem;

  @Input() id? : number;

  showOrig : boolean = true;
  showReg : boolean = true;

  constructor(private xmlpoemService : XmlpoemService) { }

  ngOnInit(): void {
    console.log("log");
    if(this.id != null) {
        this.xmlpoemService.getXmlPoem(this.id).subscribe(poem => this.poem = poem);
    }
  }

}
