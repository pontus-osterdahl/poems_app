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
    this.ciService.getContentItems().subscribe(contentItems => this.contentItems = contentItems);
  }

}
