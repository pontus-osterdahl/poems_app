import { Component, OnInit } from '@angular/core';
import { ContentItem } from '../content-item';
import { ContentItemServiceService } from '../content-item-service.service';

@Component({
  selector: 'app-text-presentation',
  templateUrl: './text-presentation.component.html',
  styleUrls: ['./text-presentation.component.css']
})
export class TextPresentationComponent implements OnInit {

  constructor(private ciService: ContentItemServiceService) { }

  contentItems : ContentItem[] = [];

  ngOnInit(): void {
    console.log("1");
    this.ciService.getContentItems().subscribe(contentItems => this.contentItems = contentItems);
//    console.log(this.ciService.getContentItemByTextId("GV_Part01_A01_Antisthenes01_ci1"));

  }

}
