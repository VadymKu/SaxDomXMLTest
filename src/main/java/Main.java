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
            antragskopfElement.setAttribute("minoccurs", "1");
            antragskopfElement.setAttribute("maxoccurs", "1");
            anlassbezogenerUeberpruefungsAntragElement.appendChild(antragskopfElement);

            // Erstellen der Elemente unter Antragskopf
            Element akteUUIDElement = doc.createElement("AkteUUID");
            akteUUIDElement.setTextContent("0");
            akteUUIDElement.setAttribute("minoccurs", "0");
            akteUUIDElement.setAttribute("maxoccurs", "1");
            antragskopfElement.appendChild(akteUUIDElement);

            Element senderAntragUUIDElement = doc.createElement("SenderAntragUUID");
            senderAntragUUIDElement.setAttribute("minoccurs", "1");
            senderAntragUUIDElement.setAttribute("maxoccurs", "1");
            senderAntragUUIDElement.setTextContent("00000000-0000-0000-0000-000000000011");
            antragskopfElement.appendChild(senderAntragUUIDElement);

            Element antragserfassungsstellenAktenzeichenElement = doc.createElement("AntragserfassungsstellenAktenzeichen");
            antragserfassungsstellenAktenzeichenElement.setAttribute("minoccurs", "1");
            antragserfassungsstellenAktenzeichenElement.setAttribute("maxoccurs", "1");
            antragserfassungsstellenAktenzeichenElement.setTextContent("ab");
            antragskopfElement.appendChild(antragserfassungsstellenAktenzeichenElement);

            Element behoerdenAktenzeichenElement = doc.createElement("BehoerdenAktenzeichen");
            behoerdenAktenzeichenElement.setAttribute("minoccurs", "1");
            behoerdenAktenzeichenElement.setAttribute("maxoccurs", "1");
            behoerdenAktenzeichenElement.setTextContent("ab");
            antragskopfElement.appendChild(behoerdenAktenzeichenElement);

            Element folgeantragsnummerElement = doc.createElement("Folgeantragsnummer");
            folgeantragsnummerElement.setAttribute("minoccurs", "1");
            folgeantragsnummerElement.setAttribute("maxoccurs", "1");
            folgeantragsnummerElement.setTextContent("");
            antragskopfElement.appendChild(folgeantragsnummerElement);

            Element antragsstellungZeitpunktUTCElement = doc.createElement("AntragsstellungZeitpunktUTC");
            antragsstellungZeitpunktUTCElement.setAttribute("minoccurs", "1");
            antragsstellungZeitpunktUTCElement.setAttribute("maxoccurs", "1");
            antragsstellungZeitpunktUTCElement.setTextContent("");
            antragskopfElement.appendChild(antragsstellungZeitpunktUTCElement);

            Element aenderungZeitpunktUTCElement = doc.createElement("AenderungZeitpunktUTC");
            aenderungZeitpunktUTCElement.setAttribute("minoccurs", "1");
            aenderungZeitpunktUTCElement.setAttribute("maxoccurs", "1");
            aenderungZeitpunktUTCElement.setTextContent("");
            antragskopfElement.appendChild(aenderungZeitpunktUTCElement);

            Element grundElement = doc.createElement("Grund");
            grundElement.setAttribute("minoccurs", "1");
            grundElement.setAttribute("maxoccurs", "1");
            grundElement.setTextContent("");
            antragskopfElement.appendChild(grundElement);

            Element referenzAntragZuAntragElement = doc.createElement("ReferenzAntragZuAntrag");
            referenzAntragZuAntragElement.setAttribute("minoccurs", "1");
            referenzAntragZuAntragElement.setAttribute("maxoccurs", "1");
            referenzAntragZuAntragElement.setTextContent("");
            antragskopfElement.appendChild(referenzAntragZuAntragElement);

            Element oSIPAZElement = doc.createElement("OSIPAZ");
            oSIPAZElement.setAttribute("minoccurs", "1");
            oSIPAZElement.setAttribute("maxoccurs", "1");
            oSIPAZElement.setTextContent("");
            antragskopfElement.appendChild(oSIPAZElement);

            Element personenbezogeneAngabenElement = doc.createElement("PersonenbezogeneAngaben");
            personenbezogeneAngabenElement.setAttribute("minoccurs", "1");
            personenbezogeneAngabenElement.setAttribute("maxoccurs", "0");
            personenbezogeneAngabenElement.setTextContent("");
            anlassbezogenerUeberpruefungsAntragElement.appendChild(personenbezogeneAngabenElement);

            Element antragstellerElement = doc.createElement("Antragsteller");
            antragstellerElement.setAttribute("minoccurs", "1");
            antragstellerElement.setAttribute("maxoccurs", "1");
            antragstellerElement.setTextContent("");
            personenbezogeneAngabenElement.appendChild(antragstellerElement);

            Element gueltigerName = doc.createElement("GueltigerName");
            gueltigerName.setAttribute("minoccurs", "1");
            gueltigerName.setAttribute("maxoccurs", "1");
            gueltigerName.setTextContent("");
            antragstellerElement.appendChild(gueltigerName);

            Element titelElement = doc.createElement("Titel");
            titelElement.setAttribute("minoccurs", "1");
            titelElement.setAttribute("maxoccurs", "1");
            titelElement.setTextContent("");
            gueltigerName.appendChild(titelElement);

            // Familienname
            Element familiennameElement = doc.createElement("Familienname");
            familiennameElement.setTextContent("FamilienTestName");
            familiennameElement.setAttribute("minOccurs", "1");
            familiennameElement.setAttribute("maxOccurs", "1");
            gueltigerName.appendChild(familiennameElement);

            // Geburtsname
            Element geburtsnameElement = doc.createElement("Geburtsname");
            geburtsnameElement.setAttribute("minOccurs", "0");
            gueltigerName.appendChild(geburtsnameElement);

            // Vorname
            Element vornameElement = doc.createElement("Vorname");
            vornameElement.setAttribute("minOccurs", "0");
            gueltigerName.appendChild(vornameElement);

            // IstBlockname
            Element istBlocknameElement = doc.createElement("IstBlockname");
            istBlocknameElement.setTextContent("true");
            istBlocknameElement.setAttribute("minOccurs", "1");
            gueltigerName.appendChild(istBlocknameElement);

            // FrühererName
            Element fruehererNameElement = doc.createElement("FruehererName");
            fruehererNameElement.setAttribute("minOccurs", "0");
            antragstellerElement.appendChild(fruehererNameElement);

            Element fruehererTitelElement = doc.createElement("Titel");
            fruehererTitelElement.setAttribute("minoccurs", "1");
            fruehererTitelElement.setAttribute("maxoccurs", "1");
            fruehererTitelElement.setTextContent("");
            fruehererNameElement.appendChild(fruehererTitelElement);

            // Familienname
            Element fruehererFamiliennameElement = doc.createElement("Familienname");
            fruehererFamiliennameElement.setTextContent("FamilienTestName");
            fruehererFamiliennameElement.setAttribute("minOccurs", "1");
            fruehererFamiliennameElement.setAttribute("maxOccurs", "1");
            fruehererNameElement.appendChild(fruehererFamiliennameElement);

            // Vorname
            Element fruehererVornameElement = doc.createElement("Vorname");
            fruehererVornameElement.setAttribute("minOccurs", "0");
            fruehererNameElement.appendChild(fruehererVornameElement);

            // IstBlockname
            Element fruehereristBlocknameElement = doc.createElement("IstBlockname");
            fruehereristBlocknameElement.setTextContent("true");
            fruehereristBlocknameElement.setAttribute("minOccurs", "1");
            fruehererNameElement.appendChild(fruehereristBlocknameElement);

            // Geschlecht
            Element geschlechtElement = doc.createElement("Geschlecht");
            geschlechtElement.setTextContent("M");
            geschlechtElement.setAttribute("minOccurs", "1");
            antragstellerElement.appendChild(geschlechtElement);

            // Staatsangehoerigkeit
            Element staatsangehoerigkeitElement = doc.createElement("Staatsangehoerigkeit");
            antragstellerElement.appendChild(staatsangehoerigkeitElement);

            Element ersteAngehoerigkeitElement = doc.createElement("ersteAngehoerigkeit");
            ersteAngehoerigkeitElement.setTextContent("AA");
            ersteAngehoerigkeitElement.setAttribute("minOccurs", "1");
            staatsangehoerigkeitElement.appendChild(ersteAngehoerigkeitElement);

            Element zweiteAngehoerigkeitElement = doc.createElement("zweiteAngehoerigkeit");
            zweiteAngehoerigkeitElement.setTextContent("");
            zweiteAngehoerigkeitElement.setAttribute("minOccurs", "0");
            staatsangehoerigkeitElement.appendChild(zweiteAngehoerigkeitElement);

            Element drittAngehoerigkeitElement = doc.createElement("dritteAngehoerigkeit");
            drittAngehoerigkeitElement.setTextContent("");
            drittAngehoerigkeitElement.setAttribute("minOccurs", "0");
            staatsangehoerigkeitElement.appendChild(drittAngehoerigkeitElement);

            Element vierteAngehoerigkeitElement = doc.createElement("vierteAngehoerigkeit");
            vierteAngehoerigkeitElement.setTextContent("");
            vierteAngehoerigkeitElement.setAttribute("minOccurs", "0");
            staatsangehoerigkeitElement.appendChild(vierteAngehoerigkeitElement);

            // Ausweisdokument
            Element ausweisdokumentElement = doc.createElement("Ausweisdokument");
            antragstellerElement.appendChild(ausweisdokumentElement);

            // Gueltigkeit
            Element gueltigkeitElement = doc.createElement("Gueltigkeit");
            gueltigkeitElement.setAttribute("minOccurs", "0");
            ausweisdokumentElement.appendChild(gueltigkeitElement);

            Element beginnElement = doc.createElement("Beginn");
            beginnElement.setTextContent("2001-12-17T09:30:47Z");
            beginnElement.setAttribute("minOccurs", "1");
            gueltigkeitElement.appendChild(beginnElement);

            Element endeElement = doc.createElement("Ende");
            endeElement.setTextContent("2001-12-17T09:30:47Z");
            endeElement.setAttribute("minOccurs", "1");
            gueltigkeitElement.appendChild(endeElement);

            Element zusatzElement = doc.createElement("Zusatz");
            zusatzElement.setAttribute("minOccurs", "0");
            gueltigkeitElement.appendChild(zusatzElement);


            // Ausweisart
            Element ausweisartElement = doc.createElement("Ausweisart");
            ausweisartElement.setTextContent("ausweis");
            ausweisartElement.setAttribute("minOccurs", "1");
            ausweisdokumentElement.appendChild(ausweisartElement);

            // AusweisId
            Element ausweisIdElement = doc.createElement("AusweisId");
            ausweisIdElement.setTextContent("ausweisid");
            ausweisIdElement.setAttribute("minOccurs", "1");
            ausweisdokumentElement.appendChild(ausweisIdElement);

            // AusstellendesLand
            Element ausstellendesLandElement = doc.createElement("AusstellendesLand");
            ausstellendesLandElement.setTextContent("DE");
            ausstellendesLandElement.setAttribute("minOccurs", "1");
            ausweisdokumentElement.appendChild(ausstellendesLandElement);

            // Bezeichnung
            Element bezeichnungElement = doc.createElement("Bezeichnung");
            bezeichnungElement.setTextContent("ausweis");
            bezeichnungElement.setAttribute("minOccurs", "0");
            ausweisdokumentElement.appendChild(bezeichnungElement);

            // Aussteller
            Element ausstellerElement = doc.createElement("Aussteller");
            ausstellerElement.setTextContent("Frankfurt");
            ausstellerElement.setAttribute("minOccurs", "0");
            ausweisdokumentElement.appendChild(ausstellerElement);

            // Geburt
            Element geburtElement = doc.createElement("Geburt");
            antragstellerElement.appendChild(geburtElement);

            // Geburtsort
            Element geburtsortElement = doc.createElement("Geburtsort");
            geburtElement.appendChild(geburtsortElement);

            // Ort
            Element ortElement = doc.createElement("Ort");
            ortElement.setTextContent("a");
            ortElement.setAttribute("minOccurs", "1");
            geburtsortElement.appendChild(ortElement);

            // Postleitzahl
            Element postleitzahlElement = doc.createElement("Postleitzahl");
            postleitzahlElement.setTextContent("a");
            postleitzahlElement.setAttribute("minOccurs", "0");
            geburtsortElement.appendChild(postleitzahlElement);

            // Land
            Element landElement = doc.createElement("Land");
            landElement.setTextContent("DE");
            landElement.setAttribute("minOccurs", "1");
            geburtsortElement.appendChild(landElement);

            // Bezirk
            Element bezirkElement = doc.createElement("Bezirk");
            bezirkElement.setTextContent("a");
            bezirkElement.setAttribute("minOccurs", "0");
            geburtsortElement.appendChild(bezirkElement);

            // Datum
            Element datumElement = doc.createElement("Datum");
            datumElement.setTextContent("1900-00-00");
            datumElement.setAttribute("minOccurs", "1");
            geburtElement.appendChild(datumElement);

            // AktuelleAnschrift
            Element aktuelleAnschriftElement = doc.createElement("AktuelleAnschrift");
            antragstellerElement.appendChild(aktuelleAnschriftElement);

            // EinzugsDatum (AktuelleAnschrift)
            Element einzugsDatumAktuelleAnschriftElement = doc.createElement("EinzugsDatum");
            einzugsDatumAktuelleAnschriftElement.setTextContent("2001-12-17T09:30:47Z");
            einzugsDatumAktuelleAnschriftElement.setAttribute("minOccurs", "1");
            aktuelleAnschriftElement.appendChild(einzugsDatumAktuelleAnschriftElement);

            // Adresse (AktuelleAnschrift)
            Element adresseAktuelleAnschriftElement = doc.createElement("Adresse");
            aktuelleAnschriftElement.appendChild(adresseAktuelleAnschriftElement);

            // Strasse
            Element strasseElementAktuelleAnschrift = doc.createElement("Strasse");
            strasseElementAktuelleAnschrift.setTextContent("a");
            strasseElementAktuelleAnschrift.setAttribute("minOccurs", "0");
            adresseAktuelleAnschriftElement.appendChild(strasseElementAktuelleAnschrift);

            // Ort
            Element ortElementAktuelleAnschrift = doc.createElement("Ort");
            ortElementAktuelleAnschrift.setTextContent("a");
            ortElementAktuelleAnschrift.setAttribute("minOccurs", "0");
            adresseAktuelleAnschriftElement.appendChild(ortElementAktuelleAnschrift);

            // Postleitzahl
            Element postleitzahlElementAktuelleAnschrift = doc.createElement("Postleitzahl");
            postleitzahlElementAktuelleAnschrift.setTextContent("a");
            postleitzahlElementAktuelleAnschrift.setAttribute("minOccurs", "0");
            adresseAktuelleAnschriftElement.appendChild(postleitzahlElementAktuelleAnschrift);

            // AlternativAdressText
            Element alternativAdressTextElementAktuelleAnschrift = doc.createElement("AlternativAdressText");
            alternativAdressTextElementAktuelleAnschrift.setTextContent("a");
            alternativAdressTextElementAktuelleAnschrift.setAttribute("minOccurs", "0");
            adresseAktuelleAnschriftElement.appendChild(alternativAdressTextElementAktuelleAnschrift);

            // Bezirk
            Element bezirkElementAktuelleAnschrift = doc.createElement("Bezirk");
            bezirkElementAktuelleAnschrift.setTextContent("a");
            bezirkElementAktuelleAnschrift.setAttribute("minOccurs", "0");
            adresseAktuelleAnschriftElement.appendChild(bezirkElementAktuelleAnschrift);

            // Land
            Element landElementAktuelleAnschrift = doc.createElement("Land");
            landElementAktuelleAnschrift.setTextContent("AA");
            landElementAktuelleAnschrift.setAttribute("minOccurs", "1");
            adresseAktuelleAnschriftElement.appendChild(landElementAktuelleAnschrift);

            // Zusatz
            Element zusatzElementAktuelleAnschrift = doc.createElement("Zusatz");
            zusatzElementAktuelleAnschrift.setTextContent("a");
            zusatzElementAktuelleAnschrift.setAttribute("minOccurs", "0");
            adresseAktuelleAnschriftElement.appendChild(zusatzElementAktuelleAnschrift);

            // Meldebescheinigung (AktuelleAnschrift)
            Element meldebescheinigungElementAktuelleAnschrift = doc.createElement("Meldebescheinigung");
            meldebescheinigungElementAktuelleAnschrift.setTextContent("true");
            meldebescheinigungElementAktuelleAnschrift.setAttribute("minOccurs", "1");
            aktuelleAnschriftElement.appendChild(meldebescheinigungElementAktuelleAnschrift);

            // Zweitwohnsitz
            Element zweitwohnsitzElement = doc.createElement("Zweitwohnsitz");
            antragstellerElement.appendChild(zweitwohnsitzElement);

            // EinzugsDatum (Zweitwohnsitz)
            Element einzugsDatumZweitwohnsitzElement = doc.createElement("EinzugsDatum");
            einzugsDatumZweitwohnsitzElement.setTextContent("2001-12-17T09:30:47Z");
            einzugsDatumZweitwohnsitzElement.setAttribute("minOccurs", "1");
            zweitwohnsitzElement.appendChild(einzugsDatumZweitwohnsitzElement);

            // Adresse (Zweitwohnsitz)
            Element adresseZweitwohnsitzElement = doc.createElement("Adresse");
            zweitwohnsitzElement.appendChild(adresseZweitwohnsitzElement);

            // Strasse
            Element strasseElementZweitwohnsitz = doc.createElement("Strasse");
            strasseElementZweitwohnsitz.setTextContent("a");
            strasseElementZweitwohnsitz.setAttribute("minOccurs", "0");
            adresseZweitwohnsitzElement.appendChild(strasseElementZweitwohnsitz);

            // Ort
            Element ortElementZweitwohnsitz = doc.createElement("Ort");
            ortElementZweitwohnsitz.setTextContent("a");
            ortElementZweitwohnsitz.setAttribute("minOccurs", "0");
            adresseZweitwohnsitzElement.appendChild(ortElementZweitwohnsitz);

            // Postleitzahl
            Element postleitzahlElementZweitwohnsitz = doc.createElement("Postleitzahl");
            postleitzahlElementZweitwohnsitz.setTextContent("a");
            postleitzahlElementZweitwohnsitz.setAttribute("minOccurs", "0");
            adresseZweitwohnsitzElement.appendChild(postleitzahlElementZweitwohnsitz);

            // AlternativAdressText
            Element alternativAdressTextElementZweitwohnsitz = doc.createElement("AlternativAdressText");
            alternativAdressTextElementZweitwohnsitz.setTextContent("a");
            alternativAdressTextElementZweitwohnsitz.setAttribute("minOccurs", "0");
            adresseZweitwohnsitzElement.appendChild(alternativAdressTextElementZweitwohnsitz);

            // Bezirk
            Element bezirkElementZweitwohnsitz = doc.createElement("Bezirk");
            bezirkElementZweitwohnsitz.setTextContent("a");
            bezirkElementZweitwohnsitz.setAttribute("minOccurs", "0");
            adresseZweitwohnsitzElement.appendChild(bezirkElementZweitwohnsitz);

            // Land
            Element landElementZweitwohnsitz = doc.createElement("Land");
            landElementZweitwohnsitz.setTextContent("AA");
            landElementZweitwohnsitz.setAttribute("minOccurs", "1");
            adresseZweitwohnsitzElement.appendChild(landElementZweitwohnsitz);

            // Zusatz
            Element zusatzElementZweitwohnsitz = doc.createElement("Zusatz");
            zusatzElementZweitwohnsitz.setTextContent("a");
            zusatzElementZweitwohnsitz.setAttribute("minOccurs", "0");
            adresseZweitwohnsitzElement.appendChild(zusatzElementZweitwohnsitz);

            // Meldebescheinigung (Zweitwohnsitz)
            Element meldebescheinigungElementZweitwohnsitz = doc.createElement("Meldebescheinigung");
            meldebescheinigungElementZweitwohnsitz.setTextContent("true");
            meldebescheinigungElementZweitwohnsitz.setAttribute("minOccurs", "1");
            zweitwohnsitzElement.appendChild(meldebescheinigungElementZweitwohnsitz);

            Element fruehereAnschriftElement = doc.createElement("FruehereAnschrift");
            antragstellerElement.appendChild(fruehereAnschriftElement);

            // EinzugsDatum (FruehereAnschrift)
            Element einzugsDatumFruehereAnschriftElement = doc.createElement("EinzugsDatum");
            einzugsDatumFruehereAnschriftElement.setTextContent("2001-12-17T09:30:47Z");
            einzugsDatumFruehereAnschriftElement.setAttribute("minOccurs", "1");
            fruehereAnschriftElement.appendChild(einzugsDatumFruehereAnschriftElement);

            // Adresse (FruehereAnschrift)
            Element adresseFruehereAnschriftElement = doc.createElement("Adresse");
            fruehereAnschriftElement.appendChild(adresseFruehereAnschriftElement);

            // Strasse
            Element strasseElementFruehereAnschrift = doc.createElement("Strasse");
            strasseElementFruehereAnschrift.setTextContent("a");
            strasseElementFruehereAnschrift.setAttribute("minOccurs", "0");
            adresseFruehereAnschriftElement.appendChild(strasseElementFruehereAnschrift);

            // Ort
            Element ortElementFruehereAnschrift = doc.createElement("Ort");
            ortElementFruehereAnschrift.setTextContent("a");
            ortElementFruehereAnschrift.setAttribute("minOccurs", "0");
            adresseFruehereAnschriftElement.appendChild(ortElementFruehereAnschrift);

            // Postleitzahl
            Element postleitzahlElementFruehereAnschrift = doc.createElement("Postleitzahl");
            postleitzahlElementFruehereAnschrift.setTextContent("a");
            postleitzahlElementFruehereAnschrift.setAttribute("minOccurs", "0");
            adresseFruehereAnschriftElement.appendChild(postleitzahlElementFruehereAnschrift);

            // AlternativAdressText
            Element alternativAdressTextElementFruehereAnschrift = doc.createElement("AlternativAdressText");
            alternativAdressTextElementFruehereAnschrift.setTextContent("a");
            alternativAdressTextElementFruehereAnschrift.setAttribute("minOccurs", "0");
            adresseFruehereAnschriftElement.appendChild(alternativAdressTextElementFruehereAnschrift);

            // Bezirk
            Element bezirkElementFruehereAnschrift = doc.createElement("Bezirk");
            bezirkElementFruehereAnschrift.setTextContent("a");
            bezirkElementFruehereAnschrift.setAttribute("minOccurs", "0");
            adresseFruehereAnschriftElement.appendChild(bezirkElementFruehereAnschrift);

            // Land
            Element landElementFruehereAnschrift = doc.createElement("Land");
            landElementFruehereAnschrift.setTextContent("AA");
            landElementFruehereAnschrift.setAttribute("minOccurs", "1");
            adresseFruehereAnschriftElement.appendChild(landElementFruehereAnschrift);

            // Zusatz
            Element zusatzElementFruehereAnschrift = doc.createElement("Zusatz");
            zusatzElementFruehereAnschrift.setTextContent("a");
            zusatzElementFruehereAnschrift.setAttribute("minOccurs", "0");
            adresseFruehereAnschriftElement.appendChild(zusatzElementFruehereAnschrift);

            // Meldebescheinigung (FruehereAnschrift)
            Element meldebescheinigungElementFruehereAnschrift = doc.createElement("Meldebescheinigung");
            meldebescheinigungElementFruehereAnschrift.setTextContent("true");
            meldebescheinigungElementFruehereAnschrift.setAttribute("minOccurs", "1");
            fruehereAnschriftElement.appendChild(meldebescheinigungElementFruehereAnschrift);

            // Zweitwohnsitz (FruehereAnschrift)
            Element zweitwohnsitzElementFruehereAnschrift = doc.createElement("Zweitwohnsitz");
            zweitwohnsitzElementFruehereAnschrift.setTextContent("true");
            zweitwohnsitzElementFruehereAnschrift.setAttribute("minOccurs", "1");
            fruehereAnschriftElement.appendChild(zweitwohnsitzElementFruehereAnschrift);

            // EmailAdresse (minOccurs: 0)
            Element emailAdresseElement = doc.createElement("EmailAdresse");
            emailAdresseElement.setTextContent("@.");
            emailAdresseElement.setAttribute("minOccurs", "0");
            antragstellerElement.appendChild(emailAdresseElement);

            // AktuelleTaetigkeit
            Element aktuelleTaetigkeitElement = doc.createElement("AktuelleTaetigkeit");
            antragstellerElement.appendChild(aktuelleTaetigkeitElement);

            // Arbeitslos (minOccurs: 0)
            Element arbeitslosElement = doc.createElement("Arbeitslos");
            aktuelleTaetigkeitElement.appendChild(arbeitslosElement);

            // Beginn (Arbeitslos)
            Element beginnArbeitslosElement = doc.createElement("Beginn");
            beginnArbeitslosElement.setTextContent("2001-12-17T09:30:47Z");
            beginnArbeitslosElement.setAttribute("minOccurs", "1");
            arbeitslosElement.appendChild(beginnArbeitslosElement);

            // Eingangsfrist
            Element eingangsfristElement = doc.createElement("Eingangsfrist");
            eingangsfristElement.setTextContent("2001-12-17T09:30:47Z");
            eingangsfristElement.setAttribute("minOccurs", "1");
            anlassbezogenerUeberpruefungsAntragElement.appendChild(eingangsfristElement);

            // Fachbehoerde
            Element fachbehoerdeElement = doc.createElement("Fachbehoerde");
            fachbehoerdeElement.setAttribute("minOccurs", "1");
            anlassbezogenerUeberpruefungsAntragElement.appendChild(fachbehoerdeElement);

            // FachbehoerdenName
            Element fachbehoerdenNameElement = doc.createElement("FachbehoerdenName");
            fachbehoerdeElement.appendChild(fachbehoerdenNameElement);

            // NameLangform
            Element nameLangformElement = doc.createElement("NameLangform");
            nameLangformElement.setTextContent("a");
            nameLangformElement.setAttribute("minOccurs", "0");
            fachbehoerdenNameElement.appendChild(nameLangformElement);

            // NameKurzform
            Element nameKurzformElement = doc.createElement("NameKurzform");
            nameKurzformElement.setTextContent("a");
            nameKurzformElement.setAttribute("minOccurs", "0");
            fachbehoerdenNameElement.appendChild(nameKurzformElement);

            // Organisationseinheit
            Element organisationseinheitElement = doc.createElement("Organisationseinheit");
            organisationseinheitElement.setTextContent("a");
            organisationseinheitElement.setAttribute("minOccurs", "0");
            fachbehoerdenNameElement.appendChild(organisationseinheitElement);

            // FachbehoerdenAnschrift (minOccurs: 0)
            Element fachbehoerdenAnschriftElement = doc.createElement("FachbehoerdenAnschrift");
            fachbehoerdeElement.appendChild(fachbehoerdenAnschriftElement);

            // Bezirk
            Element bezirkElementFachbehoerdenAnschrift = doc.createElement("Bezirk");
            bezirkElementFachbehoerdenAnschrift.setTextContent("a");
            bezirkElementFachbehoerdenAnschrift.setAttribute("minOccurs", "0");
            fachbehoerdenAnschriftElement.appendChild(bezirkElementFachbehoerdenAnschrift);

            // PostfachStrasse
            Element postfachStrasseElement = doc.createElement("PostfachStrasse");
            postfachStrasseElement.setTextContent("a");
            postfachStrasseElement.setAttribute("minOccurs", "0");
            fachbehoerdenAnschriftElement.appendChild(postfachStrasseElement);

            // Postleitzahl
            Element postleitzahlElementFachbehoerdenAnschrift = doc.createElement("Postleitzahl");
            postleitzahlElementFachbehoerdenAnschrift.setTextContent("a");
            postleitzahlElementFachbehoerdenAnschrift.setAttribute("minOccurs", "0");
            fachbehoerdenAnschriftElement.appendChild(postleitzahlElementFachbehoerdenAnschrift);

            // Ort
            Element ortElementFachbehoerdenAnschrift = doc.createElement("Ort");
            ortElementFachbehoerdenAnschrift.setTextContent("a");
            ortElementFachbehoerdenAnschrift.setAttribute("minOccurs", "0");
            fachbehoerdenAnschriftElement.appendChild(ortElementFachbehoerdenAnschrift);

            // Telefonnummer
            Element telefonnummerElement = doc.createElement("Telefonnummer");
            telefonnummerElement.setTextContent("a");
            telefonnummerElement.setAttribute("minOccurs", "0");
            fachbehoerdeElement.appendChild(telefonnummerElement);

            // Faxnummer
            Element faxnummerElement = doc.createElement("Faxnummer");
            faxnummerElement.setTextContent("a");
            faxnummerElement.setAttribute("minOccurs", "0");
            fachbehoerdeElement.appendChild(faxnummerElement);

            // Ansprechpartner (minOccurs: 0)
            Element ansprechpartnerElement = doc.createElement("Ansprechpartner");
            fachbehoerdeElement.appendChild(ansprechpartnerElement);

            // Beschreibung
            Element ansprechpartnerbeschreibungElement = doc.createElement("Beschreibung");
            ansprechpartnerbeschreibungElement.setTextContent("a");
            ansprechpartnerbeschreibungElement.setAttribute("minOccurs", "0");
            ansprechpartnerElement.appendChild(ansprechpartnerbeschreibungElement);

            // Anrede
            Element ansprechpartneranredeElement = doc.createElement("Anrede");
            ansprechpartneranredeElement.setTextContent("a");
            ansprechpartneranredeElement.setAttribute("minOccurs", "0");
            ansprechpartnerElement.appendChild(ansprechpartneranredeElement);

            // Nachname
            Element ansprechpartnernachnameElement = doc.createElement("Nachname");
            ansprechpartnernachnameElement.setTextContent("a");
            ansprechpartnernachnameElement.setAttribute("minOccurs", "0");
            ansprechpartnerElement.appendChild(ansprechpartnernachnameElement);

            // Vorname
            Element ansprechpartnervornameElement = doc.createElement("Vorname");
            ansprechpartnervornameElement.setTextContent("a");
            ansprechpartnervornameElement.setAttribute("minOccurs", "0");
            ansprechpartnerElement.appendChild(ansprechpartnervornameElement);

            // Email
            Element ansprechpartneremailElement = doc.createElement("Email");
            ansprechpartneremailElement.setTextContent("@.");
            ansprechpartneremailElement.setAttribute("minOccurs", "0");
            ansprechpartnerElement.appendChild(ansprechpartneremailElement);

            // Telefonnummer (Ansprechpartner)
            Element telefonnummerElementAnsprechpartner = doc.createElement("Telefonnummer");
            telefonnummerElementAnsprechpartner.setTextContent("a");
            telefonnummerElementAnsprechpartner.setAttribute("minOccurs", "0");
            ansprechpartnerElement.appendChild(telefonnummerElementAnsprechpartner);

            // Mobilnummer
            Element mobilnummerElement = doc.createElement("Mobilnummer");
            mobilnummerElement.setTextContent("a");
            mobilnummerElement.setAttribute("minOccurs", "0");
            ansprechpartnerElement.appendChild(mobilnummerElement);

            // Faxnummer (Ansprechpartner)
            Element faxnummerElementAnsprechpartner = doc.createElement("Faxnummer");
            faxnummerElementAnsprechpartner.setTextContent("a");
            faxnummerElementAnsprechpartner.setAttribute("minOccurs", "0");
            ansprechpartnerElement.appendChild(faxnummerElementAnsprechpartner);

            // BetriebsOrte (minOccurs: 0)
            Element betriebsOrteElement = doc.createElement("BetriebsOrte");
            anlassbezogenerUeberpruefungsAntragElement.appendChild(betriebsOrteElement);

            // AnlassOrt
            Element anlassOrtElement = doc.createElement("AnlassOrt");
            anlassOrtElement.setTextContent("a");
            anlassOrtElement.setAttribute("minOccurs", "1");
            betriebsOrteElement.appendChild(anlassOrtElement);

            // Erkenntnisstellen (minOccurs: 0)
            Element erkenntnisstellenElement = doc.createElement("Erkenntnisstellen");
            anlassbezogenerUeberpruefungsAntragElement.appendChild(erkenntnisstellenElement);

            // ErkenntnisstelleUUID
            Element erkenntnisstelleUUIDElement = doc.createElement("ErkenntnisstelleUUID");
            erkenntnisstelleUUIDElement.setTextContent("00000000-0000-0000-0000-000000000000");
            erkenntnisstelleUUIDElement.setAttribute("minOccurs", "1");
            erkenntnisstellenElement.appendChild(erkenntnisstelleUUIDElement);

            // Erstellen des Transformers, um die DOM in eine Datei zu schreiben
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty("indent", "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("example.xml");
            transformer.transform(source, result);
            System.out.println("XML-Datei wurde erfolgreich erstellt.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
