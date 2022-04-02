import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Obtenido y adaptado de https://github.com/eugenp/tutorials/blob/master/data-structures/src/main/java/com/baeldung/tree/BinaryTree.java
public class BINNODE {

    Noder root;

    public void add(String value, String prefix) {
        root = addRecursive(root, value,prefix);
    }

    private Noder addRecursive(Noder current, String value, String prefix) {

        if (current == null) {
            return new Noder(value,prefix);
        }

        if (value.compareTo(String.valueOf(current.data.getValue())) < 0) {
            current.left = addRecursive(current.left, value,prefix);
        } else if (value.compareTo(String.valueOf(current.data.getValue())) > 0) {
            current.right = addRecursive(current.right, value,prefix);
        }

        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(Noder current) {
        return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }
    public Noder getNode(String value) {
        return getRecursive(root, value);
    }

    private Noder getRecursive(Noder current, String value) {
        if (current == null) {
            return null;
        }

        if (value.equals((String)current.data.getKey())) {
            return current;
        }

        return value.compareTo((String)current.data.getKey()) < 0
            ? getRecursive(current.left, value)
          : getRecursive (current.right, value);
    }

    public boolean containsNode(String value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Noder current, String value) {
        if (current == null) {
            return false;
        }

        if (value.equals((String)current.data.getKey())) {
            return true;
        }

        return value.compareTo((String)current.data.getKey()) < 0
            ? containsNodeRecursive(current.left, value)
          : containsNodeRecursive(current.right, value);
    }

    public void delete(String value) {
        root = deleteRecursive(root, value);
    }

    private Noder deleteRecursive(Noder current, String value) {
        if (current == null) {
            return null;
        }

        if (value.equals((String)current.data.getKey())) {
            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: only 1 child
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            // Case 3: 2 children
            String smallestValue = findSmallestValue(current.right);
            current.data.setKey(smallestValue);
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value.compareTo((String) current.data.getKey()) < 0)  {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private String findSmallestValue(Noder root) {
        return root.left == null ? (String) root.data.getKey() : findSmallestValue(root.left);
    }

    public void traverseInOrder(Noder node) {
        if (node != null) {
            traverseInOrder(node.left);
            visit((String)node.data.getKey(),(String)node.data.getValue());
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(Noder node) {
        if (node != null) {
            visit((String)node.data.getKey(),(String)node.data.getValue());
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Noder node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            visit((String)node.data.getKey(),(String)node.data.getValue());
        }
    }

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Noder> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Noder node = nodes.remove();

            System.out.print(" " + node.data.getKey());

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    public void traverseInOrderWithoutRecursion() {
        Stack<Noder> stack = new Stack<>();
        Noder current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            Noder top = stack.pop();
            visit((String)current.data.getKey(),(String)current.data.getValue());
            current = top.right;
        }
    }

    public void traversePreOrderWithoutRecursion() {
        Stack<Noder> stack = new Stack<>();
        Noder current = root;
        stack.push(root);

        while (current != null && !stack.isEmpty()) {
            current = stack.pop();
            visit((String)current.data.getKey(),(String)current.data.getValue());

            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);
        }
    }
    
    public void traversePostOrderWithoutRecursion() {
        Stack<Noder> stack = new Stack<>();
        Noder prev = root;
        Noder current = root;
        stack.push(root);

        while (current != null && !stack.isEmpty()) {
            current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPrevLastChild = (prev == current.right || (prev == current.left && current.right == null));

            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
                visit((String)current.data.getKey(),(String)current.data.getValue());
                prev = current;
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }   
    }    
    
    private void visit(String value, String prefix) {
        System.out.print(" " + value + "-" + prefix);        
    }
    
    
}