import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Apophthegm } from '../apophthegm';
import { ContentItemServiceService } from '../content-item-service.service';

@Component({
  selector: 'app-content-item-component-wrapper',
  templateUrl: './content-item-component-wrapper.component.html',
  styleUrls: ['./content-item-component-wrapper.component.css']
})

export class ContentItemComponentWrapperComponent {

  id : string;
  apophthegm?: Apophthegm;

  constructor(private contentitemService: ContentItemServiceService, private dialogRef: MatDialogRef<ContentItemComponentWrapperComponent>, @Inject(MAT_DIALOG_DATA) data: any) {
      this.id = data.id;
      contentitemService.getContentItemByTextId(this.id).subscribe(a => this.apophthegm = a);
  }



}
