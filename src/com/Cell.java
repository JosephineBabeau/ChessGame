package com;

public class Cell {
    private int row;
    private int col;

    public Cell() {
        this.row = 0;
        this.col = 0;
    }

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }


    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }

    public void set(int i, int j)
    {
        row = i;
        col = j;
    }

    public void copy(Cell copy)
    {
        row = copy.getRow();
        col = copy.getCol();
    }


}





