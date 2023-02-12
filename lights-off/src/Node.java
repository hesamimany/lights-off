import java.util.ArrayList;

public class Node {
    private Node parent;
    private int xClicked;
    private int yClicked;
    private Board board;

    public Node(Node parent, int xClicked, int yClicked, Board board) {
        this.parent = parent;
        this.xClicked = xClicked;
        this.yClicked = yClicked;
        this.board = board;
    }

    public boolean isGoal() {
        return board.isGoal();
    }

    public String hash() {
        return board.hash();
    }

    // return all node you can go after this node
    public ArrayList<Node> successor() {
        ArrayList<Node> result = new ArrayList<>();
        for (int i = 0; i < board.getSize(); i++)
            for (int j = 0; j < board.getSize(); j++) {
                Board b = board.clone();
                b.clickTile(i, j);
                result.add(new Node(this, i, j, b));
            }

        return result;
    }

    public int heuristic() {
        int countOn = 0;
        int aroundOff = 0;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getBoard()[i][j].state == State.ON) countOn++;
                if (i == xClicked && j == yClicked) {
                    boolean rightBorder = false, leftBorder = false, topBorder = false, bottomBorder = false;
                    if (j + 1 == board.getSize()) rightBorder = true;
                    if (j == 0) leftBorder = true;
                    if (i == 0) topBorder = true;
                    if (i + 1 == board.getSize()) bottomBorder = true;

                    if (!rightBorder) {
                        if (board.getBoard()[i][j + 1].state == State.OFF) aroundOff++;
                    }
                    if (!leftBorder) {
                        if (board.getBoard()[i][j - 1].state == State.OFF) aroundOff++;
                    }
                    if (!topBorder) {
                        if (board.getBoard()[i - 1][j].state == State.OFF) aroundOff++;
                    }
                    if (!bottomBorder) {
                        if (board.getBoard()[i + 1][j].state == State.OFF) aroundOff++;
                    }
                }

            }
        }
        return countOn + aroundOff * 2;
    }

    public Node getParent() {
        return parent;
    }

    public void drawState() {
        System.out.println("Clicked [" + xClicked + "," + yClicked + "]");
        board.printBoard();
    }
}