package controller;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import model.MainApp;
import model.entities.Customer;
import model.entities.Flat;
import model.factories.StyleChangingRowFactory;
import model.tools.FileUtil;

import java.util.ArrayList;

/**
 * Created by R-Tem on 20.06.2015.
 */
public class DataBaseCtrl {

    private MainApp mainApp;

    @FXML
    private Button btnNewFlat;
    @FXML
    private ToggleButton togbEditInTable;
    @FXML
    private Button btnToArchiv;
    @FXML
    private Button btnViewAviso;
    @FXML
    private ToggleButton togbSelectTable;
    @FXML
    private MenuButton customersMenuBtn;
    @FXML
    private Button btnSaveTable;
    @FXML
    private TableView<Flat> tvDataBase;
    @FXML
    private TableColumn<Flat, String> flatIdCol;
    @FXML
    private TableColumn<Flat, String> roomsNumCol;
    @FXML
    private TableColumn<Flat, String> dateOfCallCol;
    @FXML
    private TableColumn<Flat, String> priceCol;
    @FXML
    private TableColumn<Flat, String> addressCol;
    @FXML
    private TableColumn<Flat, String> parametersCol;
    @FXML
    private TableColumn<Flat, String> conditionCol;
    @FXML
    private TableColumn<Flat, String> contactNumCol;
    @FXML
    private TableColumn<Flat, String> contactNameCol;
    @FXML
    private TableColumn<Flat, String> contactStatusCol;
    @FXML
    private TableColumn<Flat, String> dateOfComeCol;
    @FXML
    private TableColumn<Flat, String> kievDistrictCol;

    private static final DataFormat SERIALIZED_MIME_TYPE = new DataFormat("application/x-java-serialized-object");

    private int rowId = -1;

    /**
     * Constructor
     */
    public DataBaseCtrl() {
    }

    public void ini() {
        tableIni();
        rowsHighlight();
        togbEditInTableIni();
        customersMenuBtnIni();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    private void tableIni() {
        columnsIni();
        tvDataBase.setItems(mainApp.getFlats());
        setRowFactory();
        tvDataBase.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        mainApp.getFlats().addListener(new ListChangeListener<Flat>() {
            @Override
            public void onChanged(Change<? extends Flat> c) {
                rowsHighlight();
            }
        });
    }
    private void columnsIni(){
        flatIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        flatIdCol.setCellFactory(TextFieldTableCell.<Flat>forTableColumn());
        flatIdCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Flat, String> t) -> {
                    (t.getTableView().getItems().get(t.getTablePosition().getRow())).setId(t.getNewValue());
                });
        roomsNumCol.setCellValueFactory(new PropertyValueFactory<>("roomsNum"));
        roomsNumCol.setCellFactory(TextFieldTableCell.<Flat>forTableColumn());
        roomsNumCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Flat, String> t) -> {
                    (t.getTableView().getItems().get(t.getTablePosition().getRow())).setRoomsNum(t.getNewValue());
                });
        dateOfCallCol.setCellValueFactory(new PropertyValueFactory<>("dateOfCall"));
        dateOfCallCol.setCellFactory(TextFieldTableCell.<Flat>forTableColumn());
        dateOfCallCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Flat, String> t) -> {
                    (t.getTableView().getItems().get(t.getTablePosition().getRow())).setDateOfCall(t.getNewValue());
                });
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceCol.setCellFactory(TextFieldTableCell.<Flat>forTableColumn());
        priceCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Flat, String> t) -> {
                    (t.getTableView().getItems().get(t.getTablePosition().getRow())).setPrice(t.getNewValue());
                });
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        addressCol.setCellFactory(TextFieldTableCell.<Flat>forTableColumn());
        addressCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Flat, String> t) -> {
                    (t.getTableView().getItems().get(t.getTablePosition().getRow())).setAddress(t.getNewValue());
                });
        parametersCol.setCellValueFactory(new PropertyValueFactory<>("parameters"));
        parametersCol.setCellFactory(TextFieldTableCell.<Flat>forTableColumn());
        parametersCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Flat, String> t) -> {
                    (t.getTableView().getItems().get(t.getTablePosition().getRow())).setParameters(t.getNewValue());
                });
        conditionCol.setCellValueFactory(new PropertyValueFactory<>("condition"));
        conditionCol.setCellFactory(TextFieldTableCell.<Flat>forTableColumn());
        conditionCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Flat, String> t) -> {
                    (t.getTableView().getItems().get(t.getTablePosition().getRow())).setCondition(t.getNewValue());
                });
        contactNumCol.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        contactNumCol.setCellFactory(TextFieldTableCell.<Flat>forTableColumn());
        contactNumCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Flat, String> t) -> {
                    (t.getTableView().getItems().get(t.getTablePosition().getRow())).setContactNumber(t.getNewValue());
                });
        contactNameCol.setCellValueFactory(new PropertyValueFactory<>("contactName"));
        contactNameCol.setCellFactory(TextFieldTableCell.<Flat>forTableColumn());
        contactNameCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Flat, String> t) -> {
                    (t.getTableView().getItems().get(t.getTablePosition().getRow())).setContactName(t.getNewValue());
                });
        contactStatusCol.setCellValueFactory(new PropertyValueFactory<>("contactStatus"));
        contactStatusCol.setCellFactory(TextFieldTableCell.<Flat>forTableColumn());
        contactStatusCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Flat, String> t) -> {
                    (t.getTableView().getItems().get(t.getTablePosition().getRow())).setContactStatus(t.getNewValue());
                });
        dateOfComeCol.setCellValueFactory(new PropertyValueFactory<>("dateOfCome"));
        dateOfComeCol.setCellFactory(TextFieldTableCell.<Flat>forTableColumn());
        dateOfComeCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Flat, String> t) -> {
                    (t.getTableView().getItems().get(t.getTablePosition().getRow())).setDateOfCome(t.getNewValue());
                });
        kievDistrictCol.setCellValueFactory(new PropertyValueFactory<>("kievDistrict"));
        kievDistrictCol.setCellFactory(TextFieldTableCell.<Flat>forTableColumn());
        kievDistrictCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Flat, String> t) -> {
                    (t.getTableView().getItems().get(t.getTablePosition().getRow())).setKievDistrict(t.getNewValue());
                });
    }
    private void setRowFactory(){
        tvDataBase.setRowFactory(tv -> {
            TableRow<Flat> row = new TableRow<>();
            row.setId(String.valueOf(rowId));

            if (rowId >= 0 && rowId < mainApp.getFlats().size()) {
                switch (mainApp.getFlats().get(rowId).getRowColor()) {
                    case "lightGreen":
                        row.getStyleClass().add("rowStyleClasslightGreen");
                        break;
                    case "Green":
                        row.getStyleClass().add("rowStyleClassGreen");
                        break;
                    case "Yellow":
                        row.getStyleClass().add("rowStyleClassYellow");
                        break;
                    case "Red":
                        row.getStyleClass().add("rowStyleClassRed");
                        break;
                    case "Blue":
                        row.getStyleClass().add("rowStyleClassBlue");
                        break;
                    default:
                        break;
                }
            }
            rowId++;

            row.setOnDragDetected(event -> {
                if (!row.isEmpty()) {
                    Integer index = row.getIndex();
                    Dragboard db = row.startDragAndDrop(TransferMode.MOVE);
                    db.setDragView(row.snapshot(null, null));
                    ClipboardContent cc = new ClipboardContent();
                    cc.put(SERIALIZED_MIME_TYPE, index);
                    db.setContent(cc);
                    event.consume();
                }
            });

            row.setOnDragOver(event -> {
                Dragboard db = event.getDragboard();
                if (db.hasContent(SERIALIZED_MIME_TYPE)) {
                    if (row.getIndex() != ((Integer) db.getContent(SERIALIZED_MIME_TYPE)).intValue()) {
                        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                        event.consume();
                    }
                }
            });

            row.setOnDragDropped(event -> {
                Dragboard db = event.getDragboard();
                if (db.hasContent(SERIALIZED_MIME_TYPE)) {
                    int draggedIndex = (Integer) db.getContent(SERIALIZED_MIME_TYPE);
                    Flat draggedFlat = tvDataBase.getItems().remove(draggedIndex);

                    int dropIndex;

                    if (row.isEmpty()) {
                        dropIndex = tvDataBase.getItems().size();
                    } else {
                        dropIndex = row.getIndex();
                    }

                    tvDataBase.getItems().add(dropIndex, draggedFlat);
                    tvDataBase.getSelectionModel().clearAndSelect(dropIndex);
                    event.setDropCompleted(true);
                    event.consume();
                }
            });
            return row;
        });
    }
    private void rowsHighlight() {
        // highlight the table rows depending upon whether we expect to get paid.
        int i = 0;
        for (Node n: tvDataBase.lookupAll("TableRow")) {
            if (n instanceof TableRow) {
                TableRow row = (TableRow) n;
                switch (tvDataBase.getItems().get(i).getRowColor()) {
                    case "lightGreen":
                        row.setStyle("-fx-background-color: rgba(124, 252, 0, 0.312);");
                        break;
                    case "Green":
                        row.setStyle("-fx-background-color: rgba(34, 139, 34, 0.312);");
                        break;
                    case "Yellow":
                        row.setStyle("-fx-background-color: rgba(255, 255, 0, 0.312);");
                        break;
                    case "Red":
                        row.setStyle("-fx-background-color: rgba(255, 0, 0, 0.312);");
                        break;
                    case "Blue":
                        row.setStyle("-fx-background-color: rgba(0, 0, 255, 0.312);");
                        break;
                    default:
                        break;
                }
                i++;
                if (i == tvDataBase.getItems().size())
                    break;
            }
        }
    }

    private void togbEditInTableIni() {
        togbEditInTable.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean b, Boolean new_b) -> {
                    if (new_b == true) {
                        tvDataBase.setEditable(true);
                    } else {
                        tvDataBase.setEditable(false);
                    }
                }
        );
    }

    private void customersMenuBtnIni() {
        CustomerCtrl customerCtrl = new CustomerCtrl();
        customerCtrl.setMainApp(mainApp);
        for (int i = 0; i < mainApp.getCustomers().size(); i++) {
            MenuItem menuItem = new MenuItem(mainApp.getCustomers().get(i).getCustomerName() +
                    "  " + mainApp.getCustomers().get(i).getCustomerNumber());
            Customer customer = mainApp.getCustomers().get(i);
            menuItem.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    customerCtrl.showCustomerWin(customer);
                }
            });
            customersMenuBtn.getItems().add(menuItem);
        }
        MenuItem newCustomerMenuItem = new MenuItem("New Customer");
        Customer newCustomer = new Customer("New Customer");
        newCustomerMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                customerCtrl.showCustomerWin(newCustomer);
            }
        });
        customersMenuBtn.getItems().add(newCustomerMenuItem);
    }

    @FXML
    public void btnNewFlatClicked(ActionEvent event) {
        mainApp.showAddNewFlatWin();
    }

    @FXML
    public void btnToArchivClicked(ActionEvent event) {
        for (int i = 0; i < tvDataBase.getSelectionModel().getSelectedIndices().size(); i++) {
            mainApp.getFlats().remove((int) tvDataBase.getSelectionModel().getSelectedIndices().get(i));
        }
    }

    @FXML
    public void btnViewAvisoClicked(ActionEvent event) {
    }

    @FXML
    public void togbSelectTablePressed(ActionEvent event) {
    }

    @FXML
    public void btnSaveTableClicked(ActionEvent event) {
        new FileUtil().writeObjToFile(new ArrayList<>(mainApp.getFlats()), "resources/data/ser/flats.ser");
    }

}
