public class Graph {
    private int maxN = 10; // максимальное количество вершин в графе
    private int[][] mas; // матрица смежности (есть ли путь между вершинами)
    Vertex[] vertexList; // список вершин
    private int curN; // текущее  количество вершин
    private Stack stack = new Stack();// для занесения в стэк

    //Конструктор
    public Graph(){
        vertexList = new Vertex[maxN];
        mas = new int[maxN][maxN];
        curN = 0;
    }

    //Добавление вершины
    public  void addVertex(char name){
        vertexList[curN++] = new Vertex(name);
    }

    //Создание рёбер
    //Val для инициализации матрицы смежности ( я не понял до конца ее смысл, если думаете, что не надо, убирайте)
    public void addEdge(int start, int end, int val){
        mas[start][end] = 1;
        mas[end][start] = val;
    }

    //Функция, которая возвращает непосещенную вершину
    public int check(int v){
        for (int i = 0; i < curN; i++) {
            if (mas[v][i] == 1 && vertexList[i].IsVisited == false){
                return i;
            }
        }

        return -1;
    }

    //Обход в глубину
    public void passInDeep(int index){
        System.out.println(vertexList[index].name);
        vertexList[index].IsVisited = true; //отмечаем вершину как посещенную
        stack.push(index); // заносим в стек

        while (!stack.isEmpty()){
            int neigh = check(stack.peek());

            if (neigh == -1){
                neigh = stack.pop();
            }
            else{
                System.out.println(vertexList[neigh].name);
                vertexList[neigh].IsVisited = true;
                stack.push(neigh);
            }
        }

        //Приводим все к начальному состоянию
        for (int i = 0; i < curN; i++) {
            vertexList[i].IsVisited = false;
        }
    }
}
