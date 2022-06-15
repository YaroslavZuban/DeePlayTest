package Yaroslav.Zuban.Deeplay.Test;

import java.io.File;
import java.util.*;

public class Solution {
    private FileHandling fileHandling;

    private List<String> nameCreatures = new ArrayList<>();
    private List<String> nameObstacles = new ArrayList<>();
    private List<Integer> movingCost = new ArrayList<>();

    private String fieldDescription;
    private String creature;
    private static int result = 0;

    private Map<String, Integer> characteristics;
    private List<Vertex> vertex = new ArrayList<>();

    private Character[][] matrix;
    private Integer[][] matrixNumber;

    public Solution(String fieldDescription, String creature,File file) throws Exception {
        if (fieldDescription.length() != 16) {
            throw new Exception("Error");
        }

        fileHandling = new ReadingFile(file);
        fileHandling.workingFile(nameCreatures, nameObstacles, movingCost);

        if (!nameCreatures.contains(creature)) {
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

        int index = nameCreatures.indexOf(creature);

        int start = index * nameObstacles.size();
        int finish = start + nameObstacles.size();

        for (int j = start, i = 0; j < finish && i < nameObstacles.size(); j++, i++) {
            String temp=String.valueOf(nameObstacles.get(i).toUpperCase(Locale.ROOT).charAt(0));
            Integer number=movingCost.get(j);

            characteristics.put(temp,number);
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
