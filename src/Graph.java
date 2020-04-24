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

    public void printMatrix(HashMap graph){
        int a;
        int edges = 0;
        int vertexCount = graph.size();

        //МАТРИЦА СМЕЖНОСТИ
        int[][] adjMatrix = new int[vertexCount][vertexCount];
        for(int i = 0; i < vertexCount; i++){
            List<String> index = (List<String>) graph.get(Integer.toString(i+1));
            System.out.println(index.size());
            for(int j = 0; j < index.size(); j++){
                a =Integer.parseInt(index.get(j));
                adjMatrix[i][a-1] = 1;
                edges++;
            }
        }
        //ВЫВОД
        for (int i = 0; i < vertexCount; i++){
            for (int j = 0; j < vertexCount; j++){
                System.out.print(adjMatrix[i][j]);
            }
            System.out.print("\n");
        }

        //МАТРИЦА ИНЦИДЕНТНОСТИ
        System.out.print("\n");
        edges = edges/2;

        int[][] incMatrix = new int[vertexCount][edges];
        int l, k = -1;
        for(int i = 0; i< edges; i++){
            int t = -1;
            for(int j = i; j < vertexCount; j++){
                if (adjMatrix[i][j]==1){
                    t=j;
                    k++;
                    for(l = 0; l<vertexCount; l++){
                        if(l==t){
                            incMatrix[l][k] = 1;
                        }else{
                            incMatrix[l][k] = 0;
                        }
                        if(l==i)
                            incMatrix[l][k] = 1;
                    }
                    t=-1;
                }
            }
        }
        //ВЫВОД
        for (int i = 0; i < vertexCount; i++){
            for (int j = 0; j < edges; j++){
                System.out.print(incMatrix[i][j]);
            }
            System.out.print("\n");
        }
    }

}