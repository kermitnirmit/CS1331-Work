import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.binding.Bindings;

public class ThreeLists extends Application {

    private ObservableList<String> toDoList;
    private ObservableList<Button> buttonList;
    private ObservableList<String> playList;

    @Override
    public void start(Stage stage) {

        ObservableList<String> toDoList =
            FXCollections.observableArrayList();
        ObservableList<Button> buttonList =
            FXCollections.observableArrayList();
        ObservableList<String> playList =
            FXCollections.observableArrayList();
        ListView<String> toDoListView = new ListView<String>(toDoList);
        ListView<Button> buttonListView = new ListView<Button>(buttonList);
        ListView<String> playListView = new ListView<String>(playList);

        TextField inputField = new TextField();
        Button addButton = new Button();
        addButton.setOnAction(e -> {
            toDoList.add(inputField.getText());
            Button b = new Button(inputField.getText());
            b.setOnAction(m -> {
                playList.add(b.getText());
                FXCollections.sort(playList);
            });
            buttonList.add(b);
            inputField.setText("");
            inputField.requestFocus();
            FXCollections.sort(toDoList);
            FXCollections.sort(playList);
        });
        addButton.disableProperty()
            .bind(Bindings.isEmpty(inputField.textProperty()));

        addButton.setText("Add");

        HBox entryBox = new HBox();
        entryBox.getChildren().addAll(inputField, addButton);
        VBox vbox1 = new VBox();
        vbox1.getChildren().addAll(toDoListView, entryBox);
        VBox vbox2 = new VBox();
        vbox2.getChildren().addAll(buttonListView);
        VBox vbox3 = new VBox();
        vbox3.getChildren().addAll(playListView);

        HBox page = new HBox();
        page.getChildren().addAll(vbox1, vbox2, vbox3);

        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.setTitle("Three Lists");
        stage.show();

    }
}
