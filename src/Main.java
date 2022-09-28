import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        gameBoard.printGameBoard();

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Player1" + " place your piece");
            int pLayer1Pos = scanner.nextInt();
            gameBoard.placePiece("Player1", pLayer1Pos);
            gameBoard.printGameBoard();

            System.out.println("Player2" + " place your piece");
            int player2Pos = scanner.nextInt();
            gameBoard.placePiece("Player2", player2Pos);
            gameBoard.printGameBoard();
        }

    }
}