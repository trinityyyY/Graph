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
    public String getDescription(){ return this.Description; }
    public void setDescription(String Description){ this.Description = Description; }

    @Override
    public void addEdge(Vertex vertex) {
        List<String> edgeList = this.vertexMap.get(this.Name);
        //проверка на существование такой связи
        if(edgeList.contains(vertex.getName())){
            return;
        }
        edgeList.add(vertex.getName());
        this.vertexMap.put(this.Name, edgeList);
        HashMap newVertexMap = vertex.getVertexMap();
        String vertexName = vertex.getName();
        edgeList = (List<String>) newVertexMap.get(vertexName);
        edgeList.add(this.Name);
        newVertexMap.put(vertex.getName(), edgeList);
        vertex.setVertexMap(newVertexMap);
    }

    @Override
    public void print() {
        System.out.println(this.vertexMap);
    }
}
