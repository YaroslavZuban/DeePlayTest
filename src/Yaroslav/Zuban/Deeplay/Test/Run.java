package Yaroslav.Zuban.Deeplay.Test;

public class Run {
    public static void main(String[] args) {
        Solution solution = null;

        try {
            solution = new Solution("STWSWTPPTPTTPWPP", "Human");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Результат: " + Solution.getResult());
    }
}
