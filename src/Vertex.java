public class Vertex {
    public char name; // Имя вершины
    public boolean IsVisited; // Переменная для расознования была ли посещена вершина или нет

    //Инициализация
    public Vertex(char name){
        this.name = name;
        IsVisited = false;
    }
}
