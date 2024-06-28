package cn.lemonnetwork.catpixellobby.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
  String ip;
  
  String port;
  
  String user;
  
  String password;
  
  String database;
  
  Connection connection;
  
  public Connection getConnection() {
    return this.connection;
  }
  
  public DataBase(String ip, String port, String user, String password, String database) {
    this.ip = ip;
    this.port = port;
    this.user = user;
    this.password = password;
    this.database = database;
    connect();
  }
  
  public void connect() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      this
        .connection = DriverManager.getConnection("jdbc:mysql://" + this.ip + ":" + this.port + "/" + this.database + "?autoReconnect=true", this.user, this.password);
    } catch (SQLException|ClassNotFoundException sQLException) {}
  }
  
  public void disconnect() {
    try {
      this.connection.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } 
  }
}
