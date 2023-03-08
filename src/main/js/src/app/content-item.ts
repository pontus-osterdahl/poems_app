import { Choice } from "./choice"

export class ContentItem {
    constructor() {
        this.id = 0;
        this.textId = "";
        this.choice = new Choice();
    }
    id : number;
    textId: String;
    choice : Choice
}
