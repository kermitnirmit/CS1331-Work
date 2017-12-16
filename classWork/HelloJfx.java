import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
// import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloJfx extends Application {
    int count = 0;
    @Override public void start(Stage stage) {
        Label counterLabel = new Label("Count: 0");
        counterLabel.setFont(new Font(32));
        Button incButton = new Button("Increment Count");
        // incButton.setOnAction(event ->
        //     { counterLabel.setText("Count: " + (++count)); });
        incButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                count++;
                counterLabel.setText("Count: " + (count));
            }
    });

    // VBox root = new VBox();
    HBox root = new HBox();
    root.getChildren().addAll(counterLabel, incButton);

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setTitle("Hello");
    stage.show();
        // Label message = new Label("Hello, JavaFX!");
        // Label message = new Label("Hello, JavaFX!");
        //message.setFont(new Font(100));
        //message.setFont(new Font(100));
        // stage.setScene(new Scene(message)); //scene inside a stage
        // stage.setTitle("Hello"); //title of the window
        // stage.show();
    }
}
