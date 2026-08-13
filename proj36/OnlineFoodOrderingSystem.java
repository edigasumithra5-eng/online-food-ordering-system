```java
import java.util.ArrayList;
import java.util.Scanner;

// Food class
class Food {

    int id;
    String name;
    double price;

    Food(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

// OrderItem class
class OrderItem {

    Food food;
    int quantity;

    OrderItem(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    double getTotal() {
        return food.price * quantity;
    }
}

// Main class
public class OnlineFoodOrderingSystem {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Food> menu = new ArrayList<>();

    static ArrayList<OrderItem> order = new ArrayList<>();

    // Add food items to menu
    static void createMenu() {

        menu.add(new Food(1, "Pizza", 250));
        menu.add(new Food(2, "Burger", 120));
        menu.add(new Food(3, "Sandwich", 100));
        menu.add(new Food(4, "Pasta", 180));
        menu.add(new Food(5, "Biryani", 220));
        menu.add(new Food(6, "French Fries", 90));
        menu.add(new Food(7, "Soft Drink", 60));
    }

    // Display menu
    static void displayMenu() {

        System.out.println("\n==========================================");
        System.out.println("             FOOD MENU");
        System.out.println("==========================================");

        System.out.printf(
                "%-5s %-20s %10s%n",
                "ID",
                "Food Item",
                "Price"
        );

        System.out.println("------------------------------------------");

        for (Food food : menu) {

            System.out.printf(
                    "%-5d %-20s ₹%.2f%n",
                    food.id,
                    food.name,
                    food.price
            );
        }

        System.out.println("==========================================");
    }

    // Find food by ID
    static Food findFood(int id) {

        for (Food food : menu) {

            if (food.id == id) {
                return food;
            }
        }

        return null;
    }

    // Add food to order
    static void addFood() {

        displayMenu();

        System.out.print("\nEnter Food ID: ");
        int id = scanner.nextInt();

        Food selectedFood = findFood(id);

        if (selectedFood == null) {

            System.out.println("Invalid food ID.");
            return;
        }

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        if (quantity <= 0) {

            System.out.println(
                    "Quantity must be greater than zero."
            );

            return;
        }

        order.add(
                new OrderItem(
                        selectedFood,
                        quantity
                )
        );

        System.out.println(
                selectedFood.name
                        + " added to your order."
        );
    }

    // Display order
    static void displayOrder() {

        if (order.isEmpty()) {

            System.out.println(
                    "\nYour order is empty."
            );

            return;
        }

        System.out.println(
                "\n=========================================="
        );

        System.out.println(
                "              YOUR ORDER"
        );

        System.out.println(
                "=========================================="
        );

        double subtotal = 0;

        for (OrderItem item : order) {

            double itemTotal = item.getTotal();

            System.out.printf(
                    "%-20s x%-3d ₹%.2f%n",
                    item.food.name,
                    item.quantity,
                    itemTotal
            );

            subtotal += itemTotal;
        }

        System.out.println(
                "------------------------------------------"
        );

        System.out.printf(
                "Subtotal: ₹%.2f%n",
                subtotal
        );
    }

    // Generate bill
    static void checkout() {

        if (order.isEmpty()) {

            System.out.println(
                    "\nNo items in the order."
            );

            return;
        }

        double subtotal = 0;

        System.out.println(
                "\n=========================================="
        );

        System.out.println(
                "             FINAL BILL"
        );

        System.out.println(
                "=========================================="
        );

        for (OrderItem item : order) {

            double total = item.getTotal();

            System.out.printf(
                    "%-20s x%-3d ₹%.2f%n",
                    item.food.name,
                    item.quantity,
                    total
            );

            subtotal += total;
        }

        double discount = 0;

        if (subtotal >= 500) {
            discount = subtotal * 0.10;
        }

        double finalAmount = subtotal - discount;

        System.out.println(
                "------------------------------------------"
        );

        System.out.printf(
                "Subtotal       : ₹%.2f%n",
                subtotal
        );

        System.out.printf(
                "Discount       : ₹%.2f%n",
                discount
        );

        System.out.printf(
                "Final Amount   : ₹%.2f%n",
                finalAmount
        );

        System.out.println(
                "=========================================="
        );

        System.out.println(
                "       THANK YOU FOR YOUR ORDER!"
        );

        System.out.println(
                "=========================================="
        );
    }

    // Main method
    public static void main(String[] args) {

        createMenu();

        int choice;

        System.out.println(
                "=========================================="
        );

        System.out.println(
                "       ONLINE FOOD ORDERING SYSTEM"
        );

        System.out.println(
                "=========================================="
        );

        do {

            System.out.println("\n1. Display Menu");
            System.out.println("2. Add Food");
            System.out.println("3. View Order");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");

            System.out.print(
                    "\nEnter your choice: "
            );

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    displayMenu();
                    break;

                case 2:
                    addFood();
                    break;

                case 3:
                    displayOrder();
                    break;

                case 4:
                    checkout();
                    break;

                case 5:
                    System.out.println(
                            "\nThank you! Visit again."
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Try again."
                    );
            }

        } while (choice != 5);

        scanner.close();
    }
}
```
