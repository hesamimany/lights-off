public class Board {
    private Tile[][] board; // from 0 to size - 1
    private final int size;

    public Board(int size) {
        board = new Tile[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Tile(State.OFF);
            }
        }
        this.size = size;
    }

    public Board(Tile[][] board, int size) {
        this.board = board;
        this.size = size;
    }

    public Tile[][] getBoard() {
        return board;
    }

    public int getSize() {
        return size;
    }

    private void changeState(int i, int j) {
        getBoard()[i][j].click();
    }

    public void clickTile(int i, int j) {
        boolean rightBorder = false, leftBorder = false, topBorder = false, bottomBorder = false;
        boolean done = false;
        if (i > size || j > size) throw new ArrayIndexOutOfBoundsException();
        else {
            changeState(i, j);

            if (j + 1 == size) rightBorder = true;
            if (j == 0) leftBorder = true;
            if (i == 0) topBorder = true;
            if (i + 1 == size) bottomBorder = true;

            if (!rightBorder) {
                changeState(i, j + 1);
            }
            if (!leftBorder) {
                changeState(i, j - 1);
            }
            if (!topBorder) {
                changeState(i - 1, j);
            }
            if (!bottomBorder) {
                changeState(i + 1, j);
            }
        }
    }

    public void printBoard(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(getBoard()[i][j]);
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
