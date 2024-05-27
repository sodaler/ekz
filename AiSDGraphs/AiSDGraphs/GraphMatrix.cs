using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PreparingStateAiSDC_
{
    class GraphMatrix
    {
        private int numVertices;               
        private int[,] adjMatrix;             

        public GraphMatrix(int vertices)
        {
            numVertices = vertices;
            adjMatrix = new int[vertices, vertices];
        }

        public void AddEdge(int start, int end)
        {
            adjMatrix[start, end] = 1;
            adjMatrix[end, start] = 1; 
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

            for (int i = 0; i < numVertices; i++)
            {
                if (adjMatrix[vertex, i] == 1 && !visited[i])
                {
                    DFSUtil(i, visited);
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

                for (int i = 0; i < numVertices; i++)
                {
                    if (adjMatrix[vertex, i] == 1 && !visited[i])
                    {
                        visited[i] = true;
                        queue.Enqueue(i);
                    }
                }
            }
        }

        public void PrintGraph()
        {
            for (int i = 0; i < numVertices; i++)
            {
                for (int j = 0; j < numVertices; j++)
                {
                    Console.Write(adjMatrix[i, j] + " ");
                }
                Console.WriteLine();
            }
        }
    }

}
