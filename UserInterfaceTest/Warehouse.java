import java.util.*;

public class Warehouse {
  private static Warehouse warehouse;
  private Warehouse() {}
  public static Warehouse instance() {
    if (warehouse == null) {
      warehouse = new Warehouse();
    }
    return warehouse;
  }
  public Client addClient(String name, String address) {
    return new Client(name, address);
  }
  public Product addProduct(String name, int quantity, double price) {
    return new Product(name, quantity, price);
  }
  public Iterator<Client> getClients() {
    List<Client> list = new LinkedList<Client>();
    list.add(new Client("Dummy Client", "123 Fake St"));
    return list.iterator();
  }
  public Iterator<Product> getProducts() {
    List<Product> list = new LinkedList<Product>();
    list.add(new Product("Dummy Product", 5, 9.99));
    return list.iterator();
  }
  public boolean addToWishlist(String clientID, String productID, int quantity) {
    return true;
  }
  public Iterator<WishlistItem> getClientWishlist(String clientID) {
    List<WishlistItem> list = new LinkedList<WishlistItem>();
    list.add(new WishlistItem("Dummy Product", 2));
    return list.iterator();
  }
}