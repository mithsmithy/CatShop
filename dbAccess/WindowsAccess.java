package dbAccess;

/**
  * Implements management of a Microsoft Access database.
  * @author  Mike Smith University of Brighton
  * @version 2.0
  */
class WindowsAccess extends DBAccess
{
  @Override
public void loadDriver() throws Exception
  {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  }

  @Override
public String urlOfDatabase()
  {
    return "jdbc:odbc:cshop";
  }
}
