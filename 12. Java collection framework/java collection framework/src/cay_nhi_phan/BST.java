package cay_nhi_phan;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            insert(objects[i]);
        }
    }

    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e);
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false;
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true;
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }
    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }

    protected void preOorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.println(root.element + " ");
        inorder(root.left);
        inorder(root.right);
    }

    protected void postOrder(TreeNode<E> root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.element + " ");
    }

    public TreeNode<E> searchParent(E e) {
        TreeNode<E> current = root;
        TreeNode<E> parent = null;

        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                return parent;
        }
        return null;
    }

    public TreeNode<E> search(E e) {
        TreeNode<E> current = root;

        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else
                return current;
        }
        return null;
    }

    void deleteKey(E key)
    {
        root = deleteRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    public TreeNode<E> deleteRec(TreeNode<E> root, E key)
    {
        /* Base Case: If the tree is empty */
        if (root == null) return root;

        /* Otherwise, recur down the tree */
        if (key.compareTo(root.element) < 0)
            root.left = deleteRec(root.left, key);
        else if (key.compareTo(root.element) > 0)
            root.right = deleteRec(root.right, key);

            // if key is same as root's key, then This is the node
            // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null) {
                size--;
                return root.right;
            } else if (root.right == null) {
                size--;
                return root.left;
            }


            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.element = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.element);
        }

        return root;
    }

    public E minValue(TreeNode<E> root)
    {
        E minv = root.element;
        while (root.left != null)
        {
            minv = root.left.element;
            root = root.left;
        }
        return minv;
    }

}
