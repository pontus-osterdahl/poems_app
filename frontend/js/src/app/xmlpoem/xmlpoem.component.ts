import { Component, Input, OnInit } from '@angular/core';
import { XmlPoem } from '../xmlpoem';
import { XmlpoemService } from '../xmlpoem.service';
import { ContentItemServiceService } from '../content-item-service.service';
import { Apophthegm } from '../apophthegm';
import { ContentItem } from '../content-item';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { ContentItemComponent } from '../content-item/content-item.component';
import { ContentItemComponentWrapperComponent } from '../content-item-component-wrapper/content-item-component-wrapper.component';
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

  showOnHover() {
      
  }

  selectRelation(contentItem: String) {
      const dialogConfig = new MatDialogConfig();
      let dialogRef = this.dialog.open(ContentItemComponentWrapperComponent, {
        height: '400px',
        width: '600px',
        data : { id: "GV_Part01_Ch01_Chilo01_ci5" },
      });
      this.dialog.open(ContentItemComponentWrapperComponent,dialogConfig);
  }

  constructor(private contenitemService : ContentItemServiceService, private dialog: MatDialog) { }

  ngOnInit(): void {
    if(this.id != null) {
        this.contenitemService.getApophthegms(this.id).subscribe(a => this.apophthegms = a);
    }
  }

}
