package oops;
import java.util.*;
class Node<T extends Comparable<T>> {
    T data;
    Node<T> left, right;
    Node(T val) { data = val; }
}
class BST<T extends Comparable<T>> {
    Node<T> root;
    void insert(T val) {
        root = insertRec(root, val);
    }
    Node<T> insertRec(Node<T> n, T val) {
        if (n == null) return new Node<>(val);
        if (val.compareTo(n.data) < 0) n.left = insertRec(n.left, val);
        else n.right = insertRec(n.right, val);
        return n;
    }
    void inorder(Node<T> n) {
        if (n != null) { inorder(n.left); System.out.print(n.data + " "); inorder(n.right); }
    }
    void preorder(Node<T> n) {
        if (n != null) { System.out.print(n.data + " "); preorder(n.left); preorder(n.right); }
    }
    void postorder(Node<T> n) {
        if (n != null) { postorder(n.left); postorder(n.right); System.out.print(n.data + " "); }
    }
    void levelorder() {
        if (root == null) return;
        Queue<Node<T>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node<T> n = q.poll();
            System.out.print(n.data + " ");
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
    }
}
public class Genericbt {
	public static void main(String[] args) {
        BST<Integer> t = new BST<>();
        t.insert(10); t.insert(5); t.insert(20);
        System.out.println("TC1: (10,5,20) inserted");
        System.out.print("TC2: Level Order:");
        t.levelorder();
        System.out.print("\nTC3: In Order:");
        t.inorder(t.root);
        System.out.print("\nTC4: Pre Order:");
        t.preorder(t.root); 
        System.out.print("\nTC5: Post Order:");
        t.postorder(t.root);
	}
}
