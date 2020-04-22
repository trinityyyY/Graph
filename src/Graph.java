import java.util.Map;
import java.util.List;
import java.util.HashMap;       //чтобы хранить вершины и их связи
import java.util.ArrayList;
import java.util.Collections;   //для работы с списками вершин

public class Graph {


    private HashMap<String, List<String>> vertexMap = new HashMap<String, List<String>>();

    public void addVertex(String vertexName) {
        if (!hasVertex(vertexName)) {
            vertexMap.put(vertexName, new ArrayList<String>());
        }
    }

    public boolean hasVertex(String vertexName) {
        return vertexMap.containsKey(vertexName); //проверяем содержится ли узел с именем
                                                  //vertexname в массиве узлов(contains)
    }

    public boolean hasEdge(String vertexName1, String vertexName2) {
        if (!hasVertex(vertexName1)) return false;
        List<String> edges = vertexMap.get(vertexName1);

        //если нет вершины то binarySearch вернет отрицательное значениее
        return Collections.binarySearch(edges, vertexName2) > -1;
    }

    public void addEdge(String vertexName1, String vertexName2) {
        if (!hasVertex(vertexName1)) addVertex(vertexName1);
        if (!hasVertex(vertexName2)) addVertex(vertexName2);
        List<String> edges1 = vertexMap.get(vertexName1);
        List<String> edges2 = vertexMap.get(vertexName2);
        edges1.add(vertexName2);
        edges2.add(vertexName1);
        //сортировка для удобства вывода
        Collections.sort(edges1);
        Collections.sort(edges2);
    }

    public Map<String, List<String>> getVertexMap() {
        return vertexMap;
    }
}