/**
 * @version 1.0
 * @author nshah372
 */
import java.util.Optional;
/**
 * Represents a Ply
 * @author nshah372
 * @version 1.0
 */
public class Ply {
    private Piece piece;
    private Square from;
    private Square to;
    private Optional<String> comment;
    /**
     * [Ply description]
     * @param  piece         [piece that made the move]
     * @param  from          [wherethe piece was]
     * @param  to            [where the piece moved to]
     * @param  comment       [a comment on the strenght of the move]
     */
    public Ply(Piece piece,
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
    * @return   piece
    */
    public Piece getPiece() {
        return piece;
    }

    /**
    * Sets new value of piece
    * @param piece  new piece
    */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
    * Returns value of from
    * @return from
    */
    public Square getFrom() {
        return from;
    }

    /**
    * Sets new value of from
    * @param from new from
    */
    public void setFrom(Square from) {
        this.from = from;
    }

    /**
    * Returns value of to
    * @return to
    */
    public Square getTo() {
        return to;
    }

    /**
    * Sets new value of to
    * @param to new to
    */
    public void setTo(Square to) {
        this.to = to;
    }

    /**
    * Returns value of comment
    * @return comment
    */
    public Optional<String> getComment() {
        return comment;
    }

    /**
    * Sets new value of comment
    * @param comment new comment
    */
    public void setComment(Optional<String> comment) {
        this.comment = comment;
    }
}
