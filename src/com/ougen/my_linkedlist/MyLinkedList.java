package com.ougen.my_linkedlist;

/**
 * @author:ougen
 * @date:2018/10/178:58
 */
public class MyLinkedList<T> {

    private Node<T> head ;

    private Node<T> tail;

    private int size;

    public MyLinkedList(){
        head = new Node<>();
        tail = new Node<>();
        head.next = tail ;
    }

    public boolean add(T t){
        if (tail.item == null){
            tail.item = t;
            size++;
            return true;
        }
        if (offer(t)){
            return true;
        }
        return false;
    }

    private boolean offer(T t){
        cheakNotNull(t);
        Node newNode = new Node(t);
        newNode.pre = tail ;
        tail.next = newNode;
        tail = newNode;
        size++;
        return true;
    }

    private void cheakNotNull(T t) {
        if (t == null) {
            throw new RuntimeException("数据不能为空");
        }
    }

    public T remove(T t){
        cheakNotNull(t);
        if(tail == null){
            return null;
        }
        for (Node<T> h = head,p = h.next ; p !=null ; p = p.next ){
            if (p.item == t && p.item.equals(t)){
                p.pre.next = p.next;
                p.next.pre = p.pre;
                T o = p.item;
                p = null ;
                size--;
                return o;
            }
        }
        return null;
    }

    public T get(int i){
        checkOutOfNumber(i);
        Node<T> now = null;
        if (i < (size >> 1 )){
            Node<T> h = head;
            Node<T> p = head;
            for (int j = 0;j<=i;j++,p=p.next){
                now = p.next;
            }
            return now.item;
        }else {
            Node<T> h = tail;
            Node<T> p = now = tail;
            for (int j = size-1;j>i;j--,p=p.pre){
                now = p.pre;
            }
            return now.item;
        }
    }

    public int size(){
        return this.size;
    }

    private void checkOutOfNumber(int i) {
        if(i<0 || i >= size){
            throw new ArrayIndexOutOfBoundsException("参数越界"+i);
        }
    }

    private static class Node<T>{

        private T item ;

        private Node<T> next;

        private Node<T> pre;

        public Node(){
            this.pre = null;
            this.item = null;
            this.next = null;
        }
        public Node(T item){
            this.item = item;
        }
        public Node(Node<T> pre,T item,Node<T> next){
            this.pre = pre;
            this.item = item;
            this.next = next;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPre() {
            return pre;
        }

        public void setPre(Node<T> pre) {
            this.pre = pre;
        }
    }
}
