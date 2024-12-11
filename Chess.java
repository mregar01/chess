import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Chess {
    public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage: java Chess layout moves");
		}
		Piece.registerPiece(new KingFactory());
		Piece.registerPiece(new QueenFactory());
		Piece.registerPiece(new KnightFactory());
		Piece.registerPiece(new BishopFactory());
		Piece.registerPiece(new RookFactory());
		Piece.registerPiece(new PawnFactory());
		Board.theBoard().registerListener(new Logger());


		// args[0] is the layout file name
		// args[1] is the moves file name
		// Put your code to read the layout file and moves files
		// here.


		//layout setup
		try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
			String line;

			while ((line = br.readLine()) != null) {
				if (line.charAt(0) == '#' || line.length() == 0){
					continue;
				}

				if (!(line.charAt(0) >= 'a' && line.charAt(0) <= 'h')){
					throw new UnsupportedOperationException();
				}

				if (!(line.charAt(1) > '0' && line.charAt(1) < '9')){
					throw new UnsupportedOperationException();
				}

				if (!(line.charAt(2) == '=')){
					throw new UnsupportedOperationException();
				}

				if (!(line.charAt(3) == 'b' || line.charAt(3) == 'w') ){
					throw new UnsupportedOperationException();
				}

				if (!(line.charAt(4) == 'k' || line.charAt(4) == 'q' 
				|| line.charAt(4) == 'r' || line.charAt(4) == 'b' 
				|| line.charAt(4) == 'n' || line.charAt(4) == 'p') ){
					throw new UnsupportedOperationException();
				}

				StringBuilder sb = new StringBuilder();
				sb.append(line.charAt(3));
				sb.append(line.charAt(4));

				Piece currPiece = Piece.createPiece(sb.toString());

				StringBuilder sb1 = new StringBuilder();
				sb1.append(line.charAt(0));
				sb1.append(line.charAt(1));

				Board.theBoard().addPiece(currPiece, sb1.toString());
			}   
		} catch (IOException e) {
			e.printStackTrace(); 
			throw new UnsupportedOperationException();
		}


		//moves setup
		try (BufferedReader br = new BufferedReader(new FileReader(args[1]))) {
			String line;

			while ((line = br.readLine()) != null) {
				if (line.charAt(0) == '#' || line.length() == 0){
					continue;
				}

				if (!(line.charAt(0) >= 'a' && line.charAt(0) <= 'h')){
					throw new UnsupportedOperationException();
				}

				if (!(line.charAt(1) > '0' && line.charAt(1) < '9')){
					throw new UnsupportedOperationException();
				}

				if (!(line.charAt(2) == '-')){
					throw new UnsupportedOperationException();
				}

				if (!(line.charAt(3) >= 'a' && line.charAt(3) <= 'h')){
					throw new UnsupportedOperationException();
				}
				if (!(line.charAt(4) > '0' && line.charAt(4) < '9')){
					throw new UnsupportedOperationException();
				}


				StringBuilder fromsb = new StringBuilder();
				fromsb.append(line.charAt(0));
				fromsb.append(line.charAt(1));

				StringBuilder tosb = new StringBuilder();
				tosb.append(line.charAt(3));
				tosb.append(line.charAt(4));

				Board.theBoard().movePiece(fromsb.toString(), tosb.toString());
			}
		} catch (IOException e) {
			e.printStackTrace(); 
			throw new UnsupportedOperationException();
		}
		
		// Leave the following code at the end of the simulation:
		System.out.println("Final board:");
		Board.theBoard().iterate(new BoardPrinter());
    }
}