
public class Client {
  private String name;
  private String address;
  public Client(String name, String address) {
    this.name = name;
    this.address = address;
  }
  public String toString() {
    return "Client: " + name + ", " + address;
  }
}