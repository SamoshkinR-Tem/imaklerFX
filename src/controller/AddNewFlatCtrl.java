package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.MainApp;
import model.entities.Flat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by R-Tem on 26.06.2015.
 */
public class AddNewFlatCtrl {

    @FXML private SplitPane splitPane;
    @FXML private GridPane gpFlatDescription;
    @FXML private TextField tfAddress;
    @FXML private TextField tfParameters;
    @FXML private TextField tfCondition;
    @FXML private TextField tfContactNum;
    @FXML private TextField tfContactName;
    @FXML private TextField tfPrice;
    @FXML private TextField tfKievDistrict;
    @FXML private Button btnDone;
    final ToggleGroup roomsNumGroup = new ToggleGroup();
    @FXML private RadioButton rb1k;
    @FXML private RadioButton rb2k;
    @FXML private RadioButton rb3k;
    @FXML private RadioButton rb4k;
    final ToggleGroup statusGroup = new ToggleGroup();
    @FXML private RadioButton rbHoz;
    @FXML private RadioButton rbPos;
    final ToggleGroup markerGroup = new ToggleGroup();
    @FXML private RadioButton rbLightGreen;
    @FXML private RadioButton rbGreen;
    @FXML private RadioButton rbYellow;
    @FXML private RadioButton rbRed;
    @FXML private RadioButton rbBlue;

    private MainApp mainApp;
    private Flat f = new Flat();

    /**
     * Constructor
     */
    public AddNewFlatCtrl() {}

    @FXML public void initialize(){
        setRoomsNumGroup();
        setStatusGroup();
        setMarkerGroup();
    }

    @FXML public void btnDoneClicked(ActionEvent event){
        NewFlatDataCtrl newFlatDataCtrl = new NewFlatDataCtrl();
        NewFlatDataCtrl.Error error;
        String roomsNum;
        String contactStatus;
        String rowColor;
        try{
            roomsNum = roomsNumGroup.getSelectedToggle().getUserData().toString();
        } catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("    Ошибка ввода");
            alert.setHeaderText("   Выберите количество комнат, пожалуйста!");
            alert.showAndWait();
            return;
        }
        error = newFlatDataCtrl.verifyNewFlatData(
                tfAddress.getText(),
                tfParameters.getText(),
                tfCondition.getText(),
                tfContactNum.getText(),
                tfContactName.getText(),
                tfPrice.getText(),
                tfKievDistrict.getText());
        if (!error.getErrorBoolean()){
            try{
                contactStatus = statusGroup.getSelectedToggle().getUserData().toString();
            } catch (NullPointerException e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("    Ошибка ввода");
                alert.setHeaderText("   Выберите статус контакта, пожалуйста!");
                alert.showAndWait();
                return;
            }
            try{
                rowColor = markerGroup.getSelectedToggle().getUserData().toString();
            } catch (NullPointerException e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("    Ошибка ввода");
                alert.setHeaderText("   Выберите маркер объекта, пожалуйста!");
//                    alert.setContentText("");
                alert.showAndWait();
                return;
            }
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yy");
            error.getNewFlat().setDateOfCome(dateFormatter.format(LocalDate.now()));
            error.getNewFlat().setDateOfCall(dateFormatter.format(LocalDate.now()));
            error.getNewFlat().setRoomsNum(roomsNum);
            error.getNewFlat().setContactStatus(contactStatus);
            error.getNewFlat().setRowColor(rowColor);
            mainApp.getFlats().add(0, error.getNewFlat());
            Stage stage = (Stage) btnDone.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("    Ошибка ввода");
            alert.setHeaderText("   " + error.getErrorText());
            alert.showAndWait();
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setRoomsNumGroup() {
        rb1k.setUserData("1к");
        rb1k.setToggleGroup(roomsNumGroup);
        rb2k.setUserData("2к");
        rb2k.setToggleGroup(roomsNumGroup);
        rb3k.setUserData("3к");
        rb3k.setToggleGroup(roomsNumGroup);
        rb4k.setUserData("4к");
        rb4k.setToggleGroup(roomsNumGroup);
    }

    public void setStatusGroup() {
        rbHoz.setUserData("хоз.");
        rbHoz.setToggleGroup(statusGroup);
        rbPos.setUserData("пос.");
        rbPos.setToggleGroup(statusGroup);
    }

    public void setMarkerGroup() {
        rbLightGreen.setUserData("lightGreen");
        rbLightGreen.setToggleGroup(markerGroup);
        rbGreen.setUserData("Green");
        rbGreen.setToggleGroup(markerGroup);
        rbYellow.setUserData("Yellow");
        rbYellow.setToggleGroup(markerGroup);
        rbRed.setUserData("Red");
        rbRed.setToggleGroup(markerGroup);
        rbBlue.setUserData("Blue");
        rbBlue.setToggleGroup(markerGroup);
    }
}
