import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PoemComponent } from './poem/poem.component';
import { AddPoemComponent } from './add-poem/add-poem.component';
import { HttpClientModule } from '@angular/common/http';
import { PoemsComponent } from './poems/poems.component';
import { PoemSearchComponent } from './poem-search/poem-search.component';
import { AddFromFileComponent } from './add-from-file/add-from-file.component';
import { BibliographyComponent } from './bibliography/bibliography.component';
import { BibliographyDisplayComponent } from './bibliography-display/bibliography-display.component';
import { BibitemsourcecomponentComponent } from './bibitemsourcecomponent/bibitemsourcecomponent.component';
import { BibliographysourcecomponentComponent } from './bibliographysourcecomponent/bibliographysourcecomponent.component';
import { SearchBibitemFormComponent } from './search-bibitem-form/search-bibitem-form.component';
import { BibitemComponent } from './bibitem/bibitem.component';
import { OrigTextComponent } from './orig-text/orig-text.component';
import { RegTextComponent } from './reg-text/reg-text.component';
import { ContentItemComponent } from './content-item/content-item.component';
import { TextPresentationComponent } from './text-presentation/text-presentation.component';
import { XmlpoemComponent } from './xmlpoem/xmlpoem.component';
import { XmlpoemsComponent } from './xmlpoems/xmlpoems.component';
import { MatDialogModule} from "@angular/material/dialog";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ContentItemComponentWrapperComponent } from './content-item-component-wrapper/content-item-component-wrapper.component';
import { AddXmlPoemComponent } from './add-xml-poem/add-xml-poem.component';
import { XmlpoemsearchComponent } from './xmlpoemsearch/xmlpoemsearch.component';
import { PlacesComponent } from './places/places.component';
import { PersonsComponent } from './persons/persons.component';
@NgModule({
  declarations: [
    AppComponent,
    PoemComponent,
    AddPoemComponent,
    PoemsComponent,
    PoemSearchComponent,
    AddFromFileComponent,
    BibliographyComponent,
    BibliographyDisplayComponent,
    BibitemsourcecomponentComponent,
    BibliographysourcecomponentComponent,
    SearchBibitemFormComponent,
    BibitemComponent,
    OrigTextComponent,
    RegTextComponent,
    ContentItemComponent,
    TextPresentationComponent,
    XmlpoemComponent,
    XmlpoemsComponent,
    ContentItemComponent,
    ContentItemComponentWrapperComponent,
    AddXmlPoemComponent,
    XmlpoemsearchComponent,
    PlacesComponent,
    PersonsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [ContentItemComponent]
})
export class AppModule { }
