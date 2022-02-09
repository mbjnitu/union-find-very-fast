import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class TreeTest {
    
    @Test
    //Test the time it takes to check random connections (1 for each node there is)
    public void unionPerformance() {
        Tree t = new Tree(100000);
        t.randomUnion("union", "root");
        for (int i = 0; i < t.nodes.length; i++) {
            Random random = new Random();
            //Generate 2 random numbers between 0 and nodes.length
            int randomNumber = random.nextInt(t.nodes.length - 0) + 0;
            int randomNumber2 = random.nextInt(t.nodes.length - 0) + 0;

            t.connected(randomNumber, randomNumber2);
        }
        assertEquals(true, true, "test time");

        //With new Tree(100000), avgTime = 10200ms
    }

    @Test
    //Test the time it takes to check random connections WITH weighted unions (1 for each node there is)
    public void unionWeightedPerformance() {
        Tree t = new Tree(100000);
        t.randomUnion("unionWeighted", "root");
        for (int i = 0; i < t.nodes.length; i++) {
            Random random = new Random();
            //Generate 2 random numbers between 0 and nodes.length
            int randomNumber = random.nextInt(t.nodes.length - 0) + 0;
            int randomNumber2 = random.nextInt(t.nodes.length - 0) + 0;

            t.connected(randomNumber, randomNumber2);
        }
        assertEquals(true, true, "test time");

        //With new Tree(100000), avgTime = 9400ms
    }
    
    @Test
    //Test the time it takes to check random connections WITH weighted unions (1 for each node there is)
    public void unionWeightedPerformanceAndRootPathCompressed() {
        Tree t = new Tree(100000);
        t.randomUnion("unionWeighted", "rootPathCompressed");
        for (int i = 0; i < t.nodes.length; i++) {
            Random random = new Random();
            //Generate 2 random numbers between 0 and nodes.length
            int randomNumber = random.nextInt(t.nodes.length - 0) + 0;
            int randomNumber2 = random.nextInt(t.nodes.length - 0) + 0;

            t.connected(randomNumber, randomNumber2);
        }
        assertEquals(true, true, "test time");
        
        //With new Tree(100000), avgTime = 53ms
    }
}
