import java.util.*;
public class Board {

    private Piece[][] pieces = new Piece[8][8];
    private static Board board = null;
    private List<BoardListener> listeners = new ArrayList<>();

    private Board() { }
    
    public static Board theBoard() {
        if (board == null){
            board = new Board();
        }

       return board;
    }

    // Returns piece at given loc or null if no such piece
    // exists
    public Piece getPiece(String loc) {
        int numLocations []= Switcher.getLocationNumbers(loc);
        int col = numLocations[0];
        int row = numLocations[1];
        if (col < 0 || col > 7 || row < 0 || row > 7){
            throw new UnsupportedOperationException();
        }
        return pieces[col][row];
    }

    public void addPiece(Piece p, String loc) {
        int numLocations []= Switcher.getLocationNumbers(loc);
        int col = numLocations[0];
        int row = numLocations[1];

        if (col < 0 || col > 7 || row < 0 || row > 7){
            throw new UnsupportedOperationException();
        }

        if (pieces[col][row] != null){
            throw new UnsupportedOperationException();
        } else {
            pieces[col][row] = p;
            // System.err.println("col: " + col + "row:" + row);
        }
    }

    public void movePiece(String from, String to) {
        int fromLocations []= Switcher.getLocationNumbers(from);
        int fromcol = fromLocations[0];
        int fromrow = fromLocations[1];
        int toLocations []= Switcher.getLocationNumbers(to);
        int tocol = toLocations[0];
        int torow = toLocations[1];

        if (!(Switcher.isValid(fromcol, fromrow) || Switcher.isValid(tocol, torow))){
            throw new UnsupportedOperationException();
        }

        if (pieces[fromcol][fromrow] == null){
            throw new UnsupportedOperationException();
        }

        List<String> moves = getPiece(from).moves(this, from);
        if (!moves.contains(to)){
            throw new UnsupportedOperationException();
        }

        for (BoardListener listener : listeners ){
            listener.onMove(from, to, pieces[fromcol][fromrow]);
            if (pieces[tocol][torow] != null){
                listener.onCapture(pieces[fromcol][fromrow], pieces[tocol][torow]);
            }
            
        }

        pieces[tocol][torow] = getPiece(from);
        pieces[fromcol][fromrow] = null;

        

    }

    public void clear() {
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                pieces[col][row] = null;
            }
        }
    }

    public void registerListener(BoardListener bl) {
	    listeners.add(bl);
    }

    public void removeListener(BoardListener bl) {
        if (listeners.contains(bl)){
            listeners.remove(bl);
        }
	   
    }

    public void removeAllListeners() {
	    listeners.clear();
    }

    public void iterate(BoardInternalIterator bi) {
	    for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                String location = Switcher.getLocationString(col, row);
                bi.visit(location, pieces[col][row]);
            }
        }
    }
}