import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args){
        Graph test = new Graph();
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
        System.out.println(val);
    }
}
