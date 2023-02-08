import java.util.ArrayList;

public class Node{
    private Node parrent;
    private int xClicked;
    private int yClicked;
    private Board board;

    public Node(Node parrent , int xClicked , int yClicked , Board board){
        this.parrent = parrent;
        this.xClicked = xClicked;
        this.yClicked = yClicked;
        this.board = board;
    }

    public boolean isGoal(){
        return board.isGoal();
    }
    public String hash(){
        return board.hash();
    }
    // return all node you can go after this node
    public ArrayList<Node> successor(){
        ArrayList<Node> result = new ArrayList<Node>();
        for (int i = 0 ; i < board.getSize(); i++)
            for (int j = 0 ; j < board.getSize(); j++){
                Board b = board.clone();
                b.clickTile(i , j);
                result.add(new Node(this,i ,j,b));
            }

        return result;
    }
    public Node getParent(){
        return parrent;
    }
    public void drawState(){
        System.out.println("Clicked [" + xClicked + "," + yClicked +  "]");
        board.printBoard();
    }
}