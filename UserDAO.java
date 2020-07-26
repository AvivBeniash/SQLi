package server;

import db.connect.DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

        public User checkLogin(String email, String password, boolean isVulnerable)
                throws SQLException{
            User user = null;

            DataBase db = new DataBase();
            String sql;

            if (isVulnerable){
                sql = "SELECT * FROM users WHERE email = " + "\"" + email + "\"" +
                        " and password = " + "\"" + password + "\"";
                ResultSet result = db.select(sql);

                if (result.next()) {
                    user = new User();
                    user.setFullname(result.getString("fullname"));
                    user.setEmail(email);
                }
            }
            else{ //NotVulnerable
                sql = "SELECT * FROM users WHERE email = ? and password = ?";
                ResultSet result = db.StatementExec(sql, new String[]{email, password});

                if (result.next()) {
                    user = new User();
                    user.setFullname(result.getString("fullname"));
                    user.setEmail(email);
                }
            }
            db.close();
            return user;
        }
}
