package avvale.com;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.parser.XMLParser;
import ca.uhn.hl7v2.validation.ValidationContext;
import ca.uhn.hl7v2.validation.impl.NoValidation;
import ca.uhn.hl7v2.parser.CanonicalModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class HL7ToXMLConverter {

    public static void main(String[] args) {
        String hl7Message = readHL7MessageFromFile("C:\\Users\\manuel.almagro\\Desktop\\Proyectos\\Clínic BCN\\ArchivosTest\\Input\\RDS_input.txt");

        if (hl7Message != null) {

            // Crear un contexto HAPI con la versión específica
            try (HapiContext context = new DefaultHapiContext()) {
                //context.setModelClassFactory(new CanonicalModelClassFactory("2.5"));
                context.setModelClassFactory(new CustomModelClassFactory());
                // Desactivar la validación
                ValidationContext noValidation = new NoValidation();
                context.setValidationContext(noValidation);
                            // Crear un parser para mensajes HL7 en formato pipe (tradicional)
            PipeParser pipeParser = context.getPipeParser();
            // Parsear el mensaje HL7
            Message message = pipeParser.parse(hl7Message);


            // Crear un parser para convertir a XML
            XMLParser xmlParser = new DefaultXMLParser();
            String xmlMessage = xmlParser.encode(message);

            // Escribir el mensaje XML en un archivo
            writeXMLMessageToFile(xmlMessage, "C:\\Users\\manuel.almagro\\Desktop\\Proyectos\\Clínic BCN\\ArchivosTest\\Output\\RDS_output2.txt");

            // Imprimir el mensaje en formato XML
            //System.out.println("Mensaje XML:\n" + xmlMessage);
            } catch (IOException e) { // Manejar la excepción IOException
                e.printStackTrace();
            } catch (HL7Exception e) {
                System.out.println("Error HL7: " + e.getMessage());
            }
        }
    }

    // Método para leer el mensaje HL7 desde un archivo
    private static String readHL7MessageFromFile(String filePath) {
        StringBuilder hl7Message = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                hl7Message.append(line).append("\r");
            }
            return hl7Message.toString();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }

    // Método para escribir el mensaje XML en un archivo
    private static void writeXMLMessageToFile(String xmlMessage, String filePath) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath))) {
            out.println(xmlMessage);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
