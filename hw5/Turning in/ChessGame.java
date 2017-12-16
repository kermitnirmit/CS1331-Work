import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
/**
 * Represents a ChessGame
 * @author nshah372
 * @version 1.0
 */
public class ChessGame {
    private List<Move> moves;
    /**
     * Constructor for a ChessGame
     * @param  moves         [a list of moves]
     */
    public ChessGame(List<Move> moves) {
        this.moves = moves;
    }
    /**
     * Filters moves to a new list that fits the Predicate
     * @param  filter        [a condition that must be true]
     * @return                 [a list of moves that fits the Predicate]
     */
    public List<Move> filter(Predicate<Move> filter) {
        List<Move> answer = new ArrayList<Move>();
        for (int i = 0; i < moves.size(); i++) {
            if (filter.test(this.moves.get(i))) {
                answer.add(this.moves.get(i));
            }
        }
        return answer;

    }
    /**
     * List of moves with a comment
     * @return [returns a list of moves with comments]
     */
    public List<Move> getMovesWithComment() { //lambda
        return filter((m) ->
                            m.getWhitePly().getComment().isPresent()
                            || m.getBlackPly().getComment().isPresent());
    }
    /**
     * List of moves with without comments
     * @return [returns a list of moves without comments]
     */
    public List<Move> getMovesWithoutComment() { //anon
        List<Move> movesWithoutComment = filter(new Predicate<Move>() {
            public boolean test(Move m) {
                return  !m.getWhitePly().getComment().isPresent()
                        && !m.getBlackPly().getComment().isPresent();
            }
        });
        return movesWithoutComment;
    }
    /**
     * List of moves that are using the piece
     * @param p     piece that will be matched
     * @return [returns a list of moves that use the piece p]
     */
    public List<Move> getMovesWithPiece(Piece p) { //inner class
        class UsingPiece implements Predicate<Move> {
            @Override
            public boolean test(Move m) {
                return  m.getWhitePly().getPiece().equals(p)
                        || m.getBlackPly().getPiece().equals(p);
            }
        }
        UsingPiece s = new UsingPiece();
        List<Move> withPiece = filter(s);
        return withPiece;
    }
    /**
    * Returns move at int n
    * @param n index in List
    * @return the move at index n
    */
    public Move getMove(int n) {
        return this.moves.get(n);
    }

    /**
    * Sets new value of moves
    * @param moves a new list of moves
    */
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    /**
    * Returns value of moves
    * @return the entire list of moves
    */
    public List<Move> getMoves() {
        return moves;
    }

}
