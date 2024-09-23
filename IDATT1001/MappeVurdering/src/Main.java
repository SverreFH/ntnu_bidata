public class Main {

    public static void main(String[] args) {
        Item test = new Item("B564", "Dette er en vare", 40, "Brandico", 23.4, 30.2, 5.6,"Red", -1, 4 );

        System.out.println(test.getItemNumber());
        System.out.println(test.getDescription());
        System.out.println(test.getPrice());
        System.out.println(test.getBrand());
        System.out.println(test.getWeight());
        System.out.println(test.getLength());
        System.out.println(test.getHeight());
        System.out.println(test.getColor());
        System.out.println(test.getNumberInStock());
        System.out.println(test.getCategory());
    }
}