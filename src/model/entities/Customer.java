package model.entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by R-Tem on 02.07.2015.
 */
public class Customer implements Serializable {
    private String id;
    private String dateOfCome;
    private String dateOfCall;
    private String customerName;
    private String customerNumber;
    private Flat comingFlat;

    private String searchRequest;
    private ArrayList<Flat> seenFlats;
    private ArrayList<Flat> flatsToBeSeen;

    public Customer(String id, String dateOfCome, String dateOfCall, String customerName, String customerNumber,
                    Flat comingFlat, String searchRequest) {
        this.id = id;
        this.dateOfCome = dateOfCome;
        this.dateOfCall = dateOfCall;
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.comingFlat = comingFlat;
        this.searchRequest = searchRequest;
    }

    public Customer(String id){ this.id = id; }
    public Customer() {}

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }
    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Flat getComingFlat() {
        return comingFlat;
    }
    public void setComingFlat(Flat comingFlat) {
        this.comingFlat = comingFlat;
    }

    public String getSearchRequest() {
        return searchRequest;
    }
    public void setSearchRequest(String searchRequest) {
        this.searchRequest = searchRequest;
    }

    public ArrayList<Flat> getSeenFlats() {
        return seenFlats;
    }
    public void setSeenFlats(ArrayList<Flat> seenFlats) {
        this.seenFlats = seenFlats;
    }

    public ArrayList<Flat> getFlatsToBeSeen() {
        return flatsToBeSeen;
    }
    public void setFlatsToBeSeen(ArrayList<Flat> flatsToBeSeen) {
        this.flatsToBeSeen = flatsToBeSeen;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", dateOfCome='" + dateOfCome + '\'' +
                ", dateOfCall='" + dateOfCall + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                ", comingFlat=" + comingFlat +
                ", searchRequest='" + searchRequest + '\'' +
                ", seenFlats=" + seenFlats +
                ", flatsToBeSeen=" + flatsToBeSeen +
                '}';
    }
}
