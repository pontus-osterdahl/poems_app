import { Component, OnInit } from '@angular/core';
import { ContentItem } from '../content-item';
import { ContentItemServiceService } from '../content-item-service.service';
import { Input } from '@angular/core';
@Component({
  selector: 'app-content-item',
  templateUrl: './content-item.component.html',
  styleUrls: ['./content-item.component.css']
})
export class ContentItemComponent implements OnInit {

  constructor(private ciService : ContentItemServiceService) { }

  @Input() ci? : ContentItem;

  ngOnInit(): void {

  }

}
