import { OrigText } from "./orig-text";
import { RegText } from "./reg-text";

export class Apophthegm {

    constructor() {
        this.id = "";
        this.orig = new OrigText;
        this.reg = new RegText;
        this.relations = [];
    }
    id : String
    orig : OrigText
    reg : RegText
    relations : String[]

    
}
