/*
 * 🎮 Tic Tac Toe Game in Java
 * Author: Akshay
 * Description: A console-based 2-player Tic Tac Toe game using a 3x3 board.
 */

package com.Akshay.tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];

        // Initialize board with empty spaces
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        // Game loop
        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + ", enter your move (row and column: 0, 1, or 2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Input validation
            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid position! Try again.");
                continue;
            }

            // Check if cell is empty
            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = haveWon(board, player);

                if (gameOver) {
                    System.out.println("Player " + player + " has won! 🎉");
                } else if (isBoardFull(board)) {
                    System.out.println("The game is a draw!");
                    gameOver = true;
                } else {
                    // Switch player
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid Input.");
            }
        }

        printBoard(board);
    }

    // Display the board
    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(" " + board[row][col]);
                if (col < 2) System.out.print(" |");
            }
            System.out.println();
            if (row < 2) System.out.println("---+---+---");
        }
    }

    // Check if the board is full
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Check if the current player has won
    public static boolean haveWon(char[][] board, char player) {
        // Check rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }
}
