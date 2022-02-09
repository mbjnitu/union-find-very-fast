import java.util.Random;

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

    public void randomUnion() {
        //For each node in tree. Do a random union
        for (int i = 0; i < nodes.length; i++) {
            Random random = new Random();
            //Generate 2 random numbers between 0 and nodes.length
            int randomNumber = random.nextInt(nodes.length - 0) + 0;
            int randomNumber2 = random.nextInt(nodes.length - 0) + 0;

            union(randomNumber, randomNumber2);
        }
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
        Tree t = new Tree(100);
        t.display();
        t.randomUnion();
        t.display();
    }
}