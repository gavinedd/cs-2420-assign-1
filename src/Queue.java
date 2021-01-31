public class Queue <E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public Queue(){
        this.size = 0;
        this.tail = this.head = null;
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }


    public void enqueue(E value){
        Node<E> tempNode = new Node(value);
        if (this.tail == null){
            this.head = this.tail = tempNode;
        }
        this.tail.next = tempNode;
        this.tail = tempNode;
    }

    public Node<E> dequeue(){
        if (this.head == null){
            return null;
        }

        Node<E> tempNode = this.head;
        this.head = this.head.next;

        if (this.head == null){
            this.tail = null;
        }

        return tempNode;

    }




    private class Node<E>{
        private E value;
        private Node<E> next;

        private Node(E value){
            this.value = value;
            this.next = null;
        }


    }













}
