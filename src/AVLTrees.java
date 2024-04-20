public class AVLTrees {
    int height(Node n){
        if(n == null){
            return 0;
        }
        return n.height;
    }

    int balanceFactor(Node n){
        if (n == null){
            return 0;
        }
        return height(n.left) - height(n.right);
    }

    Node rotateLeft(Node x){
        Node y = x.right;
        Node T2 = y.left;

        //Rotation
        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.right), height(x.right)) + 1;
        y.height = Math.max(height(y.right), height(y.right)) + 1;

        return y;
    }

    Node rotateRight(Node y){
        Node x = y.left;
        Node T2 = x.right;

        //Rotation
        x.right = y;
        y.left = T2;

        x.height = Math.max(height(x.right), height(x.right)) + 1;
        y.height = Math.max(height(y.right), height(y.right)) + 1;

        return x;
    }

    Node insert(Node node, int key){
        if (node == null){
            return new Node(key);
        }
        if (key > node.data){
            node.right = insert(node.right, key);
        }
        else if (key < node.data){
            node.left = insert(node.left, key);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int bf = balanceFactor(node);

        if (bf > 1 && key < node.left.data){
            return rotateRight(node);
        }

        if (bf < -1 && key > node.right.data){
            return rotateLeft(node);
        }

        if (bf > 1 && key > node.left.data){
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (bf < -1 && key < node.right.data){
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    void preorder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    void inorder(Node root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

   void postorder(Node root){
        if (root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
   }


    public static void main(String[] args) {
        AVLTrees avl = new AVLTrees();
        Node root = null;
        root = avl.insert(root, 5);
        root = avl.insert(root, 1);
        root = avl.insert(root, 3);
        root = avl.insert(root, 4);
        root = avl.insert(root, 2);
        root = avl.insert(root, 7);

        avl.preorder(root);
        System.out.println();
        avl.inorder(root);
        System.out.println();
        avl.postorder(root);
    }
}
