import java.util.*;

public class King extends Piece {
    public King(Color c) { color = c; }
    // implement appropriate methods

    public String toString() {
        char currcolor;
        if (this.color() == Color.WHITE){
            currcolor = 'w';
        } else {
            currcolor = 'b';
        }

        StringBuilder sb = new StringBuilder();
        sb.append(currcolor);
        sb.append('k');
        return sb.toString();
    }

    public List<String> moves(Board b, String loc) {
        List<String> possibleMoves = new ArrayList<>();
        int numLocations []= Switcher.getLocationNumbers(loc);
        int col = numLocations[0];
        int row = numLocations[1];

        if (!Switcher.isValid(col, row)){
            throw new UnsupportedOperationException();
        }

        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
                int newCol = col + i;
                int newRow = row + j;
                if (Switcher.isValid(newCol, newRow) && (!(newCol == col && newRow == row))){
                    String location = Switcher.getLocationString(newCol, newRow);
                    if ((b.getPiece(location) == null)){
                        possibleMoves.add(location);
                    } else if ((this.color == Color.WHITE && b.getPiece(location).color == Color.BLACK) 
                    || (this.color == Color.BLACK && b.getPiece(location).color == Color.WHITE)){
                        possibleMoves.add(location);
                    }
                }
            }
        }
        
        return possibleMoves;
    }
}