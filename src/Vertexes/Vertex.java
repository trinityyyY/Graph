package Vertexes;

import java.util.List;

public class Vertex<name> implements Node{

    private String name; // Имя вершины
    private String Description;
    private List<String> Edges;
    @Override
    public List<String> getEdges() {
        return Edges;
    }

    public void addEdge(String vertexName){
        Edges.add(vertexName);
    }
}
