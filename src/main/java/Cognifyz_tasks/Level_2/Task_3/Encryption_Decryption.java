package Cognifyz_tasks.Level_2.Task_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encryption_Decryption {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter 'encrypt' or 'decrypt': ");
            String operation = scanner.nextLine();

            System.out.print("Enter input file name or path: ");
            String inputFileName = scanner.nextLine();

            System.out.print("Enter output file name or path: ");
            String outputFileName = scanner.nextLine();

            try {
                if (operation.equalsIgnoreCase("encrypt")) {
                    encryptFile(inputFileName, outputFileName);
                    System.out.println("File encrypted successfully.");
                } else if (operation.equalsIgnoreCase("decrypt")) {
                    decryptFile(inputFileName, outputFileName);
                    System.out.println("File decrypted successfully.");
                } else {
                    System.out.println("Invalid operation. Please enter 'encrypt' or 'decrypt'.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            } finally {
                scanner.close();
            }
        }

        private static void encryptFile(String inputFileName, String outputFileName) throws IOException {
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    String encryptedLine = encrypt(line);
                    writer.write(encryptedLine);
                    writer.newLine();
                }
            }
        }

        private static void decryptFile(String inputFileName, String outputFileName) throws IOException {
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    String decryptedLine = decrypt(line);
                    writer.write(decryptedLine);
                    writer.newLine();
                }
            }
        }

        private static String encrypt(String text) {
            // Simple encryption algorithm (for demonstration purposes)
            StringBuilder encryptedText = new StringBuilder();
            for (char ch : text.toCharArray()) {
                encryptedText.append((char) (ch + 1)); // Shift each character by 1
            }
            return encryptedText.toString();
        }

        private static String decrypt(String text) {
            // Simple decryption algorithm (for demonstration purposes)
            StringBuilder decryptedText = new StringBuilder();
            for (char ch : text.toCharArray()) {
                decryptedText.append((char) (ch - 1)); // Shift each character back by 1
            }
            return decryptedText.toString();
        }


}
