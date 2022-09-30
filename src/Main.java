import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static GameBoard gameBoard = new GameBoard();
    public static void main(String[] args) {

        gameBoard.printGameBoard();
        menu();

    }
    static void menu () {
        System.out.println("""
                *** New Game ***
                Player Vs. Player: 1
                Player Vs. Cpu: 2""");
        Scanner scanner = new Scanner(System.in);
        byte choice = scanner.nextByte();



        if (choice == 1) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Player1 Enter your name");
            String inputName1 = sc.nextLine();

            System.out.println("Player2 Enter your name");
            String inputName2 = sc.nextLine();

            Player player1 = new Player(inputName1, 'X', 1);
            Player player2 = new Player(inputName2, 'O', 2);

            while (true) {
                playerIteration(player1, gameBoard, gameBoard.player1Positions);

                playerIteration(player2, gameBoard, gameBoard.player2Positions);
            }
        } else if (choice == 2) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Player1 Enter your name");
            String inputName1 = sc.nextLine();

            Player player1 = new Player(inputName1, 'X', 1);
            Player cpu = new Player("Cpu", 'O', 2);

            while (true) {
                playerIteration(player1, gameBoard, gameBoard.player1Positions);

                cpuIteration(cpu, gameBoard, gameBoard.player2Positions);
                // FUNKAR INTE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                if (gameBoard.checkTie()) break;
                // Tror metoden funkar men en scanner(sys.in)-loop går in och jag får inte programmet till att skicka ut en Tie print
                else if (gameBoard.checkWin()) break;
            }
        }
    }
    static void playerIteration (Player player, GameBoard gameBoard, ArrayList arrayList) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(player.getName() + " place your piece");
        // "place piece"
        int playerPos = scanner.nextInt();
        // while (playerPos contains a value in one of playerPosition-array, ask for a new value.)
        while (gameBoard.player1Positions.contains(playerPos) || gameBoard.player2Positions.contains(playerPos)) {
            System.out.println("Position taken!!!");
            playerPos = scanner.nextInt();
        }
        // sends the current player and its chosen position to GameBoard.placePiece method.
        gameBoard.placePiece(player, playerPos);
        // prints gameBoard where (Player player(symbol)) has replaced gameBoard[' '].
        gameBoard.printGameBoard();
        // prints all the current player "moves"
        System.out.println(arrayList);
    }
    // follow the same concept as playerIteration but the "position" is dictated by a Random element.
    static void cpuIteration (Player player, GameBoard gameBoard, ArrayList arrayList) {
        Random rNG = new Random();
        /* cpu position is set by a randomNumberGenerator (1-9)
        1-9 */
        int cpuPos = rNG.nextInt(9) + 1;
        while (gameBoard.player1Positions.contains(cpuPos) || gameBoard.player2Positions.contains(cpuPos)) {
            cpuPos = rNG.nextInt(9) + 1;
        }
        gameBoard.placePiece(player, cpuPos);
        gameBoard.printGameBoard();
        System.out.println(arrayList);
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