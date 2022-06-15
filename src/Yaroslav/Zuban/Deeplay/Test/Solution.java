package Yaroslav.Zuban.Deeplay.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private String fieldDescription;
    private String creature;
    private static int result = 0;

    private Map<String, Integer> characteristics;
    private List<Vertex> vertex = new ArrayList<>();

    private Character[][] matrix;
    private Integer[][] matrixNumber;

    public Solution(String fieldDescription, String creature) throws Exception {
        if (fieldDescription.length() != 16) {
            throw new Exception("Error");
        }

        if (creature.compareTo("Human") != 0 && creature.compareTo("Woodman") != 0 && creature.compareTo("Swamper") != 0) {
            throw new Exception("Error");
        }

        this.fieldDescription = fieldDescription;
        this.creature = creature;

        creatureDefinition();
        matrixFilling();

        Dijkstra.computePaths(vertex, vertex.get(0));
        this.result = (int) vertex.get(vertex.size() - 1).minDistance;

    }

    public static int getResult() {
        return result;
    }

    private void matrixFilling() {
        this.matrix = new Character[4][4];
        this.matrixNumber = new Integer[4][4];

        int count = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.matrix[i][j] = fieldDescription.charAt(count - 1);
                this.matrixNumber[i][j] = characteristics.get(matrix[i][j].toString());

                this.vertex.add(new Vertex(count));
                count++;
            }
        }

        count = 1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                List<Edge> array = new ArrayList<>();
                addVertices(array, i, j, 4, count);

                this.vertex.get(count - 1).adjacencies = new ArrayList<>(array);
                count++;
            }
        }
    }

    private void creatureDefinition() {
        characteristics = new HashMap<>();

        if (this.creature.compareTo("Human") == 0) {
            characteristics.put("S", 5);
            characteristics.put("W", 2);
            characteristics.put("T", 3);
            characteristics.put("P", 1);
        } else if (this.creature.compareTo("Swamper") == 0) {
            characteristics.put("S", 2);
            characteristics.put("W", 2);
            characteristics.put("T", 5);
            characteristics.put("P", 2);
        } else if (this.creature.compareTo("Woodman") == 0) {
            characteristics.put("S", 3);
            characteristics.put("W", 3);
            characteristics.put("T", 2);
            characteristics.put("P", 2);
        }
    }


    private void addVertices(List<Edge> array, int line, int column, int length, int point) {
        if (line - 1 >= 0 && point - 4 >= 0) {
            array.add(new Edge(new Vertex(point - 4), this.matrixNumber[line - 1][column]));
        }

        if (line + 1 < length && point + 4 <= 16) {
            array.add(new Edge(new Vertex(point + 4), this.matrixNumber[line + 1][column]));

        }

        if (column - 1 >= 0 && point - 1 >= 0) {
            array.add(new Edge(new Vertex(point - 1), this.matrixNumber[line][column - 1]));
        }

        if (column + 1 < length && point + 1 <= 16) {
            array.add(new Edge(new Vertex(point + 1), this.matrixNumber[line][column + 1]));
        }
    }

}
