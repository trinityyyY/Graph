import Vertexes.Vertex;
import Vertexes.SubGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args){
        /*Graph test = new Graph();
        int a;
        Scanner in = new Scanner(System.in);


        System.out.println("Введите количество вершин: ");
        a = in.nextInt();
        for(int i = 1; i < a+1; i++){
            test.addVertex(Integer.toString(i));
        }

        System.out.println("Номера вершин для связи: ");

        for(int i = 0; i < 4; i++){
            System.out.println("Хотите продолжить?: 1-Yes  0-No ");
            int answer = in.nextInt();
            if(answer == 0){
                break;
            }
            System.out.println("Номера вершин для связи: ");
            test.addEdge(in.next(), in.next());
        }

        HashMap val = (HashMap) test.getVertexMap();
        test.printMatrix(val);
        System.out.println(val);*/

        Vertex a = new Vertex("abc", "asd");
        Vertex b = new Vertex("bcddf", "asdsdf");
        Vertex c = new Vertex("cbafdgf", "asdsdf");
        Vertex d = new Vertex("dba", "asdsdf");
        Vertex e = new Vertex("e", "asdsdf");
        a.addEdge(b);
        a.addEdge(c);
        a.addEdge(b);
        b.addEdge(a);
        //a.print();
        //b.print();

        SubGraph abc = new SubGraph();
        abc.addVertex(a);
        abc.addVertex(b);
        abc.addVertex(c);
        abc.print();
        //abc.addEdge(e);
        e.addEdge(b);
        e.addEdge(c);
        abc.addVertex(e);
        System.out.println(abc.getVertexList());
        abc.print();
        //e.print();
        System.out.println(abc.getVertexList());
        abc.printMatrix();
        //ArrayList<String> edges = (ArrayList<String>) e.getVertexMap().get(e.getName());
        //System.out.println(edges);

    }
}
