import { FileDescription } from "./file-description";

export class TeiHeader {
    id : Number;
    fileDescription : FileDescription;

    constructor() {
        this.id = 0;
        this.fileDescription = new FileDescription();
    }

}
