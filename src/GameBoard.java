import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class GameBoard {
    // Array-lists that stores the "players move".
    ArrayList<Integer> player1Positions = new ArrayList<>();
    ArrayList<Integer> player2Positions = new ArrayList<>();
    // char 2D array that defines our game board
    private char [][] gameBoard = {
            {' ',' ',' '},
            {' ',' ',' '},
            {' ',' ',' '}};
    // method for printing the gameBoard and its content in a visually appealing way
    void printGameBoard() {
        System.out.println(
                " "+gameBoard[0][0]+" | "+gameBoard[0][1]+" | "+gameBoard[0][2]+" \n" +
                "---+---+---\n" +
                " "+gameBoard[1][0]+" | "+gameBoard[1][1]+" | "+gameBoard[1][2]+" \n" +
                "---+---+---\n" +
                " "+gameBoard[2][0]+" | "+gameBoard[2][1]+" | "+gameBoard[2][2]+" ");
    }
    void printDescriptiveBoard() {
        System.out.println("""
                .1 |.2 |.3 
                ---+---+---
                .4 |.5 |.6 
                ---+---+---
                .7 |.8 |.9 """);
    }
    //Method that takes in a Player and int. representing a player and referred position.
    void placePiece(Player player, int pos) {
        /* if statement that decides which ArrayList to place (int pos("position")) in
        depending on what (playerNum), (Player player) has */
        if (player.getPlayerNum() == 1) {
            player1Positions.add(pos);
        } else if (player.getPlayerNum() == 2) {
            player2Positions.add(pos);
        }
        /* Switch statement that takes in an int which represents a place in the 2D array.
        and places an X/O there */
        switch (pos) {
            case 1:
                gameBoard[0][0] = player.getSymbol();
                break;
            case 2:
                gameBoard[0][1] = player.getSymbol();
                break;
            case 3:
                gameBoard[0][2] = player.getSymbol();
                break;
            case 4:
                gameBoard[1][0] = player.getSymbol();
                break;
            case 5:
                gameBoard[1][1] = player.getSymbol();
                break;
            case 6:
                gameBoard[1][2] = player.getSymbol();
                break;
            case 7:
                gameBoard[2][0] = player.getSymbol();
                break;
            case 8:
                gameBoard[2][1] = player.getSymbol();
                break;
            case 9:
                gameBoard[2][2] = player.getSymbol();
                break;
            default:
                System.out.println("Not a valid position!");
        }
    }
    public String checkWin(Player player) {
        /* winning conditions.
        Purpose to check if player1/2positions contains all values in one of the lists. */
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(3, 5, 7);
        // creating a ArrayList which can house lists
        List<List> winningConditions = new ArrayList<>();
        // adding all winning conditions to winningConditions
        winningConditions.add(topRow);
        winningConditions.add(midRow);
        winningConditions.add(botRow);
        winningConditions.add(leftCol);
        winningConditions.add(midCol);
        winningConditions.add(rightCol);
        winningConditions.add(cross1);
        winningConditions.add(cross2);
        // for each list inside winningConditions check >
        for (List l : winningConditions) {
            // if player1Pos or player2Pos contains all elements in one of the lists
            if (player1Positions.containsAll(l) || player2Positions.containsAll(l)) {
                // adds a win to current player
                player.addWin();
                //return string player + won !!!
                return player.getName() + "won !!!";
            }
        }

        /* if there's no winning conditions, and the amount of elements in both lists is = 9
        (maximum amount of places on the board) return String Tie !!!! */
        if (player1Positions.size() + player2Positions.size() == 9)
            return "Tie !!!!";
        return "";
    }
    // method that "clears" the gameBoard
    void setGameBoard() {
        gameBoard [0][0] = ' ';
        gameBoard [0][1] = ' ';
        gameBoard [0][2] = ' ';
        gameBoard [1][0] = ' ';
        gameBoard [1][1] = ' ';
        gameBoard [1][2] = ' ';
        gameBoard [2][0] = ' ';
        gameBoard [2][1] = ' ';
        gameBoard [2][2] = ' ';
    }
}