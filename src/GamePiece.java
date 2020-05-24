public abstract class GamePiece {
    protected PiecesName name;
    protected boolean color;

    public GamePiece(boolean color, PiecesName name){
        this.color = color;
        this.name = name;
    }

    public PiecesName getName(){
        return name;
    }
    public abstract boolean canMoveToDest(Board board, Cell start, Cell end);

    public boolean color() {
        return color;
    }

}
