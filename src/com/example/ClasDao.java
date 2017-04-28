package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MattyG on 4/27/17.
 */
public class ClasDao {


    public static void insertClass(Clas clas, Connection conn) throws SQLException {
        PreparedStatement pStmt;
        String createClasString = "INSERT INTO clas (name) VALUES (?)";

        pStmt = conn.prepareStatement(createClasString);
        pStmt.setString(1, clas.getName());
        pStmt.executeUpdate();

    }
    // #4 listAll clases
    public static List<Clas> selectClases(Connection conn) throws SQLException {
        List<Clas> clases = new ArrayList<>();
        PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM clas");
        ResultSet resultSet = pStmt.executeQuery();

        while (resultSet.next()) {
            Clas clas = new Clas();
            int id = resultSet.getInt("id");
            clas.setId(id);
            String name = resultSet.getString("name");
            clas.setName(name);
            clases.add(clas);
        }
        return clases;
    }


}
