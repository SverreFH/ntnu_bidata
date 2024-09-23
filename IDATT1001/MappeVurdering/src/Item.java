
public class Item {
    private final String itemNumber;
    private String description;
    private int price;
    private final String brand;
    private final double weight;
    private final double length;
    private final double height;
    private final String color;
    private int numberInStock;
    private Type category;

    Item(String in, String d, int p, String b, double w, double l, double h, String c, int nis, int ca){
        itemNumber = in;
        description = d;
        price = p;
        brand = b;
        weight = w;
        length = l;
        height = h;
        color = c;
        if(nis < 0){
            numberInStock = 0;
        }
        else{
            numberInStock = nis;
        }
        try {
            category = Type.values()[ca - 1];
        }
        catch (Exception e){
            System.out.println("Product type does not exist");
        }
    }

    public String getItemNumber(){return itemNumber;}
    public String getDescription(){return description;}
    public int getPrice(){return price;}
    public String getBrand(){return brand;}
    public double getWeight(){return weight;}
    public double getLength(){return length;}
    public double getHeight(){return height;}
    public String getColor(){return  color;}
    public int getNumberInStock(){return numberInStock;}
    public Type getCategory(){return category;}

    public void setNumberInStock(int newStock){
        this.numberInStock = newStock;
    }

    public void setPrice(int newPrice){
        this.price = newPrice;

    }

    public void setDescription(String newDescription){
        this.description = newDescription;
    }
}
