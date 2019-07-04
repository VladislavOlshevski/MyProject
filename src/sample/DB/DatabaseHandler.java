package sample.DB;

import sample.Part;
import sample.SQL.Configs;
import sample.SQL.Const;
import sample.Users;

import java.sql.*;


public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectinString = "jdbc:oracle:thin:@" + dbHost + ":" + dbPort + ":" + dbName;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        dbConnection = DriverManager.getConnection(connectinString, dbUser, dbPass);
        return dbConnection;
    }

    public void signUpUser(Users user) {
        String insert = "INSERT INTO " + Const.USERS_TABLE + "(" + Const.USERS_NAME + "," + Const.USERS_PASS + " ) " + "VALUES( ? , ? )";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getUserName());
            prSt.setString(2, user.getUserPass());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ResultSet dbPart(Part part) {
        String insert = "INSERT INTO " + Const.PARTS + "(" + Const.PARTID + "," + Const.ARTICLE + "," + Const.NAMEARTICLE + "," + Const.STOCK + " ) " + "VALUES( ? , ? , ? , ?)";
        try {
            PreparedStatement partsDb = getDbConnection().prepareStatement(insert);
            partsDb.setString(1, part.getIdPart());
            partsDb.setString(2, part.getIdArticle());
            partsDb.setString(3, part.getIdName());
            partsDb.setString(4, part.getIdStock());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getUser(Users user) {
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.USERS_TABLE + " WHERE " + Const.USERS_NAME + "= ? AND " + Const.USERS_PASS + "= ? ";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUserName());
            prSt.setString(2, user.getUserPass());
            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }


}
