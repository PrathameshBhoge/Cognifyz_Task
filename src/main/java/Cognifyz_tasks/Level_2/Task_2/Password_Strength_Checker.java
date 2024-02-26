package Cognifyz_tasks.Level_2.Task_2;
import java.util.Scanner;

public class Password_Strength_Checker {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            if (isStrongPassword(password)) {
                System.out.println("Password strength: Strong");
            } else {
                System.out.println("Password strength: Weak");
            }

            scanner.close();
        }

        public static boolean isStrongPassword(String password) {
            // Check length
            if (password.length() < 8) {
                return false;
            }

            // Check for presence of uppercase letters, lowercase letters, numbers, and special characters
            boolean hasUppercase = false;
            boolean hasLowercase = false;
            boolean hasDigit = false;
            boolean hasSpecialChar = false;

            for (char ch : password.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    hasUppercase = true;
                } else if (Character.isLowerCase(ch)) {
                    hasLowercase = true;
                } else if (Character.isDigit(ch)) {
                    hasDigit = true;
                } else {
                    hasSpecialChar = true;
                }
            }

            // Check if all criteria are met
            return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
        }
}


