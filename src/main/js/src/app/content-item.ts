import { Choice } from "./choice"

export class ContentItem {
    constructor() {
        this.id = 0;
        this.textId = "";
        this.relations = [];
    }
    id : number;
    textId: String;
    relations : String[];
}
