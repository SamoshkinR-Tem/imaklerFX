package model.tools.service;

import javafx.scene.layout.GridPane;

/**
 * Created by R-Tem on 14.06.2015.
 */
public class GetIndexFrom {

    /* Метод определяет индекс объекта из GridPane по заданому ID */
    public Integer getIndexOf(String id, GridPane gp){
        int index = 0;
        for (int i = 0; i < gp.getChildren().size(); i++) {
            if (id != null && id.equals(gp.getChildren().get(i).getId())) {
                index = i;
            }
        }
        return index;
    }
}
