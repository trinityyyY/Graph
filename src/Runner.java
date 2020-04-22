import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Runner {
    public static void main(String[] args){
        Graph test = new Graph();
        test.addVertex("1");
        test.addVertex("2");
        test.addVertex("3");
        test.addVertex("4");
        test.addEdge("1", "2");
        test.addEdge("2", "3");
        test.addEdge("1", "3");
        test.addEdge("1", "4");

        HashMap val = (HashMap) test.getVertexMap();
        int[][] smezn = new int[4][4];

        //System.out.print();
        int a;
        for(int i = 0; i < 4; i++){
            List<String> index = (List<String>) val.get(Integer.toString(i+1));
            System.out.println(index.size());
            for(int j = 0; j < index.size(); j++){
                a =Integer.parseInt(index.get(j));
                smezn[i][a-1] = 1;
            }
        }

        System.out.println(test.getVertexMap());
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                System.out.print(smezn[i][j]);
            }
            System.out.print("\n");
        }
    }
}
