package oops;
import java.util.*;

class TreeNode<T>{
	T data;
	TreeNode<T> l,r;
	TreeNode(T v){
		data=v;
		l=r=null;
	}
}
class BT<T extends Comparable<T>> {
    private TreeNode<T> root;

    // Insert method (BST style)
    public void insert(T value) {
        root = insertRec(root, value);
    }

    private TreeNode<T> insertRec(TreeNode<T> node, T value) {
        if (node == null) {
            return new TreeNode<>(value);
        }
        if (value.compareTo(node.data) < 0) {
            node.l = insertRec(node.l, value);
        } else {
            node.r = insertRec(node.r, value);
        }
        return node;
    }

    // Step 3: DFS Traversals
    public void inorder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(TreeNode<T> node) {
        if (node != null) {
            inOrderRec(node.l);
            System.out.print(node.data + " ");
            inOrderRec(node.r);
        }
    }

    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(TreeNode<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderRec(node.l);
            preorderRec(node.r);
        }
    }

    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(TreeNode<T> node) {
        if (node != null) {
            postorderRec(node.l);
            postorderRec(node.r);
            System.out.print(node.data + " ");
        }
    }
    public void levelorder() {
        if (root == null) return;

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.poll();
            System.out.print(node.data + " ");

            if (node.l != null) queue.add(node.l);
            if (node.r != null) queue.add(node.r);
        }
        System.out.println();
    }
}
public class Genericbt {
	public static void main(String[] args) {
		BT<Integer> t=new BT<>();
		t.insert(10);
		t.insert(5);
		t.insert(20);
		System.out.println("TC1:(10,5,20) inserted");
		System.out.println("TC2:Level Order:");
		t.levelorder();
		System.out.println("TC3:In order:");
		t.inorder();
		System.out.println("TC4:Pre order");
		t.preorder();
		System.out.println("TC5:Post order");
		t.postorder();
	}
}
