import Vertexes.Vertex;
import Vertexes.SubGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Runner {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Vertex a = new Vertex("a", "что я такое?");
        Vertex b = new Vertex("b", "что я такое?");

        SubGraph abc = new SubGraph();
        abc.addEdge(a);
        abc.addEdge(b);
        abc.print();
        b.addEdge(a);
        abc.addEdge(b);


        //SubGraph subgraph = new SubGraph();
        Graph graph = new Graph();
        System.out.println("Выберите что хотите сдеелать.\n1.Создать граф\n4.Закончить работу ");
        switch(in.nextInt()){
            /*case(1):
                String name;
                String description;
                String answer;
                System.out.println("Создание первой вершины!");
                System.out.print("Введите имя вершины: ");
                name = in.next();
                System.out.print("Введите описание вершины: ");
                description = in.next();
                graph.addVertex(name, description);
                while(true){
                    System.out.println("Продолжить создавать вершины? ");
                    answer = in.next();
                    if(answer.equals("no")){
                        graph.printMatrix();
                        break;
                    }else{

                        System.out.println("Создание вершины:");
                        System.out.print("Введите имя вершины: ");
                        name = in.next();
                        System.out.print("Введите описание вершины: ");
                        description = in.next();

                        Vertex curVertex = new Vertex(name, description);
                        List<Vertex>vertexList = graph.getVertexList();
                        int size = vertexList.size();

                        for(int i = 0; i <size ; i++){
                            System.out.println("Имя вершины для связи: ");
                            String secName = in.next();
                            for(Vertex vertex:vertexList){
                                if(secName == vertex.getName()){
                                    curVertex.addEdge(vertex);
                                }
                            }
                            System.out.println("Продолжить?");
                            if(in.next() == "no"){break;}
                        }
                        graph.addToSubGraph(curVertex);
                    }
                }
                System.out.println();
                break;*/
            case(4):
                System.out.println("Конец работы");
                break;

            case(3):
                //для заполнения созданных вершин
                String name;
                String description;
                int answer;
                //создаем первую вершину графа
                System.out.println("Создание первой вершины!");
                System.out.print("Введите имя вершины и через пробел описание ");
                name = in.next();
                description = in.nextLine();
                //System.out.println(description);
                graph.addVertex(name, description);

                System.out.println("Продолжить создавать вершины? 1-yes 2-no");
                answer = in.nextInt();
                if(answer == 2)
                    break;
                while(true){
                    System.out.print("Введите имя вершины и через пробел описание ");
                    name = in.next();
                    description = in.nextLine();

                    Vertex curVertex = new Vertex(name, description);
                    List<Vertex>vertexList = graph.getVertexList();
                    int size = vertexList.size();

                    List<String> connectNames = new ArrayList<>();
                    System.out.print("Введите имена вершин для связи через пробел ");
                    System.out.print("Доступно связей " + size + " ");
                    System.out.print("Сколько нужно связей? ");
                    size = in.nextInt();
                    for(int i = 0; i < size; i++){
                        String some = in.next();
                        connectNames.add(some);
                    }
                    graph.addToSubGraph(curVertex, connectNames);
                    System.out.println("Продолжить? 1-yes 2-no");
                    answer = in.nextInt();
                    if(answer == 2){break;}
                }
                graph.printMatrix();
                break;
        }

        System.out.println("Что дальше. 1-перейти на вершину. 2-выход ");
        switch(in.nextInt()){
            case(1):
                String name;
                while (true){
                    System.out.println("Введите имя вершины ");
                    name = in.next();
                    graph.getDescription(name);
                    System.out.println("Продолжить? 1-yes 2-no");
                    if(in.nextInt()==2){break;}
                }
                break;
            }
    }
}
