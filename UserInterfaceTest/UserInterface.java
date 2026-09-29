import java.util.*;
import java.io.*;

public class UserInterface {

  public static String getToken(String prompt) {
    do {
      try {
        System.out.println(prompt);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line, "\n\r\f");
        if (tokenizer.hasMoreTokens()) {
          return tokenizer.nextToken();
        }
      } catch (IOException ioe) {
        System.exit(0);
      }
    } while (true);
  }

  public void addClient() {
    String name = getToken("Enter client name:");
    String address = getToken("Enter client address:");
    Client client = Warehouse.instance().addClient(name, address);
    System.out.println("Added: " + client);
  }

  public void addProduct() {
    String name = getToken("Enter product name:");
    int quantity = Integer.parseInt(getToken("Enter quantity:"));
    double price = Double.parseDouble(getToken("Enter unit price:"));
    Product product = Warehouse.instance().addProduct(name, quantity, price);
    System.out.println("Added: " + product);
  }

  public void displayAllClients() {
    Iterator<Client> clients = Warehouse.instance().getClients();
    while (clients.hasNext()) {
      System.out.println(clients.next());
    }
  }

  public void displayAllProducts() {
    Iterator<Product> products = Warehouse.instance().getProducts();
    while (products.hasNext()) {
      System.out.println(products.next());
    }
  }

  public void addToWishlist() {
    String clientID = getToken("Enter client ID:");
    String productID = getToken("Enter product ID:");
    int quantity = Integer.parseInt(getToken("Enter quantity:"));
    boolean success = Warehouse.instance().addToWishlist(clientID, productID, quantity);
    System.out.println("Added to wishlist: " + success);
  }

  public void displayClientWishlist() {
    String clientID = getToken("Enter client ID:");
    Iterator<WishlistItem> items = Warehouse.instance().getClientWishlist(clientID);
    while (items.hasNext()) {
      System.out.println(items.next());
    }
  }

  public static void main(String[] args) {
    UserInterface ui = new UserInterface();
    ui.addClient();
    ui.addProduct();
    ui.displayAllClients();
    ui.displayAllProducts();
    ui.addToWishlist();
    ui.displayClientWishlist();
  }
}