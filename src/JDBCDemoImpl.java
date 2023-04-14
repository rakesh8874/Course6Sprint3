import java.sql.*;

public class JDBCDemoImpl {
    Connection connect;
    JDBCDemoImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Rakesh@2022");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public int validateUser(String userName){
        int found = 0;
        try {
            String sql = "select * from Users";
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String name = resultSet.getString(1);
                if(userName.equals(name)){
                    found = 1;
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return found;
        }
    void insertData(String userName, String userPass){
        int exist = validateUser(userName);
        if(exist==1){
            System.out.println("User is Already Exist Can't register Again");
        }else {
            try {
                String sql = "insert into Users values(?,?)";
                PreparedStatement statement = connect.prepareStatement(sql);
                statement.setString(1, userName);
                statement.setString(2, userPass);
                statement.executeUpdate();

                System.out.println("Record Inserted");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    void showAll() {
        try {
            String sql = "select * from Users";
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
               System.out.format("%-10s %-5s %n",resultSet.getString(1),resultSet.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
        void showDept (String occ){
            try {
                String sql = "select * from parent where p_occ = ?";
                PreparedStatement statement = connect.prepareStatement(sql);
                statement.setString(1, occ);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                  //  System.out.println(resultSet.getString(2) + "   " + resultSet.getString(3));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
          }

    }
