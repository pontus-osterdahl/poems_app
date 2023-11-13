import { Break } from "src/break";

export class RegText {
    constructor() {
        this.id = 0;
        this.text = "";
        this.criticalApparatus = "";
            this.id = 0;
            this.breaks = [];
        }
    
    breaks : Break[]; 


    id : number;
    text : String;
    criticalApparatus : String;
}
