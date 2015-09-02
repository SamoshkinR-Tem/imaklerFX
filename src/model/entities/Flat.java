package model.entities;

import java.io.Serializable;

/**
 * Created by R-Tem on 09.06.2015.
 */
public class Flat implements Serializable {

    private String id;
    private String roomsNum;
    private String dateOfCome;
    private String dateOfCall;
    private String address;
    private String parameters;
    private String condition;
    private String contactNumber;
    private String contactName;
    private String contactStatus;
    private String price;
    private String kievDistrict;
    private String rowColor;
    private String nameFromYandex;
    private String buildingStatus;

    public Flat(String id, String roomsNum, String dateOfCome, String dateOfCall, String address, String parameters,
                String condition, String contactNumber, String contactName, String contactStatus, String price,
                String kievDistrict, String rowColor, String nameFromYandex, String buildingStatus) {
        this.id = id;
        this.roomsNum = roomsNum;
        this.dateOfCome = dateOfCome;
        this.dateOfCall = dateOfCall;
        this.address = address;
        this.parameters = parameters;
        this.condition = condition;
        this.contactNumber = contactNumber;
        this.contactName = contactName;
        this.contactStatus = contactStatus;
        this.price = price;
        this.kievDistrict = kievDistrict;
        this.rowColor = rowColor;
        this.nameFromYandex = nameFromYandex;
        this.buildingStatus = buildingStatus;
    }

    public Flat() {
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getRoomsNum() {
        return roomsNum;
    }
    public void setRoomsNum(String roomsNum) {
        this.roomsNum = roomsNum;
    }

    public String getDateOfCome() {
        return dateOfCome;
    }
    public void setDateOfCome(String dateOfCome) {
        this.dateOfCome = dateOfCome;
    }

    public String getDateOfCall() {
        return dateOfCall;
    }
    public void setDateOfCall(String dateOfCall) {
        this.dateOfCall = dateOfCall;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getParameters() {
        return parameters;
    }
    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactStatus() {
        return contactStatus;
    }
    public void setContactStatus(String contactStatus) {
        this.contactStatus = contactStatus;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getKievDistrict() {
        return kievDistrict;
    }
    public void setKievDistrict(String kievDistrict) {
        this.kievDistrict = kievDistrict;
    }

    public String getRowColor(){return rowColor; }
    public void setRowColor(String rowColor) { this.rowColor = rowColor;}

    public String getNameFromYandex() {
        return nameFromYandex;
    }
    public void setNameFromYandex(String nameFromYandex) {
        this.nameFromYandex = nameFromYandex;
    }

    public String getBuildingStatus() {
        return buildingStatus;
    }
    public void setBuildingStatus(String buildingStatus) {
        this.buildingStatus = buildingStatus;
    }

    @Override
    public String toString() {
        return  id + ": " +
                roomsNum + ": " +
                dateOfCall + ": " +
                price + ": " +
                address + ": " +
                parameters + ": " +
                contactNumber + " " +
                contactName + " " +
                contactStatus + ": " +
                dateOfCome + ": " +
                ", kievDistrict='" + kievDistrict + '\'' +
                ", nameFromYandex='" + nameFromYandex + '\'' +
                ", buildingStatus='" + buildingStatus;
    }
}
