import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RowSetExample {
    Connection con;
    Statement stmt;
    int count = 0;
    ResultSet rs;

    public RowSetExample() {
        System.out.println("connectingg...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students?allowMultiQueries=true", "root",
                    "");
            stmt = (Statement) con.createStatement();
            String sql = "select * from student where id > 1; select * from student where id < 10 ; select * from student where name like 'p%'";
            boolean result = stmt.execute(sql);

            do {
                if (result) {
                    rs = ((java.sql.Statement) stmt).getResultSet();
                    count++;
                    System.out.println("resut of query " + count);
                    while (rs.next()) {
                        int rm = rs.getInt("id");
                        String name = rs.getString("name");
                        String addr = rs.getString("address");
                        System.out.println("{ id :" + rm + "}\t\t{ name : " + name + "}\t\t{ address :" + addr + "}");
                    }
                }
                rs.close();
                result = stmt.getMoreResults();
            } while (result);
            stmt.close();
            con.close();

        } catch (Exception ex) {

        }
    }

}
