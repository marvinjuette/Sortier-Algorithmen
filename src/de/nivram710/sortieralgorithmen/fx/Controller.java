package de.nivram710.sortieralgorithmen.fx;

import de.nivram710.sortieralgorithmen.main.Main;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public CheckBox checkbox_bubblesort;
    public CheckBox checkbox_selectionsort;
    public CheckBox checkbox_insertionesort;
    public CheckBox checkbox_quicksort;
    public CheckBox checkbox_countingsort;
    public CheckBox checkbox_radixsort;

    public Button button_start;

    public ListView<Label> listview_results;

    private static Controller instance;

    public Controller() {
        instance = this;
    }

    public static Controller getInstace() {
        return instance;
    }

    public void startSorting() {

        boolean bubblsort = checkbox_bubblesort.isSelected();
        boolean selectionsort = checkbox_selectionsort.isSelected();
        boolean insertionsort = checkbox_insertionesort.isSelected();
        boolean quicksort = checkbox_quicksort.isSelected();
        boolean countingsort = checkbox_countingsort.isSelected();
        boolean radixsort = checkbox_radixsort.isSelected();

        Main.runAlgorithms(bubblsort, selectionsort, insertionsort, quicksort, countingsort, radixsort, true);

    }

    public void addLabelToListView(String text) {

        listview_results.getItems().add(new Label(text));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button_start.setOnAction(event -> {
            startSorting();
            button_start.setDisable(true);
        });
    }
}
