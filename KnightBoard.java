public class KnightBoard{
  private int[][] KnightBoard;
  public KnightBoard(int startingRows, int startingCols){
    if (startingRows <= 0 || startingCols <= 0){
      throw new IllegalArgumentException();
    }
    KnightBoard = new int[startingRows][startingCols];
  }
}
