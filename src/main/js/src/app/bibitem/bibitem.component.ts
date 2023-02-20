import { Component, OnInit } from '@angular/core';
import { Bibitem } from '../bibitem';
import { Input } from '@angular/core';

@Component({
  selector: 'app-bibitem',
  templateUrl: './bibitem.component.html',
  styleUrls: ['./bibitem.component.css']
})
export class BibitemComponent implements OnInit {


  @Input() bibitem?: Bibitem;

  constructor() { }

  ngOnInit(): void {
  }

}
