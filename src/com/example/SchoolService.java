package com.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SchoolService {

    // #1 createNewStudent
    public static void createNewStudent(Student student) throws EnrollmentException {

        Connection conn = null;

        try {
            conn = getConnection();
            StudentDao.insertStudent(student, conn);
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("cant rollback... ");
            }

            throw new EnrollmentException("Could not create a Student ");

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("could not close connection... ");
            }
        }
    }
    //#2 createNewClas
    public static void createNewClas (Clas clas) throws EnrollmentException {

        Connection conn = null;

        try {
            conn = getConnection();
            ClasDao.insertClass(clas, conn);
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("cant rollback... ");
            }

            throw new EnrollmentException("Could not create a Clas ");

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("could not close connection... ");
            }
        }
    }
    // #3 Get List of All Students
    public static List<Student> getListOfAllStudent() throws EnrollmentException {

        Connection conn = null;

        try {
            conn = getConnection();

            List<Student> students = StudentDao.selectAllStudents(conn);
            conn.commit();
            return students;
        } catch (SQLException e) {

            try {
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("cant rollback... ");
            }

            throw new EnrollmentException("Could not create a Student ");

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("could not close connection... ");
            }
        }
    }
    //#4 Get list of all classes:
    public static List<Clas> getListOfClas() throws EnrollmentException {

        Connection conn = null;

        try {
            conn = getConnection();
            List<Clas> clases = ClasDao.selectClases(conn);
            conn.commit();
            return clases;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("cant rollback... ");
            }
            throw new EnrollmentException("Could not create a list of clases ");
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("could not close connection... ");
            }
        }
    }
    //5 getListOfStudentInClass
    public static List<Student> getListOfStudentInClass(int clas_id) throws EnrollmentException {
        Connection conn = null;
        try {
            conn = getConnection();
            int useThis = clas_id;
            List<Student> students = StudentDao.selectStudentsInClas(conn, useThis);
            conn.commit();
            return students;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("cant rollback... ");
            }
            throw new EnrollmentException("Could not generate a list of students in class c ");
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("could not close connection... ");
            }
        }
    }
//    #6  getListOfStudentsClases
    public static List<Clas> getListOfStudentsClases(int studentId) throws EnrollmentException {
        Connection conn = null;
        try {
            conn = getConnection();
            int useThis = studentId;
            List<Clas> clases = StudentDao.selectStudentsClases(useThis,conn);
            conn.commit();
            return clases;
        } catch (SQLException e) {

            try {
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("cant rollback... ");
            }

            throw new EnrollmentException("Could not generate a list of students' clases ");

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("could not close connection... ");
            }
        }
    }
    // #7
    public static void assignStudentToClass(int studentId, int clasId) throws EnrollmentException {

        Connection conn = null;

        try {
            conn = getConnection();
            StudentDao.assignStudentToClass(studentId, clasId, conn);
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("cant rollback... ");
            }

            throw new EnrollmentException("Could not assign student to class ");

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("could not close connection... ");
            }
        }
    }

    // #8  dropStudentFromClass

    public static void dropStudentFromClass(int studentId, int clasId) throws EnrollmentException {

        Connection conn = null;

        try {
            conn = getConnection();
            StudentDao.dropStudentFromClass(studentId, clasId, conn);
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("cant rollback... ");
            }

            throw new EnrollmentException("Could not drop student from clas ");

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("could not close connection... ");
            }
        }
    }




    //  getConnection();
    private static Connection getConnection() throws SQLException {
        Connection conn = DatabaseUtils.getInstance().getConnection();
        System.out.println(conn.getAutoCommit());
        conn.setAutoCommit(false);
        return conn;
    }


}
