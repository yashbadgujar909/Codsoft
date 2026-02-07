package CodSoftTask2;

import java.util.Scanner;
public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Subjects : ");
        int subjects = sc.nextInt();

        //taking Input Marks For Each Subject
        int TotalMarks = 0;
        System.out.println();
        for(int i=0; i<subjects; i++){
            System.out.print("Enter the Subject Marks (/100): ");
            int marks = sc.nextInt();
            TotalMarks+=marks;
        }

        //Calculating Average here
        double avrage = (double) TotalMarks/subjects;

        //Grade Calculating here
        String Grade;
        if (avrage >= 90){
            Grade = "A";
        }else if (avrage >= 80){
            Grade = "A";
        } else if (avrage >= 70){
            Grade = "B";
        } else if (avrage >= 60){
            Grade = "C";
        } else if (avrage >= 50) {
            Grade = "D";
        } else {
            Grade = "F";
        }

        //Displaying Result
        System.out.println();
        System.out.println("RESULT :");
        System.out.println("Total Mark : "+TotalMarks+" | "+"Average : "+avrage+"%"+" | "+"Grade : "+Grade);

    }
}
