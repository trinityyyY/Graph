package Vertexes;

import java.util.ArrayList;
import java.util.List;

public class SubGraph implements Node {
    List<Node> vertices = new ArrayList<>();

    public void addVertex(Vertex vertex){
        vertices.add(vertex);
    }
    public void removeVertex(Vertex vertex){
        vertices.remove(vertex);
    }
    @Override
    public List<String> getEdges() {
        return null;
    }
}
