import java.util.*;

/**
 *
 * @author sethu
 */
/**
 * Represents a pair of a string value and an integer value.
 */
class StringIntPair {

    // The string value of the pair
    private final String stringValue;

    // The integer value of the pair
    private final int intValue;

    /**
     * Constructs a new StringIntPair with the given string and integer values.
     *
     * @param stringValue the string value
     * @param intValue the integer value
     */
    public StringIntPair(String stringValue, int intValue) {
        this.stringValue = stringValue;
        this.intValue = intValue;
    }

    /**
     * Gets the string value of the pair.
     *
     * @return the string value
     */
    public String getStringValue() {
        return stringValue;
    }

    /**
     * Gets the integer value of the pair.
     *
     * @return the integer value
     */
    public int getIntValue() {
        return intValue;
    }
}


/**
 * Represents a collection of products with their details.
 */
class Products {

    // HashMap to store products with their IDs as keys
    private final HashMap<Integer, StringIntPair> bunchOfProducts = new HashMap<>();

    /**
     * Retrieves the details of a product with the given ID.
     *
     * @param id The ID of the product to retrieve.
     * @return The details of the product as a StringIntPair.
     */
    StringIntPair getDetails(int id) {
        return bunchOfProducts.get(id);
    }

    /**
     * Checks if a product with the given ID exists in the collection.
     *
     * @param id The ID of the product to check.
     * @return 1 if the product exists, 0 otherwise.
     */
    public int isTheIdAvailable(int id) {
        if (bunchOfProducts.containsKey(id)) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Adds a new product with the given details to the collection.
     *
     * @param id The ID of the product.
     * @param name The name of the product.
     * @param price The price of the product.
     */
    public void setDetails(int id, String name, int price) {
        bunchOfProducts.put(id, new StringIntPair(name, price));
    }

    /**
     * Removes a product with the given ID from the collection.
     *
     * @param id The ID of the product to remove.
     */
    public void removeDetails(int id) {
        if (!bunchOfProducts.containsKey(id)) {
            System.out.print("Id Not Found!\n");
            return;
        } else {
            bunchOfProducts.remove(id);
            System.out.println("Deleted product with ID " + id + "\n");
        }
    }

    /**
     * Deletes all products from the collection.
     */
    public void deleteAllDetails() {
        bunchOfProducts.clear();
    }

    /**
     * Retrieves all products from the collection.
     *
     * @return A HashMap containing all products with their IDs as keys.
     */
    HashMap<Integer, StringIntPair> ShowAllProducts() {
        return bunchOfProducts;
    }
}


/**
 * Represents an administrator responsible for managing product details.
 */
class Admin {

    // Products instance to perform administrative tasks
    private final Products products;

    /**
     * Constructs an Admin object with the specified Products instance.
     *
     * @param products The Products instance to manage.
     */
    public Admin(Products products) {
        this.products = products;
    }

    /**
     * Adds a new product with the given details.
     *
     * @param id The ID of the product to add.
     * @param name The name of the product.
     * @param price The price of the product.
     */
    public void addProductDetails(int id, String name, int price) {
        products.setDetails(id, name, price);
    }

    /**
     * Removes the product with the specified ID.
     *
     * @param id The ID of the product to remove.
     */
    public void removeProductDetails(int id) {
        products.removeDetails(id);
    }

    /**
     * Clears all product details from the system.
     */
    public void clearAllProductDetails() {
        products.deleteAllDetails();
    }

    /**
     * Retrieves details of all products.
     *
     * @return A HashMap containing details of all products.
     */
    public HashMap<Integer, StringIntPair> ShowAllProducts() {
        return products.ShowAllProducts();
    }
}


/**
 * Represents the format of a bill item.
 */
class BillFormat {

    // Item ID
    private final int itemId;

    // Quantity of the item
    private final int quantity;

    // Price per unit of the item
    private final int price;

    // Name of the item
    private final String itemName;

    /**
     * Constructs a BillFormat object with the specified details.
     *
     * @param id The ID of the item.
     * @param quantity The quantity of the item.
     * @param price The price per unit of the item.
     * @param name The name of the item.
     */
    public BillFormat(int id, int quantity, int price, String name) {
        this.itemId = id;
        this.quantity = quantity;
        this.price = price;
        this.itemName = name;
    }

    /**
     * Retrieves the ID of the item.
     *
     * @return The item ID.
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * Retrieves the quantity of the item.
     *
     * @return The quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Retrieves the price per unit of the item.
     *
     * @return The price.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Retrieves the name of the item.
     *
     * @return The item name.
     */
    public String getItemName() {
        return itemName;
    }
}


/**
 * Represents a bill counter staff member responsible for managing bill items.
 */
class BillCounterGuy {

    // Reference to the Products class for fetching product details
    private final Products products;

    // Item ID
    private int itemId;

    // Item name
    private String itemName;

    // Quantity of the item
    private int quantity;

    // Price of the item
    private int price;

    // Counter for items
    private int itemNo;

    // Total amount of the bill
    private int totalAmount;

    // List to store bill details
    private final List<BillFormat> billDetails = new ArrayList<>();

    /**
     * Constructs a BillCounterGuy object with the specified Products instance.
     *
     * @param products The Products instance to fetch product details from.
     */
    public BillCounterGuy(Products products) {
        this.products = products;
    }

    /**
     * Checks if the given item ID is available in the bill.
     *
     * @param id The item ID to check.
     * @return 1 if the item ID is available, otherwise 0.
     */
    public int isTheIdAvailable(int id) {
        for (BillFormat item : billDetails) {
            if (item.getItemId() == id) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * Fetches product details for the given item ID.
     *
     * @param id The item ID to fetch details for.
     * @return The StringIntPair containing the name and price of the product.
     */
    StringIntPair fetchProductDetails(int id) {
        return products.getDetails(id);
    }

    /**
     * Adds an item to the bill with the specified ID and quantity.
     *
     * @param id The ID of the item to add.
     * @param qty The quantity of the item to add.
     */
    public void addItem(int id, int qty) {
        // Fetch product details
        this.itemName = fetchProductDetails(id).getStringValue();
        this.price = fetchProductDetails(id).getIntValue();
        this.price *= qty;
        this.totalAmount += price;
        this.itemId = id;
        this.quantity = qty;

        // Add item to bill details list
        billDetails.add(new BillFormat(id, quantity, price, itemName));
        System.out.println("Added Item:\nItem ID: " + billDetails.get(billDetails.size() - 1).getItemId() + "\nItem Name: "
                + billDetails.get(billDetails.size() - 1).getItemName() + "\nItem Qty: " + billDetails.get(billDetails.size() - 1).getQuantity() + "\nItem Price: "
                + billDetails.get(billDetails.size() - 1).getPrice());
    }

    /**
     * Modifies the quantity of an item in the bill.
     *
     * @param id The ID of the item to modify.
     * @param qty The new quantity of the item.
     */
    public void modifyItem(int id, int qty) {
        for (BillFormat item : billDetails) {
            if (item.getItemId() == id) {
                this.totalAmount -= item.getPrice();
                this.itemName = fetchProductDetails(id).getStringValue();
                this.price = fetchProductDetails(id).getIntValue();
                this.price *= qty;
                this.totalAmount += price;
                item = new BillFormat(id, qty, price, itemName);
                System.out.println("Modified Item:\nItem ID: " + item.getItemId() + "\nItem Name: "
                        + item.getItemName() + "\nItem Qty: " + item.getQuantity() + "\nItem Price: "
                        + item.getPrice());
            }
        }
    }

    /**
     * Removes an item from the bill.
     *
     * @param id The ID of the item to remove.
     */
    void removeItem(int id) {
        for (BillFormat item : billDetails) {
            if (item.getItemId() == id) {
                totalAmount -= item.getPrice();
                billDetails.remove(item);
                System.out.println("Product ID: " + id + " has been removed!!");
                return;
            }
        }
        System.out.println("Item not found!!");
    }

    /**
     * Retrieves the total amount of the bill.
     *
     * @return The total bill amount.
     */
    public int getBillAmount() {
        return this.totalAmount;
    }

    /**
     * Generates the bill with all the items and their details.
     *
     * @return The list of BillFormat objects representing the bill.
     */
    public List<BillFormat> generateBill() {
        return billDetails;
    }
}


/**
 * The BillCounter class manages the bill counter operations for XYZ. It allows
 * both admins and bill counter guys to perform their respective operations.
 */
public class BillCounter {

    // Scanner object for taking user input
    private final Scanner sc = new Scanner(System.in);

    // Instances of Admin and BillCounterGuy classes
    Admin admin;
    BillCounterGuy billCounterGuy;

    // Instance of Products class for managing products
    private final Products products = new Products();

    // Variables for storing user role and passwords
    private int role;
    private final int adminPassword = 1234;
    private final int userPassword = 5678;

    /**
     * Constructor for BillCounter class. Initializes instances of Admin and
     * BillCounterGuy classes with the same Products instance.
     */
    public BillCounter() {
        this.admin = new Admin(products); // Passing the same Products instance to Admin
        this.billCounterGuy = new BillCounterGuy(products); // Passing the same Products instance to BillCounterGuy
    }

    /**
     * Verifies the login details based on the provided password and user role.
     * Prints success or failure messages accordingly.
     *
     * @param password The password entered by the user.
     */
    public void verifyLoginDetails(int password) {

        // Check if the role is admin and the password matches the admin password
        if (this.role == 1 && this.adminPassword == password) {
            System.out.println("Sucessfully loged in!! \n");
        } // Check if the role is bill counter guy and the password matches the user password
        else if (this.role == 2 && this.userPassword == password) {
            System.out.println("Sucessfully loged in!! \n");
        } // If the login fails, print a failure message and set the role to -1
        else {
            System.out.println("Failed to log in!! \n");
            this.role = -1;
        }
    }

    /**
     * Performs admin operations such as adding, removing, or showing product
     * details. Prints a menu for the user to select the operation.
     */
    public void adminOperations() {
        try {
            // Print menu for admin operations
            System.out.println("""
                           What Operation You Want to perform: (Choose a number)
                            1) Add Product Details\t 2) Remove Product Details
                            3) Clear All Product Details\t 4) Show All Products
                            5) Exit\n
                           """);
            int option = sc.nextInt(); // Take user input for selected option
            sc.nextLine(); // Consume newline character for error purpose

            // Perform operation based on the selected option
            switch (option) {
                // Case for adding product details
                case 1 -> {
                    System.out.println("Enter the Product Name:");
                    String name = sc.nextLine();
                    System.out.println("Enter the Product ID:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the Price:");
                    int price = sc.nextInt();
                    sc.nextLine();
                    admin.addProductDetails(id, name, price);
                    System.out.println("Product " + name + " added with ID " + id);
                }
                // Case for removing product details
                case 2 -> {
                    System.out.println("Enter the Product ID:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    admin.removeProductDetails(id);
                }
                // Case for clearing all product details
                case 3 -> {
                    admin.clearAllProductDetails();
                    System.out.println("Deleted all the products!\n");
                }
                // Case for showing all products
                case 4 -> {
                    HashMap<Integer, StringIntPair> productDetails = admin.ShowAllProducts();
                    System.out.println("ID\tName\tPrice");
                    for (int productId : productDetails.keySet()) {
                        System.out.println(productId + "\t" + productDetails.get(productId).getStringValue()
                                + "\t" + productDetails.get(productId).getIntValue());
                    }
                }
                // Case for exiting admin operations
                case 5 -> {
                    this.role = -1;
                }
                // Default case for handling invalid option
                default -> {
                    System.out.println("Please select a valid option number!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Retry! Please enter a valid input.");
            sc.nextLine(); // Consume invalid input
        }
    }

    /**
     * Performs bill counter guy operations such as adding, modifying, and
     * removing items from the bill.
     */
    public void billCounterGuyOperations() {
        try {
            // Print menu for bill counter guy operations
            System.out.println("""
                           What Operation You Want to perform: (Choose a number)
                            1) Add Item to Bill\t 2) Modify Item in Bill
                            3) Remove Item from Bill\t 4) Show Bill Amount
                            5) Generate Bill\t 6) Exit\n
                           """);
            int option = sc.nextInt();
            sc.nextLine();

            // Perform operation based on the selected option
            switch (option) {
                // Case for adding item to bill
                case 1 -> {
                    System.out.println("Enter the Product ID:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if (products.isTheIdAvailable(id) == 0) {
                        System.out.println("Item not found!!");
                    } else {
                        System.out.println("Enter the Quantity:");
                        int qty = sc.nextInt();
                        sc.nextLine();
                        billCounterGuy.addItem(id, qty);
                    }
                }
                // Case for modifying item in bill
                case 2 -> {
                    System.out.println("Enter the Product ID:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if (products.isTheIdAvailable(id) == 0) {
                        System.out.println("Item not found in Store!!\n");
                    }
                    if (billCounterGuy.isTheIdAvailable(id) == 0) {
                        System.out.println("Item not found in Bill!!\n");
                    } else {
                        System.out.println("Enter the New Quantity:");
                        int qty = sc.nextInt();
                        sc.nextLine();
                        billCounterGuy.modifyItem(id, qty);
                    }
                }
                // Case for removing item from bill
                case 3 -> {
                    System.out.println("Enter the Product ID:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if (products.isTheIdAvailable(id) == 0) {
                        System.out.println("Item not found in Store!!\n");
                    }
                    if (billCounterGuy.isTheIdAvailable(id) == 0) {
                        System.out.println("Item not found in Bill!!\n");
                    } else {
                        billCounterGuy.removeItem(id);
                    }
                }
                // Case for showing bill amount
                case 4 -> {
                    int billAmount = billCounterGuy.getBillAmount();
                    System.out.println("Bill Amount: " + billAmount);
                }
                // Case for generating bill
                case 5 -> {
                    int billAmount = billCounterGuy.getBillAmount();
                    List<BillFormat> bill = billCounterGuy.generateBill();
                    System.out.println("Generated Bill:");
                    System.out.println("itemId\titemName\tquantity\tprice");
                    for (BillFormat item : bill) {
                        System.out.println(item.getItemId() + "\t" + item.getItemName() + "\t"
                                + item.getQuantity() + "\t" + item.getPrice());
                    }
                    System.out.println("Bill Amount: " + billAmount);
                }
                // Case for exiting bill counter guy operations
                case 6 -> {
                    this.role = -1;
                }
                // Default case for handling invalid option
                default -> {
                    System.out.println("Please select the given option number!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Retry! Please enter a valid input.");
            sc.nextLine(); // to Consume invalid input
        }
    }

    
    /**
     * The main method of the BillCounter class. Initializes the BillCounter
     * object and manages user interaction. Allows users to log in as an admin
     * or a bill counter guy and perform operations. Handles exceptions and
     * provides retry options for invalid inputs.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BillCounter billCounter = new BillCounter();

        // Infinite loop for user interaction
        while (true) {
            try {
                // Prompting user to select role and enter password
                System.out.println("Select Your Role: (Choose a number)\n 1)Admin\t 2)BillCounterGuy");
                billCounter.role = sc.nextInt();
                sc.nextLine(); // Consume newline
                System.out.println("Please Enter Your Password:\n");
                int password = sc.nextInt();
                sc.nextLine(); // Consume newline
                billCounter.verifyLoginDetails(password);

                // Admin operations
                while (billCounter.role == 1) {
                    try {
                        billCounter.adminOperations();
                    } catch (Exception e) {
                        // Handling invalid input for admin operations
                        System.out.println("Retry! Please enter a valid input." + e.getMessage() + "\n");
                    }
                }

                // Bill counter guy operations
                while (billCounter.role == 2) {
                    try {
                        billCounter.billCounterGuyOperations();
                    } catch (Exception e) {
                        // Handling invalid input for bill counter guy operations
                        System.out.println("Retry! Please enter a valid input." + e.getMessage() + "\n");
                    }
                }
            } catch (Exception e) {
                // Handling invalid input for main menu
                System.out.println("Retry! Please enter a valid input." + e.getMessage() + "\n");
                sc.nextLine(); // Consume invalid input
            }
        }
    }
}
