import { Component, Input, OnInit } from '@angular/core';
import { XmlPoem } from '../xmlpoem';
import { XmlpoemService } from '../xmlpoem.service';
import { ContentItemServiceService } from '../content-item-service.service';
import { Apophthegm } from '../apophthegm';
@Component({
  selector: 'app-xmlpoem',
  templateUrl: './xmlpoem.component.html',
  styleUrls: ['./xmlpoem.component.css']
})
export class XmlpoemComponent implements OnInit {

  poem? : XmlPoem;
  apophthegms : Apophthegm[] = [];

  @Input() id? : number;

  showOrig : boolean = true;
  showReg : boolean = true;

  

  constructor(private contenitemService : ContentItemServiceService) { }

  ngOnInit(): void {
    if(this.id != null) {
        this.contenitemService.getApophthegms(this.id).subscribe(a => this.apophthegms = a);
    }
  }

}
