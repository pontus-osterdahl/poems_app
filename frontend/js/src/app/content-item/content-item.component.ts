import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ContentItem } from '../content-item';
import { ContentItemServiceService } from '../content-item-service.service';
import { Input } from '@angular/core';
import { Apophthegm } from '../apophthegm';

@Component({
  selector: 'app-content-item',
  templateUrl: './content-item.component.html',
  styleUrls: ['./content-item.component.css']
})
export class ContentItemComponent implements OnInit {

  showRelations : boolean = false;

  constructor(private ciService : ContentItemServiceService) { }

  @Input() apophthegm? : Apophthegm;
  @Output('relation')
  ciEmitter = new EventEmitter<String>();

  selectRelation(ci : String) {
    console.log("hallo")
    this.ciEmitter.emit(ci);
  }

  toggleShowRelations() {
      this.showRelations = !this.showRelations;
  }

  ngOnInit(): void {
  //  if(this.ci != null) {
  //  this.ciService.getApophthegms(this.ci.textId).subscribe(a => this.apophthegm = a);
  //}
  }
}


