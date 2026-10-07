package com.studentmanagement.model;

public class Student extends Person {
    private int[] marks;

    public Student(String name, String id, int[] marks) {
        super(name, id);
        this.marks = marks.clone();
    }

    public int[] getMarks() {
        return marks.clone();
    }

    public void setMarks(int[] marks) {
        this.marks = marks.clone();
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Student");
    }

    public void displayStudentDetails() {
        System.out.println("Student Name: " + getName());
        System.out.println("Student ID: " + getId());
    }
}