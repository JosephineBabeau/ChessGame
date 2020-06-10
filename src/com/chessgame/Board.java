package com.chessgame;

import java.util.LinkedList;

public class Board {
    GamePiece[][] board = new GamePiece[8][8];

    // Helper function: provides location of a given type of piece(s)
    public LinkedList<Cell> getPiecesByType(Constants.GamePieceName name) {

        LinkedList<Cell> listOfPieces = new LinkedList<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){

                GamePiece piece = board[i][j];
                if((piece != null) && (name == piece.getName())) {
                    listOfPieces.addLast(new Cell(i,j));
                }
            }
        }
        return listOfPieces;
    }
    // getPiece returns the piece displayed in a given cell
    public GamePiece getPiece(Cell boardCell){

        return board[boardCell.getRow()][boardCell.getCol()];
    }
    public void setPiece(Cell boardCell, GamePiece piece) {

        board[boardCell.getRow()][boardCell.getCol()] = piece;
    }

    public void movePiece(Cell start, Cell end, GamePiece piece) {
        setPiece(end, piece);
        setPiece(start, null);
    }

    // isEmpty method indicates if a piece is in this given square
    public boolean isEmpty(Cell cell){
        return board[cell.getRow()][cell.getCol()] == null;
    }
    //isCellValid method checks for out of bound
    public boolean isCellValid(Cell cell){

        if(cell.getRow() < 0) return false;
        if(cell.getRow() >= board.length) return false;
        if(cell.getCol() < 0) return false;
        if(cell.getCol() >= board[0].length) return false;

        return true;
    }

    public int getRowSize() {
        return board.length;
    }

    public int getColSize() {
        return board[0].length;
    }

}
