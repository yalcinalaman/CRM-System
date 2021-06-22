package DataStructures;

import java.util.ArrayList;
public class BinarySearchTree<E extends Comparable<E>>{

    /**
     * remove ve iterator lazım
     */

    private Node<E> head;

    public BinarySearchTree() {
        head = null;
    }

    public Node<E> getRoot() {
        return head;
    }

    public boolean add(E _data) {
        head = add(head,_data);
        return true;
    }

    public Node<E> add(Node<E> head,E _data){
        if(head == null)
            return new Node<E>(_data);

        if(head.getData().compareTo(_data) > 0)
            head.rBranch = add(head.rBranch, _data);

        if(head.getData().compareTo(_data) < 0)
            head.lBranch = add(head.lBranch, _data);

        return head;
    }

    private static class Node<E extends Comparable<E>>{

        E data;
        Node<E> lBranch;
        Node<E> rBranch;

        public Node(E _data) {
            data = (_data);
            lBranch = null;
            rBranch = null;
        }

        public E min() {
            if (lBranch == null) {
                return data;
            }
            else {
                return lBranch.min();
            }
        }

        public E max() {
            if (rBranch == null) {
                return data;
            }
            else {
                return rBranch.max();
            }
        }

        public void traverseInOrder() {
            if (lBranch != null) {
                lBranch.traverseInOrder();
            }
            System.out.print(data + ", ");
            if (rBranch != null) {
                rBranch.traverseInOrder();
            }
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node getLeftChild() {
            return lBranch;
        }

        public void setLeftChild(Node lBranch) {
            this.lBranch = Node.this.lBranch;
        }

        public Node getRightChild() {
            return rBranch;
        }

        public void setRightChild(Node rBranch) {
            this.rBranch = Node.this.rBranch;
        }


    }


    public void inOrder() {
        inOrder(head,"h");
    }

    private void inOrder(Node<E> local,String dir) {
        if(local == null)
            return;

        System.out.print(dir + local.data + "\n");

        inOrder(local.lBranch,dir+"l");

        inOrder(local.rBranch,dir+"r");
    }

    @Override
    public String toString() {
        StringBuilder strBuild = new StringBuilder();


        return strBuild.toString();
    }
    public void delete(E value) {
        head = delete(head, value);
    }

    private Node delete(Node subtreeRoot, E value) {
        if (subtreeRoot == null) {
            return subtreeRoot;
        }

        if (value.compareTo((E) subtreeRoot.getData()) < 0 ) {
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
        }
        else if (value.compareTo((E) subtreeRoot.getData()) > 0 ) {
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
        }
        else {
            if (subtreeRoot.getLeftChild() == null) {
                return subtreeRoot.getRightChild();
            }
            else if (subtreeRoot.getRightChild() == null) {
                return subtreeRoot.getLeftChild();
            }
            subtreeRoot.setData(subtreeRoot.getRightChild().min());
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), (E) subtreeRoot.getData()));
        }

        return subtreeRoot;
    }


    /**
     * Puts items into an array.
     * */
    private ArrayList<E> items = new ArrayList<>();
    private void PutItemsIntoArray(Node<E> subTree){
        if(subTree.rBranch != null){
            PutItemsIntoArray(subTree.rBranch);
        }
        items.add(subTree.getData());
        if(subTree.lBranch != null){
            PutItemsIntoArray(subTree.lBranch);
        }
    }

    public ArrayList<E> toArray(){
        PutItemsIntoArray(head);
        return items;
    }
    public BST_Iterator iterator(){
        return new BST_Iterator();
    }

    public class BST_Iterator{
        ArrayList<E> items = toArray();
        int last = -1;
        int curr = 0;

        public E next(){
            if(!hasNext()) return null;
            curr++;
            return items.get(++last);
        }
        public boolean hasNext(){
            return items.size() != curr;
        }

    }


}
