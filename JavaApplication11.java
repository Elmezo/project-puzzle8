package javaapplication11;

import java.util.LinkedList;

public class JavaApplication11 {

    public static void main(String[] args) {
        int[] puzzle = {3, 1, 2, 5, 4, 8, 6, 7, 0};

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
