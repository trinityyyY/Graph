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
        //вершина создается с пустым списком связей
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

    //Метод создает связь между двумя вершинами(добавляет их имена в списки связей друг друга)
    @Override
    public void addEdge(Vertex vertex) {
        //Берем список связей для текущей вершины
        List<String> edgeList = this.vertexMap.get(this.Name);
        //проверка на существование такой связи
        if(edgeList.contains(vertex.getName())){
            return;
        }
        //добавляем в список связей имя новой вершины
        edgeList.add(vertex.getName());
        //записываем обновленный список в хэшмапу для вершины
        this.vertexMap.put(this.Name, edgeList);
        //Аналогично для второй вершины(только перезаписываем ее хэшмап целиком)
        HashMap newVertexMap = vertex.getVertexMap();
        String vertexName = vertex.getName();
        edgeList = (List<String>) newVertexMap.get(vertexName);
        edgeList.add(this.Name);
        newVertexMap.put(vertex.getName(), edgeList);
        vertex.setVertexMap(newVertexMap);
    }

    //вывод хэшмапы вершины
    @Override
    public void print() {
        System.out.println(this.vertexMap);
    }
}
