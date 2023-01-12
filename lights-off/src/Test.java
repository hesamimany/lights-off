public class Test {
    public static void main(String[] args) {
        Board board = new Board(5);
        board.printBoard();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                board.clickTile(i,j);
            }
        }
        board.printBoard();

    }
}
