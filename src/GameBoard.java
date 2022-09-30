import java.util.ArrayList;

public class GameBoard {
    // Array-lists that stores the "players move".
    ArrayList<Integer> player1Positions = new ArrayList<>();
    ArrayList<Integer> player2Positions = new ArrayList<>();
    ArrayList<Integer> cpuPositions = new ArrayList<>();
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
    //Method that takes in a String and int. representing a player and referred position.
    void placePiece(Player player, int pos) {

        char symbol = ' ';
        /* if statement that decides what value (symbol) has,
        depending on what String u place in the Method
        then stores that value in a playerArray */

//      char symbol = player.getSymbol()



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


    boolean checkWin() {
        if (player1Positions.size() + player2Positions.size() == 9)
        return true;
        else
        return false;
    }
}

