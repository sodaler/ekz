using System;
using PreparingStateAiSDC_;

internal class Program
{
    private static void Main(string[] args)
    {
        int vertices = 5;

        GraphMatrix gm = new GraphMatrix(vertices);
        GraphLists gl = new GraphLists(vertices);

        Console.WriteLine("Матрица смежности графа:");
        InitializeGraphMatrix(gm, vertices);
        Console.WriteLine("\n-------------");
        Console.WriteLine("Список смежности графа:");
        InitializeGraphList(gl, vertices);
        Console.WriteLine("\n-------------");
    }

    static void InitializeGraphList(GraphLists graph, int vertices)
    {
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(1, 2);
        graph.AddEdge(1, 3);
        graph.AddEdge(2, 4);
        graph.PrintGraph();
        Console.WriteLine("\nОбход графа в глубину (начиная с вершины 0):");
        graph.DFS(0);
        Console.WriteLine("\nОбход графа в ширину (начиная с вершины 0):");
        graph.BFS(0);
    }

    static void InitializeGraphMatrix(GraphMatrix graph, int vertices)
    {
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(1, 2);
        graph.AddEdge(1, 3);
        graph.AddEdge(2, 4);
        graph.PrintGraph();
        Console.WriteLine("\nОбход графа в глубину (начиная с вершины 0):");
        graph.DFS(0);
        Console.WriteLine("\nОбход графа в ширину (начиная с вершины 0):");
        graph.BFS(0);

    }

}
