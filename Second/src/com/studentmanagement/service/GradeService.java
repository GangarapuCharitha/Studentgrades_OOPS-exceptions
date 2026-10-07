package com.studentmanagement.service;

import com.studentmanagement.interfaces.GradeCalculator;
import com.studentmanagement.exception.InvalidMarksException;

public class GradeService implements GradeCalculator {

    public void validateMarks(int[] marks)
            throws InvalidMarksException {

        if (marks == null || marks.length != 5) {
            throw new InvalidMarksException(
                "Enter marks for exactly five subjects."
            );
        }

        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarksException(
                    "Marks must be between 0 and 100."
                );
            }
        }
    }

    @Override
    public int calculateTotal(int[] marks) {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    @Override
    public double calculateAverage(int[] marks) {
        return (double) calculateTotal(marks) / marks.length;
    }

    @Override
    public String calculateGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else if (average >= 40) {
            return "E";
        } else {
            return "F";
        }
    }

    @Override
    public String calculateResult(int[] marks) {
        for (int mark : marks) {
            if (mark < 35) {
                return "FAIL";
            }
        }

        return "PASS";
    }
}