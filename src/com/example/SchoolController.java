package com.example;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SchoolController {

    public static void main(String[] args) throws SQLException, EnrollmentException {
        Scanner in = new Scanner(System.in);
        int menuPick;

        while (true) {
            System.out.println("\n Choose one : ");
            System.out.println("1. createNew  ->  Student ");
            System.out.println("2. createNew  ->  Clas ");
            System.out.println("3. listAll students ");
            System.out.println("4. listAll clases  ");
            System.out.println("5. list students (in class c)");
            System.out.println("6. listAll clases (for student s) ");
            System.out.println("7. assignStudent (to clas c) ");
            System.out.println("8. dropStudent   (from clas c) ");
            System.out.println("9. expelStudent (MUST have 0 clases!) ");
            System.out.println("10.cancelClas   (MUST have 0 students!) ");

            menuPick = Integer.parseInt(in.nextLine());
            switch (menuPick) {

                case 1:
                    System.out.println("Lets create a student! \n");
                    System.out.println("Name ? --> \n");
                    String kidName = in.nextLine();
                    Student student0 = new Student();
                    student0.setName(kidName);
                    System.out.println(student0.getName() + "now exists! --> " + student0);
                    SchoolService.createNewStudent(student0);

                    break;
                case 2:
                    System.out.println("Lets create a clas! \n");
                    System.out.println("Clas name ? --> \n");
                    String clasName = in.nextLine();
                    Clas clas0 = new Clas();
                    clas0.setName(clasName);
                    System.out.println(clas0.getName() + " now exists! --> " + clas0);
                    SchoolService.createNewClas(clas0);
                    break;
                case 3:
                    System.out.println("Lets find a listOf students! \n");
                    List<Student> students = SchoolService.getListOfAllStudent();
                    for (Student student : students) {
                        System.out.println(student);
                    }
                    break;
                case 4:
                    System.out.println("Lets find a listOf clases! \n");
                    List<Clas> clases = SchoolService.getListOfClas();
                    for (Clas clas : clases) {
                        System.out.println(clas);
                    }
                    break;
                case 5:
                    System.out.println("students in clas c \n");
                    System.out.println("Clas id # --> ? ");
                    int clas_id = Integer.parseInt(in.nextLine());
                    students = SchoolService.getListOfStudentInClass(clas_id);
                    for (Student student : students) {
                        System.out.println(student);
                    }
                    break;
                case 6:
                    System.out.println("clases for student s \n");
                    System.out.println("Student id # --> ? ");
                    int studentId = Integer.parseInt(in.nextLine());
                    clases = SchoolService.getListOfStudentsClases(studentId);
                    for (Clas clas : clases) {
                        System.out.println(clas);
                        break;
                    }
                case 7:
                    System.out.println("assignStudent -> clas \n");
                    System.out.println("Student id # --> ? ");
                    studentId = Integer.parseInt(in.nextLine());
                    System.out.println("Clas id # --> ? ");
                    int classId = Integer.parseInt(in.nextLine());
                    SchoolService.assignStudentToClass(studentId, classId);
                    break;
                case 8:
                    System.out.println("dropStudent -> clas \n");
                    System.out.println("Student id # --> ? ");
                    studentId = Integer.parseInt(in.nextLine());
                    System.out.println("Clas id # --> ? ");
                    classId = Integer.parseInt(in.nextLine());
                    SchoolService.dropStudentFromClass(studentId, classId);
                    break;
                case 9:
                    System.out.println("expelStudent (must have 0 clases!) \n");
                    break;
                case 10:
                    System.out.println("cancelClas (must have 0 students!) \n");
                    break;
                default:
                    System.out.println("Give me an int please! ");
            }
        }
    }
}



