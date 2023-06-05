import { Component } from '@angular/core';
import { XmlpoemService } from '../xmlpoem.service';

@Component({
  selector: 'app-add-xml-poem',
  templateUrl: './add-xml-poem.component.html',
  styleUrls: ['./add-xml-poem.component.css']
})
export class AddXmlPoemComponent {

  
  constructor(private xmlpoemservice : XmlpoemService) {

  }
}
