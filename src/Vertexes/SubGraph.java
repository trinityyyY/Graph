package Vertexes;

import java.util.*;

public class SubGraph implements Node {
    private HashMap<String, List<String>> vertexMap = new HashMap<String, List<String>>();
    List<Vertex> vertexList = new ArrayList<>();

    public void addVertex(Vertex vertex){
        //HashMap newHashMap = vertex.getVertexMap();
        this.vertexList.add(vertex);
        this.vertexMap.putAll(vertex.getVertexMap());
    }

    @Override
    public void addEdge(Vertex vertex) {
        ArrayList<String> edges = (ArrayList<String>) vertex.getVertexMap().get(vertex.getName()); //получаем список всех связей для вершины которую надо добавить в граф
        int size = edges.size();                                                                                 //вершина уже связана с чем то методом addEdge у vertex
        Vertex sec;
        for(int i = 0; i < size; i++){
            System.out.println(size);
            for(Vertex vertex1:vertexList){
                if(vertex1.getName() == edges.get(i)){
                    sec = vertex1;
                    sec.addEdge(vertex);
                    //После обновления всех хэшмап записываем изменения
                    this.vertexMap.putAll(sec.getVertexMap());
                }
            }
        }
        this.vertexList.add(vertex);
    }

    @Override
    public void print() {
        System.out.println(this.vertexMap);
    }
}
