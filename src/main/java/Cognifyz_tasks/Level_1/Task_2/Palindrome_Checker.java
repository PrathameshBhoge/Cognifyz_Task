package Cognifyz_tasks.Level_1.Task_2;

import java.util.Scanner;

public class Palindrome_Checker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your number : ");
        int n = sc.nextInt();
        check_palindrome(n);
    }
    public static void check_palindrome(int n){
        int num = n;
        int reverse = 0;
        while(n>0){
            int last = n%10;
            reverse= reverse * 10 +last;
            n = n/10;

        }
        if(reverse == num){
            System.out.println("It is a palindrome Number.");
        }
        else{
            System.out.println("It is not a palindrome Number.");
        }
    }

}
