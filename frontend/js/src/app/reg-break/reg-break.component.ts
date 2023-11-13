import { Component, Input } from '@angular/core';
import { Break } from 'src/break';

@Component({
  selector: 'app-reg-break',
  templateUrl: './reg-break.component.html',
  styleUrls: ['./reg-break.component.css']
})
export class RegBreakComponent {

constructor() {
  this.break = new Break();
}

  @Input() break : Break; 
}
