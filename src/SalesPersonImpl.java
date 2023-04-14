import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SalesPersonImpl {
    private Connection connectToDatabase(){
        Connection connect = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/CarSalesData","root","Rakesh@2022");
            if(connect != null)
                System.out.println("Connection Established");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return connect;
        }
        public boolean createTable(){
        Connection connect = connectToDatabase();
        boolean flag = false;
        try {
             Statement  st = connect.createStatement();
              flag =  st.execute("create table if not exists salesperson1(SalesPersonId int, SalesPersonName varchar(30),city varchar(20),commission float)");
            }catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return flag;
            }
            public String insetIntoTable(){
                  Connection connection = connectToDatabase();
                  int rowInserted = 0;
                try {
                  Statement st = connection.createStatement();
                  rowInserted = st.executeUpdate("insert into salesperson1 values(1002,'Sam','Stockholm',25.0)");
                    rowInserted = st.executeUpdate("insert into salesperson1 values(1003,'Dave','Rome',12.0)");
                    rowInserted = st.executeUpdate("insert into salesperson1 values(1004,'Gary','Stockholm',13.5)");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if(rowInserted == 1)
                    return "Record Inserted";
                    else
                        return "Record Not Inserted";
            }
            public List<SalesPerson> fetchAllData(){
              List<SalesPerson> salesPersonList = new ArrayList<>();
              try {
                  Connection connection = connectToDatabase();
                  Statement st = connection.createStatement();
                  ResultSet resultSet = st.executeQuery("select * from salesperson1");
                  SalesPerson salesPerson = null;
                  while (resultSet.next()) {
                      int id = resultSet.getInt(1);
                      String name = resultSet.getString(2);
                      String city = resultSet.getString(3);
                      float com = resultSet.getFloat(4);
                      salesPerson = new SalesPerson(id, name, city, com);
                      salesPersonList.add(salesPerson);
                  }
              }catch(SQLException e){
                  System.out.println(e.getMessage());
              }
              return salesPersonList;
              }
            public static void main(String[] args) {
                  SalesPersonImpl sales = new SalesPersonImpl();
                  List <SalesPerson> list = new ArrayList<>();
                 // boolean isFound = sales.createTable();
                //  System.out.println(isFound);
             //   System.out.println(sales.insetIntoTable());
                list = sales.fetchAllData();
                for(SalesPerson person:list)
                    System.out.println(person);
    }
}
