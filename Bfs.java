package javaapplication11;

import java.util.LinkedList;

public class Bfs {

    public Bfs() {
    }

    public LinkedList<Node> BreadthFisrstSearch(Node root) {

        LinkedList<Node> patheToSolu = new LinkedList<Node>();
        LinkedList<Node> OpenList = new LinkedList<Node>();
        LinkedList<Node> ClosedList = new LinkedList<Node>();
        OpenList.add(root);
        boolean goalFound = false;
        while (OpenList.size() > 0 && !goalFound) {
            Node CuruntNode = OpenList.get(0);
            ClosedList.add(CuruntNode);
            OpenList.remove(0);

            CuruntNode.ExpendNode();
            for (int i = 0; i < CuruntNode.children.size(); i++) {
                Node Curuntchild = CuruntNode.children.get(i);
                if (Curuntchild.GoalTest()) {
                    System.out.println("Goal Found :) ");
                    goalFound = true;
                    //------
                    pathTrace(patheToSolu, Curuntchild);

                }
                if (!contains(OpenList, Curuntchild) && !contains(ClosedList, Curuntchild)) {
                    OpenList.add(Curuntchild);
                }
            }
        }

        return patheToSolu;
    }

    public void pathTrace(LinkedList<Node> path, Node n) {
        System.out.println("Tracing bath ...");

        Node currnt = n;
        path.add(currnt);

        while (currnt.parent != null) {
            currnt = currnt.parent;
            path.add(currnt);

        }

    }

    public static boolean contains(LinkedList<Node> list, Node c) {
        boolean contains = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSamePuzzle(c.puzzle)) {
                contains = true;
            }
        }
        return contains;
    }

}
