package by.academy.it;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class MainHomeWorkTask4 {


    private static Logger log = Logger.getLogger(MainHomeWorkTask4.class.getName());
    static String url = "jdbc:mysql://localhost:3306/homeWorkTask4";
    static Properties properties = new Properties();

    static {
        properties.put("user", "root");
        properties.put("password", "root");
        properties.put("useSSL", "false");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {

            Connection connection = DriverManager.getConnection(url, properties);
            log.info("Is connected: " + !connection.isClosed());

            //Task4
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO expenses (num, payday, receiver, value) VALUES (1, '2011-05-11', 1, 20000)");
            statement.executeUpdate("INSERT INTO expenses (num, payday, receiver, value) VALUES (2, '2011-05-11', 2, 94200)");
            statement.executeUpdate("INSERT INTO expenses (num, payday, receiver, value) VALUES (3, '2011-05-11', 3, 10000)");
            statement.executeUpdate("INSERT INTO expenses (num, payday, receiver, value) VALUES (4, '2011-05-11', 2, 12950)");


            //Task5
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO expenses  VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1,5);
            preparedStatement.setDate(2, Date.valueOf("2011-05-11"));
            preparedStatement.setInt(3,1);
            preparedStatement.setDouble(4,20000);
            preparedStatement.executeUpdate();

            String querySelectAll = "SELECT * FROM homeWorkTask4.expenses"; // получение данных из БД
            ResultSet resultSet = statement.executeQuery(querySelectAll);
            System.out.println(resultSet);

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getDate(2));
                System.out.println(resultSet.getInt(3));
                System.out.println(resultSet.getDouble(4));
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            log.info("Finished");

        }
    }
}
