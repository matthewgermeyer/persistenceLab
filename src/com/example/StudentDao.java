package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public static void insertStudent(Student student, Connection conn) throws SQLException {

        PreparedStatement pStmt;
        String createStudentString = "INSERT INTO student (name) VALUES (?)";

        pStmt = conn.prepareStatement(createStudentString);
        pStmt.setString(1, student.getName());
        pStmt.executeUpdate();

    }
    //# 3
    public static List<Student> selectAllStudents(Connection conn) throws SQLException {
        List<Student> students = new ArrayList<>();
        PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM student");
        ResultSet resultSet = pStmt.executeQuery();

        while (resultSet.next()) {
            Student student = new Student();
            int id = resultSet.getInt("id");
            student.setId(id);
            String name = resultSet.getString("name");
            student.setName(name);
            students.add(student);
        }
        return students;
    }
    //#5        SelectStudentsInClas
    public static List<Student> selectStudentsInClas (Connection conn, int useThis) throws SQLException {
        List<Student> students = new ArrayList<>();
        int fillIn = useThis;
        PreparedStatement pStmt = conn.prepareStatement(" select s.* from student s, roster r where r.class_id = ? and r.student_id = s.id ;");

        pStmt.setInt(1, fillIn);

        ResultSet resultSet = pStmt.executeQuery();

        while (resultSet.next()) {
            Student student = new Student();
            int id = resultSet.getInt("id");
            student.setId(id);
            String name = resultSet.getString("name");
            student.setName(name);
            students.add(student);
        }
        return students;
    }

    //# 6   Select students' Classes
    public static List<Clas> selectStudentsClases (int class_id, Connection conn) throws SQLException {
        List<Clas> clases = new ArrayList<>();

        String sql = " select c.* from roster r student s where r.class_id = ? and r.student_id = s.id ;";
        int fillIn = class_id;
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.setInt(1, fillIn);
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
    //# 7
    public static void assignStudentToClass(int studentId, int clasId, Connection conn) throws SQLException {

        PreparedStatement pStmt;
        String sql = "INSERT INTO roster (student_id, class_id) VALUES (?, ?)";

        pStmt = conn.prepareStatement(sql);
        pStmt.setInt(1, studentId);
        pStmt.setInt(2, clasId);
        pStmt.executeUpdate();

    }

    //  #8   dropStudentFromClass
    public static void dropStudentFromClass(int studentId, int clasId, Connection conn) throws SQLException {

        PreparedStatement pStmt;
        String sql = "DELETE FROM roster WHERE student_id = ? and class_id = ?";

        pStmt = conn.prepareStatement(sql);
        pStmt.setInt(1, studentId);
        pStmt.setInt(2, clasId);
        pStmt.executeUpdate();
    }
}
