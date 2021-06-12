package src;
public class BinarySearchTree<E extends Comparable<E>>{

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

    public Node<E> add(Node<E> root,E _data){
        if(root == null)
            return new Node<E>(_data);

        if(root.getData().compareTo(_data) > 0)
            root.rBranch = add(root.rBranch, _data);

        if(root.getData().compareTo(_data) < 0)
            root.lBranch = add(root.lBranch, _data);

        return root;
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

        public E getData(){
            return data;
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




}
