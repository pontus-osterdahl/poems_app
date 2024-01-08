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

getrep() : string {
  var arr = this.break.attributes.filter((attr) => {
    return attr.name = "resp";
  })
  return arr[0].value;
}

trimBreakText() : string {
  var array = this.break.text.split("\n");
  array = array.filter((item) => {
    return item !== '';
  });
  return array.join(" "); 
}


  @Input() break : Break; 
}
