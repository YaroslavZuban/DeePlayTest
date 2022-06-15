package Yaroslav.Zuban.Deeplay.Test;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void getResult() throws Exception {
        Solution solution1 = new Solution("PPPPSSSPSSSPSSSP", "Human");
        assertEquals(Solution.getResult(), 6);

        Solution solution2 = new Solution("PPPPSSSPSSSPSSSP", "Woodman");
        assertEquals(Solution.getResult(), 12);

        Solution solution3 = new Solution("PPPPSSSPSSSPSSSP", "Swamper");
        assertEquals(Solution.getResult(), 12);

        Solution solution4 = new Solution("PWTTTPWTTTPWTTTP", "Human");
        assertEquals(Solution.getResult(), 9);

        Solution solution5 = new Solution("PWTTTPWTTTPWTTTP", "Woodman");
        assertEquals(Solution.getResult(), 12);

        Solution solution6 = new Solution("PPPPSSSPSSSPSSSP", "Swamper");
        assertEquals(Solution.getResult(), 12);
    }
}