public class Tree {
    int[] nodes;

    public Tree(int size) {
        nodes = new int[size];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = i;
        }
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
    }
    public static void main(String[] args) {
        Tree t = new Tree(10);
        t.display();
    }
}