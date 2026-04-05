public class Main {
    public static void main(String[] args){

        BagInterface<String> storeBag = new LinkedBag<>();
        BagInterface<String> fragileBag = new LinkedBag<>();
        BagInterface<String> giftBag = new LinkedBag<>();

        storeBag.add("F_Plate");
        storeBag.add("X_Cotton_Candy");
        storeBag.add("F_Beer_Glass");
        storeBag.add("X_Magnet");

        System.out.println("Sorting...");

        while(!storeBag.isEmpty()){
            String item = storeBag.remove();
            if(item != null && item.length() > 0){
                if(item.charAt(0) == 'F'){
                    fragileBag.add(item);
                }
                else{
                    giftBag.add(item);
                }
            }
        }

        System.out.println("Fragile: ");
        fragileBag.displayBag();
        System.out.println("Non-fragile: ");
        giftBag.displayBag();
        System.out.println("Bag: ");
        storeBag.displayBag();

    }
}
