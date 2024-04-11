/**
 * Represents a node in a binary search tree.
 */

class Node{
   int value;
   Node left, right;
     /**
     * Constructs a new node with the given value.
     *
     * @param value the value to be stored in the node
     */
  
      public Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }


}
/**
 * Represents a binary search tree and provides various operations on it.
 */

class BinarySearchTree{

   Node root;
   
   
      /**
     * Inserts a new node with the given value into the binary search tree.
     *
     * @param value the value to insert
     * @return the root node of the updated tree
     */

   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   
   
       /**
     * Performs a pre-order traversal of the binary search tree.
     *
     * @param root the root node of the subtree to traverse
     */

     public void preOrderTraversal(Node root){
        if(root != null){
            System.out.print(root.value + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }


   
   
       /**
     * Performs an in-order traversal of the binary search tree.
     *
     * @param root the root node of the subtree to traverse
     */
    public void inOrderTraversal(Node root){
        if(root != null){
            inOrderTraversal(root.left);
            System.out.print(root.value + " ");
            inOrderTraversal(root.right);
        }
    }

   
   
     /**
     * Performs a post-order traversal of the binary search tree.
     *
     * @param root the root node of the subtree to traverse
     */
    public void postOrderTraversal(Node root){
        if(root != null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value + " ");
        }
    }

   
   
   
  
    /**
     * Searches for a node with the specified key in the binary search tree.
     *
     * @param root the root node of the subtree to search
     * @param key  the key to search for
     * @return true if the key is found, false otherwise
     */
    public boolean find(Node root, int key){
        if(root == null){
            return false;
        } else if(root.value == key){
            return true;
        } else if(key < root.value){
            return find(root.left, key);
        } else{
            return find(root.right, key);
        }
    }

   
    /**
     * Finds the minimum value in the binary search tree.
     *
     * @param root the root node of the subtree to search
     * @return the minimum value in the subtree
     * @throws IllegalArgumentException if the tree is empty
     */
    public int getMin(Node root){
        if(root == null){
            throw new IllegalArgumentException("Tree is empty");
        }
        while(root.left != null){
            root = root.left;
        }
        return root.value;
    }
    /**

  
  
   /*
   a method to find the node in the tree
   with a largest key
   */
   public int getMax(Node root){
	  //implement me
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}