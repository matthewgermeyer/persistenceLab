package com.example;

import java.util.ArrayList;
import java.util.List;

public class Clas {
    private int id;
    private String name;
    List<Student> clasesStudents = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getClasRoster() {
        return clasesStudents;
    }

    public void setClasRoster(List<Student> clasRoster) {
        this.clasesStudents = clasRoster;
    }

    @Override
    public String toString() {
        return "Clas{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clasesStudents=" + clasesStudents +
                '}';
    }
}
