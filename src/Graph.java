import Vertexes.SubGraph;
import Vertexes.Vertex;

import java.util.Map;
import java.util.List;
import java.util.HashMap;       //чтобы хранить вершины и их связи
import java.util.ArrayList;
import java.util.Collections;   //для работы с списками вершин

public class Graph {
    //список всех созданных вершин
    private List<Vertex> vertexList = new ArrayList<>();
    private SubGraph subgraph = new SubGraph();

    public void addVertex(String name, String description){
        Vertex vertex = new Vertex(name, description);
        vertexList.add(vertex);
        subgraph.addVertex(vertex);
    }

    public void createSubGraph(Vertex vertex){
        //subgraph = new SubGraph();
        subgraph.addVertex(vertex);
    }
    public void addToSubGraph(Vertex vertex, List<String> connectNames){
        for(Vertex vertex1:vertexList){
            for(int i = 0; i < connectNames.size(); i++){
                if(connectNames.get(i).equals(vertex1.getName())){
                    vertex.addEdge(vertex1);
                }
            }
        }
        subgraph.addEdge(vertex);
        vertexList.add(vertex);
    }
    public void printMatrix(){
        System.out.println("МАТРИЦА");
        subgraph.printMatrix();
        subgraph.print();
    }
    public void getDescription(String name){
        for(Vertex vertex:vertexList){
            if(vertex.getName().equals(name)){
                System.out.println(vertex.getDescription());
            }
        }
    }
    public List<Vertex> getVertexList() {
        return vertexList;
    }
}