package bank;

public class Account {

  private int id;
  private String type;
  private String balance;

  public Account(int id, String type, String balance) {
    setId(id);
    setType(type);
    setBalance(balance);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getBalance() {
    return balance;
  }

  public void setBalance(String balance) {
    this.balance = balance;
  }

}
