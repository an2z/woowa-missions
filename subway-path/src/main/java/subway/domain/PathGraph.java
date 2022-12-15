package subway.domain;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class PathGraph {
    private static final WeightedMultigraph<Station, DefaultWeightedEdge> graphOfDistance = new WeightedMultigraph(
            DefaultWeightedEdge.class);
    private static final WeightedMultigraph<Station, DefaultWeightedEdge> graphOfTime = new WeightedMultigraph(
            DefaultWeightedEdge.class);

    public static void addVertex(List<Station> stations) {
        for (Station station : stations) {
            graphOfDistance.addVertex(station);
            graphOfTime.addVertex(station);
        }
    }

    public static void setEdgeDistance(Station start, Station end, int distance) {
        graphOfDistance.setEdgeWeight(graphOfDistance.addEdge(start, end), distance);
    }

    public static void setEdgeTime(Station start, Station end, int time) {
        graphOfDistance.setEdgeWeight(graphOfDistance.addEdge(start, end), time);
    }

    public static List<Station> getPathOfDistance(Station start, Station end) {
        return new DijkstraShortestPath(graphOfDistance).getPath(start, end).getVertexList();
    }

    public static List<Station> getPathOfTime(Station start, Station end) {
        return new DijkstraShortestPath(graphOfTime).getPath(start, end).getVertexList();
    }
}
