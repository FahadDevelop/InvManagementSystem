public class InventoryManager {
    protected Product[] products = new Product[50];
    private int count = 0;

    public void addProduct(int id, String name, double price, int qt) {
        if (this.products.length > count) {
            Product prd = new Product(id, name, price, qt);
            for (int i = 0; i < this.products.length; i++) {
                if (this.products[i] == null) {
                    this.products[i] = prd;
                    this.count++;
                    System.out.println("\nProduct ID " + id + " Added!");
                    break;
                }
            }
        } else {
            System.out.println("Inventory is full!");
        }
    }

    public void addProduct(int id, String name, double price, int qt, String exp) {
        if (this.products.length > count) {
            PerishableProduct prd = new PerishableProduct(id, name, price, qt, exp);
            for (int i = 0; i < this.products.length; i++) {
                if (this.products[i] == null) {
                    this.products[i] = prd;
                    this.count++;
                    System.out.println("\nProduct ID " + id + " Added!");
                    break;
                }
            }
        } else {
            System.out.println("Inventory is full!");
        }
    }

    public void viewProducts() {
        System.out.println("----------------------------");
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i] != null) {
                this.products[i].displayProductInfo();
                System.out.println("----------------------------");
            }
        }
    }

    public void updateProduct(int id, double price, int qt) throws ProductNotFoundException {
        boolean found = false;
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i] != null && this.products[i].productId == id) {
                System.out.println("\nUpdating the Following:");
                System.out.println(String.format("Price: %.2f AED -> %.2f AED", this.products[i].price, price));
                System.out.println(String.format("Quantity: %d -> %d", this.products[i].quantity, qt));
                this.products[i].price = price;
                this.products[i].quantity = qt;
                found = true;
                break;
            }
        }
        if (found == false) {
            throw new ProductNotFoundException("Product not Found!");
        }
    }

    public void deleteProduct(int id) throws ProductNotFoundException {
        boolean found = false;
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i] != null && this.products[i].productId == id) {
                this.products[i] = null;
                this.count--;
                System.out.println("\nProduct ID " + id + " Deleted!");
                found = true;
            }
        }
        if (found == false) {
            throw new ProductNotFoundException("Product not Found!");
        }
    }

    public void searchProduct(int id) throws ProductNotFoundException {
        boolean found = false;
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i] != null && this.products[i].productId == id) {
                System.out.println("\nProduct Found!");
                this.products[i].displayProductInfo();
                found = true;
            }
        }
        if (found == false) {
            throw new ProductNotFoundException("Product not Found!");
        }
    }
}