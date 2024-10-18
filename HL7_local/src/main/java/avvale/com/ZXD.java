package avvale.com;

import ca.uhn.hl7v2.model.AbstractSegment;
//import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Group; 
import ca.uhn.hl7v2.model.v25.datatype.ST; // String Data
import ca.uhn.hl7v2.model.v25.datatype.CE; // Coded Element

import ca.uhn.hl7v2.parser.ModelClassFactory;


public class ZXD extends AbstractSegment {

    public ZXD(Group parent, ModelClassFactory factory) {
        super(parent, factory);
        try {
            init(); // Initialize the segment fields
        } catch (HL7Exception e) {
            throw new RuntimeException("Error initializing ZXD segment", e); // Propagate the exception
        }
    }

    private void init() throws HL7Exception {
        // Initialize each field with CE types
        this.add(CE.class, false, 1, 1, new Object[]{this.getMessage()}, "Status"); // ZXD.1
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Drug Code"); // ZXD.2
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Field 3"); // ZXD.3

        // Dosage Information fields
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Dosage Information 1"); // ZXD.4
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Dosage Information 2"); // ZXD.5
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Dosage Information 3"); // ZXD.6
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Dosage Information 4"); // ZXD.7
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Dosage Information 5"); // ZXD.8
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Dosage Information 6"); // ZXD.9
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Dosage Information 7"); // ZXD.10
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Dosage Information 8"); // ZXD.11
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Dosage Information 9"); // ZXD.12
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Dosage Information 10"); // ZXD.13
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Drug Identifier"); // ZXD.14
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Additional Identifier"); // ZXD.15
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Dosage Information 11"); // ZXD.16
    }

 // Accessor methods for each field in the ZXD segment

    public CE getStatus() {
        return this.getTypedField(1, 0); // ZXD.1
    }

    public CE getDrugCode() {
        return this.getTypedField(2, 0); // ZXD.2
    }

    public CE getField3() {
        return this.getTypedField(3, 0); // ZXD.3
    }

    public CE getDosageInfo1() {
        return this.getTypedField(4, 0); // ZXD.4
    }

    public CE getDosageInfo2() {
        return this.getTypedField(5, 0); // ZXD.5
    }

    public CE getDosageInfo3() {
        return this.getTypedField(6, 0); // ZXD.6
    }

    public CE getDosageInfo4() {
        return this.getTypedField(7, 0); // ZXD.7
    }

    public CE getDosageInfo5() {
        return this.getTypedField(8, 0); // ZXD.8
    }

    public CE getDosageInfo6() {
        return this.getTypedField(9, 0); // ZXD.9
    }

    public CE getDosageInfo7() {
        return this.getTypedField(10, 0); // ZXD.10
    }

    public CE getDosageInfo8() {
        return this.getTypedField(11, 0); // ZXD.11
    }

    public CE getDosageInfo9() {
        return this.getTypedField(12, 0); // ZXD.12
    }

    public CE getDrugIdentifier() {
        return this.getTypedField(13, 0); // ZXD.13
    }

    public CE getAdditionalIdentifier() {
        return this.getTypedField(14, 0); // ZXD.14
    }

    public CE getDosageInfo10() {
        return this.getTypedField(15, 0); // ZXD.15
    }

    public CE getDosageInfo11() {
        return this.getTypedField(16, 0); // ZXD.16
    }

}