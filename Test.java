import java.util.*;
public class Test {


    // Run "java -ea Test" to run with assertions enabled (If you run
    // with assertions disabled, the default, then assert statements
    // will not execute!)

    public static void test1() {
        Board b = Board.theBoard();
        Piece.registerPiece(new PawnFactory());
        Piece p = Piece.createPiece("bp");
        b.addPiece(p, "a8");
        assert b.getPiece("a8") == p;
        
        System.out.println("test1 output:");
        Switcher.printBoard(b);

        b.clear();
    }

    public static void move_pawn() {
        Board b = Board.theBoard();
        Piece.registerPiece(new PawnFactory());
        Piece wp = Piece.createPiece("wp");
        Piece bp = Piece.createPiece("bp");
        b.addPiece(wp, "a2");
        b.addPiece(bp, "b7");

        b.movePiece("a2", "a3");
        b.movePiece("a3", "a4");
        b.movePiece("b7", "b6");
        b.movePiece("b6", "b5");

        b.movePiece("a4", "b5");

        assert b.getPiece("b5") == wp;
        System.out.println("move_pawn output:");
        Switcher.printBoard(b);
        b.clear();

    }

    public static void move_king(){
        Board b = Board.theBoard();
        Piece.registerPiece(new KingFactory());
        Piece.registerPiece(new PawnFactory());
        Piece bp = Piece.createPiece("bp");
        Piece wk = Piece.createPiece("wk");
        b.addPiece(bp, "a3");
        b.addPiece(wk, "a1");

        b.movePiece("a1", "a2");

        b.movePiece("a2", "b2");
        b.movePiece("b2", "a3");

        assert(b.getPiece("a3") == wk);

        System.out.println("move_king output:");
        Switcher.printBoard(b);
        b.clear();
    }

    public static void move_knight(){
        Board b = Board.theBoard();
        Piece.registerPiece(new KnightFactory());
        Piece.registerPiece(new PawnFactory());
        Piece bp = Piece.createPiece("bp");
        Piece wn = Piece.createPiece("wn");
        b.addPiece(bp, "c2");
        b.addPiece(wn, "a1");

        b.movePiece("a1", "c2");

        // b.movePiece("a2", "b2");
        // b.movePiece("b2", "a3");

        assert(b.getPiece("c2") == wn);

        System.out.println("move_knight output:");
        Switcher.printBoard(b);
        b.clear();
    }

    public static void move_rook(){
        Board b = Board.theBoard();
        Piece.registerPiece(new RookFactory());
        Piece.registerPiece(new PawnFactory());
        Piece wr = Piece.createPiece("wr");
        Piece bp = Piece.createPiece("bp");
        b.addPiece(wr, "a1");
        b.addPiece(bp, "a8");

        b.movePiece("a1", "h1");
        b.movePiece("h1", "h8");
        b.movePiece("h8", "a8");

        assert(b.getPiece("a8") == wr);

        System.out.println("move_rook output:");
        Switcher.printBoard(b);
        b.clear();

    }

    public static void move_bishop(){
        Board b = Board.theBoard();
        Piece.registerPiece(new BishopFactory());
        Piece.registerPiece(new PawnFactory());
        Piece wb = Piece.createPiece("wb");
        Piece bp = Piece.createPiece("bp");
        b.addPiece(wb, "d4");
        b.addPiece(bp, "a7");
        

        b.movePiece("d4", "a7");

        assert(b.getPiece("a7") == wb);

        System.out.println("move_bishop output:");
        Switcher.printBoard(b);
        b.clear();

    }

    public static void move_queen(){
        Board b = Board.theBoard();
        Piece.registerPiece(new QueenFactory());
        Piece.registerPiece(new PawnFactory());
        Piece wq = Piece.createPiece("wq");
        Piece bp = Piece.createPiece("bp");
        b.addPiece(wq, "d4");
        b.addPiece(bp, "a7");
        
        b.movePiece("d4", "a7");

        assert(b.getPiece("a7") == wq);

        System.out.println("move_bishop output:");
        Switcher.printBoard(b);
        b.clear();

    }

    private static void testKnightMoves() {
        Board board = Board.theBoard();
        Knight knight = new Knight(Color.WHITE);

        // in the middle of the board
        board.addPiece(knight, "e4");
        List<String> moves = knight.moves(board, "e4");
        assert moves.containsAll(Arrays.asList("c5", "d6", "f6", "g5", "g3", "f2", "d2", "c3"));
        board.clear();

        // at the edge of the board
        board.addPiece(knight, "h7");
        moves = knight.moves(board, "h7");
        assert moves.containsAll(Arrays.asList("f6", "g5"));
        board.clear();

        // at the corner of the board
        board.addPiece(knight, "a1");
        moves = knight.moves(board, "a1");
        assert moves.containsAll(Arrays.asList("b3", "c2"));
        board.clear();

        // occupied surroundings (friend and opponent pieces)
        board.addPiece(knight, "e4");
        board.addPiece(new Rook(Color.WHITE), "c5"); // friend piece
        board.addPiece(new Rook(Color.BLACK), "g5"); // opponent piece
        moves = knight.moves(board, "e4");
        assert moves.containsAll(Arrays.asList("d6", "f6", "g5", "g3", "f2", "d2", "c3"));
        assert !moves.contains("c5"); // blocked move should not be in the list

        System.out.println("move_knight_extra output:");
        Switcher.printBoard(board);
        board.clear();
    }

    public static void new_test(){
        Board b = Board.theBoard();
        Piece.registerPiece(new PawnFactory());
        Piece wp = Piece.createPiece("wp");
        Piece bp = Piece.createPiece("bp");
        b.addPiece(wp, "d2");
        b.addPiece(bp, "c3");
        Switcher.printBoard(b);
        System.err.println(wp.moves(b, "d2"));
        System.err.println(bp.moves(b, "c3"));
    }


    
    public static void main(String[] args) {
	    test1();
        move_pawn();
        move_king();
        move_knight();
        move_rook();
        move_bishop();
        move_queen();
        testKnightMoves();
        new_test();
        System.out.println("Tests Passed!");
    }

}