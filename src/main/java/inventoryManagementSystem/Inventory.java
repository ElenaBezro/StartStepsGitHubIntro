package inventoryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Inventory <T extends Item> {
    private List<T> itemList;

    public Inventory() {
        itemList = new ArrayList<>();
    }

    public void addItem(T item) throws ItemNotFoundException {
        if (item == null) {
            throw new ItemNotFoundException("Item not found");
        }
        itemList.add(item);
    }

    public T getItemById(String id) {
        for (T item: itemList) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public void removeItem(String id) throws ItemNotFoundException {
        Item itemToRemove = getItemById(id);

        if (itemToRemove == null) {
            throw new ItemNotFoundException(String.format("Item with id: %s not found", id));
        }
        itemList.remove(itemToRemove);
    }
    public void decreaseQuantity(String id, int quantityToRemove) throws InsufficientStockException, ItemNotFoundException {
        boolean isItemInStock = false;
        for (Item item: itemList) {
            if (item.getId().equals(id)) {
                if (item.getQuantity() < quantityToRemove) {
                        throw new InsufficientStockException(String.format("Not enough %s in stock.", id));
                    }
                int newQuantity = item.getQuantity() - quantityToRemove;
                item.setQuantity(newQuantity);
                isItemInStock = true;
            }
        }
        if (!isItemInStock) {
            throw new ItemNotFoundException(String.format("Item with id: %s not found", id));
        }
    }

    public static void main(String[] args) {
        FoodItem foodItem = new FoodItem();
        FoodItem foodItem2 = null;
        foodItem.setName("Apple");
        foodItem.setId("Apple");
        foodItem.setQuantity(100);

        ElectronicsItem electronicsItem = new ElectronicsItem();
        electronicsItem.setName("Mobile Phone");
        electronicsItem.setId("MobilePhone");
        electronicsItem.setQuantity(200);

        Inventory<FoodItem> inventory = new Inventory<>();
        Inventory<ElectronicsItem> inventory2 = new Inventory<>();
        try {
            inventory.addItem(foodItem);
            inventory.addItem(foodItem2);
            inventory2.addItem(electronicsItem);
        }
        catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            inventory.removeItem("Banana");
        }
        catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            inventory.decreaseQuantity("Apple", 500);
        }
        catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (InsufficientStockException e) {
            System.out.println(e.getMessage());
        }
    }
}
