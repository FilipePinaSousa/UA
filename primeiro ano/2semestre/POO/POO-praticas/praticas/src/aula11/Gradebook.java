package aula11;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gradebook {
    private List<Student> students;

    public Gradebook() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student newStudent) {
        students.add(newStudent);
    }
    
    public Student getStudent(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    public void removeStudent(String name) {
        for (Student student : this.students) {
            if (student.getName().equals(name)) {
                this.students.remove(student);
                break;
            }
        }
    }




    public void printAllStudents() {
        for (Student student : this.students) {
            System.out.println(student.getName() + ": " + student.getGrades());
        }
    }

    public void load(String filename) throws IOException {
        Scanner reader = new Scanner(new FileReader(filename));
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] parts = line.split("\\|");
            String name = parts[0];
            List<Double> grades = new ArrayList<>();
            for (int i = 1; i < parts.length; i++) {
                grades.add(Double.parseDouble(parts[i]));
            }
            Student student = new Student(name, grades);
            this.students.add(student);
        }
        reader.close();
    }

    
    public double CalculateAVG(String name){
        Student student = getStudent(name);
        List<Double> grades = student.getGrades();
        SimpleGradeCalculator calculator = new SimpleGradeCalculator();
        double avg = calculator.calculate(grades);
        return avg;
    }

    
}
