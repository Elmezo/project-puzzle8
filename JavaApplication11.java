import java.util.LinkedList;
import java.util.Scanner;

public class JavaApplication11 {

    public static void main(String[] args) {
        // int[] puzzle = {1, 2, 4, 3, 0, 5, 7, 6, 8};
        //*******************---------------------------------------------------------------
        System.out.println("please enter the arrangement of the number in the puzzle");
        Scanner s = new Scanner(System.in);
        int puzzle[] = new int[9];
        for (int i = 0; i < 9; i++) {
            puzzle[i] = s.nextInt();
        }
       //*******************---------------------------------------------------------------

        
        
        Node root = new Node(puzzle);
        Bfs ui = new Bfs();
        LinkedList<Node> solution = ui.BreadthFisrstSearch(root);
        if (solution.size() > 0) {
            for (int i = 0; i < solution.size(); i++) {
                solution.get(i).printPuzzle();
            }
        } else {
            System.out.println("No path to solution to fond ...");
        }

    }

}
