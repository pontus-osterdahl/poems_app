import { ManuscriptDescription } from "src/manuscript-description";

export class SourceDescription {
    id : Number;
    manusciptDescription : ManuscriptDescription;

    public constructor() {
        this.id = 0;
        this.manusciptDescription = new ManuscriptDescription();
    }
}
