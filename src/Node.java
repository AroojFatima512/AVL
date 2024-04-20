public class Node {
    int data;
    Node right;
    Node left;
    int height;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }

}
