import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PoemComponent } from './poem/poem.component';
import { AddPoemComponent } from './add-poem/add-poem.component';
import { PoemSearchComponent } from './poem-search/poem-search.component';
import { PoemsComponent } from './poems/poems.component';
import { BibliographyComponent } from './bibliography/bibliography.component';
import { BibliographyDisplayComponent } from './bibliography-display/bibliography-display.component';
import { BibitemsourcecomponentComponent } from './bibitemsourcecomponent/bibitemsourcecomponent.component';
import { SearchBibitemFormComponent } from './search-bibitem-form/search-bibitem-form.component';
import { ContentItemComponent } from './content-item/content-item.component';
import { TextPresentationComponent } from './text-presentation/text-presentation.component';
import { XmlpoemComponent } from './xmlpoem/xmlpoem.component';
import { XmlpoemsComponent } from './xmlpoems/xmlpoems.component';

const routes: Routes = [
  { path: 'poem', component: PoemComponent},
  { path: 'add-poem', component: AddPoemComponent},
  { path: 'poem-search', component: PoemSearchComponent},
  { path: 'poems', component: PoemsComponent},
  { path: 'bibliography', component: BibliographyComponent},
  { path: 'bibliographydisplay/:id', component: BibliographyDisplayComponent},
  { path: 'bibitemsourcecomponentComponent', component: BibitemsourcecomponentComponent},
  { path: 'searchbibitemform', component: SearchBibitemFormComponent},
  { path: 'contentItem', component: ContentItemComponent},
  { path: 'contentItems', component: TextPresentationComponent},
  { path: 'xmlpoem', component: XmlpoemComponent},
  { path: 'xmlpoems', component: XmlpoemsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
