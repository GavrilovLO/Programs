//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class JDBCPostgreSQLExample {

    //  Database credentials
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "fushse";
    static Connection connection = null;

    public  JDBCPostgreSQLExample() {

        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
        }

       public static void InsertDataCustomer(int id, String name) throws SQLException {
        System.out.println("Insert data");
        PreparedStatement insertStatement = connection
                .prepareStatement("INSERT INTO sale (id,name) VALUES (?,?);");
        insertStatement.setInt(1, id);
        insertStatement.setString(2,name);
        insertStatement.executeUpdate();
    }

    public static void ReadDataCustomer(ArrayList<Customer> todos) throws SQLException {//работает
        System.out.println("Read data");
        PreparedStatement readStatement = connection.prepareStatement("SELECT * FROM sale;");
        ResultSet resultSet = readStatement.executeQuery();
        while (resultSet.next()){
            Customer todo1 = new Customer();
            todo1.setCode_customer(resultSet.getInt("id"));
            todo1.setName(resultSet.getString("name"));
            todos.add(todo1);
            System.out.println("Data read from the database: " + todo1.toString());
        }
        System.out.println("There is no data in the database!");
    }

    public static void UpdateDataCustomer(String name,int id) throws SQLException {//работает
        System.out.println("Update data");
        PreparedStatement updateStatement=connection.prepareStatement("UPDATE sale SET name = ? WHERE id = ?;");
        updateStatement.setString(1,name);
        updateStatement.setInt(2,id);
        updateStatement.executeUpdate();
    }

    public static void DeleteDataCustomer(int id)throws SQLException{
        System.out.println("Delete data");
        PreparedStatement DeleteStatement=connection.prepareStatement("DELETE FROM sale WHERE id = ?;");
        DeleteStatement.setInt(1,id);
        DeleteStatement.executeUpdate();
    }

    public static void Procedure(String name)throws SQLException{
        PreparedStatement ProcedureStatement=connection.prepareStatement("CALL transfer(CAST('?' AS character varying[50]));");
        ProcedureStatement.setString(1,name);
        ProcedureStatement.executeUpdate();
    }

    public static void InsertDataOrder(String paymentType, java.sql.Date date,int cost) throws SQLException {
        System.out.println("Insert data");
        PreparedStatement insertStatement = connection
                .prepareStatement("INSERT INTO Order (Payment_type,Date,Cost) VALUES (?,?,?);");
        insertStatement.setString(1,paymentType);
        insertStatement.setDate(2,date);
        insertStatement.setInt(3,cost);
        insertStatement.executeUpdate();
    }

    public static void ReadDataOrder(ArrayList<Order> todos) throws SQLException {//работает
        System.out.println("Read data");
        PreparedStatement readStatement = connection.prepareStatement("SELECT * FROM Order;");
        ResultSet resultSet = readStatement.executeQuery();
        while (resultSet.next()){
            Order todo1 = new Order();
            todo1.setCode_customer(resultSet.getInt("Code_customer"));
            todo1.setPaymentType(resultSet.getString("Payment_type"));
            todo1.setDate(resultSet.getDate("Date"));
            todo1.setCost(resultSet.getInt("cost"));
            todos.add(todo1);
            System.out.println("Data read from the database: " + todo1.toString());
        }
        System.out.println("There is no data in the database!");
    }

    public static void UpdateDataOrder(int id,int cost) throws SQLException {//работает
        System.out.println("Update data");
        PreparedStatement updateStatement=connection.prepareStatement("UPDATE Order SET cost = ? WHERE id = ?;");
        updateStatement.setInt(1,cost);
        updateStatement.setInt(2,id);
        updateStatement.executeUpdate();
    }

    public static void DeleteDataOrder(int id)throws SQLException{
        System.out.println("Delete data");
        PreparedStatement DeleteStatement=connection.prepareStatement("DELETE FROM Order WHERE id = ?;");
        DeleteStatement.setInt(1,id);
        DeleteStatement.executeUpdate();
    }


    public static void InsertDataGood(String description, String delivery,int price,String typeOfGood, int number) throws SQLException {
        System.out.println("Insert data");
        PreparedStatement insertStatement = connection
                .prepareStatement("INSERT INTO Good (description,delivery,price,typeOfGood,number) VALUES (?,?,?,?,?);");
        insertStatement.setString(1,description);
        insertStatement.setString(2,delivery);
        insertStatement.setInt(3,price);
        insertStatement.setString(4,typeOfGood);
        insertStatement.setInt(5,number);
        insertStatement.executeUpdate();
    }

    public static void ReadDataGood(ArrayList<Good> todos) throws SQLException {//работает
        System.out.println("Read data");
        PreparedStatement readStatement = connection.prepareStatement("SELECT * FROM Good;");
        ResultSet resultSet = readStatement.executeQuery();
        while (resultSet.next()){
            Good todo1 = new Good();
            todo1.setCode_representative(resultSet.getInt("Code_representative"));
            todo1.setDescription(resultSet.getString("description"));
            todo1.setDelivery(resultSet.getString("delivery"));
            todo1.setPrice(resultSet.getInt("price"));
            todo1.setTypeOfGood(resultSet.getString("typeOfGood"));
            todo1.setNumber(resultSet.getInt("number"));
            todos.add(todo1);
            System.out.println("Data read from the database: " + todo1.toString());
        }
        System.out.println("There is no data in the database!");
    }

    public static void UpdateDataGood(int id,int price) throws SQLException {//работает
        System.out.println("Update data");
        PreparedStatement updateStatement=connection.prepareStatement("UPDATE Good SET price = ? WHERE id = ?;");
        updateStatement.setInt(1,price);
        updateStatement.setInt(2,id);
        updateStatement.executeUpdate();
    }

    public static void DeleteDataGood(int id)throws SQLException{
        System.out.println("Delete data");
        PreparedStatement DeleteStatement=connection.prepareStatement("DELETE FROM Good WHERE id = ?;");
        DeleteStatement.setInt(1,id);
        DeleteStatement.executeUpdate();
    }



}