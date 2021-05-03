package dllist;

import dllist.Node;

public class DoublyLinkedList<T> {

  //Node inner class for DLL
    public Node headNode;
    public int size;

    public DoublyLinkedList(){
      headNode = null;
    }

    public boolean isEmpty(){
      if(headNode == null){
        return true;
      }
      return false;
    }

    public void insertAtHead(T data){
      Node newNode = new Node<T>();
      newNode.data = data;
      newNode.nextNode = headNode;
      newNode.prevNode = null;

      if(headNode != null){
        headNode.prevNode = newNode;

      }
      headNode = newNode;
      size++;
    }

    public void printList(){
      if(isEmpty()){
        System.out.println("the list is empty");
      }

      Node currentNode = headNode;
      System.out.println("printing doubly linked lis");

      while(currentNode != null){
        System.out.print(currentNode.data.toString() + " <-> ");
        currentNode = currentNode.nextNode;
      }

    }

    public void deleteAtHead(){
      if(isEmpty()){
        return;
      }

      headNode = headNode.nextNode;
      headNode.prevNode = null;
      size--;
    }

    public void deleteByValue(T data){
        if(isEmpty()){
          return;
        }

        Node currentNode = headNode;
        if(currentNode.data  == data){
          deleteAtHead();
        }

        while (currentNode != null){
          if(currentNode.data == data){
            Node prv = currentNode.prevNode;
            Node next = currentNode.nextNode;

            prv.nextNode = next;
            next.prevNode = prv;
            size--;
            return;
          }

          currentNode = currentNode.nextNode;
        }
    }
}