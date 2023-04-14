import java.net.ConnectException;
import java.sql.*;

public class JDBCDemo{
    public static void main(String[] args) {
     JDBCDemoImpl demo = new JDBCDemoImpl();
     // demo.showDept("GovtJob");
   //  demo.insertData("Victor","Victor@123");
     demo.showAll();
    }
}