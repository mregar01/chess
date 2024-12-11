import java.util.*;

public class Pawn extends Piece {
    public Pawn(Color c) { color = c; }
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
        sb.append('p');
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

        if(this.color == Color.WHITE){
            if(row == 1 && (b.getPiece(Switcher.getLocationString(col, row + 2)) == null)){
                possibleMoves.add(Switcher.getLocationString(col, row + 2));
            }

            if (Switcher.isValid(col, row + 1)){
                if ((b.getPiece(Switcher.getLocationString(col, row + 1)) == null)){
                    possibleMoves.add(Switcher.getLocationString(col, row + 1));
                }
            }

            
            if (Switcher.isValid(col + 1, row + 1)){
                if (b.getPiece(Switcher.getLocationString(col + 1, row + 1)) != null){
                    if (b.getPiece(Switcher.getLocationString(col + 1, row + 1)).color == Color.BLACK){
                        possibleMoves.add(Switcher.getLocationString(col + 1, row + 1));
                    }
                }
            }

            if (Switcher.isValid(col - 1, row + 1)){
                if (b.getPiece(Switcher.getLocationString(col - 1, row + 1)) != null){
                    if (b.getPiece(Switcher.getLocationString(col - 1, row + 1)).color == Color.BLACK){
                        possibleMoves.add(Switcher.getLocationString(col - 1, row + 1));
                    }
                }
            }

            


        } else {
            if(row == 6 && (b.getPiece(Switcher.getLocationString(col, row - 2)) == null)){
                possibleMoves.add(Switcher.getLocationString(col, row - 2));
            }

            if (Switcher.isValid(col, row - 1)){
                if ((b.getPiece(Switcher.getLocationString(col, row - 1)) == null)){
                    possibleMoves.add(Switcher.getLocationString(col, row - 1));
                }
            }

            
            if (Switcher.isValid(col + 1, row - 1)){
                if (b.getPiece(Switcher.getLocationString(col + 1, row - 1)) != null){                    
                    if (b.getPiece(Switcher.getLocationString(col + 1, row - 1)).color == Color.WHITE){
                        possibleMoves.add(Switcher.getLocationString(col + 1, row - 1));
                    }
                }
            }

            if (Switcher.isValid(col - 1, row - 1)){
                if (b.getPiece(Switcher.getLocationString(col - 1, row - 1)) != null){
                    if (b.getPiece(Switcher.getLocationString(col - 1, row - 1)).color == Color.WHITE){
                        possibleMoves.add(Switcher.getLocationString(col - 1, row - 1));
                    }
                }
            }
        }


        return possibleMoves;
    }

}