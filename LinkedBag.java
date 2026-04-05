public class LinkedBag<T> implements BagInterface<T>{

    private Node<T> firstNode; // Listenin başlangıç düğümü
    private int numberOfEntries;

    // Constructor
    public LinkedBag(){
        firstNode = null;  // Başta zincirin başı boştur
        numberOfEntries = 0;
    }

    @Override
    public int getCurrentSize(){
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty(){
        return numberOfEntries == 0;
    }

    // Yeni elemanı listenin en başına ekler (en hızlı yöntem)
    @Override
    public boolean add(T newEntry){

        Node<T> newNode = new Node<>(newEntry);  // Yeni veri için yeni node oluşturulur
        newNode.next = firstNode;  // listenin başına (firstnode) bağlanır
        firstNode = newNode;  // fristnode yeni düğüm olur
        numberOfEntries++;
        return true;
    }

    // Listenin başındaki (son eklenen) elemanı çıkarır
    @Override
    public T remove(){

        T result = null;
        if(firstNode != null){
            result = firstNode.data;
            firstNode = firstNode.next;  // İlk düğümü devreden çıkar (referansı kaydırılır)
            numberOfEntries--;
        }
        return result;
    }

    // Seçilen bir elemanı siler
    @Override
    public boolean remove(T anEntry){

        Node<T> nodeN = getReferenceTo(anEntry);
        if(nodeN != null){
            // Silinecek düğümün içine ilk düğümün verisini kopyala
            nodeN.data = firstNode.data;
            // İlk düğümü sil (Dizideki son elemanı kaydırma mantığının benzeri)
            remove();
            return true;
        }
        return false;
    }

    @Override
    public void clear(){
        while(!isEmpty()){
            remove();
        }
    }

    // Bir elemandan kaç tane olduğunu sayar
    @Override
    public int getFrequencyOf(T anEntry){

        int frequency = 0;  // Sayaç
        Node<T> currentNode = firstNode;
        while(currentNode != null){
            if(anEntry.equals(currentNode.data)){
                frequency++;
            }
            currentNode = currentNode.next;  // sonraki node'a geç
        }
        return frequency;
    }

    @Override
    public boolean contains(T anEntry){
        return getReferenceTo(anEntry) != null;
    }

    // Tüm verileri yeni diziye kopyalar
    @Override
    public T[] toArray(){

        @SuppressWarnings("unhecked")
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        Node<T> currentNode = firstNode;
        while(index < numberOfEntries && currentNode != null){
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;  // sonraki node'a geç
        }
        return result;
    }

    // Her node'u tarar ve içlerindeki veriyi ekrana yazar
    @Override
    public void displayBag(){
        if(isEmpty()){
            System.out.println("Bag is empty!");
        }
        else{
            Node<T> currentNode = firstNode;
            while(currentNode != null){
                System.out.println(currentNode.data + " ");
                currentNode = currentNode.next;  // sonraki node'a geç
            }
            System.out.println();
        }
    }

    // Node'ları tarar ve aranan eleman bulununca node adresini döndürür.
    private Node<T> getReferenceTo(T anEntry){
        Node<T> currentNode = firstNode;
        while(currentNode != null){
            if(anEntry.equals(currentNode.data)){
                return currentNode;
            }
            currentNode = currentNode.next;  // sonraki node'a geç
        }
        return null;
    }

    

}
