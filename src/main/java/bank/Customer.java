package bank;

public class Customer {

  private int id;
  private String name;
  private String username;
  private String password;
  private String accountId;

  public Customer(int id, String name, String username, String password, String accountId) {
    setId(id);
    setName(username);
    setUsername(username);
    setPassword(password);
    setAccountId(accountId);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

}
