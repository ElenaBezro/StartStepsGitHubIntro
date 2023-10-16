package inventoryManagementSystem;

public class InsufficientStockException extends Exception{
    public InsufficientStockException(String message) {
        super(message);
    }
}
