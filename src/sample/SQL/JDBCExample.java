package sample.SQL;

import java.sql.*;

public class JDBCExample extends Configs {
    public static void main(String args[]) throws SQLException {
        /* Объявление используемого типа драйвера Oracle */
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        /* Создание соединения с базой данных для программы JDBC */
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:newlab", "hr", "hr");
        Statement stmt = conn.createStatement();
        /* Передача запроса SQL и сохранение результатов в результирующем наборе rs */
        ResultSet rs = stmt.executeQuery("select EMPLOYEE_ID, FIRST_NAME, salary from employees");
        /* Доступ к содержимому результирующего набора rs по строкам в цикле while */
        while (rs.next()) {
            int number = rs.getInt(1);
            String name = rs.getString(2);
            double salary = rs.getDouble(3);
            System.out.println(number + " " + name + " " + salary);
        }
        /* Закрытие результирующего набора JDBC и соединения с базой данных */
        rs.close();
        conn.close();
    }
}
