package view;

import controller.NewFlatDataCtrl;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.entities.Flat;
import model.tools.service.GetIndexFrom;

import java.io.File;
import java.io.IOException;

/**
 * Created by R-Tem on 14.06.2015.
 */
public class MainWin {
    public void mainWinShow(ObservableList<Flat> flats, NewFlatDataCtrl controller, GetIndexFrom getIndexFrom){
        Stage mainStage = new Stage();
        AnchorPane mainAP = null;
        GridPane mainGP = null;
        try{
            mainAP = new FXMLLoader(new File("src/main/resources/fxml/mainWindowAP.fxml").toURI().toURL()).load();
            mainGP = (GridPane) mainAP.getChildren().get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
//      ----------------------------------------------------------------------------------------------------------------
        Button btnDataBase = (Button) mainGP.getChildren().get(getIndexFrom.getIndexOf("btnDataBase", mainGP));
        btnDataBase.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            }
        });
//      ----------------------------------------------------------------------------------------------------------------
        Button btnYandexMap = (Button) mainGP.getChildren().get(getIndexFrom.getIndexOf("btnYandexMap", mainGP));
        btnYandexMap.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
            }
        });
//      ----------------------------------------------------------------------------------------------------------------
        Button btnOLX = (Button) mainGP.getChildren().get(getIndexFrom.getIndexOf("btnOLX", mainGP));
        btnOLX.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle (ActionEvent event){
//                TODO
            }
        });

        mainStage.setScene(new Scene(mainAP));
        mainStage.showAndWait();
    }
}
