import javafx.application.Application;
import javafx.stage.Stage;
import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import java.util.List;
import java.util.ArrayList;
import javafx.application.Platform;
/**
 * Represents a ChessGui
 * @author nshah372
 * @version 1.0
 */
public class ChessGui extends Application {
    // private ObservableList<String> toDoList;
    // private ObservableList<Button> buttonList;
    // private ObservableList<String> playList;
    private static ChessGame morphyIsouard;
    private static ChessGame talFischer;
    private static List<ChessGame> games;
    private static boolean firstClick = true;
    /**
     * the main part of my Gui
     * @param  stage [what gets displayed]
     */
    public void start(Stage stage) {
        ArrayList<String> pgnFiles = new ArrayList<String>();
        File current = new File(".");
        String currentPath = current.getAbsolutePath();
        File directory = new File(currentPath);
        for (File name: directory.listFiles()) {
            if (name.getName().endsWith((".pgn"))) {
                pgnFiles.add(name.getName());
            }
        }
        fillGames();
        ArrayList<ChessGame> gameFiles = new ArrayList<ChessGame>();
        gameFiles.add(games.get(0));
        gameFiles.add(games.get(1));
        for (String name : pgnFiles) {
            ChessGame newGame = ChessGame.getFromFile(name);
            gameFiles.add(newGame);
        }
        ObservableList<ChessGame> gameList =
            FXCollections.observableArrayList(gameFiles);

        TableView<ChessGame> table = new TableView<ChessGame>();
        TableColumn<ChessGame, String> event = new TableColumn("Event");
        event.setCellValueFactory(e -> new ReadOnlyStringWrapper(
                e.getValue()
                .getEvent()));
        TableColumn<ChessGame, String> site = new TableColumn("Site");
        site.setCellValueFactory(e -> new ReadOnlyStringWrapper(
            e.getValue()
            .getSite()));
        TableColumn<ChessGame, String> date = new TableColumn("Date");
        date.setCellValueFactory(e -> new ReadOnlyStringWrapper(
            e.getValue()
            .getDate()));
        TableColumn<ChessGame, String> white = new TableColumn("White");
        white.setCellValueFactory(e -> new ReadOnlyStringWrapper(
            e.getValue()
            .getWhite()));
        TableColumn<ChessGame, String> black = new TableColumn("Black");
        black.setCellValueFactory(e -> new ReadOnlyStringWrapper(
            e.getValue()
            .getBlack()));
        TableColumn<ChessGame, String> result = new TableColumn("Result");
        result.setCellValueFactory(e -> new ReadOnlyStringWrapper(
            e.getValue()
            .getResult()));
        TableColumn<ChessGame, String> open = new TableColumn("Opening");
        open.setCellValueFactory(e -> new ReadOnlyStringWrapper(
            e.getValue()
            .getOpeningForTable()));
        table.setItems(gameList);
        table.getColumns().setAll(event,
                                    site,
                                    date,
                                    white,
                                    black,
                                    result,
                                    open);

        Button viewButton = new Button();
        viewButton.setText("View Game");
        viewButton.setOnAction(e -> {
                ChessGame gameselect = table
                        .getSelectionModel()
                        .getSelectedItem();
                viewGame(gameselect);
            });
        viewButton.disableProperty()
                .bind(Bindings.isNull(table.getSelectionModel()
                                    .selectedItemProperty()));

        Button dismissButton = new Button();
        dismissButton.setOnAction(e -> {
                Platform.exit();
            });
        dismissButton.setText("Dismiss");
        FilteredList<ChessGame> filteredGameList = new FilteredList<ChessGame>(
                                    gameList, p-> true);
        TextField search = new TextField();
        search.setText("Search");

        search.setOnMouseClicked((MouseEvent mouse) -> {
                if (firstClick) {
                    search.setText("");
                    firstClick = false;
                }
            });
        search.textProperty().addListener((observedValue, old, newer) -> {
                filteredGameList.setPredicate(game ->  {
                        if (newer.isEmpty() || newer == null) {
                            return true;
                        }
                        String newerUp = newer.toUpperCase();
                        if (game.getEvent().toUpperCase().contains(newerUp)) {
                            return true;
                        } else if (game.getSite()
                                .toUpperCase()
                                .contains(newerUp)) {
                            return true;
                        } else if (game.getDate()
                                .toUpperCase()
                                .contains(newerUp)) {
                            return true;
                        } else if (game.getWhite()
                                .toUpperCase()
                                .contains(newerUp)) {
                            return true;
                        } else if (game.getBlack()
                                .toUpperCase()
                                .contains(newerUp)) {
                            return true;
                        } else if (game.getResult()
                                .toUpperCase()
                                .contains(newerUp)) {
                            return true;
                        } else if (game.getOpeningForTable()
                                .toUpperCase()
                                .contains(newerUp)) {
                            return true;
                        }
                        return false;
                    });
            });
        SortedList<ChessGame> sorted = new SortedList(filteredGameList);
        sorted.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sorted);
        table.getColumns().setAll(event,
                                    site,
                                    date,
                                    white,
                                    black,
                                    result,
                                    open);
        HBox bottom = new HBox();
        bottom.getChildren().addAll(viewButton, dismissButton);
        VBox everything = new VBox();
        everything.getChildren().addAll(table, bottom, search);

        Scene scene = new Scene(everything);
        stage.setScene(scene);
        stage.setTitle("Chess Gui");
        stage.show();
    }
    /**
     * Gets the games from ChessDb
     */
    public static void fillGames() {
        ChessDb db = new ChessDb();
        games = db.getGames();
    }
    /**
     * Displays the ChessGame selected
     * @param  gameSelect [selected game]
     */
    private void viewGame(ChessGame gameSelect) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(gameSelect.getEvent());
        alert.setHeaderText("Event: " + gameSelect.getEvent()
                            + "\nSite: " + gameSelect.getSite()
                            + "\nDate: " + gameSelect.getDate()
                            + "\nWhite: " + gameSelect.getWhite()
                            + "\nBlack: " + gameSelect.getBlack()
                            + "\nResult: " + gameSelect.getResult());
        alert.setContentText(gameSelect.getOpening() + "\n"
                            + gameSelect.getMovesToPrint());
        alert.showAndWait();
    }
}
