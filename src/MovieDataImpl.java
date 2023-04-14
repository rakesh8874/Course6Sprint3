import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MovieDataImpl {
    public Connection createConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MovieDatabase", "root", "Rakesh@2022");
            System.out.println("Connection Establish");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
        }
        public boolean createTable(){
        Connection connection = createConnection();
        boolean flag = false;
        try {
            Statement st = connection.createStatement();
            flag = st.execute("create table if not exists movietable1(title varchar(30), budgetInMillion int,releaseDate varchar(30),revenuesInMillions int, ratingAvg float)");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return flag;
        }
        public String insertIntoTable(){
        Connection connection = createConnection();
        int row = 0;
        try {
            Statement st = connection.createStatement();
            row = st.executeUpdate("insert into movietable1 values('Avtaar',237,'10-12-2009',278,7.2)");
            row = st.executeUpdate("insert into movietable1 values('Titanic',200,'18-11-1997',185,7.5)");
            row = st.executeUpdate("insert into movietable1 values('The Avengers',220,'25-04-2012',152,7.4)");
            row = st.executeUpdate("insert into movietable1 values('Jurassic World',150,'09-06-2015',151,6.5)");
            row = st.executeUpdate("insert into movietable1 values('Furious 7',190,'01-04-2015',150,7.3)");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        if(row == 1)
            return "Record Inserted";
        else
            return "Record Not Inserted";
        }
        public List<MovieData> showDetails() {
           List<MovieData> list = new ArrayList<>();
            Connection connect = createConnection();
            try {
                Statement st = connect.createStatement();
                ResultSet resultSet = st.executeQuery("select * from movietable1");
                MovieData movieData;
                while (resultSet.next()) {
                    String title = resultSet.getString(1);
                    int rec = resultSet.getInt(2);
                    String res = resultSet.getString(3);
                    int rec1 = resultSet.getInt(4);
                    float rec2 = resultSet.getFloat(5);
                    movieData = new MovieData(title,rec,res,rec1,rec2);
                    list.add(movieData);
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
            return list;
        }
        public static void main(String[] args) {
        MovieDataImpl movie = new MovieDataImpl();
        List <MovieData> list1 = new ArrayList<>();
        movie.createConnection();
            //System.out.println(movie.createTable());
           // System.out.println(movie.insertIntoTable());
            list1 = movie.showDetails();
            for(MovieData movie1:list1)
                System.out.println(movie1);
        }
}
