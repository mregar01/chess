
public class Switcher {
    public static int[] getLocationNumbers(String loc){

        int col = loc.charAt(0)-97;
        int row = loc.charAt(1)-49;
        int numbers[] = {0,0};

        numbers[0] = col;
        numbers[1] = row;

        return numbers;
    }

    public static String getLocationString(int col, int row){
        StringBuilder sb = new StringBuilder();

        char c = (char)( col + 97);
        


        sb.append(c);  
        sb.append(Integer.toString(row + 1));

        return sb.toString();
    }

    public static boolean isValid(int col, int row){
        if (col < 0 || row < 0 || col > 7 || row > 7){
          return false;
        }

        return true;
    }

    public static void printBoard(Board board) 
    {
        System.out.println("   a  b  c  d  e  f  g  h");
        System.out.println("  +------------------------");

        for(int row = 7; row >= 0; row--) 
        { 
          System.out.print((row + 1) + " |"); 

          for(int col = 0; col < 8; col++) 
          {
              String loc = Switcher.getLocationString(col, row); 
              Piece piece = board.getPiece(loc);

              if(piece != null) 
              {
                System.out.printf("%-3s", piece);
              } else 
              {
                System.out.print(".  ");
              }
          }
          System.out.println();
        }
    }
}
