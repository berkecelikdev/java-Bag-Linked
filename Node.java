class Node<T>{

    T data;  // Verinin kendisi
    Node<T> next;   // bir sonraki Node objesinin bellekteki adresini tutar

    // sadece veri verilip "sonraki düğüm" belirtilmediğinde çalışır
    Node(T dataPortion){
        this(dataPortion, null);
    }

    // Ana constructor
    Node(T dataPortion, Node<T> nextNode){
        data = dataPortion;   // Gelen veriyi düğümün içine yerleştirir
        next = nextNode;   // Düğümün kendisinden sonra hangi düğüme bağlanacağını belirler
    }
}

