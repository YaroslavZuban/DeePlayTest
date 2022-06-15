package Yaroslav.Zuban.Deeplay.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    public static void computePaths(List<Vertex> array, Vertex source) {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            u.adjacencies = array.get(u.name - 1).adjacencies;

            // Visit each edge exiting u
            for (Edge e : u.adjacencies) {
                Vertex v = e.target;
                v = array.get(v.name - 1);

                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {

                    vertexQueue.remove(v);

                    v.minDistance = distanceThroughU;
                    v.previous = u;

                    vertexQueue.add(v);

                }
            }
        }
    }
}
