import Vertexes.SubGraph;
import Vertexes.Vertex;

import java.util.List;
import java.util.ArrayList;

public class Graph {
    //список всех созданных вершин
    private List<Vertex> vertexList = new ArrayList<>();
    //внутренняя организация графа
    private SubGraph subgraph = new SubGraph();

    //добавляем вершины и храним их
    public void addVertex(String name, String description){
        Vertex vertex = new Vertex(name, description);
        vertexList.add(vertex);
        subgraph.addVertex(vertex);
    }

    //добавляем в граф вершины
    public void addToSubGraph(Vertex vertex, List<String> connectNames){
        //создаем связи с уже имеющимися вершинами
        for(Vertex vertex1:vertexList){
            for(int i = 0; i < connectNames.size(); i++){
                if(connectNames.get(i).equals(vertex1.getName())){
                    vertex.addEdge(vertex1);
                }
            }
        }
        //добвляем новую вершину со связями в граф и список вершин
        subgraph.addEdge(vertex);
        vertexList.add(vertex);
    }

    public void printMatrix(){
        subgraph.printMatrix();
        subgraph.print();
    }

    //печатаеет описание вершины по ее имени
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