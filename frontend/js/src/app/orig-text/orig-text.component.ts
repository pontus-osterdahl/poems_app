import { Component, Input, OnInit } from '@angular/core';
import { OrigText } from '../orig-text';

@Component({
  selector: 'app-orig-text',
  templateUrl: './orig-text.component.html',
  styleUrls: ['./orig-text.component.css']
})
export class OrigTextComponent implements OnInit {

  constructor() { }
  @Input() text?: OrigText;

 // }
 // public text : OrigText = new OrigText();

  ngOnInit(): void {
  }

}
