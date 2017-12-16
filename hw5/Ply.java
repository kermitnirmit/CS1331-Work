/**
 * @version 1.0
 * @author nshah372
 */
import java.util.Optional;
public class Ply {
    private Piece piece;
    private Square from;
    private Square to;
    private Optional<String> comment;
    public Ply( Piece piece,
                Square from,
                Square to,
                Optional<String> comment) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.comment = comment;
    }


    /**
    * Returns value of piece
    * @return
    */
    public Piece getPiece() {
        return piece;
    }

    /**
    * Sets new value of piece
    * @param
    */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
    * Returns value of from
    * @return
    */
    public Square getFrom() {
        return from;
    }

    /**
    * Sets new value of from
    * @param
    */
    public void setFrom(Square from) {
        this.from = from;
    }

    /**
    * Returns value of to
    * @return
    */
    public Square getTo() {
        return to;
    }

    /**
    * Sets new value of to
    * @param
    */
    public void setTo(Square to) {
        this.to = to;
    }

    /**
    * Returns value of comment
    * @return
    */
    public Optional<String> getComment() {
        return comment;
	}

    /**
    * Sets new value of comment
    * @param
    */
    public void setComment(Optional<String> comment) {
        this.comment = comment;
    }
}
