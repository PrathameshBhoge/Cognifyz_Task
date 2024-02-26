package Cognifyz_tasks.Level_1.Task_3;

import java.util.Scanner;

public class Student_grade_calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Grades : ");
        int numbersofSubject = sc.nextInt();
        System.out.print("Enter the grades : ");
        double [] grade = new double[numbersofSubject];
        for (int i =0;i<numbersofSubject;i++){
            grade[i]=sc.nextDouble();
        }
        System.out.println( "The number of grades obatined by student is : "+grade_calculator(grade));
    }

    public static double grade_calculator(double [] grade){
        double sum =0;
         for(double grades :grade){
             sum += grades;
         }

         double avg= sum/grade.length;

         return avg;
    }
}
