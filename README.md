# Conversor HL7: XML &harr; EDI
Este proyecto contiene un conversor de mensajes HL7 (Health Level 7) que permite saltar entre XML y EDI. Es compatible con segmentos Z (customizados por el usuario), ya que uso un `CustomModelClassFactory` en el cual se pueden añadir clases Z definidas por el usuario.

## Funcionalidades
- Conversión de mensajes HL7 de EDI a XML y de XML a EDI.
- Soporte para segmentos Z personalizados (custom).

## Archivos
- **HL7_local/**: Contiene el proyecto para ser corrido localmente.
- **ArchivosTest/**: Carpeta con archivos de prueba para validar el funcionamiento del conversor, tanto EDI como XML.
- **HL7_Converter_PI_JavaMapping.jar**: Archivo JAR que contiene las clases necesarias para su uso en SAP PI/PO (con la estructura requerida por el integrador).

## Uso
1. Clona este repositorio.
2. Usa compila los archivos .java, indicando qué archivo local deben convertir.
3. Personaliza los segmentos Z según sea necesario. Basta añadir una nueva clase por cada segmento custom y referenciarla en la clase `CustomModelClassFactory`.

## Ejemplo
### Mensaje HL7 en formato EDI
El siguiente archivo puede ser convertido a XML usando la clase HL7ToXMLConverter:
```txt
MSH|^~\&|HOSPITAL|GASTROENTEROLOGY|PHARMACY|GH|202410180900||ORM^O01|789123|P|2.6
PID|1||PACIENTE_123^^^GH||ALMAGRO^MANUEL^A||19950728|M|||C/ Falsa 123^^Villabroma^Granada^11111^España||(666)333-222|||M|||123456789|987654321
PV1|1|O|2000^2012^01||||DOCTOR_321^TOMIA^ANA^H|||MED||||||||OUTPATIENT|A0|
ORC|NW|RX12345^HOSPITAL|RX54321^PHARMACY|PA|1|CM||||202410180900|DOCTOR_321^TOMIA^ANA^H|||NO||||||||||NO REFILLS
RXO|001^LACTASE||60000|TAB|||PO||||||||202410180900|30D|||||||||||||||||||
RXR|PO^Oral
OBX|1|TX|COMMENT^Doctor's Comments||The patient suffers from lactose intolerance. Follow-up in 3 months.

```
### Mensaje HL7 en formato XML
El siguiente archivo puede ser convertido a EDI usando la clase XMLToHL7Converter:
```xml
<?xml version="1.0" encoding="UTF-8"?><ORM_O01 xmlns="urn:hl7-org:v2xml">
    <MSH>
        <MSH.1>|</MSH.1>
        <MSH.2>^~\&amp;</MSH.2>
        <MSH.3>
            <HD.1>HOSPITAL</HD.1>
        </MSH.3>
        <MSH.4>
            <HD.1>GASTROENTEROLOGY</HD.1>
        </MSH.4>
        <MSH.5>
            <HD.1>PHARMACY</HD.1>
        </MSH.5>
        <MSH.6>
            <HD.1>GH</HD.1>
        </MSH.6>
        <MSH.7>
            <TS.1>202410180900</TS.1>
        </MSH.7>
        <MSH.9>
            <MSG.1>ORM</MSG.1>
            <MSG.2>O01</MSG.2>
        </MSH.9>
        <MSH.10>789123</MSH.10>
        <MSH.11>
            <PT.1>P</PT.1>
        </MSH.11>
        <MSH.12>
            <VID.1>2.6</VID.1>
        </MSH.12>
    </MSH>
    <ORM_O01.PATIENT>
        <PID>
            <PID.1>1</PID.1>
            <PID.3>
                <CX.1>PACIENTE_123</CX.1>
                <CX.4>
                    <HD.1>GH</HD.1>
                </CX.4>
            </PID.3>
            <PID.5>
                <XPN.1>
                    <FN.1>ALMAGRO</FN.1>
                </XPN.1>
                <XPN.2>MANUEL</XPN.2>
                <XPN.3>A</XPN.3>
            </PID.5>
            <PID.7>
                <TS.1>19950728</TS.1>
            </PID.7>
            <PID.8>M</PID.8>
            <PID.11>
                <XAD.1>
                    <SAD.1>C/ Falsa 123</SAD.1>
                </XAD.1>
                <XAD.3>Villabroma</XAD.3>
                <XAD.4>Granada</XAD.4>
                <XAD.5>11111</XAD.5>
                <XAD.6>España</XAD.6>
            </PID.11>
            <PID.13>
                <XTN.1>(666)333-222</XTN.1>
            </PID.13>
            <PID.16>
                <CE.1>M</CE.1>
            </PID.16>
            <PID.19>123456789</PID.19>
            <PID.20>
                <DLN.1>987654321</DLN.1>
            </PID.20>
        </PID>
        <ORM_O01.PATIENT_VISIT>
            <PV1>
                <PV1.1>1</PV1.1>
                <PV1.2>O</PV1.2>
                <PV1.3>
                    <PL.1>2000</PL.1>
                    <PL.2>2012</PL.2>
                    <PL.3>01</PL.3>
                </PV1.3>
                <PV1.7>
                    <XCN.1>DOCTORA_321</XCN.1>
                    <XCN.2>
                        <FN.1>TOMIA</FN.1>
                    </XCN.2>
                    <XCN.3>ANA</XCN.3>
                    <XCN.4>H</XCN.4>
                </PV1.7>
                <PV1.10>MED</PV1.10>
                <PV1.18>OUTPATIENT</PV1.18>
                <PV1.19>
                    <CX.1>A0</CX.1>
                </PV1.19>
            </PV1>
        </ORM_O01.PATIENT_VISIT>
    </ORM_O01.PATIENT>
    <ORM_O01.ORDER>
        <ORC>
            <ORC.1>NW</ORC.1>
            <ORC.2>
                <EI.1>RX12345</EI.1>
                <EI.2>HOSPITAL</EI.2>
            </ORC.2>
            <ORC.3>
                <EI.1>RX54321</EI.1>
                <EI.2>PHARMACY</EI.2>
            </ORC.3>
            <ORC.4>
                <EI.1>PA</EI.1>
            </ORC.4>
            <ORC.5>1</ORC.5>
            <ORC.6>CM</ORC.6>
            <ORC.10>
                <XCN.1>202410180900</XCN.1>
            </ORC.10>
            <ORC.11>
                <XCN.1>DOCTORA_321</XCN.1>
                <XCN.2>
                    <FN.1>TOMIA</FN.1>
                </XCN.2>
                <XCN.3>ANA</XCN.3>
                <XCN.4>H</XCN.4>
            </ORC.11>
            <ORC.14>
                <XTN.1>NO</XTN.1>
            </ORC.14>
            <ORC.24>
                <XAD.1>
                    <SAD.1>NO REFILLS</SAD.1>
                </XAD.1>
            </ORC.24>
        </ORC>
        <ORM_O01.ORDER_DETAIL>
            <RXO>
                <RXO.1>
                    <CE.1>001</CE.1>
                    <CE.2>LACTASE</CE.2>
                </RXO.1>
                <RXO.3>60000</RXO.3>
                <RXO.4>
                    <CE.1>TAB</CE.1>
                </RXO.4>
                <RXO.7>
                    <CE.1>PO</CE.1>
                </RXO.7>
                <RXO.15>
                    <XCN.1>202410180900</XCN.1>
                </RXO.15>
                <RXO.16>30D</RXO.16>
            </RXO>
            <RXR>
                <RXR.1>
                    <CE.1>PO</CE.1>
                    <CE.2>Oral</CE.2>
                </RXR.1>
            </RXR>
            <ORM_O01.OBSERVATION>
                <OBX>
                    <OBX.1>1</OBX.1>
                    <OBX.2>TX</OBX.2>
                    <OBX.3>
                        <CE.1>COMMENT</CE.1>
                        <CE.2>Doctor's Comments</CE.2>
                    </OBX.3>
                    <OBX.5>The patient suffers from lactose intolerance. Follow-up in 3 months.</OBX.5>
                </OBX>
            </ORM_O01.OBSERVATION>
        </ORM_O01.ORDER_DETAIL>
    </ORM_O01.ORDER>
</ORM_O01>
```

