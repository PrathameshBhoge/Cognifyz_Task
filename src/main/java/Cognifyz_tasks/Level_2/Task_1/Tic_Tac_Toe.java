package Cognifyz_tasks.Level_2.Task_1;

import java.util.Scanner;

public class Tic_Tac_Toe {
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY_CELL = ' ';
    private static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            initializeBoard();
            boolean gameEnded = false;
            printBoard();

            while (!gameEnded) {
                int[] move = getPlayerMove(scanner);
                int row = move[0];
                int col = move[1];

                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;
                    printBoard();
                    if (checkWin(row, col)) {
                        System.out.println("Player " + currentPlayer + " wins!");
                        gameEnded = true;
                    } else if (checkDraw()) {
                        System.out.println("It's a draw!");
                        gameEnded = true;
                    } else {
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            }

            System.out.print("Play again? (yes/no): ");
            String choice = scanner.next();
            playAgain = choice.equalsIgnoreCase("yes");
        }
        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j]);
                if (j < BOARD_SIZE - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < BOARD_SIZE - 1) {
                System.out.println("---------");
            }
        }
    }

    private static int[] getPlayerMove(Scanner scanner) {
        int[] move = new int[2];
        System.out.print("Player " + currentPlayer + "'s turn. Enter row (1-3) and column (1-3): ");
        move[0] = scanner.nextInt() - 1;
        move[1] = scanner.nextInt() - 1;
        return move;
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == EMPTY_CELL;
    }

    private static boolean checkWin(int row, int col) {
        return checkRow(row) || checkColumn(col) || checkDiagonal(row, col) || checkAntiDiagonal(row, col);
    }

    private static boolean checkRow(int row) {
        return board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != EMPTY_CELL;
    }

    private static boolean checkColumn(int col) {
        return board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] != EMPTY_CELL;
    }

    private static boolean checkDiagonal(int row, int col) {
        return row == col && board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != EMPTY_CELL;
    }

    private static boolean checkAntiDiagonal(int row, int col) {
        return row + col == BOARD_SIZE - 1 && board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != EMPTY_CELL;
    }

    private static boolean checkDraw() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }
}

