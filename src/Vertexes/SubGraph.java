package Vertexes;

import java.util.*;

public class SubGraph implements Node {
    private HashMap<String, List<String>> vertexMap = new HashMap<String, List<String>>();
    private List<Vertex> vertexList = new ArrayList<>();

    public void addVertex(Vertex vertex){
        //добавляем вершину в список вершин и дописываем ее хэшмапу в общую хэшмапу(vertexMap)
        this.vertexList.add(vertex);
        this.vertexMap.putAll(vertex.getVertexMap());
    }

    //пользователь переедает методу вершину которая уже имеет связи и метод
    //дописывает эти связи к hashmap-ам вершин и добавляет новую вершину
    @Override
    public void addEdge(Vertex vertex) {
        ArrayList<String> edgeList = (ArrayList<String>) vertex.getVertexMap().get(vertex.getName());  //получаем список всех связей для вершины которую надо добавить в граф
        int size = edgeList.size();                                                                    //вершина уже связана с чем то методом addEdge у vertex
        Vertex var;                                                                                    //нужно будет запомнить вершину для которой будем дописывать связь
        for(int i = 0; i < size; i++){                                                                 //Двигаемся по массиву вершин связанных с переданной vertex
            for(Vertex vertex1:vertexList){                                                            //Перебираем те вершины которые экземпляр SubGraph уже хранит в себе
                if(vertex1.getName() == edgeList.get(i)){                                              //Когда находим совпадения по именам вершин в графе и связях переданной вершины
                    var = vertex1;                                                                     //вызываем для двух вершин меетод addEdge дописывая их связи в hashmap
                    var.addEdge(vertex);
                    //После обновления всех хэшмап записываем изменения
                    this.vertexMap.putAll(var.getVertexMap());
                }
            }
        }
        //новую вершину добавляем в список вершин для текущего графа
        this.vertexList.add(vertex);
        this.vertexMap.put(vertex.getName(), edgeList);
    }

    //Печатает хэшмапу для графа
    @Override
    public void print() {
        System.out.println(this.vertexMap);
    }

    public List<Vertex> getVertexList() {
        return vertexList;
    }

    //Вывод матриц смежности и инцидеентности
    public void printMatrix(){
        //МАТРИЦА СМЕЖНОСТИ
        int edgesCount = 0;
        int vertexCount = vertexList.size();
        int[][] adjMatrix = new int[vertexCount][vertexCount];
        for(int i = 0; i < vertexCount; i++){
            String curName = vertexList.get(i).getName();
            for(int j = i+1; j<vertexCount; j++){
                String nextName = vertexList.get(j).getName();
                HashMap curMap = vertexList.get(j).getVertexMap();
                List<String> curEdges = (List<String>) curMap.get(nextName);
                if(curEdges.contains(curName)){
                    edgesCount++;
                    adjMatrix[i][j] = 1;
                    adjMatrix[j][i] = 1;
                }
            }
        }

        //ВЫВОД
        System.out.print("МАТРИЦА СМЕЖНОСТИ");
        System.out.print("\n");

        //Для красивого вывода с учетом длин имен веершин
        String nameVal = vertexList.get(0).getName();
        int maxSize = nameVal.length();
        for (int i = 1; i < vertexCount; i++){
            int size = vertexList.get(i).getName().length();
            if (size > maxSize ){
                maxSize = size;
            }
        }
        for (int i = 0; i < vertexCount; i++){
            if (i == 0){
                String namePost = vertexList.get(i).getName();
                int size = namePost.length();
                System.out.print(" ");

                for (int j = 0; j < maxSize; j++){
                    System.out.print(" ");
                }
            }
            String namePost = vertexList.get(i).getName();
            System.out.print(namePost + " ");
        }

        System.out.print("\n");


        for (int i = 0; i < vertexCount; i++){
            String nameString = vertexList.get(i).getName();
            System.out.print(nameString + ' ');
            String namePost = vertexList.get(i).getName();
            int size = namePost.length();
            String namePost1 = vertexList.get(0).getName();
            int size1 = namePost1.length();

            for (int m = 0; m < maxSize - size; m ++){
                System.out.print(" ");
            }

            for (int n = 0; n < size1/2; n++){
                System.out.print(" ");
            }
            for (int j = 0; j < vertexCount; j++){
                System.out.print(adjMatrix[i][j] );
                String name2 = vertexList.get(j).getName();
                int size3 = name2.length();

                for (int n = 0; n < size3/2; n++){
                    System.out.print(" ");
                }

                System.out.print(" ");

                if (j != vertexCount - 1) {
                    String name1 = vertexList.get(j + 1).getName();
                    int size2 = name1.length();
                    for (int n = 0; n < size2/2; n++){
                        System.out.print(" ");
                    }
                }
            }
            System.out.print("\n");
        }

        System.out.print("\n");
        System.out.print("МАТРИЦА ИНЦИДЕНТНОСТИ");
        System.out.print("\n");

        //МАТРИЦА ИНЦИДЕНТНОСТИ
        int[][] incMatrix = new int[vertexCount][edgesCount];
        int l, k = -1;
        for(int i = 0; i< edgesCount; i++){
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
            String nameString = vertexList.get(i).getName();
            System.out.print(nameString + ' ');
            String namePost = vertexList.get(i).getName();
            int size = namePost.length();
            String namePost1 = vertexList.get(0).getName();
            int size1 = namePost1.length();
            for (int m = 0; m < maxSize - size; m ++){
                System.out.print(" ");
            }
            for (int n = 0; n < size1/2; n++){
                System.out.print(" ");
            }
            for (int j = 0; j < vertexCount; j++){
                System.out.print(incMatrix[i][j] );
            }
            System.out.print("\n");
        }
    }
}
