package DataStructures;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private int V;
    private LinkedList<Integer> graph[];


    public Graph(int v) {
        V = v;
        graph = new LinkedList[V];


        for (int i = 0; i < V; i++) {
            graph[i] = new LinkedList<>();
        }
    }

    List<Integer> dfsIterative(int v) {
        List<Integer> result = new ArrayList<>();

        boolean[] visited = new boolean[V];

        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while (!stack.isEmpty()) {
            v = stack.pop();

            if (!visited[v]) {
                result.add(v);
                visited[v] = true;
            }
            LinkedList<Integer> neighbours = graph[v];

            for (int i = 0; i < neighbours.size(); i++) {
                v = neighbours.get(i);

                if (!visited[v]) {
                    stack.push(v);
                }
            }
        }

        return result;
    }


    List<Integer> dfsRecursive(int v) {
        boolean[] visited = new boolean[V];
        List<Integer> result = new ArrayList<>();
        return dfsRecursiveHelper(v, visited, result);
    }

    List<Integer> dfsRecursiveHelper(int v, boolean visited[], List<Integer> result) {
        visited[v] = true;
        result.add(v);
        int a = 0;

        for (int i = 0; i < graph[v].size(); i++) {
            a = graph[v].get(i);
            if (!visited[a]) {
                dfsRecursiveHelper(a, visited, result);
            }
        }

        return result;
    }


    List<Integer> bfsIterative(int v) {
        List<Integer> result = new ArrayList<>();

        boolean[] visited = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);


        while (!queue.isEmpty()) {
            v = queue.poll();

            if (!visited[v]) {
                result.add(v);
                visited[v] = true;
            }
            LinkedList<Integer> neighbours = graph[v];

            for (int i = 0; i < neighbours.size(); i++) {
                v = neighbours.get(i);

                if (!visited[v]) {
                    queue.add(v);
                }
            }
        }

        return result;
    }


    void addEdge(int v1, int v2) {
        graph[v1].add(v2);
    }

    public static void main(String[] args) {
        Graph graph1 = new Graph(5);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(0, 3);
        graph1.addEdge(1, 0);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 0);
        graph1.addEdge(2, 1);
        graph1.addEdge(2, 4);
        graph1.addEdge(3, 0);
        graph1.addEdge(4, 2);


        System.out.println(graph1.bfsIterative(0));
    }

}
