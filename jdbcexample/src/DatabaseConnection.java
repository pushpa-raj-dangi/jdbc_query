import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.*;

public class DatabaseConnection {
    private static Connection con = null;

    static {
        String url = "jdbc:mysql://localhost:3306/students";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("driver loaded");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {
        return con;
    }

    public void showData() throws SQLException {
        String query = "SELECT * FROM STUDENT";
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery(query);

        while (rs.next()) {
            System.out.print(rs.getString("id") + "\t\t");
            System.out.print(rs.getString("name") + "\t\t\t\t\t\t\t\t");
            System.out.println(rs.getString("address"));
        }

    }

    public void updateData(String name, int id) throws SQLException {

        String query = "UPDATE STUDENT SET name=? where id=?";
        PreparedStatement stm = con.prepareStatement(query);
        stm.setInt(2, id);
        stm.setString(1, name);
        int i = stm.executeUpdate();
        System.out.println("Data updated success fully" + i);

    }

    public void insertData(int id, String name, String address) throws SQLException {
        String query = "INSERT INTO student VALUES(?,?,?)";
        PreparedStatement stm = con.prepareStatement(query);
        stm.setInt(1, id);
        stm.setString(2, name);
        stm.setString(3, address);
        int i = stm.executeUpdate();
        System.out.println("Insert data  successfully" + i);

    }

    public void deleteData(int id) throws SQLException {
        String query = "DELTE FROM student WHERE id=?";
        PreparedStatement stm = con.prepareStatement(query);

        stm.setInt(1, id);

        int i = stm.executeUpdate();
        System.out.println("Data delete  successfully" + i);

    }

}
