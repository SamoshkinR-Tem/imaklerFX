import model.entities.Flat;
import model.tools.FileUtil;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by R-Tem on 10.06.2015.
 */
public class WriteFlatsToXML {
    @Test
    public void test() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = documentBuilder.newDocument();
        Element rootElement = document.createElement("flats");
        rootElement.setAttribute("class", "Flat");
        document.appendChild(rootElement);

        ArrayList<Flat> flats = new FileUtil<Flat>().readObjFromFile("src/main/resources/data/ser/flats.ser");
        for (int i = 0; i < flats.size(); i++) {
            Element idElement = document.createElement("id");
            idElement.appendChild(document.createTextNode(flats.get(i).getId())); // first variant
//            -----------------------------------------------------
            Element roomsNumElement = document.createElement("roomsNum");
            roomsNumElement.appendChild(document.createTextNode(flats.get(i).getRoomsNum())); // first variant
//            -----------------------------------------------------
            Element dateOfComeElement = document.createElement("dateOfCome");
            dateOfComeElement.setTextContent(flats.get(i).getDateOfCome());// second variant
//            -----------------------------------------------------
            Element dateOfCallElement = document.createElement("dateOfCall");
            dateOfCallElement.setTextContent(flats.get(i).getDateOfCall());
//            -----------------------------------------------------
            Element addressElement = document.createElement("address");
            addressElement.appendChild(document.createTextNode(flats.get(i).getAddress()));
//            -----------------------------------------------------
            Element parametersElement = document.createElement("parameters");
            parametersElement.appendChild(document.createTextNode(flats.get(i).getParameters()));
//            -----------------------------------------------------
            Element conditionElement = document.createElement("condition");
            conditionElement.appendChild(document.createTextNode(flats.get(i).getCondition()));
//            -----------------------------------------------------
            Element contactNumberElement = document.createElement("contactNumber");
            contactNumberElement.appendChild(document.createTextNode(flats.get(i).getContactNumber()));
//            -----------------------------------------------------
            Element contactNameElement = document.createElement("contactName");
            contactNameElement.appendChild(document.createTextNode(flats.get(i).getContactName()));
//            -----------------------------------------------------
            Element contactStatusElement = document.createElement("contactStatus");
            contactStatusElement.appendChild(document.createTextNode(flats.get(i).getContactStatus()));
//            -----------------------------------------------------
            Element priceElement = document.createElement("price");
            priceElement.appendChild(document.createTextNode(flats.get(i).getPrice()));
//            -----------------------------------------------------
            Element kievDistrictElement = document.createElement("kievDistrict");
            kievDistrictElement.appendChild(document.createTextNode(flats.get(i).getKievDistrict()));
//            -----------------------------------------------------
//            Element nameFromYandexElement = document.createElement("nameFromYandex");
//            nameFromYandexElement.appendChild(document.createTextNode(flats.get(i).getNameFromYandex()));
//            -----------------------------------------------------
//            Element buildingStatusElement = document.createElement("buildingStatus");
//            buildingStatusElement.appendChild(document.createTextNode(flats.get(i).getBuildingStatus()));
//            -----------------------------------------------------
            Element flatElement = document.createElement("flat");
            flatElement.setAttribute("rowColor", flats.get(i).getRowColor());
            flatElement.appendChild(idElement);
            flatElement.appendChild(roomsNumElement);
            flatElement.appendChild(dateOfComeElement);
            flatElement.appendChild(dateOfCallElement);
            flatElement.appendChild(addressElement);
            flatElement.appendChild(parametersElement);
            flatElement.appendChild(conditionElement);
            flatElement.appendChild(contactNumberElement);
            flatElement.appendChild(contactNameElement);
            flatElement.appendChild(contactStatusElement);
            flatElement.appendChild(priceElement);
            flatElement.appendChild(kievDistrictElement);
//            flatElement.appendChild(nameFromYandexElement);
//            flatElement.appendChild(buildingStatusElement);

            rootElement.appendChild(flatElement);
        }
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            DOMSource source = new DOMSource(document);
            Writer out = new OutputStreamWriter(new FileOutputStream("C:/Users/R-Tem/IdeaProjects/imakler/resources/data/xml/flats.xml"), "UTF-8");
            StreamResult result = new StreamResult(out);
            transformer.transform(source, result);
//            StreamResult resultStream = new StreamResult(System.out);
//            transformer.transform(source, resultStream);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done!");
    }
}
