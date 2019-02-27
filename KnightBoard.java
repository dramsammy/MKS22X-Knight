public class KnightBoard{
  private int[][] board;
  private int rows;
  private int cols;
  public static int[] moves = {1,2,1,-2,-1,2,-1,-2,2,1,2,-1,-2,1,-2,-1};
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
        solveH(row+1,col-2,counter+1);
        solveH(row-1,col-2,counter+1);
        solveH(row-1,col+2,counter+1);
        solveH(row+1,col+2,counter+1);
        solveH(row-2,col-1,counter+1);
        solveH(row-2,col+1,counter+1);
        solveH(row+2,col-1,counter+1);
        solveH(row+2,col+1,counter+1);
        return true;
      }
      else{
        RK(row,col);
      }
    }
    return false;
  }
  public boolean solve(int row, int col){
    return solveH(row,col,1);
  }
  private void clearBoard(){
    for (int i=0;i<board.length;i++) {
      for (int j=0;j<board[i].length;j++){
        board[i][j] = 0;
      }
  }
}
  public int countSolutions(int row, int col){
    return countSolutionsH(row, col, 1);
  }
  public int countSolutionsH(int row, int col, int counter){
    int count = 0;
    if (row >= board.length || row < 0 || col >= board[0].length || col < 0){
      return 0;
    }
    if (counter == rows * cols){
      count++;
    }
    AK(row, col, counter);
    for (int i = 0; i < moves.length; i += 2) {
      if (row + moves[i] < rows && row + moves[i] >= 0 && col + moves[i + 1] < cols && col + moves[i + 1] >= 0 && board[row + moves[i]][col + moves[i + 1]] == 0) {
        count += countSolutionsH(row + moves[i], col + moves[i+1], counter + 1);
      }
    }
    RK(row, col);
    return count;
    }


  public static void main(String[] args) {
    KnightBoard board = new KnightBoard(5,5);
    System.out.println(board.solve(0,0));
    KnightBoard test1 = new KnightBoard(4,4);
    System.out.println(test1.solve(0,0));
    System.out.println(board.countSolutions(0,0));
  }
}
