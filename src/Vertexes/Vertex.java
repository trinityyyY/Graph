package Vertexes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Vertex implements Node{
    private String Name;
    private String Description;
    private HashMap<String, List<String>> vertexMap = new HashMap<String, List<String>>();

    public Vertex(String name, String description){
        this.Name = name;
        this.Description = description;
        this.vertexMap.put(this.Name, new ArrayList<String>());
    }

    public String getName(){
        return this.Name;
    }
    public HashMap getVertexMap(){
        return this.vertexMap;
    }
    public void setVertexMap(HashMap newHashMap){
        this.vertexMap = newHashMap;
    }

    @Override
    public void addEdge(Vertex vertex) {
        List<String> edges = this.vertexMap.get(this.Name);
        edges.add(vertex.getName());
        this.vertexMap.put(this.Name, edges);
        HashMap newVertexMap = vertex.getVertexMap();
        String vertexName = vertex.getName();
        edges = (List<String>) newVertexMap.get(vertexName);
        edges.add(this.Name);
        newVertexMap.put(vertex.getName(), edges);
        vertex.setVertexMap(newVertexMap);
    }

    @Override
    public void print() {
        System.out.println(this.vertexMap);
    }
}
