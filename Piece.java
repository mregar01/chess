import java.util.*;

abstract public class Piece {
    public static HashMap<Character, PieceFactory> register = new HashMap<>();

    public Color color;

    public static void registerPiece(PieceFactory pf) {
        register.put(pf.symbol(), pf);
    }

    public static Piece createPiece(String name) {
        char curr_color = name.charAt(0);
        char type = name.charAt(1);

        PieceFactory p = register.get(type);
        Piece new_p;
        if (curr_color == 'w') {
            new_p = p.create(Color.WHITE);
        } else if (curr_color == 'b'){
            new_p = p.create(Color.BLACK);
        } else {
            throw new UnsupportedOperationException();
        }
        
        return new_p;
    }

    public Color color() {
	// You should write code here and just inherit it in
	// subclasses. For this to work, you should know
	// that subclasses can access superclass fields.
        return color;
    }

    abstract public String toString();

    abstract public List<String> moves(Board b, String loc);
}