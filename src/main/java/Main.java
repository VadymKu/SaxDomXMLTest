import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Main {

    public static void main(String[] args) {
        try {
            // Erstellen einer DOM-Implementierung
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            // Erstellen des Wurzelelements
            Element antragsListeElement = doc.createElement("AntragsListe");
            antragsListeElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            antragsListeElement.setAttribute("xsi:noNamespaceSchemaLocation", "SendMaxAntrag.xsd");
            doc.appendChild(antragsListeElement);

            // Erstellen des AnlassbezogenerUeberpruefungsAntrag Elements
            Element anlassbezogenerUeberpruefungsAntragElement = doc.createElement("AnlassbezogenerUeberpruefungsAntrag");
            anlassbezogenerUeberpruefungsAntragElement.setAttribute("modus", "Erstantrag");
            antragsListeElement.appendChild(anlassbezogenerUeberpruefungsAntragElement);

            // Erstellen des Antragskopf Elements
            Element antragskopfElement = doc.createElement("Antragskopf");
            antragskopfElement.setAttribute("minoccurs","1");
            antragskopfElement.setAttribute("maxoccurs","1");
            anlassbezogenerUeberpruefungsAntragElement.appendChild(antragskopfElement);

            // Erstellen der Elemente unter Antragskopf
            Element akteUUIDElement = doc.createElement("AkteUUID");
            akteUUIDElement.setTextContent("0");
            akteUUIDElement.setAttribute("minoccurs","0");
            akteUUIDElement.setAttribute("maxoccurs","1");
            antragskopfElement.appendChild(akteUUIDElement);

            Element senderAntragUUIDElement = doc.createElement("SenderAntragUUID");
            senderAntragUUIDElement.setAttribute("minoccurs","1");
            senderAntragUUIDElement.setAttribute("maxoccurs","1");
            senderAntragUUIDElement.setTextContent("00000000-0000-0000-0000-000000000011");
            antragskopfElement.appendChild(senderAntragUUIDElement);

            Element antragserfassungsstellenAktenzeichenElement = doc.createElement("AntragserfassungsstellenAktenzeichen");
            antragserfassungsstellenAktenzeichenElement.setAttribute("minoccurs","1");
            antragserfassungsstellenAktenzeichenElement.setAttribute("maxoccurs","1");
            antragserfassungsstellenAktenzeichenElement.setTextContent("ab");
            antragskopfElement.appendChild(antragserfassungsstellenAktenzeichenElement);

            Element behoerdenAktenzeichenElement = doc.createElement("BehoerdenAktenzeichen");
            behoerdenAktenzeichenElement.setAttribute("minoccurs","1");
            behoerdenAktenzeichenElement.setAttribute("maxoccurs","1");
            behoerdenAktenzeichenElement.setTextContent("ab");
            antragskopfElement.appendChild(behoerdenAktenzeichenElement);

            Element folgeantragsnummerElement = doc.createElement("Folgeantragsnummer");
            folgeantragsnummerElement.setAttribute("minoccurs","1");
            folgeantragsnummerElement.setAttribute("maxoccurs","1");
            folgeantragsnummerElement.setTextContent("");
            antragskopfElement.appendChild(folgeantragsnummerElement);

            Element antragsstellungZeitpunktUTCElement = doc.createElement("AntragsstellungZeitpunktUTC");
            antragsstellungZeitpunktUTCElement.setAttribute("minoccurs","1");
            antragsstellungZeitpunktUTCElement.setAttribute("maxoccurs","1");
            antragsstellungZeitpunktUTCElement.setTextContent("");
            antragskopfElement.appendChild(antragsstellungZeitpunktUTCElement);

            Element aenderungZeitpunktUTCElement = doc.createElement("AenderungZeitpunktUTC");
            aenderungZeitpunktUTCElement.setAttribute("minoccurs","1");
            aenderungZeitpunktUTCElement.setAttribute("maxoccurs","1");
            aenderungZeitpunktUTCElement.setTextContent("");
            antragskopfElement.appendChild(aenderungZeitpunktUTCElement);

            Element grundElement = doc.createElement("Grund");
            grundElement.setAttribute("minoccurs","1");
            grundElement.setAttribute("maxoccurs","1");
            grundElement.setTextContent("");
            antragskopfElement.appendChild(grundElement);

            Element referenzAntragZuAntragElement = doc.createElement("ReferenzAntragZuAntrag");
            referenzAntragZuAntragElement.setAttribute("minoccurs","1");
            referenzAntragZuAntragElement.setAttribute("maxoccurs","1");
            referenzAntragZuAntragElement.setTextContent("");
            antragskopfElement.appendChild(referenzAntragZuAntragElement);

            Element oSIPAZElement = doc.createElement("OSIPAZ");
            oSIPAZElement.setAttribute("minoccurs","1");
            oSIPAZElement.setAttribute("maxoccurs","1");
            oSIPAZElement.setTextContent("");
            antragskopfElement.appendChild(oSIPAZElement);

            Element personenbezogeneAngabenElement = doc.createElement("PersonenbezogeneAngaben");
            personenbezogeneAngabenElement.setAttribute("minoccurs","1");
            personenbezogeneAngabenElement.setAttribute("maxoccurs","0");
            personenbezogeneAngabenElement.setTextContent("");
            anlassbezogenerUeberpruefungsAntragElement.appendChild(personenbezogeneAngabenElement);

            Element antragstellerElement = doc.createElement("Antragsteller");
            antragstellerElement.setAttribute("minoccurs","1");
            antragstellerElement.setAttribute("maxoccurs","1");
            antragstellerElement.setTextContent("");
            personenbezogeneAngabenElement.appendChild(antragstellerElement);

            Element gueltigerName = doc.createElement("GueltigerName");
            gueltigerName.setAttribute("minoccurs","1");
            gueltigerName.setAttribute("maxoccurs","1");
            gueltigerName.setTextContent("");
            antragskopfElement.appendChild(gueltigerName);

            Element titelElement = doc.createElement()


            // Erstellen des Transformers, um die DOM in eine Datei zu schreiben
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty("indent","yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("example.xml");
            transformer.transform(source, result);
            System.out.println("XML-Datei wurde erfolgreich erstellt.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
