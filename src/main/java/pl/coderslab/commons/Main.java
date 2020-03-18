package pl.coderslab.commons;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try (Connection connection = DbUtil.getConnection()) {
            System.out.println("do something");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }
}
