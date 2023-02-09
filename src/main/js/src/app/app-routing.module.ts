import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PoemComponent } from './poem/poem.component';
import { AddPoemComponent } from './add-poem/add-poem.component';
import { PoemSearchComponent } from './poem-search/poem-search.component';
import { PoemsComponent } from './poems/poems.component';
import { BibliographyComponent } from './bibliography/bibliography.component';
import { BibliographyDisplayComponent } from './bibliography-display/bibliography-display.component';
import { BibitemsourcecomponentComponent } from './bibitemsourcecomponent/bibitemsourcecomponent.component';

const routes: Routes = [
  { path: 'poem', component: PoemComponent},
  { path: 'add-poem', component: AddPoemComponent},
  { path: 'poem-search', component: PoemSearchComponent},
  { path: 'poems', component: PoemsComponent},
  { path: 'bibliography', component: BibliographyComponent},
  { path: 'bibliographyDisplay', component: BibliographyDisplayComponent},
  { path: 'bibitemsourcecomponentComponent', component: BibitemsourcecomponentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
