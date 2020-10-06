package de.nivram710.sortieralgorithmen.fx;

import de.nivram710.sortieralgorithmen.main.Main;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public CheckBox checkbox_bubblesort;
    public CheckBox checkbox_selectionsort;
    public CheckBox checkbox_insertionsort;
    public CheckBox checkbox_mergesort;
    public CheckBox checkbox_quicksort;
    public CheckBox checkbox_countingsort;
    public CheckBox checkbox_radixsort;
    public ListView<Label> listview_results;
    public Spinner<Integer> spinner_array_size;

    public Button button_start;

    public static Controller instance;

    public Controller() {
        instance = this;
    }

    public static Controller getInstace() {
        return instance;
    }

    public void startSorting() {

        boolean bubblsort = checkbox_bubblesort.isSelected();
        boolean selectionsort = checkbox_selectionsort.isSelected();
        boolean insertionsort = checkbox_insertionsort.isSelected();
        boolean mergesort = checkbox_mergesort.isSelected();
        boolean quicksort = checkbox_quicksort.isSelected();
        boolean countingsort = checkbox_countingsort.isSelected();
        boolean radixsort = checkbox_radixsort.isSelected();

        listview_results.getItems().clear();

        int arraySize = spinner_array_size.getValue();

        Main.runAlgorithms(bubblsort, selectionsort, insertionsort, mergesort, quicksort, countingsort, radixsort, true, arraySize);

    }

    public void addLabelToListView(String text) {

        listview_results.getItems().add(new Label(text));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        checkbox_bubblesort.setSelected(true);
        checkbox_selectionsort.setSelected(true);
        checkbox_insertionsort.setSelected(true);
        checkbox_mergesort.setSelected(true);
        checkbox_quicksort.setSelected(true);
        checkbox_countingsort.setSelected(true);
        checkbox_radixsort.setSelected(true);

        SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1_000_000, 10_000, 500);
        spinner_array_size.setValueFactory(spinnerValueFactory);
        spinner_array_size.setEditable(true);

        button_start.setOnAction(event -> startSorting());

    }
}
