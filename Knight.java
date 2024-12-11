import java.util.*;

public class Knight extends Piece {
    public Knight(Color c) { color = c; }
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
        sb.append('n');
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

        
        if (Switcher.isValid(col + 2, row + 1)) {
            String location = Switcher.getLocationString(col + 2, row + 1);
            if ((b.getPiece(location) == null)){
                possibleMoves.add(location);
            } else if ((this.color == Color.WHITE && b.getPiece(location).color == Color.BLACK) 
            || (this.color == Color.BLACK && b.getPiece(location).color == Color.WHITE)){
                possibleMoves.add(location);
            }
        }

        if (Switcher.isValid(col + 2, row - 1)) {
            String location = Switcher.getLocationString(col + 2, row - 1);
            if ((b.getPiece(location) == null)){
                possibleMoves.add(location);
            } else if ((this.color == Color.WHITE && b.getPiece(location).color == Color.BLACK) 
            || (this.color == Color.BLACK && b.getPiece(location).color == Color.WHITE)){
                possibleMoves.add(location);
            }
        }

        if (Switcher.isValid(col - 2, row + 1)) {
            String location = Switcher.getLocationString(col - 2, row + 1);
            if ((b.getPiece(location) == null)){
                possibleMoves.add(location);
            } else if ((this.color == Color.WHITE && b.getPiece(location).color == Color.BLACK) 
            || (this.color == Color.BLACK && b.getPiece(location).color == Color.WHITE)){
                possibleMoves.add(location);
            }
        }

        if (Switcher.isValid(col - 2, row - 1)) {
            String location = Switcher.getLocationString(col - 2, row - 1);
            if ((b.getPiece(location) == null)){
                possibleMoves.add(location);
            } else if ((this.color == Color.WHITE && b.getPiece(location).color == Color.BLACK) 
            || (this.color == Color.BLACK && b.getPiece(location).color == Color.WHITE)){
                possibleMoves.add(location);
            }
        }

        if (Switcher.isValid(col + 1, row + 2)) {
            String location = Switcher.getLocationString(col + 1, row + 2);
            if ((b.getPiece(location) == null)){
                possibleMoves.add(location);
            } else if ((this.color == Color.WHITE && b.getPiece(location).color == Color.BLACK) 
            || (this.color == Color.BLACK && b.getPiece(location).color == Color.WHITE)){
                possibleMoves.add(location);
            }
        }

        if (Switcher.isValid(col + 1, row - 2)) {
            String location = Switcher.getLocationString(col + 1, row - 2);
            if ((b.getPiece(location) == null)){
                possibleMoves.add(location);
            } else if ((this.color == Color.WHITE && b.getPiece(location).color == Color.BLACK) 
            || (this.color == Color.BLACK && b.getPiece(location).color == Color.WHITE)){
                possibleMoves.add(location);
            }
        }

        if (Switcher.isValid(col - 1, row + 2)) {
            String location = Switcher.getLocationString(col - 1, row + 2);
            if ((b.getPiece(location) == null)){
                possibleMoves.add(location);
            } else if ((this.color == Color.WHITE && b.getPiece(location).color == Color.BLACK) 
            || (this.color == Color.BLACK && b.getPiece(location).color == Color.WHITE)){
                possibleMoves.add(location);
            }
        }

        if (Switcher.isValid(col - 1, row - 2)) {
            String location = Switcher.getLocationString(col - 1, row - 2);
            if ((b.getPiece(location) == null)){
                possibleMoves.add(location);
            } else if ((this.color == Color.WHITE && b.getPiece(location).color == Color.BLACK) 
            || (this.color == Color.BLACK && b.getPiece(location).color == Color.WHITE)){
                possibleMoves.add(location);
            }
        }
        
        return possibleMoves;
    }

}