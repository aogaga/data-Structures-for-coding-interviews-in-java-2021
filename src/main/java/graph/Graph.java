package graph;


import dllist.DoublyLinkedList;
import dllist.Node;

public class Graph {

  int vertices;
  DoublyLinkedList<Integer>[] adjacencyList;

  public Graph(int vertices){
    this.vertices = vertices;
    adjacencyList = new DoublyLinkedList[this.vertices];

    for(int i  = 0; i < vertices; i++){
      adjacencyList[i]  = new DoublyLinkedList<>();
    }
  }
  void addEdge(int source, int destination){
    if(source < vertices && destination < vertices){
      this.adjacencyList[source].insertAtHead(destination);
    }

    //for undirected graph uncomment the line below
    //this.adjacencyList[destination].insertAtEnd(source);
  }

  public void printGraph(){

    System.out.println(">>Adjacency List of Directed Graph<<");

    for(int i = 0; i < vertices; i++){

      if(adjacencyList[i] != null){

        System.out.print("|" + i + "| => ");
        DoublyLinkedList<Integer> ll = adjacencyList[i];
        Node curentNode = ll.headNode;

        while (curentNode != null){
          System.out.print("[" + curentNode.data + "] -> ");
          curentNode = curentNode.nextNode;
        }

      }else{
        System.out.println("|" + i + "| => "+ "null");
      }


    }


  }
}
