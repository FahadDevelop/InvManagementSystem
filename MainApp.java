import java.util.Scanner;

class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String msg) {
        super(msg);
    }
}

public class MainApp {
    public static int intInput(Scanner input, String output) {
        while (true) {
            System.out.print(output);
            try {
                return Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("InvalidInputException: The given integer input is invalid!");
            }
        }
    }
    public static double doubleInput(Scanner input, String output) {
        while (true) {
            System.out.print(output);
            try {
                return Double.parseDouble(input.nextLine());
            } catch (Exception e) {
                System.out.println("InvalidInputException: The given decimal input is invalid!");
            }
        }
    }
    public static void returnBack(Scanner input) {
        System.out.print("\nPress Enter to return back...");
        input.nextLine();
    }
    public static void main(String[] args) throws Exception {
        InventoryManager inv = new InventoryManager();
        Scanner input = new Scanner(System.in);
        int choice = 0;
        int id, quantity;
        double price;
        String name, expiry;
        while (choice != 6) {
            try {
                System.out.println();
                System.out.println("Inventory Management System:\n");
                System.out.println("[1] Add Product\n[2] View All Products\n[3] Update Product\n[4] Delete Product\n[5] Search Product by ID\n[6] Exit Program\n");
                choice = intInput(input, "Choice: ");
                switch (choice) {
                    case 1:
                        System.out.println("\nAdd Product:\n");
                        id = intInput(input, "ID: ");
                        System.out.print("Name: ");
                        name = input.nextLine();
                        price = doubleInput(input, "Price: ");
                        quantity = intInput(input, "Quantity: ");
                        System.out.print("Expiry Date (skip by leaving it blank): ");
                        expiry = input.nextLine();
                        if (expiry.length() > 0) {
                            inv.addProduct(id, name, price, quantity, expiry);
                        } else {
                            inv.addProduct(id, name, price, quantity);
                        }
                        returnBack(input);
                        break;
                    case 2:
                        System.out.println("\nView All Products:\n");
                        inv.viewProducts();
                        returnBack(input);
                        break;
                    case 3:
                        System.out.println("\nUpdate Product:\n");
                        id = intInput(input, "ID: ");
                        inv.searchProduct(id);
                        System.out.println("\nEnter the new details below!\n");
                        price = doubleInput(input, "Price: ");
                        quantity = intInput(input, "Quantity: ");
                        inv.updateProduct(id, price, quantity);
                        returnBack(input);
                        break;
                    case 4:
                        System.out.println("\nDelete Product:\n");
                        id = intInput(input, "ID: ");
                        inv.deleteProduct(id);
                        returnBack(input);
                        break;
                    case 5:
                        System.out.println("\nSearch Product:\n");
                        id = intInput(input, "ID: ");
                        inv.searchProduct(id);
                        returnBack(input);
                        break;
                    case 6:
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("\n" + e);
                returnBack(input);
            }
        }
        input.close();
    }
}
