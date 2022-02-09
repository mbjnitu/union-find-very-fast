import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class TreeTest {
    
    @Test
    //Test the time it takes to check random connections (1 for each node there is)
    public void rootPerformance() {
        Tree t = new Tree(10000);
        t.randomUnion();
        for (int i = 0; i < t.nodes.length; i++) {
            Random random = new Random();
            //Generate 2 random numbers between 0 and nodes.length
            int randomNumber = random.nextInt(t.nodes.length - 0) + 0;
            int randomNumber2 = random.nextInt(t.nodes.length - 0) + 0;

            t.connected(randomNumber, randomNumber2);
        }
        assertEquals(true, true, "test time");
    }
}
