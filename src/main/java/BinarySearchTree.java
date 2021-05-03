import java.util.Arrays;
import java.util.HashSet;
import tree.Node;

public class BinarySearchTree {
  HashSet<Integer> sb;

  public BinarySearchTree(){
    sb = new HashSet<Integer>();
  }

  public int findMin(Node root){
    if(root.getLeftChild() == null){
      return root.getData();
    }

    return findMin(root.getLeftChild());
  }


  public int findMinV2(Node root){
    Node currentNode = root;

    while(currentNode.getLeftChild() != null){

      currentNode = currentNode.getRightChild();
    }

    return  currentNode.getData();
  }


  public int findKMax(Node root, int k){
    treeToString(root);
    int counter  =0;
    int [] result = new int[sb.size()];

    for(int item : sb){
      result[counter] = item;
     System.out.println(item);
      counter++;
    }

    Arrays.sort(result);

    return result[result.length - 3];

  }


  public void treeToString(Node node){
   if(node == null){
     return ;
   }

    sb.add(node.getData());
   treeToString(node.getLeftChild());
   treeToString(node.getRightChild());

  }

  public Node findParent(Node node, int k){
    if(node.getLeftChild() == null && node.getRightChild() == null) {
      return null;
    }

    if(node.getLeftChild().getData() == k || node.getRightChild().getData() == k){
      return node;
    }

    if(k > node.getData()){
      return findParent(node.getRightChild(), k);
    }else {
      return findParent(node.getLeftChild(), k);
    }
  }

  public String findAncenstors(Node node, int k){
    StringBuilder sb = new StringBuilder();

    Node currentNode = node;

    while(currentNode != null){

      if(currentNode.getData() == k){
        System.out.println(sb.toString());
        return sb.toString();
      }

      sb.append(currentNode.getData() + " ");

      if(k > currentNode.getData()){
        currentNode = currentNode.getRightChild();
      }else {
        currentNode = currentNode.getLeftChild();
      }


    }
    System.out.println(sb.toString());
    return sb.toString();
  }
}
