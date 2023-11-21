package subway.domain;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class PathGraph {
    private static final WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(
            DefaultWeightedEdge.class);
    private static final WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(
            DefaultWeightedEdge.class);

    public static void addVertex(List<Station> stations) {
        for (Station station : stations) {
            distanceGraph.addVertex(station);
            timeGraph.addVertex(station);
        }
    }

    public static void setEdgeDistance(Station start, Station end, int distance) {
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(start, end), distance);
    }

    public static void setEdgeTime(Station start, Station end, int time) {
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(start, end), time);
    }

    public static List<Station> getPathOfDistance(Station start, Station end) {
        return new DijkstraShortestPath(distanceGraph).getPath(start, end).getVertexList();
    }

    public static List<Station> getPathOfTime(Station start, Station end) {
        return new DijkstraShortestPath(timeGraph).getPath(start, end).getVertexList();
    }
}
