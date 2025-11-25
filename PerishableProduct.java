public class PerishableProduct extends Product {
    protected String expiryDate;

    public PerishableProduct(int id, String name, double price, int qt, String exp) {
        super(id, name, price, qt);
        this.expiryDate = exp;
    }

    @Override
    public void displayProductInfo() {
        super.displayProductInfo();
        System.out.println("Expiry Date: " + this.expiryDate);
    }
}