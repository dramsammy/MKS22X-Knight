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
        if (board[i][a] == 0){
          returnValue += " " + "_" + " ";
        }
        if (board[i][a] < 10 && board[i][a] > 0){
          returnValue += " " + board[i][a] + " ";
        }
        if (board[i][a] > 10){
          returnValue += board[i][a] + " ";
        }
      }
      returnValue += "\n";
  }
  return returnValue;
}

  private boolean RK(int row, int col){
    board[row][col] = 0;
    return true;
  }

  private boolean AK(int row, int col, int counter){
    if (board[row][col] != 0){
      return false;
    }
    if (row > rows || col > cols || row < 0 || col < 0){
      return false;
    }
    if (board[row][col] == 0){
      board[row][col] = counter;
      return true;
    }
    return false;
    }
  public boolean solveH(int row, int col, int counter){
    if (counter > rows * col){
      return true; // counter is greater than number of possible moves around the board stop recursion
    }
    else{
      if (AK(row,col,counter)){//if the knight can be added
        solveH(row+1,col-2,level+1);
        solveH(row-1,col-2,level+1);
        solveH(row-1,col+2,level+1);
        solveH(row+1,col+2,level+1);
        solveH(row-2,col-1,level+1);
        solveH(row-2,col+1,level+1);
        solveH(row+2,col-1,level+1);
        solveH(row+2,col+1,level+1);
        return true;
      }
      else{
        RK(row,col);
      }
    }
    return false;
  }
  public boolean solve(int row, int col, int counter){
    if (startingRows <= 0 || startingCols <= 0){
      throw new IllegalArgumentException();
    }
    return solveH(row,col,0);
  }
}
