import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
  private final String JDBC_DRIVER = "org.postgresql.Driver";

  private Connection _connection;

  private String _host;
  private String _port;
  private String _username;
  private String _password;
  private String _databaseName;
  private String _connectionString;
  private Statement _statement;

  // Atribui as propriedades da classe
  public ConnectionFactory(
    String host, 
    String port, 
    String username, 
    String password, 
    String databaseName
  ) {
    _host = host;
    _port = port;
    _username = username;
    _password = password;
    _databaseName = databaseName;

    _connectionString = "jdbc:postgresql://" + _host + ":" + _port + "/" + _databaseName;
  }

  // Abre a conexão com o banco
  public ConnectionFactory connect() {
    try {
      Class.forName(JDBC_DRIVER);

      _connection = DriverManager.getConnection(
        _connectionString, 
        _username,
        _password
      );
      
      _statement = _connection.createStatement();
    } catch (Exception exception) {
      System.err.println(exception);
      exception.printStackTrace();
    }

    return this;
  }

  // Fecha a conexão com o banco
  public void disconnect() {
    try {
      _connection.close();
    } catch (SQLException exception) {
      System.err.println(exception);
      exception.printStackTrace();
    }
  }

  // Executa queries sem retorno
  public ConnectionFactory runQuery(String query) {
    try {
      _statement.execute(query);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }

    return this;
  }

  // Executa queries com retorno
  public ResultSet executeQuery(String query) {
    try {
      return _statement.executeQuery(query);
    } catch (SQLException ex) {
      ex.printStackTrace();
      return null;
    }
  }
}
