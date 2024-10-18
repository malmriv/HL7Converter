package avvale.com;

//import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.CanonicalModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Segment;

public class CustomModelClassFactory extends CanonicalModelClassFactory  {

    public CustomModelClassFactory() {
        // Especificamos la versión 2.5
        super("2.5");
    }

    @Override
    public Class<? extends Segment> getSegmentClass(String name, String version) throws HL7Exception {
        //if ("ZID".equals(name)) {
        //    return ZID.class;
        //} else if ("ZXD".equals(name)) {
        //    return ZXD.class;
        //} else if ("ZTQ".equals(name)) {
        if ("ZTQ".equals(name)) {
            return ZTQ.class;  // Handle ZTQ segment
        }else if ("ZXD".equals(name)) {
            return ZXD.class;  // Handle ZXD segment
        }else if ("ZID".equals(name)) {
            return ZID.class;  // Handle ZID segment
        }else {
            return super.getSegmentClass(name, version);
        }
    }
}
