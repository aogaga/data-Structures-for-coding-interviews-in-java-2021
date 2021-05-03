package tree;

public class BinaryTree {
  private Node root;

  public boolean add(int value){

    if(isEmpty()){
      Node node = new Node(value);
      setRoot(node);
      return true;
    }

    Node currentNode = root;
    while(currentNode != null){
      Node leftChild = currentNode.getLeftChild();
      Node rightChild = currentNode.getRightChild();

      if(currentNode.getData() > value ){
          if(leftChild == null){
            leftChild = new Node(value);
            currentNode.setLeftChild(leftChild);
            return true;
          }
          currentNode = leftChild;
      }else{
        if(rightChild == null){
          rightChild = new Node(value);
          currentNode.setRightChild(rightChild);
          return true;
        }
        currentNode = rightChild;
      }
    }

    return false;
  }
  public Node insertNode(int value){
    return null;
  }


  public Node getRoot() {
    return root;
  }

  public void setRoot(Node root) {
    this.root = root;
  }

  public boolean isEmpty(){
    return (this.root == null);
  }

  public void print(Node currentNode){
    if(currentNode == null){
      return;
    }
    System.out.println(currentNode);
    print(currentNode.getLeftChild());
    print(currentNode.getRightChild());

  }

  public Node search(int value){
    Node currentNode = root;

    while(currentNode != null){
      if(currentNode.getData() == value){
        return currentNode;
      }

      if(currentNode.getData() < value){
        currentNode = currentNode.getLeftChild();
      }else {
        currentNode.getRightChild();
      }
    }
    System.out.println(value + " Not found in the Tree!");
    return null;
  }

  //3.node has 2 children.
  boolean delete(int value, Node currentNode) {

    if (root == null) {
      return false;
    }

    Node parent = null; //To Store parent of currentNode
    while(currentNode != null && (currentNode.getData() != value)) {
      parent = currentNode;
      if (currentNode.getData() > value)
        currentNode = currentNode.getLeftChild();
      else
        currentNode = currentNode.getRightChild();

    }

    if(currentNode == null) {
      return false;
    }
    else if(currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
      //1. tree.Node is Leaf tree.Node
      //if that leaf node is the root (a tree with just root)
      if(root.getData() == currentNode.getData()){
        setRoot(null);
        return true;
      }
      else if(currentNode.getData() < parent.getData()){
        parent.setLeftChild(null);
        return true;
      }
      else{
        parent.setRightChild(null);
        return true;
      }
    } else if(currentNode.getRightChild() == null) {

      if(root.getData() == currentNode.getData()){
        setRoot(currentNode.getLeftChild());
        return true;
      }
      else if(currentNode.getData() < parent.getData()){
        parent.setLeftChild(currentNode.getLeftChild());
        return true;
      }
      else{

        parent.setRightChild(currentNode.getLeftChild());
        return true;
      }

    }
    else if(currentNode.getLeftChild() == null) {

      if(root.getData() == currentNode.getData()){
        setRoot(currentNode.getRightChild());
        return true;
      }
      else if(currentNode.getData() < parent.getData()){
        parent.setLeftChild(currentNode.getRightChild());
        return true;
      }
      else{
        parent.setRightChild(currentNode.getRightChild());
        return true;
      }

    }
    else {
      //Find Least Value tree.Node in right-subtree of current tree.Node
      Node leastNode = findLeastNode(currentNode.getRightChild());
      //Set CurrentNode's Data to the least value in its right-subtree
      int temp = leastNode.getData();
      delete(temp, root);
      currentNode.setData(temp);
      //Delete the leafNode which had the least value
      return true;
    }

  }

  private Node findLeastNode(Node currentNode) {

    Node temp = currentNode;

    while (temp.getLeftChild() != null) {
      temp = temp.getLeftChild();
    }

    return temp;

  }
}
