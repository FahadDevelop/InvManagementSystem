public class Product {
    protected int productId, quantity;
    protected double price;
    protected String productName;

    public Product(int id, String name, double price, int qt) {
        this.productId = id;
        this.productName = name;
        this.price = price;
        this.quantity = qt;
    }

    public void displayProductInfo() {
        System.out.println("Product ID: " + this.productId);
        System.out.println("Product Name: " + this.productName);
        System.out.println("Price: " + this.price + " AED");
        System.out.println("Quantity: " + this.quantity);
    }
}