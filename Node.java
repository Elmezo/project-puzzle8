import java.util.LinkedList;

public final class Node {

    public int x;
    public Node parent;
    public int[] puzzle = new int[9];
    public LinkedList<Node> children = new LinkedList<>();
    public final int col = 3;

    public Node(int[] p) {
        setPazzle(p);
    }

    public void ExpendNode() {
        for (int i = 0; i < puzzle.length; i++) {
            if (puzzle[i] == 0) {
                x = i;
            }
        }
        moveToR(puzzle, x);
        moveToL(puzzle, x);
        moveToUp(puzzle, x);
        moveToDown(puzzle, x);

    }
//---------------*----------------------------

    public void moveToR(int[] p, int i) {
        if (i % col < col - 1) {
            int[] pc = new int[9];
            copyPuzzle(pc, p);
            int temp = pc[i + 1];
            pc[i + 1] = pc[i];
            pc[i] = temp;
            Node child = new Node(pc);
            children.add(child);
            child.parent = this;
        }

    }

    public void moveToL(int[] p, int i) {
        if (i % col > 0) {
            int[] pc = new int[9];
            copyPuzzle(pc, p);

            int temp = pc[i - 1];
            pc[i - 1] = pc[i];
            pc[i] = temp;

            Node child = new Node(pc);
            children.add(child);
            child.parent = this;
        }
    }

    public void moveToUp(int[] p, int i) {
        if (i - col >= 0) {
            int[] pc = new int[9];
            copyPuzzle(pc, p);
            int temp = pc[i - 3];
            pc[i - 3] = pc[i];
            pc[i] = temp;
            Node child = new Node(pc);
            children.add(child);
            child.parent = this;
        }
    }

    public void moveToDown(int[] p, int i) {
        if (i + col < puzzle.length) {
            int[] pc = new int[9];
            copyPuzzle(pc, p);

            int temp = pc[i + 3];
            pc[i + 3] = pc[i];
            pc[i] = temp;

            Node child = new Node(pc);
            children.add(child);
            child.parent = this;
        }
    }
//---------------*----------------------------

    public void printPuzzle() {
        System.out.println();
        int m = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(puzzle[m] + "\t");
                m++;
            }
            System.out.println();
        }

    }

    public boolean isSamePuzzle(int[] p) {
        boolean samePuzzle = true;
        for (int i = 0; i < p.length; i++) {
            if (puzzle[i] != p[i]) {
                samePuzzle = false;
            }
        }
        return samePuzzle;

    }

    public void copyPuzzle(int[] a, int[] b) {
        System.arraycopy(b, 0, a, 0, b.length);
    }

    public void setPazzle(int[] p) {
        System.arraycopy(p, 0, this.puzzle, 0, puzzle.length);

    }

    public boolean GoalTest() {

        boolean isGoal = true;
        int m = puzzle[0];

        for (int i = 1; i < puzzle.length; i++) {
            if (m > puzzle[i]) {
                isGoal = false;
                m = puzzle[i];
            }
        }
        return isGoal;
    }

}
