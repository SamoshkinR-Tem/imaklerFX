/**
 * Created by R-Tem on 12.07.2015.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.LinearGradient;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerTab extends Application {
//    FXMLLoader loader = new FXMLLoader();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        showCustomerWin();
        java.awt.Window win[] = java.awt.Window.getWindows();
        System.out.println(win);
    }

    private void showCustomerWin() {
        GridPane gridPane = readGp();
        gridPane.add(addMenuBar(), 0, 0);
        TabPane tabPane = new TabPane();
        tabPane.getTabs().add(addNewTab());
        gridPane.add(tabPane, 0, 1);

        Stage customerWin = new Stage();
        customerWin.setScene(new Scene(gridPane, 1200, 600));
        customerWin.showAndWait();
    }
    private GridPane readGp(){
        GridPane gridPane = new GridPane();
        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("/fxml/customerWin/gridPane.fxml"));
//            gridPane = loader.load();
            gridPane = FXMLLoader.load(getClass().getResource("/fxml/customerWin/gridPane.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gridPane;
    }
    private MenuBar addMenuBar(){
        MenuBar menuBar = new MenuBar();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/customerWin/menuBarSmp.fxml"));
            menuBar = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return menuBar;
    }
    private Tab addNewTab() {
        Tab tab = new Tab();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/customerWin/customerTab.fxml"));
            tab = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tab;
    }
}
