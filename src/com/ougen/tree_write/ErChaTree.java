package com.ougen.tree_write;

/**
 * @author:ougen
 * @date:2018/8/1821:46
 */
public class ErChaTree<T extends Comparable> {

    private Node<T> root;

    private Node<T> insert(T data ,Node<T> croot){
        if (croot == null){
            return new Node<T>(data);
        }
        int res = croot.data.compareTo(data);
        if ( res > 0){
            croot.setLeftNode(insert(data,croot.getLeftNode()));
        }else if (res <0 ){
            croot.setRightNode(insert(data,croot.getRightNode()));
        }else {
            croot.setRightNode(insert(data,croot.getLeftNode()));
        }
        return croot;
    }

    public Node<T> insert(T data){
        if (root == null) {
            root = new Node<T>(data);
            return root;
        }
        return insert(data,root);
    }


    static class Node<T extends Comparable>{
        private Node<T> leftNode;

        private Node<T> rightNode;

        private T data;

        public Node(T data) {
            this.data = data;
        }

        public Node<T> getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node<T> leftNode) {
            this.leftNode = leftNode;
        }

        public Node<T> getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node<T> rightNode) {
            this.rightNode = rightNode;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }


    public void toPrin() {
        toPrint(root);
    }
    private void toPrint(Node<T> croot){
        if (croot == null)return;
        System.out.print(croot.data.toString()+"   ");
        toPrint(croot.leftNode);
        toPrint(croot.rightNode);
    }
}
