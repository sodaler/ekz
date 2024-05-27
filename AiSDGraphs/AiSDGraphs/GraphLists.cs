using System;
using System.Collections.Generic;

class GraphLists
{
    private int numVertices;               
    private List<int>[] adjLists;          

    public GraphLists(int vertices)
    {
        numVertices = vertices;
        adjLists = new List<int>[vertices];
        for (int i = 0; i < vertices; i++)
        {
            adjLists[i] = new List<int>();
        }
    }

    public void AddEdge(int start, int end)
    {
        adjLists[start].Add(end);
        adjLists[end].Add(start);
    }

    public void DFS(int startVertex)
    {
        bool[] visited = new bool[numVertices];
        DFSUtil(startVertex, visited);
    }

    private void DFSUtil(int vertex, bool[] visited)
    {
        visited[vertex] = true;
        Console.Write(vertex + " ");

        foreach (int neighbor in adjLists[vertex])
        {
            if (!visited[neighbor])
            {
                DFSUtil(neighbor, visited);
            }
        }
    }

    public void BFS(int startVertex)
    {
        bool[] visited = new bool[numVertices];
        Queue<int> queue = new Queue<int>();

        visited[startVertex] = true;
        queue.Enqueue(startVertex);

        while (queue.Count != 0)
        {
            int vertex = queue.Dequeue();
            Console.Write(vertex + " ");

            foreach (int neighbor in adjLists[vertex])
            {
                if (!visited[neighbor])
                {
                    visited[neighbor] = true;
                    queue.Enqueue(neighbor);
                }
            }
        }
    }

    public void PrintGraph()
    {
        for (int i = 0; i < numVertices; i++)
        {
            Console.Write("Vertex " + i + ":");
            foreach (int neighbor in adjLists[i])
            {
                Console.Write(" " + neighbor);
            }
            Console.WriteLine();
        }
    }
}
