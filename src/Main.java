import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Main {
    static GameBoard gameBoard = new GameBoard();
    public static void main(String[] args) {
        // **********************
        gameBoard.printDescriptiveBoard();
        // **********************
        menu();
    }
    // ***********************
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
            // Creates 2 players. a "Player" vs "Player"
            Player player1 = new Player(inputName1, 'X', 1);
            Player player2 = new Player(inputName2, 'O', 2);
            // GameLoop PvP. Breaks when you input 2 after winningConditions is filled.
            while (true) {
                if (!playerIteration(player1, gameBoard, gameBoard.player1Positions, player2))
                    break;
                else if (!playerIteration(player2, gameBoard, gameBoard.player2Positions, player1))
                    break;
            }
        } else if (choice == 2) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Player1 Enter your name");
            String inputName1 = sc.nextLine();
            // Creates 2 players. a "Player" vs "Cpu"
            Player player1 = new Player(inputName1, 'X', 1);
            Player cpu = new Player("Cpu", 'O', 2);
            // GameLoop PvC. Breaks when you input 2 after winningConditions is filled.
            while (true) {
                if (!playerIteration(player1, gameBoard, gameBoard.player1Positions, cpu))
                    break;
                else if (!cpuIteration(cpu, gameBoard, gameBoard.player2Positions, player1))
                    break;
            }
        }
    }
    static boolean playerIteration (Player player, GameBoard gameBoard, ArrayList arrayList, Player opponent) {
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
        //check win break
        // prints gameBoard where (Player player(symbol)) has replaced gameBoard[' '].
        gameBoard.printGameBoard();
        // prints all the current player "moves"
        System.out.println(arrayList);
        String player1Win = gameBoard.checkWin(player);
        if (player1Win.length() > 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println(player1Win + " " + opponent.getName() + ": " + opponent.getWinCount() +
                    " VS. " + player.getName() + ": " + player.getWinCount() +
                    "\nOne more round?\nyes = 1\nno = 2");
            byte choice = sc.nextByte();
            if (choice == 1) {
                gameBoard.player1Positions.clear();
                gameBoard.player2Positions.clear();
                gameBoard.setGameBoard();
            } else if (choice == 2) {
                return false;
            }
        } return true;
    }
    // follow the same concept as playerIteration but the "position" is dictated by a Random element.
    static boolean cpuIteration (Player player, GameBoard gameBoard, ArrayList arrayList, Player opponent){
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
            String cpuWin = gameBoard.checkWin(player);
            if (cpuWin.length() > 0) {
                Scanner sc = new Scanner(System.in);
                System.out.println(cpuWin + " " + player.getName() + ": " + player.getWinCount() +
                        " VS. " + opponent.getName() + ": " + opponent.getWinCount() +
                        "\nOne more round?\nyes = 1\nno = 2");
                byte choice = sc.nextByte();
                if (choice == 1) {
                    gameBoard.player1Positions.clear();
                    gameBoard.player2Positions.clear();
                    gameBoard.setGameBoard();
                } else if (choice == 2) {
                    return false;
                }
            } return true;
        }
}