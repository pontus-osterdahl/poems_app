import { Component } from '@angular/core';
import { XmlpoemService } from '../xmlpoem.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { XmlPoem } from '../xmlpoem';

@Component({
  selector: 'app-add-xml-poem',
  templateUrl: './add-xml-poem.component.html',
  styleUrls: ['./add-xml-poem.component.css']
})
export class AddXmlPoemComponent {

  xmlpoemGroup = new FormGroup( {
  xmlpoemTitle: new FormControl('', [Validators.required]),
  xmlpoemFile: new FormControl(null, [Validators.required]),
  xmlpoemFilePath: new FormControl('', [Validators.required])
  });
  constructor(private xmlpoemservice : XmlpoemService) {

  }

  onSubmit() {
    if (this.xmlpoemGroup.value.xmlpoemFile && this.xmlpoemGroup.value.xmlpoemFilePath && this.xmlpoemGroup.value.xmlpoemTitle) {
        let newpoem = new XmlPoem();
        newpoem.name = this.xmlpoemGroup.value.xmlpoemTitle;
        newpoem.filepath = this.xmlpoemGroup.value.xmlpoemFilePath;
        this.xmlpoemservice.saveXmlPoem(newpoem,this.xmlpoemGroup.value.xmlpoemFile);
    }
  }
}
