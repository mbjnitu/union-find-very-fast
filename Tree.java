import java.util.Random;

// Sources:
//https://www.youtube.com/watch?v=BcRLmCS8pfw
//https://www.youtube.com/watch?v=Wme8SDUaBx8

public class Tree {
    int[] nodes;
    int[] branchSize;

    public Tree(int size) {
        nodes = new int[size];
        branchSize = new int[size];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = i;
            branchSize[i] = 1;
        }
    }

    //Classic root. Checks if the node at an index, is equal to the index. If not, go to the index matching the node-value, and check again.
    //  Atlast, return the index that IS equal to its node-value. (And therefor the top of the tree.)
    public int root(int index) {
        while(nodes[index] != index) {
            index = nodes[index];
        }
        return index;
    }
    
    //Same as root, but everytime the next-up / parent node is checked, set the current node to be equal to it. This way we flatten the tree.
    // (Watch following video: https://www.youtube.com/watch?v=Wme8SDUaBx8)
    public int rootPathCompressed(int index) {
        while(nodes[index] != index) {
            nodes[index] = nodes[nodes[index]];
            index = nodes[index];
        }
        return index;
    }

    public boolean connected(int index1, int index2) {
        return root(index1) == root(index2);
    }

    //Classic union. The Root of index2, will be set at the new node-value of index2.
    //  This way Index1 and its sub-nodes are now merged with root of Index2
    public void union(int index1, int index2) {
        nodes[root(index1)] = root(index2);
    }

    // Same as union, but implements "Weight" that keeps track of branch-sizes. The smallest branch is merged into the largest.
    //  This means that branch-lenghts will be minimized when possible.
    public void unionWeighted(int index1, int index2, String rootType) {
        int rootI1;
        int rootI2;

        if (rootType.equals("root")) {
            rootI1 = root(index1);
            rootI2 = root(index2);
        }
        else if (rootType.equals("rootPathCompressed")) {
            rootI1 = rootPathCompressed(index1);
            rootI2 = rootPathCompressed(index2);
        }
        else { //Else so compiler doesn't complain :/
            rootI1 = 0;
            rootI2 = 0;
        }
        

        if (branchSize[rootI1] < branchSize[rootI2]) {
            nodes[rootI1] = rootI2;
            branchSize[rootI2] += branchSize[rootI1];
        }
        else {
            nodes[rootI2] = rootI1;
            branchSize[rootI1] += branchSize[rootI2];
        }
    }

    public void randomUnion(String unionType, String rootType) {
        //For each node in tree. Do a random union
        for (int i = 0; i < nodes.length; i++) {
            Random random = new Random();
            //Generate 2 random numbers between 0 and nodes.length
            int randomNumber = random.nextInt(nodes.length - 0) + 0;
            int randomNumber2 = random.nextInt(nodes.length - 0) + 0;

            if (unionType.equals("union")) {
                union(randomNumber, randomNumber2);
            }
                
            else if (unionType.equals("unionWeighted")) {
                unionWeighted(randomNumber, randomNumber2, rootType);
            }
                
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
        Tree t = new Tree(10);
        t.display();
        t.randomUnion("union", "root");
        t.display();
    }
}