package avvale.com;

import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.v25.datatype.CE; // Coded Element
import ca.uhn.hl7v2.parser.ModelClassFactory;

public class ZXE extends AbstractSegment {

    public ZXE(Group parent, ModelClassFactory factory) {
        super(parent, factory);
        try {
            init(); // Initialize the segment fields
        } catch (HL7Exception e) {
            throw new RuntimeException("Error initializing ZXE segment", e); // Propagate the exception
        }
    }

    private void init() throws HL7Exception {
        // Initialize each field with CE types
        this.add(CE.class, false, 1, 1, new Object[]{this.getMessage()}, "Field 1"); // ZXE.1
        this.add(CE.class, false, 1, 1, new Object[]{this.getMessage()}, "Field 2"); // ZXE.2
        this.add(CE.class, false, 1, 1, new Object[]{this.getMessage()}, "Field 3"); // ZXE.3
        this.add(CE.class, false, 1, 1, new Object[]{this.getMessage()}, "Field 4"); // ZXE.4
        this.add(CE.class, false, 1, 1, new Object[]{this.getMessage()}, "Field 5"); // ZXE.5
        this.add(CE.class, false, 1, 1, new Object[]{this.getMessage()}, "Field 6"); // ZXE.6
    }

    // Accessor methods for each field in the ZXE segment

    public CE getField1() {
        return this.getTypedField(1, 0); // ZXE.1
    }

    public CE getField2() {
        return this.getTypedField(2, 0); // ZXE.2
    }

    public CE getField3() {
        return this.getTypedField(3, 0); // ZXE.3
    }

    public CE getField4() {
        return this.getTypedField(4, 0); // ZXE.4
    }

    public CE getField5() {
        return this.getTypedField(5, 0); // ZXE.5
    }

    public CE getField6() {
        return this.getTypedField(6, 0); // ZXE.6
    }
}
