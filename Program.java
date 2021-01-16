import java.sql.SQLException;

public class Program {
  public static void main(String[] args) throws SQLException {
    var dbFactory = new ConnectionFactory(
      "127.0.0.1", 
      "5432", 
      "postgres", 
      "DockerPostgres127!", 
      "db_java"
    ); 

    CreateExampleTable.Run(dbFactory);

    var resultSet = dbFactory
      .connect()
      .executeQuery("select * from users");
      
    dbFactory.disconnect();

    while (resultSet.next())
      System.out.println(resultSet.getString("name"));
  }
}
