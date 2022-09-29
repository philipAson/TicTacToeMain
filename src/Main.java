import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static GameBoard gameBoard = new GameBoard();
    public static void main(String[] args) {

        gameBoard.printGameBoard();
        menu();

    }

    static void playerIteration (String playerName, GameBoard gameBoard, ArrayList arrayList) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(playerName + " place your piece");
        int playerPos = scanner.nextInt();
        // while input is equal to a value in one of playerPos-array, ask for a new value.
        while (gameBoard.player1Positions.contains(playerPos) || gameBoard.player2Positions.contains(playerPos)) {
            System.out.println("Position taken!!!");
            playerPos = scanner.nextInt();
        }
        gameBoard.placePiece(playerName, playerPos);
        gameBoard.printGameBoard();
        System.out.println(arrayList);
    }
    
    static void cpuIteration (String name, GameBoard gameBoard, ArrayList arrayList) {
        Random rNG = new Random();
        /* cpu position is set by a randomNumberGenerator (1-9)
        1-9 */
        int cpuPos = rNG.nextInt(9) + 1;
        while (gameBoard.player1Positions.contains(cpuPos) || gameBoard.cpuPositions.contains(cpuPos)) {
            cpuPos = rNG.nextInt(9) + 1;
        }
        gameBoard.placePiece(name, cpuPos);
        gameBoard.printGameBoard();
        System.out.println(arrayList);


    }
    static void menu () {
        System.out.println("""
                *** New Game ***
                Player Vs. Player: 1
                Player Vs. Cpu: 2""");
        Scanner scanner = new Scanner(System.in);
        byte choice = scanner.nextByte();
        if (choice == 1) {
            // input x2 "Enter Names"
            while (true) {
                playerIteration("Player1", gameBoard, gameBoard.player1Positions);

                playerIteration("Player2", gameBoard, gameBoard.player2Positions);
            }
        } else if (choice == 2) {
            // input "Enter Name"
            while (true) {
                playerIteration("Player1", gameBoard, gameBoard.player1Positions);

                cpuIteration("Cpu", gameBoard, gameBoard.cpuPositions);
            }
        }
    }
}


















/*    while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Player1" + " place your piece");
            int pLayer1Pos = scanner.nextInt();
            // while input is equal to a value in one of playerPos-array, ask for a new value.
            while (gameBoard.player1Positions.contains(pLayer1Pos) || gameBoard.player2Positions.contains(pLayer1Pos)) {
                System.out.println("Position taken!!!");
                pLayer1Pos = scanner.nextInt();
            }
            gameBoard.placePiece("Player1", pLayer1Pos);
            gameBoard.printGameBoard();
            System.out.println(gameBoard.player1Positions);



            System.out.println("Player2" + " place your piece");
            int player2Pos = scanner.nextInt();
            while (gameBoard.player1Positions.contains(player2Pos) || gameBoard.player2Positions.contains(player2Pos)) {
                System.out.println("Position taken!!!");
                player2Pos = scanner.nextInt();
            }
            gameBoard.placePiece("Player2", player2Pos);
            gameBoard.printGameBoard();
            System.out.println(gameBoard.player2Positions);
        }   */