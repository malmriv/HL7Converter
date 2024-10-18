package avvale.com;

import ca.uhn.hl7v2.parser.CanonicalModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Segment;

public class CustomModelClassFactory extends CanonicalModelClassFactory {

    public CustomModelClassFactory() {
        // Specify version 2.5
        super("2.5");
    }

    @Override
    public Class<? extends Segment> getSegmentClass(String name, String version) throws HL7Exception {
        // Handle custom segments
        if ("ZTQ".equals(name)) {
            return ZTQ.class; // Handle ZTQ segment
        } else if ("ZXD".equals(name)) {
            return ZXD.class; // Handle ZXD segment
        } else if ("ZID".equals(name)) {
            return ZID.class; // Handle ZID segment
        } else if ("ZRX".equals(name)) {
            return ZRX.class; // Handle ZRX segment
        } else if ("ZXE".equals(name)) {
            return ZXE.class; // Handle ZXE segment
        } else {
            return super.getSegmentClass(name, version);
        }
    }
}
