package model;

import controller.AddNewFlatCtrl;
import controller.DataBaseCtrl;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import model.entities.Customer;
import model.entities.Flat;
import model.tools.FileUtil;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by R-Tem on 20.06.2015.
 */
public class MainApp extends Application {

    private ObservableList<Flat> flats;
    public ObservableList<Flat> getFlats() {
        return flats;
    }

    private ObservableList<Customer> customers;
    public ObservableList<Customer> getCustomers() {
        return customers;
    }

    private Stage addNewFlatWin = new Stage();
    public ArrayList openedStages = new ArrayList<>();

    public MainApp() {
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    //Инициализация любых данных, до включения основного потока Start в работу.
    public void init(){
        flats = FXCollections.observableArrayList(
                new FileUtil<Flat>().readObjFromFile("C:/Users/R-Tem/IdeaProjects/imakler/out/production/imakler/data/ser/flats.ser"));

        customers = FXCollections.observableArrayList(
                new FileUtil<Customer>().readObjFromFile("C:/Users/R-Tem/IdeaProjects/imakler/out/production/imakler/data/ser/customers.ser"));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        showMainWin();
//        yandexWinShow();
    }

    public void showMainWin() {
        showDataBaseWin();
    }

    public void showDataBaseWin() {
        try {
            // Load flats dataBase.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/dataBase.fxml"));
            Parent root = loader.load();
            DataBaseCtrl ctrl = loader.getController();
            ctrl.setMainApp(this);
            ctrl.ini();

            Stage dataBaseWin = new Stage();
            Scene dataBaseScene = new Scene(root, 1200, 600);
            dataBaseScene.getStylesheets().add("css/highlightingTable.css");
            dataBaseWin.setScene(dataBaseScene);
            dataBaseWin.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAddNewFlatWin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/addNewFlat.fxml"));
            Parent root = loader.load();
            AddNewFlatCtrl ctrl = loader.getController();
            ctrl.setMainApp(this);

            addNewFlatWin.setScene(new Scene(root, 600, 400));
            if (!openedStages.contains(addNewFlatWin)) {
                openedStages.add(addNewFlatWin);
                addNewFlatWin.show();
            } else {
                addNewFlatWin.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void yandexWinShow() {
        final Stage yandexStage = new Stage();
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {
                if (newState == Worker.State.SUCCEEDED) {
                    yandexStage.setTitle(webEngine.getLocation());
                }
            }
        });
        webEngine.load("http://imakler/app/getJson.html");

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(browser);
        Scene yandexScene = new Scene(scrollPane);
        yandexStage.setScene(yandexScene);
        yandexStage.show();
    } // почему этот метод работает, а
}
