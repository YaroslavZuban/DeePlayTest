package Yaroslav.Zuban.Deeplay.Test;

import java.io.File;

public class Run {
    public static void main(String[] args) {
        Solution solution = null;

        try {
            solution = new Solution("SBWSWBPPBPBBPWPP", "Human",new File("C:\\Users\\babka\\IdeaProjects\\DeePlayTest\\src\\out.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Результат: " + Solution.getResult());
    }
}
