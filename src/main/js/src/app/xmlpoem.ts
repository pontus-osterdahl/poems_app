import { ContentItem } from "./content-item";

export class XmlPoem {

    constructor() {
        this.id = 0;
        this.filepath = "";
        this.name = "";
        this.contentItems=[];
    }

    id: Number;
    filepath: String;
    name: String;
    contentItems: ContentItem[];
}
