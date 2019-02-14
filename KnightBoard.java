public class KnightBoard{
  private int[][] board;
  private int rows;
  private int cols;
  public KnightBoard(int startingRows, int startingCols){
    if (startingRows <= 0 || startingCols <= 0){
      throw new IllegalArgumentException();
    }
    rows = startingRows;
    cols = startingCols;
    board = new int[startingRows][startingCols];
    for (int i = 0; i < rows; i++){
      for (int a = 0; a < cols; a++){
        board[i][a] = 0;
      }
    }
  }


  public String toString(){
    String returnValue = "\n";
    for (int i = 0; i < rows; i++){
      for (int a = 0; a < cols; a++){
        if (board[i][a] < 10){
          returnValue += " " + board[i][a] + " ";
        }
        else{
          returnValue += board[i][a] + " ";
        }
      }
      returnValue += "\n";
  }
  return returnValue;
}
}
