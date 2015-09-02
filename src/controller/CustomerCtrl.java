package controller;

import controller.customerWin.CustomerTabCtrl;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.MainApp;
import model.entities.Customer;

import java.io.IOException;

/**
 * Created by R-Tem on 02.07.2015.
 */
public class CustomerCtrl {
    private MainApp mainApp;
    private Tab newCustomerTab = readCustomerTab();
    private final int NEW_CUSTOMER_TAB_INDEX = 0;
    private GridPane gridPane = readCustomerGp();
    private TabPane tabPane = (TabPane) gridPane.getChildren().get(1);
    private CustomerTabCtrl customerTabCtrl;
    private Stage customerWin = new Stage();



    /**
     * Constructor
     */
    public CustomerCtrl() {
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void showCustomerWin(Customer customer) {
        if (customer.getId() == "New Customer"){
            if (!tabPane.getTabs().contains(newCustomerTab)) {
                tabPane.getTabs().add(NEW_CUSTOMER_TAB_INDEX, newCustomerTab);
                tabPane.getSelectionModel().select(newCustomerTab);
            } else tabPane.getSelectionModel().select(newCustomerTab);
        } else {
            boolean flag = false;
            int i;
            for (i = 0; i < tabPane.getTabs().size(); i++) {
                if (tabPane.getTabs().get(i).getId().equals(customer.getId())){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                Tab customerTab = readCustomerTab();
                customerTabCtrl.customerTabIni(customerTab, customer);
                tabPane.getTabs().add(customerTab);
                tabPane.getSelectionModel().select(i);
            } else tabPane.getSelectionModel().select(i);
        }
        customerWin.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                mainApp.openedStages.remove(customerWin);
            }
        });
        if(customerWin.getScene() == null) customerWin.setScene(new Scene(gridPane, 1200, 600));
        if (!mainApp.openedStages.contains(customerWin)) {
            mainApp.openedStages.add(customerWin);
            customerWin.show();
        } else {
            customerWin.toFront();
        }
    }

    private GridPane readCustomerGp() {
        GridPane gridPane = new GridPane();
        try {
            gridPane = FXMLLoader.load(getClass().getResource("/fxml/customerWin/gridPane.fxml"));
            MenuBar menuBar = FXMLLoader.load(getClass().getResource("/fxml/customerWin/menuBarSmp.fxml"));
            gridPane.add(menuBar, 0, 0);
            TabPane tabPane = new TabPane();
            tabPane.getTabs().add(NEW_CUSTOMER_TAB_INDEX, newCustomerTab);
            gridPane.add(tabPane, 0, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gridPane;
    }
    private Tab readCustomerTab(){
        Tab tab = new Tab();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/customerWin/customerTab.fxml"));
            tab = loader.load();
            tab.setText("New Customer");
            tab.setId("New Customer");
            customerTabCtrl = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tab;
    }
}
