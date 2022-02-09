public class Tree {
    int[] nodes;

    public Tree(int size) {
        nodes = new int[size];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = i;
        }
    }

    public int root(int index) {
        while(nodes[index] != index) {
            index = nodes[index];
        }
        return index;
    }

    public boolean connected(int index1, int index2) {
        return root(index1) == root(index2);
    }

    public void union(int index1, int index2) {
        nodes[root(index1)] = root(index2);
    }

    ////////////////////////////////
    // Display functions

    public void displayConnected(int index1, int index2) {
        System.out.println(connected(index1, index2));
    }

    public void display() {
        System.out.println("");
        for (int i = 0; i < nodes.length; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println("");
        for (int i = 0; i < nodes.length; i++) {
            System.out.print("[" + nodes[i] + "] ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Tree t = new Tree(10);
        t.display();
        t.union(0,1);
        t.display();
        t.union(1,2);
        t.display();
        t.union(4,0);
        t.display();
        t.displayConnected(4, 1);
        t.displayConnected(4, 9);
    }
}