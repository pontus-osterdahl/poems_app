import { Additional } from "./app/additional";
import { PhysicalDescription } from "./app/physical-description";
import { MsIdentifier } from "./ms-identifier";
import { MsItemStruct } from "./ms-item-struct";

export class ManuscriptDescription {

    id : Number;
    msIdentifier : MsIdentifier;
    msContent : MsItemStruct[];
    history : History;
    additional : Additional;
    physicalDescription : PhysicalDescription;


    public constructor() {
        this.id = 0;
        this.msIdentifier = new MsIdentifier();
        this.msContent = [];
        this.history = new History();
        this.additional = new Additional();
        this.physicalDescription = new PhysicalDescription();
    }
}
