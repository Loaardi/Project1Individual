public class WishlistItem {
  private String productName;
  private int quantity;
  public WishlistItem(String productName, int quantity) {
    this.productName = productName;
    this.quantity = quantity;
  }
  public String toString() {
    return productName + " x" + quantity;
  }
}