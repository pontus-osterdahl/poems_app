import { Component, Input, OnInit } from '@angular/core';
import { RegText } from '../reg-text';

@Component({
  selector: 'app-reg-text',
  templateUrl: './reg-text.component.html',
  styleUrls: ['./reg-text.component.css']
})
export class RegTextComponent implements OnInit {

  constructor() { }

  @Input() text?: RegText;

  ngOnInit(): void {
  }

}
