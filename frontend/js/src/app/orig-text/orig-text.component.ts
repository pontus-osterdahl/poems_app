import { Component, OnInit } from '@angular/core';
import { OrigText } from '../orig-text';

@Component({
  selector: 'app-orig-text',
  templateUrl: './orig-text.component.html',
  styleUrls: ['./orig-text.component.css']
})
export class OrigTextComponent implements OnInit {

  constructor() { }
  public text : OrigText = new OrigText();

  ngOnInit(): void {
  }

}
