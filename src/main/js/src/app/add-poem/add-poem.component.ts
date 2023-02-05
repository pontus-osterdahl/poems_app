import { Component, OnInit } from '@angular/core';
import { Poem } from '../poem';
import { PoemService } from '../poem.service';

@Component({
  selector: 'app-add-poem',
  templateUrl: './add-poem.component.html',
  styleUrls: ['./add-poem.component.css']
})
export class AddPoemComponent implements OnInit {

  constructor(private poemService : PoemService) { }

  poem : Poem = {
    title: "",
    text: ""
  }

  ngOnInit(): void {

  }

  addPoem(){
    console.log("tjoho");
    this.poemService.addPoem(this.poem);
    console.log("naj");
  }

}
