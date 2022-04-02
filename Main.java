
 public class Main{
    public static void main(String[] args) {
        
        System.out.println("Binary tree test");
        BinaryTree test = new BinaryTree();
        test.add("a"); 
        test.add("b"); 
        test.add("c"); 
        test.traverseInOrder(test.root);
        System.out.println();
        test.add("d"); 
        test.traverseInOrder(test.root);
        test.delete("a");
        System.out.println();
        test.traverseInOrder(test.root);
        test.delete("c");
        System.out.println();
        test.traverseInOrder(test.root);
    } 
 }
 