import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Represents a PgnReader
 * @author nshah372
 * @version 2.0
 */
public class PgnReader {
    private static int gameLocation;
    private static String theRealGame;
    private static List<String> theRealMoves = new ArrayList<String>();
    private static ChessGame currentGame;
    /**
     * Alternate Constructor for a PgnReader
     * @param    path          [path to the file]
     * @param   useless       [a boolean I created to have a new constructor]
     */
    public PgnReader(String path, boolean useless) {
        String game = fileContent(path);
        currentGame = gameMaker(game);
    }
    /**
     * Returns current game
     * @return [the current game]
     */
    public ChessGame getCurrentGame() {
        return currentGame;
    }
    /**
     * Returns the tagValue specivied
     * @param   tagName       [the tag wanted]
     * @param   game          [the pgn text]
     * @return        [the tagValue that corresponds to tagName]
     */
    public static String tagValue(String tagName, String game) {
        int index = game.indexOf(tagName);
        int quoteFinder = index + tagName.length() + 2;
        if (index > -1) {
            return game.substring(quoteFinder, game.indexOf('"', quoteFinder));
        }
        return "NOT GIVEN";
        
    }
    /**
     * Adds moves to the List
     * @param  wholeGame [all of the moves in the pgn]
     */
    public static void addMoves(String wholeGame) {
        int beginningOfMove = 0;
        int spaceCounter = 0;
        for (int i = 1; i < wholeGame.length(); i++) {
            if (wholeGame.charAt(i) == ' ') {
                spaceCounter++;
                if (spaceCounter % 2 == 0) {
                    theRealMoves.add(wholeGame.substring(beginningOfMove, i));
                    beginningOfMove = i;
                }

            }
            if (i == wholeGame.length() - 1) {
                theRealMoves.add(wholeGame.substring(beginningOfMove, i));
            }
        }
    }
    /**
     * Trims the entire pgn file to the important parts
     * @param  game [entire text of the pgn file]
     */
    public static void playGame(String game) {
        gameLocation = game.indexOf("1.");
        theRealGame = game.substring(gameLocation);
        for (int i = 100; i > 0; i--) {
            if (theRealGame.contains(i + ".")) {
                theRealGame = theRealGame.replaceAll(i + "\\.", "");
            }
        }
        theRealGame = theRealGame.replaceAll("\\  ", " ");
        addMoves(theRealGame);
    }

    /**
     * [Extracts the text from a .pgn file]
     * @param   path          [path to the file]
     * @return        [string of the pgn extrated]
     */
    public static String fileContent(String path) {
        Path file = Paths.get(path);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                // Add the \n that's removed by readline()
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
            System.exit(1);
        }
        return sb.toString();
    }
    /**
     * Makes a ChessGame object from a pgn
     * @param   game          [the extracted text from the pgn file]
     * @return        [a ChessGame object]
     */
    public static ChessGame gameMaker(String game) {
        String event = tagValue("Event", game);
        String site = tagValue("Site", game);
        String date = tagValue("Date", game);
        String white = tagValue("White", game);
        String black = tagValue("Black", game);
        String result = tagValue("Result", game);

        playGame(game);
        ChessGame g1 = new ChessGame(event,
                                    site,
                                    date,
                                    white,
                                    black,
                                    result,
                                    theRealMoves);
        return g1;
    }

    /**
     * [Gets gameLocation]
     * @return [gameLocation]
     */
    public static int getGameLocation() {
        return gameLocation;
    }

    /**
     * Sets game location
     * @param  gameLocation [new value wanted]
     */
    public static void setGameLocation(int gameLocation) {
        PgnReader.gameLocation = gameLocation;
    }

    /**
    * Returns value of theRealGame
    * @return Returns theRealGame
    */
    public static String getTheRealGame() {
        return theRealGame;
    }

    /**
     * Sets theRealGame to a new value
     * @param  theRealGame [the new value wanted]
     */
    public static void setTheRealGame(String theRealGame) {
        PgnReader.theRealGame = theRealGame;
    }

    /**
    * Returns value of theRealMoves
    * @return theRealMoves
    */
    public static List<String> getTheRealMoves() {
        return theRealMoves;
    }

    /**
    * Clears TheRealMoves
    */
    public static void setTheRealMoves() {
        PgnReader.theRealMoves = new ArrayList<String>();
    }


    /**
    * Sets currentGame
    * @param  currentGame [new value of currentGame]
    */
    public static void setCurrentGame(ChessGame currentGame) {
        PgnReader.currentGame = currentGame;
    }
}
