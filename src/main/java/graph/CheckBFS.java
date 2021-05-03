package graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheckBFS {

  public String bfs(Graph g){
    StringBuilder result = new StringBuilder();

    if(g.vertices < 1){
      return result.toString();
    }
    boolean[] visited = new boolean[g.vertices];

    for(int i = 0; i < g.vertices; i++){
      if(!visited[i]){
         result.append(bfsVisit(g, i, visited));
      }
    }

    return result.toString();
  }

  private String bfsVisit(Graph g, int source, boolean[] visited) {
    StringBuilder result = new StringBuilder();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);
    visited[source] = true;

    while (!queue.isEmpty()){
      int current_node = queue.remove();
      result.append(current_node);
    }

    return  result.toString();
  }

}
