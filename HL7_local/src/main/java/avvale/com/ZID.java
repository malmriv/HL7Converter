package avvale.com;

import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.v25.datatype.CE; // Coded Element
import ca.uhn.hl7v2.parser.ModelClassFactory;

public class ZID extends AbstractSegment {

    public ZID(Group parent, ModelClassFactory factory) {
        super(parent, factory);
        try {
            init(); // Initialize the segment fields
        } catch (HL7Exception e) {
            throw new RuntimeException("Error initializing ZID segment", e); // Propagate the exception
        }
    }

    private void init() throws HL7Exception {
        // Initialize each field with CE types
        this.add(CE.class, false, 1, 1, new Object[]{this.getMessage()}, "Transaction Status"); // ZID.1
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Transaction ID"); // ZID.2
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Timestamp"); // ZID.3
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "User Information"); // ZID.4
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Approval Status"); // ZID.5
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Drug Category"); // ZID.6
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Clinic Code"); // ZID.7
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Patient ID"); // ZID.8
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Drug Composition"); // ZID.9
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Dosage Instructions"); // ZID.10
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Expiry Date"); // ZID.11
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Administration Date"); // ZID.12
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Next Administration Date"); // ZID.13
    }

    // Accessor methods for each field in the ZID segment

    public CE getTransactionStatus() {
        return this.getTypedField(1, 0); // ZID.1
    }

    public CE getTransactionID() {
        return this.getTypedField(2, 0); // ZID.2
    }

    public CE getTimestamp() {
        return this.getTypedField(3, 0); // ZID.3
    }

    public CE getUserInformation() {
        return this.getTypedField(4, 0); // ZID.4
    }

    public CE getApprovalStatus() {
        return this.getTypedField(5, 0); // ZID.5
    }

    public CE getDrugCategory() {
        return this.getTypedField(6, 0); // ZID.6
    }

    public CE getClinicCode() {
        return this.getTypedField(7, 0); // ZID.7
    }

    public CE getPatientID() {
        return this.getTypedField(8, 0); // ZID.8
    }

    public CE getDrugComposition() {
        return this.getTypedField(9, 0); // ZID.9
    }

    public CE getDosageInstructions() {
        return this.getTypedField(10, 0); // ZID.10
    }

    public CE getExpiryDate() {
        return this.getTypedField(11, 0); // ZID.11
    }

    public CE getAdministrationDate() {
        return this.getTypedField(12, 0); // ZID.12
    }

    public CE getNextAdministrationDate() {
        return this.getTypedField(13, 0); // ZID.13
    }
}
