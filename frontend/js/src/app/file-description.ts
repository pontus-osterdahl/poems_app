import { SourceDescription } from "./source-description";
import { TitleStatement } from "./title-statement";

export class FileDescription {
    id: Number;
    titleStatement : TitleStatement;
    publicationStatement : String;
    sourceDescription : SourceDescription;

    constructor() {
        this.id = 0;
        this.titleStatement = new TitleStatement();
        this.publicationStatement = "";
        this.sourceDescription = new SourceDescription();
    }
}
