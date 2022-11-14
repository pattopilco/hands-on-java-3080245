package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSource {

  private static Connection connect() {
    String db_file = "jdbc:sqlite:resources/bank.db";
    Connection connection = null;

    try {
      connection = DriverManager.getConnection(db_file);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }

  public static Customer getCustomer(String username) {
    String sql = "select * from customers where username = ?";
    Customer customer = null;
    try (
        Connection connection = connect();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setString(1, username);
      try (ResultSet resultSet = statement.executeQuery()) {

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(resultSet.getInt("ACCOUNT_ID"));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
        customer = new Customer(resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("username"),
            resultSet.getString("password"),
            resultSet.getInt("ACCOUNT_ID"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return customer;
  }

  public static Account geAccount(int accountId) {
    String sql = "select * from accounts where id = ?";
    Account account = null;
    try (
        Connection connection = connect();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setInt(1, accountId);

      try (ResultSet resulset = statement.executeQuery()) {
        account = new Account(resulset.getInt("id"),
            resulset.getString("type"),
            resulset.getDouble("balance"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return account;
  }

  public static void updateAccountBalance(int accountId, double balance) {
    String sql = "update accounts set balance = ? where id = ?";

    try (
        Connection connection = connect();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setInt(1, accountId);
      statement.setDouble(1, balance);

      statement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
}
