package avvale.com;

import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.v25.datatype.CE; // Coded Element
import ca.uhn.hl7v2.model.v25.datatype.TS; // Timestamp
import ca.uhn.hl7v2.parser.ModelClassFactory;

public class ZRX extends AbstractSegment {

    public ZRX(Group parent, ModelClassFactory factory) {
        super(parent, factory);
        try {
            init(); // Initialize the segment fields
        } catch (HL7Exception e) {
            throw new RuntimeException("Error initializing ZRX segment", e); // Propagate the exception
        }
    }

    private void init() throws HL7Exception {
        // Initialize each field with appropriate types
        this.add(CE.class, false, 1, 1, new Object[]{this.getMessage()}, "Transaction Status"); // ZRX.1
        this.add(CE.class, false, 1, 1, new Object[]{this.getMessage()}, "Transaction Date"); // ZRX.2
        this.add(CE.class, false, 1, 1, new Object[]{this.getMessage()}, "Prescription ID"); // ZRX.3
        this.add(CE.class, false, 1, 1, new Object[]{this.getMessage()}, "Expiration Date"); // ZRX.4
        this.add(CE.class, false, 1, 1, new Object[]{this.getMessage()}, "Administration Date"); // ZRX.5
        this.add(CE.class, false, 1, 1, new Object[]{this.getMessage()}, "Dosage Instructions"); // ZRX.6
        this.add(CE.class, false, 1, 1, new Object[]{this.getMessage()}, "Start Date"); // ZRX.7
        this.add(CE.class, false, 1, 1, new Object[]{this.getMessage()}, "End Date"); // ZRX.8
        this.add(CE.class, false, 1, 1, new Object[]{this.getMessage()}, "Drug Information"); // ZRX.9
        this.add(CE.class, false, 1, 1, new Object[]{this.getMessage()}, "Original Order Date"); // ZRX.10
    }

    // Accessor methods for each field in the ZRX segment

    public CE getTransactionStatus() {
        return this.getTypedField(1, 0); // ZRX.1
    }

    public CE getTransactionDate() {
        return this.getTypedField(2, 0); // ZRX.2
    }

    public CE getPrescriptionID() {
        return this.getTypedField(3, 0); // ZRX.3
    }

    public CE getExpirationDate() {
        return this.getTypedField(4, 0); // ZRX.4
    }

    public CE getAdministrationDate() {
        return this.getTypedField(5, 0); // ZRX.5
    }

    public CE getDosageInstructions() {
        return this.getTypedField(6, 0); // ZRX.6
    }

    public CE getStartDate() {
        return this.getTypedField(7, 0); // ZRX.7
    }

    public CE getEndDate() {
        return this.getTypedField(8, 0); // ZRX.8
    }

    public CE getDrugInformation() {
        return this.getTypedField(9, 0); // ZRX.9
    }

    public CE getOriginalOrderDate() {
        return this.getTypedField(10, 0); // ZRX.10
    }
}
