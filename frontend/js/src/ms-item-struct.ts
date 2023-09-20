import { Locus } from "./app/locus";

export class MsItemStruct {
    id : Number;
    locus : Locus;
    author: String;
    title : String;
    note : String;
    textLang : String;

    constructor() {
        this.id = 0;
        this.locus = new Locus();
        this.author = "";
        this.title = "";
        this.note = "";
        this.textLang = "";
    }

}
