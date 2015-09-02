package controller.customerWin;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import javafx.util.Callback;
import model.entities.Customer;

/**
 * Created by R-Tem on 15.07.2015.
 */
public class CustomerTabCtrl {
    @FXML private TableView tbSeenFlats;
    @FXML private TableColumn tcSeenFlats;
    @FXML private TableColumn tcDateSeen;
    @FXML private TableView tbFlatsToBeSeen;
    @FXML private TableColumn tcFlatsToBeSeen;
    @FXML private TableColumn tcDateToBeSeen;
    @FXML private ScrollPane spForWebView;
    @FXML private AnchorPane apForWebView;
    @FXML private WebView webView;

    public void customerTabIni(Tab tab, Customer customer){

        tab.setText(customer.getCustomerName()+" "+customer.getCustomerNumber());
        tab.setId(customer.getCustomerName()+" "+customer.getCustomerNumber());

        ObservableList<SeenFlat> seenFlats = FXCollections.observableArrayList(
                new SeenFlat("test", "test"),
                new SeenFlat("test", "test")
        );

        tcSeenFlats.setCellFactory(new Callback<TableColumn<SeenFlat, String>, TableCell<SeenFlat, String>>() {
            @Override
            public TableCell<SeenFlat, String> call(TableColumn <SeenFlat, String> p) {
                TableCell<SeenFlat, String> tc = new TableCell<SeenFlat, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        if (item != null) {
                            setText(item);
                        }
                    }
                };
                tc.setAlignment(Pos.CENTER);
                return tc;
            }
        });
        tcSeenFlats.setCellValueFactory(new PropertyValueFactory<>("flatShort"));
        tcDateToBeSeen.setCellFactory(new Callback<TableColumn<SeenFlat, String>, TableCell<SeenFlat, String>>() {
            @Override
            public TableCell<SeenFlat, String> call(TableColumn<SeenFlat, String> p) {
                TableCell<SeenFlat, String> tc = new TableCell<SeenFlat, String>(){
                    @Override
                    public void updateItem(String item, boolean empty) {
                        if (item != null){
                            setText(item);
                        }
                    }
                };
                tc.setAlignment(Pos.CENTER);
                return tc;
            }
        });
        tcDateSeen.setCellValueFactory(new PropertyValueFactory<>("date"));
        tbSeenFlats.setItems(seenFlats);

        ObservableList<FlatToBeSeen> flatsToBeSeen = FXCollections.observableArrayList(
                new FlatToBeSeen("ул. Вышгородская 46а,\n45/21/7, 2/5, косм рем, 45 000 у.е.\n093 006 21 61 Артем ", "06.07.2015\n19-00")
        );

        tcFlatsToBeSeen.setCellFactory(new Callback<TableColumn<SeenFlat, String>, TableCell<SeenFlat, String>>() {
            @Override
            public TableCell<SeenFlat, String> call(TableColumn<SeenFlat, String> p) {
                TableCell<SeenFlat, String> tc = new TableCell<SeenFlat, String>(){
                    @Override
                    public void updateItem(String item, boolean empty) {
                        if (item != null){
                            setText(item);
                        }
                    }
                };
                tc.setAlignment(Pos.CENTER);
                return tc;
            }
        });
        tcFlatsToBeSeen.setCellValueFactory(new PropertyValueFactory<>("flatShort"));
        tcDateToBeSeen.setCellFactory( new Callback< TableColumn<SeenFlat, String>, TableCell<SeenFlat, String>>(){
            @Override
            public TableCell<SeenFlat, String> call(TableColumn<SeenFlat, String> p) {
                TableCell<SeenFlat, String> tc = new TableCell<SeenFlat, String>(){
                    @Override
                    public void updateItem(String item, boolean empty) {
                        if (item != null){
                            setText(item);
                        }
                    }
                };
                tc.setAlignment(Pos.CENTER);
                return tc;
            }
        });
        tcDateToBeSeen.setCellValueFactory(new PropertyValueFactory<>("date"));
        tbFlatsToBeSeen.setItems(flatsToBeSeen);
    }

    public static class SeenFlat {
        private final SimpleStringProperty flatShort;
        private final SimpleStringProperty date;

        public SeenFlat(String flatShort, String date) {
            this.flatShort = new SimpleStringProperty(flatShort);
            this.date = new SimpleStringProperty(date);
        }

        public String getFlatShort() {
            return flatShort.get();
        }
        public String getDate() {
            return date.get();
        }
    }
    public static class FlatToBeSeen {
        private final SimpleStringProperty flatShort;
        private final SimpleStringProperty date;

        public FlatToBeSeen(String flatShort, String date) {
            this.flatShort = new SimpleStringProperty(flatShort);
            this.date = new SimpleStringProperty(date);
        }

        public String getFlatShort() {
            return flatShort.get();
        }
        public String getDate() {
            return date.get();
        }

    }
}
