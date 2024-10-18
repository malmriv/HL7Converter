package avvale.com;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.parser.XMLParser;
import ca.uhn.hl7v2.validation.ValidationContext;
import ca.uhn.hl7v2.validation.impl.NoValidation;
import ca.uhn.hl7v2.parser.DefaultXMLParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class XMLToHL7Converter {

    public static void main(String[] args) {
        String xmlMessage = readXMLMessageFromFile("C:\\Users\\manuel.almagro\\Desktop\\Proyectos\\Clínic BCN\\ArchivosTest\\Input\\RDE_XML_Input.xml");

        if (xmlMessage != null) {
            try (HapiContext context = new DefaultHapiContext()) {
                context.setModelClassFactory(new CustomModelClassFactory()); // Usar tu clase de modelo personalizada
                ValidationContext noValidation = new NoValidation();
                context.setValidationContext(noValidation);

             // Crear un parser para convertir el mensaje HL7 a formato pipe
                XMLParser xmlParser = new DefaultXMLParser(context.getModelClassFactory()); // Asegúrate de pasar el factory aquí
                Message message = xmlParser.parse(xmlMessage);

                // Aquí imprimimos el mensaje parseado para ver si los segmentos PID, ZID, etc. están presentes
                System.out.println("Mensaje HL7 parseado desde XML:");
                System.out.println(message.encode()); // Esto muestra el mensaje en formato HL7 pipe delimited

                // Crear un parser para convertir el mensaje HL7 a formato pipe
                PipeParser pipeParser = context.getPipeParser();
                String hl7Message = pipeParser.encode(message);

                // Escribir el mensaje HL7 en un archivo
                writeHL7MessageToFile(hl7Message, "C:\\Users\\manuel.almagro\\Desktop\\Proyectos\\Clínic BCN\\ArchivosTest\\Output\\RDS_EDI_output.txt");

                // Imprimir el mensaje HL7 en formato pipe
                System.out.println("Mensaje HL7 generado:\r" + hl7Message);
            } catch (IOException e) {
                System.err.println("Error durante la operación de archivo: " + e.getMessage());
            } catch (HL7Exception e) {
                System.err.println("Error HL7: " + e.getMessage());
            }
        }
    }

    // Método para leer el mensaje XML desde un archivo
    private static String readXMLMessageFromFile(String filePath) {
        StringBuilder xmlMessage = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                xmlMessage.append(line).append("\r");
            }
            return xmlMessage.toString();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }

    // Método para escribir el mensaje HL7 en un archivo
    private static void writeHL7MessageToFile(String hl7Message, String filePath) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath))) {
            out.println(hl7Message);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
