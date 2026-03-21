package guistate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.List;

public class Gui extends Application {

    // create a GUI with three adjacent ColorBoxes and one CheckBox below them
    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;
    private ListView<String> listView;
    /** Parallel to list row order: memento id for {@link Controller#goToHistoryItem(String)}. */
    private final List<String> historyIds = new ArrayList<>();
    /** Avoid treating programmatic CheckBox updates as user edits (would duplicate history). */
    private boolean suppressCheckboxAction;

    public void start(Stage stage) {

        controller = new Controller(this);

        // Insets for margin and padding
        Insets insets = new Insets(10, 10, 10, 10);

        // Create three ColorBoxes
        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        // Create a CheckBox
        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        //create listview for history
        listView = new ListView<>();

        // Add the ColorBoxes and CheckBox to a HBox
        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);


        Label label = new Label("Press Ctrl-Z to undo the last change, and CTRL-Y to redo.");
        label.setPadding(insets);

        // create a VBox that contains the HBox and the CheckBox
        VBox vBox = new VBox(hBox, checkBox, label,  listView);
        // call controller when the CheckBox is clicked
        checkBox.setOnAction(event -> {
            if (suppressCheckboxAction) {
                return;
            }
            controller.setIsSelected(checkBox.isSelected());
        });



        // Set the HBox to be the root of the Scene
        Scene scene = new Scene(vBox);
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                // Ctrl-Z: undo
                System.out.println("Undo key combination pressed");
                controller.undo();
            }
            //redo funtionality
            if(event.isControlDown() && event.getCode() == KeyCode.Y) {
                System.out.println("redo key combination pressed");
                controller.redo();

            }
        });

        listView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                int idx = listView.getSelectionModel().getSelectedIndex();
                if (idx >= 0 && idx < historyIds.size()) {
                    System.out.println(historyIds.get(idx));
                    controller.goToHistoryItem(historyIds.get(idx));
                }
            }
        });


        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        updateGui();
        stage.show();
    }

    public void updateGui() {
        // called after restoring state from a Memento
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        boolean selected = controller.getIsSelected();
        if (checkBox.isSelected() != selected) {
            suppressCheckboxAction = true;
            try {
                checkBox.setSelected(selected);
            } finally {
                suppressCheckboxAction = false;
            }
        }
        historyIds.clear();
        historyIds.addAll(controller.getHistoryIds());
        List<String> items = controller.getHistoryDisplayLabels();
        for (IMemento mem : controller.history) {
            System.out.println(mem.printMemento());
        }
        listView.getItems().setAll(items);
        if (!items.isEmpty()) {
            int currentIndex = items.size() - 1;
            listView.getSelectionModel().clearAndSelect(currentIndex);
            listView.scrollTo(currentIndex);
        }

    }
}