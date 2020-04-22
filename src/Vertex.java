public class Vertex {

    public char name; // Имя вершины
    public boolean IsVisited; // Переменная для расознования была ли посещена вершина или нет
    public static int counter;
    //Инициализация
    public Vertex(char name){
        this.name = name;
        IsVisited = false;
        counter++;
    }

    public char getName() {
     return this.name;
    }
    public int getcounter() {
        return this.counter;
    }
}
