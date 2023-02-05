import { Component, Input, OnInit } from '@angular/core';
import { Poem } from '../poem';

@Component({
  selector: 'app-poem',
  templateUrl: './poem.component.html',
  styleUrls: ['./poem.component.css']
})
export class PoemComponent implements OnInit {

  constructor() { }
  
  @Input() poem?: Poem;



  

  ngOnInit(): void {
    
  }

}
