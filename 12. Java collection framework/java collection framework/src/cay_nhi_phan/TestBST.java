package cay_nhi_phan;

import java.util.Arrays;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
//        tree.insert("George");
//        tree.insert("Michael");
//        tree.insert("Tom");
//        tree.insert("Adam");
//        tree.insert("Jones");
//        tree.insert("Peter");
//        tree.insert("Daniel");
        tree.insert(60);
        tree.insert(55);
        tree.insert(100);
        tree.insert(45);
        tree.insert(57);
        tree.insert(67);
        tree.insert(107);
        tree.insert(59);
        tree.insert(101);


        System.out.println("Inorder (sorted): ");
        tree.inorder();
        System.out.println("PostOrder (sorted): ");
//        tree.postOrder();

        System.out.println("The number of nodes is: " + tree.getSize());

//        System.out.println(tree.search(60).element);
        tree.deleteKey(45);
        tree.deleteKey(101);
        tree.deleteKey(55);

        System.out.println("Inorder (sorted): ______");
        tree.inorder();
        System.out.println("The number of nodes is: " + tree.getSize());
    }
}
