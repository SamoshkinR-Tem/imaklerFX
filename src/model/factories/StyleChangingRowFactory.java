package model.factories;

import java.util.Collections;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import model.entities.Flat;


public class StyleChangingRowFactory<T> implements
        Callback<TableView<T>, TableRow<T>> {

    private final ObservableList<Integer> rowIndices;
    private final Callback<TableView<T>, TableRow<T>> baseFactory;
    private ObservableList<Flat> flats;

    public StyleChangingRowFactory(ObservableList<Flat> flats, Callback<TableView<T>, TableRow<T>> baseFactory) {
        this.rowIndices = FXCollections.observableArrayList();
        this.baseFactory = baseFactory;
        this.flats = flats;
    }

    public StyleChangingRowFactory(ObservableList<Flat> flats) {
        this(flats, null);
    }

    @Override
    public TableRow<T> call(TableView<T> tableView) {

        final TableRow<T> row = new TableRow<>();

        flats.addListener(new ListChangeListener<Flat>() {
            @Override
            public void onChanged(Change<? extends Flat> c) {
                for (int i = 0; i < flats.size(); i++) {
                    rowIndices.add(i);
                }
                updateStyleClass(row);
            }
        });
        return row;
    }

    private void updateStyleClass(TableRow<T> row) {
        System.out.println(row.getIndex());
        if (rowIndices.contains(row.getIndex())) {
            switch (flats.get(row.getIndex()).getRowColor()) {
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
        } /*else {
            row.getStyleClass().remove(row.getIndex());
        }*/
    }
}