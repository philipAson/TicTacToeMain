import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        gameBoard.printGameBoard();

        while (true) {
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
            while (gameBoard.player2Positions.contains(player2Pos) || gameBoard.player1Positions.contains(player2Pos)) {
                System.out.println("Position taken!!!");
                player2Pos = scanner.nextInt();
            }
            gameBoard.placePiece("Player2", player2Pos);
            gameBoard.printGameBoard();
            System.out.println(gameBoard.player2Positions);
        }

    }
}