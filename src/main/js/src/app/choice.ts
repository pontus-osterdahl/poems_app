import { OrigText } from "./orig-text";
import { RegText } from "./reg-text";

export class Choice {
    constructor() {
        this.id = 0;
        this.orig = new OrigText;
        this.reg = new RegText;
    }
    id: number;
    orig : OrigText;
    reg : RegText;
}
