import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * @author nshah372
 * @version 1.0
 * Represents a ChessGame
 */
public class ChessGame {

    private StringProperty event = new SimpleStringProperty(this, "NA");
    private StringProperty site = new SimpleStringProperty(this, "NA");
    private StringProperty date = new SimpleStringProperty(this, "NA");
    private StringProperty white = new SimpleStringProperty(this, "NA");
    private StringProperty black = new SimpleStringProperty(this, "NA");
    private StringProperty result = new SimpleStringProperty(this, "NA");
    private List<String> moves;
    /**
     * Given Constructor for a ChessGame
     * @param   event         [the tournament or event for the game]
     * @param   site          [where the game took place]
     * @param   date          [when the game took place]
     * @param   white         [who played white]
     * @param   black         [who played black]
     * @param   result        [result]
     */
    public ChessGame(String event, String site, String date,
                     String white, String black, String result) {
        this.event.set(event);
        this.site.set(site);
        this.date.set(date);
        this.white.set(white);
        this.black.set(black);
        this.result.set(result);
        moves = new ArrayList<>();
    }
    /**
     * Given Constructor for a ChessGame
     * @param   event         [the tournament or event for the game]
     * @param   site          [where the game took place]
     * @param   date          [when the game took place]
     * @param   white         [who played white]
     * @param   black         [who played black]
     * @param   result        [result]
     * @param   moveList      [list of the moves in moves format]
     */
    public ChessGame(String event, String site, String date,
                     String white, String black, String result,
                     List<String> moveList) {
        this.event.set(event);
        this.site.set(site);
        this.date.set(date);
        this.white.set(white);
        this.black.set(black);
        this.result.set(result);
        this.moves = moveList;
    }
    /**
     * Adds a move to moves
     * @param  move [move to be added]
     */
    public void addMove(String move) {
        moves.add(move);
    }
    /**
     * Gets the move at index n
     * @param   n             [index]
     * @return                [the move]
     */
    public String getMove(int n) {
        return moves.get(n - 1);
    }
    /**
     * Gets the list of moves and pretty-prints them
     * @return [returns the list of moves in a neat String]
     */
    public String getMovesToPrint() {
        String allMoves = "";
        for (int i = 1; i <= moves.size(); i++) {
            allMoves = allMoves + i + ". " + getMove(i) + " ";
            if (i % 3 == 0) {
                allMoves = allMoves + "\n";
            }
        }
        return allMoves;
    }
    /**
     * Gets the list of moves
     * @return [returns all of the moves in a sTring]
     */
    public String getMoves() {
        String allMoves = "";
        for (int i = 1; i <= moves.size(); i++) {
            allMoves = allMoves + getMove(i) + " ";
        }
        return allMoves;
    }
    /**
     * Gets the event
     * @return [event]
     */
    public String getEvent() {
        return event.get();
    }
    /**
     * Gets the site
     * @return [site]
     */
    public String getSite() {
        return site.get();
    }
    /**
     * Gets the date
     * @return [date]
     */
    public String getDate() {
        return date.get();
    }
    /**
     * Gets the white
     * @return [white]
     */
    public String getWhite() {
        return white.get();
    }
    /**
     * Gets the black
     * @return [black]
     */
    public String getBlack() {
        return black.get();
    }
    /**
     * Gets the result
     * @return [result]
     */
    public String getResult() {
        return result.get();
    }
    /**
     * Converts .pgn filepath to a ChessGame
     * @param   name          [path to .pgn file]
     * @return        [a new ChessGame]
     */
    public static ChessGame getFromFile(String name) {
        PgnReader reader = new PgnReader(name, true);
        ChessGame toReturn = reader.getCurrentGame();
        reader.setGameLocation(0);
        reader.setTheRealMoves();
        return toReturn;
    }
    /**
     * Gets the opening
     * @return [the opening]
     */
    public String getOpening() {
        String gameToCheck = this.getMoves();
        gameToCheck = gameToCheck.replaceAll("\\  ", " ");
        String opening = "Opening: ";
        if (gameToCheck.contains("e4 e5 Nf3 d6")) {
            return opening + "Philidor Defence";
        }
        if (gameToCheck.contains("e4 e6")) {
            return opening + "French Defence";
        }
        if (gameToCheck.contains("e4 e5 Nf3 Nc6 Bc4 Bc5")) {
            return opening + "Giuoco Piano";
        }
        if (gameToCheck.contains("e4 e5 Nf3 Nc6 Bc4")) {
            return opening + "Italian Game";
        }
        if (gameToCheck.contains("e4 c5")) {
            return opening + "Sicilian Defence";
        }
        if (gameToCheck.contains("d4 d5 c4")) {
            return opening + "Queen's Gambit";
        }
        if (gameToCheck.contains("d4 Nf6")) {
            return opening + "Indian Defence";
        }
        if (gameToCheck.contains("e4 e5 Nf3 Nc6 Bb5")) {
            return opening + "Ruy Lopez";
        }
        if (gameToCheck.contains("e4 e5 Nf3 Nf6")) {
            return opening + "Petrov's Defence";
        }
        if (gameToCheck.contains("e4 e5 Nc3")) {
            return opening + "Vienna Game";
        }
        return "Unrecognized Opening";
    }
    /**
     * Gets the opening
     * @return [the opening]
     */
    public String getOpeningForTable() {
        String gameToCheck = this.getMoves();
        gameToCheck = gameToCheck.replaceAll("\\  ", " ");
        if (gameToCheck.contains("e4 e5 Nf3 d6")) {
            return "Philidor Defence";
        }
        if (gameToCheck.contains("e4 e6")) {
            return "French Defence";
        }
        if (gameToCheck.contains("e4 e5 Nf3 Nc6 Bc4 Bc5")) {
            return "Giuoco Piano";
        }
        if (gameToCheck.contains("e4 e5 Nf3 Nc6 Bc4")) {
            return "Italian Game";
        }
        if (gameToCheck.contains("e4 c5")) {
            return "Sicilian Defence";
        }
        if (gameToCheck.contains("d4 d5 c4")) {
            return "Queen's Gambit";
        }
        if (gameToCheck.contains("d4 Nf6")) {
            return "Indian Defence";
        }
        if (gameToCheck.contains("e4 e5 Nf3 Nc6 Bb5")) {
            return "Ruy Lopez";
        }
        if (gameToCheck.contains("e4 e5 Nf3 Nf6")) {
            return "Petrov's Defence";
        }
        if (gameToCheck.contains("e4 e5 Nc3")) {
            return "Vienna Game";
        }
        return "Unrecognized Opening";
    }
}
