import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
public class ChessGame {
    private List<Move> moves;
    public ChessGame(List<Move> moves) {
        this.moves = moves;
    }
    public List<Move> filter(Predicate<Move> filter) {
        List<Move> answer = new ArrayList<Move>();
        for (int i = 0; i < moves.size(); i++) {
            if (filter.test(this.moves.get(i))) {
                answer.add(this.moves.get(i));
            }
        }
        return answer;

    }
    public List<Move> getMovesWithComment() { //lambda
        return filter((m) ->
                        m.getWhitePly().getComment().isPresent()
                        ||m.getBlackPly().getComment().isPresent());
    }

    public List<Move> getMovesWithoutComment() { //anon
        List<Move> movesWithoutComment = filter(new Predicate<Move> () {
            public boolean test(Move m) {
                return  !m.getWhitePly().getComment().isPresent() &&
                        !m.getBlackPly().getComment().isPresent();
            }
        });
        return movesWithoutComment;
    }
    public List<Move> getMovesWithPiece(Piece p) { //inner class
        class UsingPiece implements Predicate<Move> {
            @Override
            public boolean test(Move m) {
                return  m.getWhitePly().getPiece().equals(p) ||
                        m.getBlackPly().getPiece().equals(p);
            }
        }
        UsingPiece s = new UsingPiece();
        List<Move> withPiece = filter(s);
        return withPiece;
    }
    /**
    * Returns move at int n
    * @return
    */
    public Move getMove(int n) {
        return this.moves.get(n);
    }

    /**
    * Sets new value of moves
    * @param
    */
    public void setMoves(List<Move> moves) {
        this.moves = moves;
	}

    /**
    * Returns value of moves
    * @return
    */
    public List<Move> getMoves() {
        return moves;
    }

}
