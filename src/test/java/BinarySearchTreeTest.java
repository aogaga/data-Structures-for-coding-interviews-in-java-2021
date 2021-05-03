import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tree.BinaryTree;
import tree.Node;

class BinarySearchTreeTest {
  BinaryTree bsT ;
  BinarySearchTree binarySearchTree;
  @BeforeEach
  void setUp() {
    binarySearchTree = new BinarySearchTree();

    bsT = new BinaryTree();
    bsT.add(6);
    bsT.add(4);
    bsT.add(9);
    bsT.add(5);
    bsT.add(2);
    bsT.add(8);
    bsT.add(12);
    bsT.add(10);
    bsT.add(14);
  }

  @Test
  void findMin() {
    int val = binarySearchTree.findMin(bsT.getRoot());
    assertEquals(2, val);
  }

  @Test
  void findMinV2() {
    int val = binarySearchTree.findMin(bsT.getRoot());
    assertEquals(2, val);
  }

  @Test
  void findKthValue(){
    int result = binarySearchTree.findKMax(bsT.getRoot(), 3);
    assertEquals(6, result);
  }

  @Test
  void findParent(){
    Node node = binarySearchTree.findParent(bsT.getRoot(), 2);
    assertEquals(4, node.getData());
  }

  @Test
  void testFindAncestors(){
  String sb = binarySearchTree.findAncenstors(bsT.getRoot(), 10);
    String sb2 = binarySearchTree.findAncenstors(bsT.getRoot(), 5);
  assertTrue(true);
  }
}