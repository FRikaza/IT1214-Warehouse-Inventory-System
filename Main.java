import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id;
    String name;
    int quantity;
    double price;

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %-15s | Qty: %-5d | Price: $%.2f", id, name, quantity, price);
    }
}

public class Main {
    private static ArrayList<Product> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--- Warehouse Inventory System ---");
        while (true) {
            System.out.println("\n1. Add Product\n2. View Inventory\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                addProduct();
            } else if (choice == 2) {
                viewInventory();
            } else if (choice == 3) {
                System.out.println("Exiting system...");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int qty = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        inventory.add(new Product(id, name, qty, price));
        System.out.println("Product added successfully!");
    }

    private static void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("\n--- Current Stock ---");
            for (Product p : inventory) {
                System.out.println(p);
            }
        }
    }
}
