import { OrigText } from "./orig-text";
import { RegText } from "./reg-text";

export class Apophthegm {

    constructor() {
        this.id = "";
        this.textId = "";
        this.orig = new OrigText;
        this.reg = new RegText;
        this.relations = [];
    }
    id : String
    textId : String
    orig : OrigText
    reg : RegText
    relations : String[]

    
}
