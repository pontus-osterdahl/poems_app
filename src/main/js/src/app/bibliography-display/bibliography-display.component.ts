import { Component, OnInit } from '@angular/core';
import { BibliographyService } from '../bibliography-service.service';
import { PoemService } from '../poem.service';
import { Poem } from '../poem';
import { Input } from '@angular/core';
import { Bibitem } from '../bibitem';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-bibliography-display',
  templateUrl: './bibliography-display.component.html',
  styleUrls: ['./bibliography-display.component.css']
})
export class BibliographyDisplayComponent implements OnInit {

  constructor(private bibliographyService : BibliographyService, private route: ActivatedRoute,
    private router: Router, private poemService : PoemService  ) { 
    
  }
  selectedId = 0;

  public poem!: Observable<Poem>;
  public bibItems: Bibitem[] = [];

  ngOnInit(): void {
    this.poem = this.route.paramMap.pipe(
      switchMap( params => {
        this.selectedId = parseInt(params.get('id')!);
        this.bibliographyService.getBibItemsByPoem(Number(this.selectedId)).subscribe(foundpoems => this.bibItems = foundpoems);
        return this.poemService.getPoemById(Number(this.selectedId));
      })
    )

    }
  }

