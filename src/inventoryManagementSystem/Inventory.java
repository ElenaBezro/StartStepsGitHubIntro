package inventoryManagementSystem;

import java.util.List;

public class Inventory {
    List<Item> itemList;

    public void addItem(Item item) throws ItemNotFoundException {
        if (item == null) {
            throw new ItemNotFoundException("Item not found");
        }
        itemList.add(item);
    }

    public Item getItemById(String id) {
        for (Item item: itemList) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public void removeItem(String id) throws InsufficientStockException {
        Item itemToRemove = getItemById(id);

        if (itemToRemove == null) {
            throw new InsufficientStockException("Not in stock.");
        }
        itemList.remove(itemToRemove);
    }
    public void decreaseQuantity(String id, int quantityToRemove) throws InsufficientStockException {
        for (Item item: itemList) {
            if (item.getId().equals(id)) {
                if (item.getQuantity() < quantityToRemove) {
                        throw new InsufficientStockException("Not enough items in stock.");
                    }
                int newQuantity = item.getQuantity() - quantityToRemove;
                item.setQuantity(newQuantity);
            }
        }
    }
}
