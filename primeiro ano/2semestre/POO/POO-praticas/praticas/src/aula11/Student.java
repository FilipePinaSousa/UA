package aula11;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<Double> grades;

    public Student(String name, List<Double> grades) {
        this.name = name;
        this.grades = grades;
    }



			
    public Student(String name, String grades) {
        this.name = name;
        this.grades = new ArrayList<>();
        String[] parts = grades.split(",");
        for (String part : parts) {
            this.grades.add(Double.parseDouble(part));
        }
    }
   


    public String getName() {
        return name;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Grades: " + grades;
    }


}