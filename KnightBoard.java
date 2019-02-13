public class KnightBoard{
  private int[][] board;
  public KnightBoard(int startingRows, int startingCols){
    if (startingRows <= 0 || startingCols <= 0){
      throw new IllegalArgumentException();
    }
    board = new int[startingRows][startingCols];
    for (int i = 0; i < startingRows; i++){
      for (int a = 0; a < startingCols; a++){
        board[i][a] = 0;
      }
    }
  }
}
