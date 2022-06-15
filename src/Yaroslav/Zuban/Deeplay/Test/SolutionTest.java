package Yaroslav.Zuban.Deeplay.Test;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void getResult() throws Exception {
        Solution solution1 = new Solution("PPPPSSSPSSSPSSSP", "Human",new File("C:\\Users\\babka\\IdeaProjects\\DeePlayTest\\src\\out.txt"));
        assertEquals(Solution.getResult(), 6);

        Solution solution2 = new Solution("PPPPSSSPSSSPSSSP", "Woodman",new File("C:\\Users\\babka\\IdeaProjects\\DeePlayTest\\src\\out.txt"));
        assertEquals(Solution.getResult(), 12);

        Solution solution3 = new Solution("PPPPSSSPSSSPSSSP", "Swamper",new File("C:\\Users\\babka\\IdeaProjects\\DeePlayTest\\src\\out.txt"));
        assertEquals(Solution.getResult(), 12);

        Solution solution4 = new Solution("PWBBBPWBBBPWBBBP", "Human",new File("C:\\Users\\babka\\IdeaProjects\\DeePlayTest\\src\\out.txt"));
        assertEquals(Solution.getResult(), 9);

        Solution solution5 = new Solution("PWBBBPWBBBPWBBBP", "Woodman",new File("C:\\Users\\babka\\IdeaProjects\\DeePlayTest\\src\\out.txt"));
        assertEquals(Solution.getResult(), 12);

        Solution solution6 = new Solution("PPPPSSSPSSSPSSSP", "Swamper",new File("C:\\Users\\babka\\IdeaProjects\\DeePlayTest\\src\\out.txt"));
        assertEquals(Solution.getResult(), 12);
    }
}