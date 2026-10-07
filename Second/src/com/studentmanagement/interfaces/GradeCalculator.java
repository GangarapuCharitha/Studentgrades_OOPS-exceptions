package com.studentmanagement.interfaces;

public interface GradeCalculator {
    int calculateTotal(int[] marks);

    double calculateAverage(int[] marks);

    String calculateGrade(double average);

    String calculateResult(int[] marks);
}