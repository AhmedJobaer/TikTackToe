package tiktaktoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    static ArrayList<Integer> player1Positions = new ArrayList<Integer>();
    static ArrayList<Integer> player2Positions = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /*char[][] gameBoardDemo
                = {{'1', '|', '2', '|', '3'},
                {'-', '+', '-', '+', '-'},
                {'4', '|', '5', '|', '6'},
                {'-', '+', '-', '+', '-'},
                {'7', '|', '8', '|', '9'}};

        printGameBoard(gameBoardDemo);
        System.out.println("\nThis is the TicTakToe Game Board.\nRemember your input position.\nLets Play!!\n");

        char[][] gameBoard
                = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);*/

        while (true) {

            char[][] gameBoardDemo
                    = {{'1', '|', '2', '|', '3'},
                    {'-', '+', '-', '+', '-'},
                    {'4', '|', '5', '|', '6'},
                    {'-', '+', '-', '+', '-'},
                    {'7', '|', '8', '|', '9'}};

            printGameBoard(gameBoardDemo);
            System.out.println("\nThis is the TicTakToe Game Board.\nRemember your input position.\nLets Play!!\n");

            char[][] gameBoard
                    = {{' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};
            printGameBoard(gameBoard);

            while (true) {

                System.out.print("Enter Player1 placement (1-9): ");
                int p1Pos = scan.nextInt();
                while (player1Positions.contains(p1Pos) || player2Positions.contains(p1Pos)) {
                    System.out.print("Position Taken!! Enter a correct Position: ");
                    p1Pos = scan.nextInt();
                }
                placePiece(gameBoard, p1Pos, "player1");
                printGameBoard(gameBoard);
                String result = checkWinner();
                if (result.length() > 0) {
                    System.out.println(result);
                    break;
                }
                System.out.print("Enter Player2 placement (1-9): ");
                int p2Pos = scan.nextInt();
                while (player1Positions.contains(p2Pos) || player2Positions.contains(p2Pos)) {
                    System.out.print("Position Taken!! Enter a correct Position: ");
                    p2Pos = scan.nextInt();
                }
                placePiece(gameBoard, p2Pos, "player2");

                printGameBoard(gameBoard);

                result = checkWinner();
                if (result.length() > 0) {
                    System.out.println(result);
                    break;
                }

            }
            player1Positions.clear();
            player2Positions.clear();
            System.out.print("Do you want to contiue(1) or exit(-1): ");
            int choice = scan.nextInt();
            if (choice == -1) {
                break;
            }
        }

    }

    public static void printGameBoardDemo(char[][] gameBoardDemo) {
        for (char[] row : gameBoardDemo) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {

        char symbol = ' ';

        if (user.equals("player1")) {
            symbol = 'X';
            player1Positions.add(pos);
        } else if (user.equals("player2")) {
            symbol = 'O';
            player2Positions.add(pos);
        }

        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static String checkWinner() {

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning) {
            if (player1Positions.containsAll(l)) {
                return "Congrats!! Player1 Won!! ";
            } else if (player2Positions.containsAll(l)) {
                return "Congrats!! Player2 Won!!";
            } else if (player1Positions.size() + player2Positions.size() == 9) {
                return "Match Tied";
            }
        }

        return "";
    }

}
