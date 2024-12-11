import java.util.*;

public class Queen extends Piece {
    public Queen(Color c) { color = c; }
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
        sb.append('q');
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

        //bishop

        int newcol = col;
        for (int i = row + 1; i < 8; i++){
            newcol++;
            String location = Switcher.getLocationString(newcol, i);
            if (Switcher.isValid(newcol, i)){
                if ((b.getPiece(location) == null)){
                    possibleMoves.add(location);
                } else if ((this.color == Color.WHITE && b.getPiece(location).color == Color.BLACK) 
                || (this.color == Color.BLACK && b.getPiece(location).color == Color.WHITE)){
                    possibleMoves.add(location);
                    break;
                } else {
                    break;
                }
            }
            
        }

        newcol = col;
        for (int i = row - 1; i > -1; i--){
            newcol--;
            String location = Switcher.getLocationString(newcol, i);

            if(Switcher.isValid(newcol, i)){
                if ((b.getPiece(location) == null)){
                    possibleMoves.add(location);
                } else if ((this.color == Color.WHITE && b.getPiece(location).color == Color.BLACK) 
                || (this.color == Color.BLACK && b.getPiece(location).color == Color.WHITE)){
                    possibleMoves.add(location);
                    break;
                } else {
                    break;
                }
            }
            
        }

        int newrow = row;
        for (int i = col + 1; i < 8; i++){
            newrow--;
            String location = Switcher.getLocationString(i, newrow);

            if(Switcher.isValid(i, newrow)){
                if ((b.getPiece(location) == null)){
                    possibleMoves.add(location);
                } else if ((this.color == Color.WHITE && b.getPiece(location).color == Color.BLACK) 
                || (this.color == Color.BLACK && b.getPiece(location).color == Color.WHITE)){
                    possibleMoves.add(location);
                    break;
                } else {
                    break;
                }
            }
            
        }

        newrow = row;
        for (int i = col - 1; i > -1; i--){
            newrow++;
            String location = Switcher.getLocationString(i, newrow);

            if(Switcher.isValid(i, newrow)){
                if ((b.getPiece(location) == null)){
                    possibleMoves.add(location);
                } else if ((this.color == Color.WHITE && b.getPiece(location).color == Color.BLACK) 
                || (this.color == Color.BLACK && b.getPiece(location).color == Color.WHITE)){
                    possibleMoves.add(location);
                    break;
                } else {
                    break;
                }
            }
            
        }

        //rook

        for (int i = row + 1; i < 8; i++){
            String location = Switcher.getLocationString(col, i);
            if ((b.getPiece(location) == null)){
                possibleMoves.add(location);
            } else if ((this.color == Color.WHITE && b.getPiece(location).color == Color.BLACK) 
            || (this.color == Color.BLACK && b.getPiece(location).color == Color.WHITE)){
                possibleMoves.add(location);
                break;
            } else {
                break;
            }
        }

        for (int i = row - 1; i > -1; i--){
            String location = Switcher.getLocationString(col, i);
            if ((b.getPiece(location) == null)){
                possibleMoves.add(location);
            } else if ((this.color == Color.WHITE && b.getPiece(location).color == Color.BLACK) 
            || (this.color == Color.BLACK && b.getPiece(location).color == Color.WHITE)){
                possibleMoves.add(location);
                break;
            } else {
                break;
            }
        }

        for (int i = col + 1; i < 8; i++){
            String location = Switcher.getLocationString(i, row);
            if ((b.getPiece(location) == null)){
                possibleMoves.add(location);
            } else if ((this.color == Color.WHITE && b.getPiece(location).color == Color.BLACK) 
            || (this.color == Color.BLACK && b.getPiece(location).color == Color.WHITE)){
                possibleMoves.add(location);
                break;
            } else {
                break;
            }
        }

        for (int i = col - 1; i > -1; i--){
            String location = Switcher.getLocationString(i, row);
            if ((b.getPiece(location) == null)){
                possibleMoves.add(location);
            } else if ((this.color == Color.WHITE && b.getPiece(location).color == Color.BLACK) 
            || (this.color == Color.BLACK && b.getPiece(location).color == Color.WHITE)){
                possibleMoves.add(location);
                break;
            } else {
                break;
            }
        }

        


        return possibleMoves;
    }

}