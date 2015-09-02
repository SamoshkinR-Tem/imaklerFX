import model.entities.Flat;
import model.tools.FileUtil;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by R-Tem on 11.06.2015.
 */
public class ReadFlatsFromXML {
    @Test
    public void test (){
        ArrayList<Flat> flats = new ArrayList<>();

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        Document doc = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(new File("C:/Users/R-Tem/IdeaProjects/imakler/resources/data/xml/flats.xml"));
            doc.getDocumentElement().normalize();
        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("flat");
            System.out.println("----------------------------");
            for (int i = 0; i < nList.getLength(); i++) {
                Flat flat = new Flat();
                Node node = nList.item(i);
                System.out.println("\nCurrent Element :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) node;
                    flat.setRoomsNum(e.getElementsByTagName("roomsNum").item(0).getTextContent());
                    flat.setDateOfCome(e.getElementsByTagName("dateOfCome").item(0).getTextContent());
                    flat.setDateOfCall(e.getElementsByTagName("dateOfCall").item(0).getTextContent());
                    flat.setAddress(e.getElementsByTagName("address").item(0).getTextContent());
                    flat.setParameters(e.getElementsByTagName("parameters").item(0).getTextContent());
                    flat.setCondition(e.getElementsByTagName("condition").item(0).getTextContent());
                    flat.setContactNumber(e.getElementsByTagName("contactNumber").item(0).getTextContent());
                    flat.setContactName(e.getElementsByTagName("contactName").item(0).getTextContent());
                    flat.setContactStatus(e.getElementsByTagName("contactStatus").item(0).getTextContent());
                    flat.setPrice(e.getElementsByTagName("price").item(0).getTextContent());
                    flat.setKievDistrict(e.getElementsByTagName("kievDistrict").item(0).getTextContent());
                    flat.setRowColor(e.getAttribute("rowColor"));
//                    flat.setNameFromYandex(e.getElementsByTagName("nameFromYandex").item(0).getTextContent());
//                    flat.setBuildingStatus(e.getElementsByTagName("buildingStatus").item(0).getTextContent());
                }
                flat.setId(String.valueOf(i+17));
                flats.add(flat);
                System.out.println(flats.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        new FileUtil().writeObjToFile(flats, "C:/Users/R-Tem/IdeaProjects/imakler/resources/data/ser/flats.ser");
    }
}
