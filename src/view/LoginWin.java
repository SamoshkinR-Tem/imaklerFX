package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.tools.UsersUtil;
import model.tools.service.GetIndexFrom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by R-Tem on 14.06.2015.
 */
public class LoginWin {
    private Boolean isAuthorized;
    private GetIndexFrom getIndexFrom = new GetIndexFrom();
    private Boolean login() {
        Stage loginStage = new Stage();
        loginStage.setTitle("imakler App");
        GridPane loginGP = null;
        try{
            loginGP = new FXMLLoader(new File("src/main/resources/fxml/loginGP.fxml").toURI().toURL()).load();
        }catch (IOException e){
            e.printStackTrace();
        }
        loginStage.setScene(new Scene(loginGP));
        final GridPane finalLoginGP = loginGP;

        Button btnLogin = (Button) loginGP.getChildren().get(getIndexFrom.getIndexOf("btnLogin", loginGP));
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TextField userTextField = (TextField) finalLoginGP.getChildren().get(getIndexFrom.getIndexOf("userTextField", finalLoginGP));
                String userName = userTextField.getText();
                TextField passTextField = (TextField) finalLoginGP.getChildren().get(getIndexFrom.getIndexOf("passTextField", finalLoginGP));
                String pass = passTextField.getText();
                try {
                    isAuthorized = UsersUtil.authorization(userName, pass); // почему не работает с isAuthorized напрямую???
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                loginStage.close();
            }
        });
//        -----------------------------------------------------------------------------------------------
        Button btnRegistration = (Button) loginGP.getChildren().get(getIndexFrom.getIndexOf("btnRegistration", loginGP));
        btnRegistration.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TextField userTextField = (TextField) finalLoginGP.getChildren().get(getIndexFrom.getIndexOf("userTextField", finalLoginGP));
                String userName = userTextField.getText();
                TextField passTextField = (TextField) finalLoginGP.getChildren().get(getIndexFrom.getIndexOf("passTextField", finalLoginGP));
                String pass = passTextField.getText();
                try {
                    new UsersUtil().registration(userName, pass);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        loginStage.showAndWait(); // показывает окно и ждет, пока пользователь выполнит действия
//        isAuthorized = authorisationDone[0];
        return isAuthorized;
    }
}
