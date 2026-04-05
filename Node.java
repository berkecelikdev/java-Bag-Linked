class Node<T>{

    T data;
    Node<T> next;

    Node(T dataPortion){
        this(dataPortion, null);
    }

    Node(T dataPortion, Node<T> nextNode){
        data = dataPortion;
        next = nextNode;
    }
}
