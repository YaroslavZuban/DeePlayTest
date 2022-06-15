package Yaroslav.Zuban.Deeplay.Test;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
    public final Integer name;
    public List<Edge> adjacencies = new ArrayList<>();
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;

    public Vertex(Integer argName) {
        name = argName;
    }

    public String toString() {
        return name.toString();
    }

    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }
}
