package Cognifyz_tasks.Task_1;

import java.util.Scanner;

public class Temprature_converter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Celcius : ");
        double value = sc.nextDouble();

        System.out.println("Faranheit : "+celcius_to_Farenheit(value));
    }

    public static double celcius_to_Farenheit(double value){
        return (value*1.8)+32;
    }
}
