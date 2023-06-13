import { Component } from '@angular/core';
import { XmlpoemService } from '../xmlpoem.service';

@Component({
  selector: 'app-add-xml-poem',
  templateUrl: './add-xml-poem.component.html',
  styleUrls: ['./add-xml-poem.component.css']
})

export class AddXmlPoemComponent {
  
  fileListToUpload?: FileList;

  constructor(private xmlpoemservice : XmlpoemService) {}
  
  onFileChange(event: Event) {
  
    const element = event.currentTarget as HTMLInputElement;
  
    let fileList: FileList | null = element.files;
      
    if (fileList && fileList.length > 0) {
      this.fileListToUpload = fileList;
    }
  }
  
  onSubmit() {
    if (this.fileListToUpload && this.fileListToUpload.length > 0) {
      this.xmlpoemservice.saveXmlPoem(this.fileListToUpload[0]);
    }
  }
}
