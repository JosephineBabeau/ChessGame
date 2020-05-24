public class Board {
    GamePiece[][] board = new GamePiece[8][8];

    public GamePiece getPiece(Cell boardCell){

        return board[boardCell.getRow()][boardCell.getCol()];
    }
    public boolean isEmpty(Cell cell){
        return board[cell.getRow()][cell.getCol()] == null;
    }
    public boolean isCellValid(Cell cell){

        if(cell.getRow() < 0) return false;
        if(cell.getRow() >= board.length ) return false;
        if(cell.getCol() < 0) return false;
        if(cell.getCol() >= board[0].length) return false;

        return true;
    }
}
