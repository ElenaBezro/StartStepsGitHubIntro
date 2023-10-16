package inventoryManagementSystem;
//Create a class Item with fields like id, name, and quantity.
//Create a class Inventory which holds a list of items.
//Implement methods for adding and removing items.
//Use custom exceptions to handle cases like "Item not found" or "Not enough items in stock."
public class Item {
    private String id;
    private String name;
    private int quantity;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
