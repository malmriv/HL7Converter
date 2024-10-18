package avvale.com;

import ca.uhn.hl7v2.model.AbstractSegment;
//import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Group; 

import ca.uhn.hl7v2.model.v25.datatype.CE; // Coded Element
import ca.uhn.hl7v2.model.v25.datatype.TS; // Time Stamp
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.v25.datatype.ST; // String Data

public class ZTQ extends AbstractSegment {

     public ZTQ(Group parent, ModelClassFactory factory) {
        super(parent, factory);
        try {
            init();
        } catch (HL7Exception e) {
            e.printStackTrace();
        }
    }

    private void init() throws HL7Exception {
        // ZTQ.1 - Campo con múltiples componentes (CE)
        this.add(CE.class, false, 1, 250, new Object[]{this.getMessage()}, "Scheduled Date/Time");

        // ZTQ.2 - Código de Protocolo (ST)
        this.add(ST.class, false, 1, 250, new Object[]{this.getMessage()}, "Protocol Code");

        // ZTQ.3 - Campo 3 (ST)
        this.add(ST.class, false, 1, 250, new Object[]{this.getMessage()}, "Field 3");

        // ZTQ.4 - Campo 4 (ST)
        this.add(ST.class, false, 1, 250, new Object[]{this.getMessage()}, "Field 4");

        // ZTQ.5 - Campo 5 (ST)
        this.add(ST.class, false, 1, 250, new Object[]{this.getMessage()}, "Field 5");

        // ZTQ.6 - Código de Protocolo Adicional (ST)
        this.add(ST.class, false, 1, 250, new Object[]{this.getMessage()}, "Additional Protocol Code");
        
        
    }

    // Métodos para acceder a los campos

    // ZTQ.1 - Fecha de Programación
    public CE getScheduledDateTime() {
        return this.getTypedField(1, 0);
    }

    // ZTQ.2 - Código de Protocolo
    public ST getProtocolCode() {
        return this.getTypedField(2, 0);
    }

    // ZTQ.6 - Código de Protocolo Adicional
    public ST getAdditionalProtocolCode() {
        return this.getTypedField(6, 0);
    }

    // Puedes agregar métodos para los campos adicionales si lo deseas
}
