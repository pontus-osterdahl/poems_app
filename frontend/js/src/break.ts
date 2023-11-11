import { Attribute } from "./attribute";

export class Break {
    constructor() {
        this.id = 0;
        this.type = "";
        this.text = "";
        this.content = [];
        this.attributes = [];
    }
    id: number;
    type: String;
    text: string;
    content: Break[];
    attributes : Attribute[];

}
