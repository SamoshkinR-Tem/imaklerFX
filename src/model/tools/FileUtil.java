package model.tools;

import model.entities.Flat;
import model.entities.User;
import model.interfaces.IFileTools;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by R-Tem on 22.05.2015.
 */
public class FileUtil<T> implements IFileTools<T> {

    @Override
    public void writeStringToFile(String txt, String path, Boolean addToEnd) {
        // AddToEnd:::::: TRUE - дописывать в конец, FALSE - перезаписать всё
        try {
            FileWriter writer = new FileWriter(path, addToEnd);
            writer.write(txt);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeObjToFile(T object, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void wrireFlatsToXML(ArrayList<Flat> flats) {
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

        for (int i = 0; i < flats.size(); i++) {
            Element flatIdElement = document.createElement("flatId");
            flatIdElement.setTextContent(flats.get(i).getId());// second variant
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
            Element nameFromYandexElement = document.createElement("nameFromYandex");
            nameFromYandexElement.appendChild(document.createTextNode(flats.get(i).getNameFromYandex()));
//            -----------------------------------------------------
            Element buildingStatusElement = document.createElement("buildingStatus");
            buildingStatusElement.appendChild(document.createTextNode(flats.get(i).getBuildingStatus()));
//            -----------------------------------------------------
            Element flatElement = document.createElement("flat");
            flatElement.setAttribute("rowColor", flats.get(i).getRowColor());
            flatElement.appendChild(flatIdElement);
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
            flatElement.appendChild(nameFromYandexElement);
            flatElement.appendChild(buildingStatusElement);

            rootElement.appendChild(flatElement);
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileWriter("/resources/data/xml/flats.xml"));
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
    }

    public void writeUserToXML(ArrayList<User> users) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = documentBuilder.newDocument();
        Element rootElement = document.createElement("users");
        rootElement.setAttribute("class", "User");
        document.appendChild(rootElement);

        for (int i = 0; i < users.size(); i++) {
            Element userNameElement = document.createElement("username");
            userNameElement.appendChild(document.createTextNode(users.get(i).getUserName())); // first variant
            Element passwordElement = document.createElement("password");
            passwordElement.setTextContent(users.get(i).getPassword()); // seccond variant

            Element userElement = document.createElement("user");
            userElement.setAttribute("index", String.valueOf(i));
            userElement.appendChild(userNameElement);
            userElement.appendChild(passwordElement);

            rootElement.appendChild(userElement);
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileWriter("src/main/resources/data/xml/user.xml"));
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
    }

    @Override
    public ArrayList<String[]> readStringFromFile(String path, String RegExp) {
        ArrayList<String[]> fileStrings = new ArrayList<>();
        File file = new File(path);
        FileReader reader = null;
        try {
            reader = new FileReader(file);

            BufferedReader buffer = new BufferedReader(reader);
            String line;
            while ((line = buffer.readLine()) != null) {
                String[] preEntity = line.split(RegExp);
                fileStrings.add(preEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileStrings;
    }

    @Override
    public ArrayList<T> readObjFromFile(String path) {
        ArrayList<T> arrayList = new ArrayList<T>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            arrayList = (ArrayList<T>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public ArrayList<T> readFlatsFromXML (String path) {
        ArrayList<T> flats = new ArrayList<>();
        Flat flat = new Flat();

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        Document doc = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(new File(path));
            doc.getDocumentElement().normalize();
        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        try {
            NodeList nList = doc.getElementsByTagName("flat");
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
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
                    flat.setNameFromYandex(e.getElementsByTagName("nameFromYandex").item(0).getTextContent());
                    flat.setBuildingStatus(e.getElementsByTagName("buildingStatus").item(0).getTextContent());

                    flats.add((T) flat);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flats;
    }
}
