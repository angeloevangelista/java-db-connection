import java.util.ArrayList;

public class CreateExampleTable {
  public static void Run(ConnectionFactory connectionFactory) {
    String createTableQuery = "";
    createTableQuery += "create table if not exists users(";
    createTableQuery += "  id integer primary key generated always as identity,";
    createTableQuery += "  name varchar(50) not null";
    createTableQuery += ")";

    var usernames = new ArrayList<String>();
    usernames.add("Angelo");
    usernames.add("Andre");
    usernames.add("Anna");
    usernames.add("Fernanda");

    String insertUsersQuery = "";
    insertUsersQuery += "insert into users (name)";
    insertUsersQuery += "values";

    for (int i = 0; i < usernames.size(); i++) {
      insertUsersQuery += "('" + usernames.get(i) + "')";

      if (i != usernames.size() - 1)
        insertUsersQuery += ",";
    }

    connectionFactory
      .connect()
      .runQuery(createTableQuery)
      .runQuery(insertUsersQuery)
      .disconnect();
  }
}
