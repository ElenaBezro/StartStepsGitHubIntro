package inventoryManagementSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    private Inventory<Item> inventory;

@BeforeEach
    void setUp() {
        inventory = new Inventory<>();
        var item = new Item();
        item.setId("AppleId");
        item.setName("Apple");
        item.setQuantity(100);
    }

        @Test
        @DisplayName("Test ItemNotFoundException while adding empty item")
        void testAddEmptyItemExeption() {
            ItemNotFoundException thrown = assertThrows(ItemNotFoundException.class, () -> {
                var inventory = new Inventory<Item>();
                inventory.addItem(null);
            } );
            assertEquals("Item not found", thrown.getMessage());
        }

    @Test
    @DisplayName("Test adding an Item to Inventory list")
    void addItem_itemExist() throws ItemNotFoundException {
        //Arrange
        var item = new Item();
        item.setId("AppleId");
        item.setName("Apple");
        item.setQuantity(100);
        //Act
        inventory.addItem(item);
        //Assert
        assertSame(item, inventory.getItemById("AppleId"));
        assertEquals("AppleId", inventory.getItemById("AppleId").getId());
    }

    @Test
    @DisplayName("Test getting an existing Item by id")
    void getItemById_itemExist() throws ItemNotFoundException {
            //Arrange
        var item = new Item();
        item.setId("AppleId");
        item.setName("Apple");
        item.setQuantity(100);
        inventory.addItem(item);
        //Act
        var itemById = inventory.getItemById("AppleId");
        //Assert
        assertNotNull(itemById);
        assertEquals("AppleId", itemById.getId());
        assertEquals("Apple", itemById.getName());
        assertEquals(100, itemById.getQuantity());
    }

    @Test
    @DisplayName("Test getting an unexisting Item by id")
    void getItemById_itemDoesNotExist() throws ItemNotFoundException {
            //Arrange
        //Act
        var itemById = inventory.getItemById("OrangeId");
        //Assert
        assertNull(itemById);
    }

    @Test
    @DisplayName("Test removing an Item from Inventory list")
    void removeItem_itemExist() throws ItemNotFoundException {
            //Arrange
        var item = new Item();
        item.setId("AppleId");
        item.setName("Apple");
        item.setQuantity(100);
        inventory.addItem(item);
        //Act
        assertDoesNotThrow(() -> inventory.removeItem("AppleId"));
        //Assert
        assertNull(inventory.getItemById("AppleId"));
    }

    @Test
    @DisplayName("Test ItemNotFoundException")
    void testRemoveNullException() {
        ItemNotFoundException thrown = assertThrows(ItemNotFoundException.class, () -> {
            var inventory = new Inventory<Item>();
            inventory.removeItem("DoesNotExist");
        } );
        assertEquals("Item with id: DoesNotExist not found", thrown.getMessage());
    }

    @Test
    @DisplayName("Test decreasing quantity of the existing item with suffitient quantity")
    void decreaseQuantity_itemExist_enoughQuantity() throws ItemNotFoundException {
    //Arrange
        var item = new Item();
        item.setId("AppleId");
        item.setName("Apple");
        item.setQuantity(100);
        inventory.addItem(item);
    }

}