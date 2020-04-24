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
        test.addEdge("3", "4");

        HashMap val = (HashMap) test.getVertexMap();
        test.printMatrix(val);
    }
}
